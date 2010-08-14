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
        
        ## if too many results returned...
        if geoinfo == petroltracker.TOO_MANY_RESULTS:
            self.response.out.write(geoinfo + "\n")
            return
        
        ## if no results returned...
        elif geoinfo == petroltracker.NO_RESULTS:
            self.response.out.write(geoinfo + "\n")
            return
        
        ## If all seems ok...
        place, (lat, lon) = geoinfo
        ##if-else

        ## perform a proximity search on the geocoded location
        stations = self.petroltracker.proximity_search(lat, lon)
        
        if type(stations) == list:
            for station in stations:
                place = station.canonical_name.split(",", 1)[0]
                nearby = station.canonical_name.split(",", 1)[1]
                
                self.response.out.write("%s (near %s) *** (lat, lon) = (%s, %s)\n" % (place, nearby, station.location.lat, station.location.lon))
                return
            ##for
        ##if
        
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