#!/usr/bin/env python
#
# Copyright 2010 Saidimu Apale
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

__author__ = "saidimu@gmail.com (Saidimu Apale)"


"""
The main handler for UI-related AppEngine requests
"""

import logging
import urllib
import petroltracker

import wsgiref.handlers
from google.appengine.ext import webapp

class HandleRequests(webapp.RequestHandler):
    '''
    The main handler for UI-related AppEngine requests
    '''
    
    def __init__(self):
        '''
        '''
        webapp.RequestHandler.__init__(self)
        self.petroltracker = petroltracker.PetrolTracker()
    ##__init__()
    
    
    def get(self):
        '''
        '''
        place_to_geocode = self.request.get("place", None)

        ## if not an accepted query field...
        if not place_to_geocode:
            self.response.out.write("Please provide a location name in a query field named 'place'.\n")
            return
        ##if

        ## geocode the location name given        
        geoinfo = self.petroltracker.geocode(place_to_geocode)
        logging.debug("Return value from google_geocoder.geocode() 'geoinfo' = '%s'" % str(geoinfo))
        ##if
        
#        ## if too many results returned...
#        if geoinfo == petroltracker.TOO_MANY_RESULTS:
#            self.response.out.write(geoinfo + "\n")
#            return
#        
#        ## if no results returned...
#        elif geoinfo == petroltracker.NO_RESULTS:
#            self.response.out.write(geoinfo + "\n")
#            return
#        ##if-else

        ## memoize to reduce repeated calls to proximity_search with the same arguments
        memoized_places = {}

        self.response.out.write("<li>Locations in <b>bold</b> are the places the system thinks you asked for (listed from highest-confidence to lowest-confidence).<br />")
        self.response.out.write("<li>The top <b>%s</b> stations in a radius of <b>%skm</b> closest to the location are listed (from nearest to farthest).<br /><hr />" \
                                        % (petroltracker.MAX_RESULTS, petroltracker.MAX_DISTANCE))

        for places in geoinfo:
            ## If all seems ok...
#            logging.debug("places : '%s'" % str(geoinfo))
            place, (lat, lon) = places
            place = place.strip()
            
            ## FIXME: a hack to trap a spurious response that always returns the following even for spurious searches like 'abracadabra' (!!)
            ## 'Nairobi National Park, Nairobi, Kenya'
            ## 'Nairobi, Kenya'
            if (place == 'Nairobi, Kenya') or (place == 'Nairobi National Park, Nairobi, Kenya'):
                logging.warn("Bullshit geocoding reesults '%s' for '%s'" % (str(places), place_to_geocode))
                self.response.out.write("<li>Sorry, no petrol stations were found near <b>%s</b>. If you believe this is in error,\
                                 please let us know at <a href='mailto:saidimu@gmail.com?subject=PetrolTracker missing station&body=My search for **%s** did not return any results'>saidimu@gmail.com</a>\
                                  OR at <a target ='_blank' href='http://code.google.com/p/petroltracker/'>http://code.google.com/p/petroltracker/</a>" % (place_to_geocode, place_to_geocode))
                logging.critical("No petrol stations found near '%s'" % place_to_geocode)
                continue
            ##if-else
            
            self.response.out.write("<p />Petrol Stations closest to <b>%s:</b>" % place)

            ## only call proximity_fetch() if this (lat, lon) hasn't been seen before    
            if (lat, lon) in memoized_places:
                stations = memoized_places[(lat, lon)]
                logging.debug("(memoized) Return value for '%s' from PetrolStation.proximity_fetch() 'stations' = '%s'" % (place, str(stations)))
            else:
                ## perform a proximity search on the geocoded location
                stations = self.petroltracker.proximity_search(lat, lon)
                logging.debug("Return value for '%s' from PetrolStation.proximity_fetch() 'stations' = '%s'" % (place, str(stations)))
            ##if
            
            if len(stations) > 0:
                for station in stations:
                    logging.debug("Station close to '%s' --> '%s'" % (place, station.canonical_name))
                    station_name = station.canonical_name
                    station_lat = station.location.lat
                    station_lon = station.location.lon
                    
                    params = {
                        'q': "%s,%s" % (station_lat, station_lon),
                        }
                    
                    station_maps_link = "http://maps.google.com/maps?" + urllib.urlencode(params)
    
#                    self.response.out.write("<br /><a href='%s'>%s</a> is the closest petrol station to '%s'" % (google_maps_link, station_name, place))
                    self.response.out.write("<li><a href='%s' target='_blank'>%s</a>" % (station_maps_link, station_name))
                ##for
            else:
                self.response.out.write("<li>Sorry, no petrol stations were found near <b>%s</b>. If you believe this is in error,\
                                 please let us know at <a href='mailto:saidimu@gmail.com?subject=PetrolTracker missing station&body=My search for **%s** did not return any results'>saidimu@gmail.com</a>\
                                  OR at <a target ='_blank' href='http://code.google.com/p/petroltracker/'>http://code.google.com/p/petroltracker/</a>" % (place_to_geocode, place_to_geocode))
                logging.critical("No petrol stations found near '%s'" % str(places))
            ##if-else
            
            self.response.out.write("<br /><hr />")
        ##for
        
    ##get()
    
    
##class HandleRequests()



def main():
    application = webapp.WSGIApplication([
                                ('/', HandleRequests),
                            ],
                            debug=False)
    
    wsgiref.handlers.CGIHandler().run(application)


if __name__ == '__main__':
    main()