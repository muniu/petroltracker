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
        place = self.request.get("place", None)

        ## if not an accepted query field...
        if not place:
            self.response.out.write("Please provide a location name in a query field named 'place'.\n")
            return
        ##if

        ## geocode the location name given        
        geoinfo = self.petroltracker.geocode(place)
        logging.debug("Return value from google_geocoder.geocode() 'geoinfo' = '%s'" % str(geoinfo))
        
        ## if too many results returned...
        if geoinfo == petroltracker.TOO_MANY_RESULTS:
            self.response.out.write(geoinfo + "\n")
            return
        
        ## if no results returned...
        elif geoinfo == petroltracker.NO_RESULTS:
            self.response.out.write(geoinfo + "\n")
            return
        ##if-else
        
        ## If all seems ok...
        place, (lat, lon) = geoinfo

        ## perform a proximity search on the geocoded location
        stations = self.petroltracker.proximity_search(lat, lon)
        logging.debug("Return value from PetrolStation.proximity_fetch() 'stations' = '%s'" % str(stations))
        
#        if type(stations) == list:        ## TODO: seems reduntant, can there ever be a different return type?
        if len(stations) > 0:
            for station in stations:
                logging.debug("Station close to place:'%s' --> station:'%s'" % (place, station.canonical_name))
                station_name = station.canonical_name
                
                params = {
#                    'q': "%s,%s (petrol station closest to %s)" % (lat, lon, place),
                    'q': "%s,%s" % (lat, lon),
                    }
                
                google_maps_link = "http://maps.google.com/maps?" + urllib.urlencode(params)

#                self.response.out.write("%s (lat, lon = %s, %s) is the closest petrol station to '%s'\n\n<p />" % (station_name, station.location.lat, station.location.lon, place))
                self.response.out.write("<br /><br /><a href='%s'>%s</a> is the closest petrol station to '%s'\n\n<p />" % (google_maps_link, station_name, place))
#                self.response.out.write("<a href='%s'>Map this location</a>" % google_maps_link)
                return
            ##for
        else:
            self.response.out.write("No petrol stations found near %s\n" % place)
        ##if-else
        
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