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


#import sys
#sys.path.insert(0, 'geopy.zip')
import time
from geopy import geocoders
from geo import geotypes

from models import PetrolStation


MAX_RESULTS = 5         ## the max. number of results to return
MAX_DISTANCE = 5        ## in km, the max. distance that a location-result can be in


TOO_MANY_RESULTS = "More than 1 place was found to match the name you entered. Please provide additional details."
NO_RESULTS = "No places matched your request. Please provide additional details."
GOOGLE_TOO_MANY_QUERIES_ERROR = "The system is overloaded, please try again in a short moment."

class PetrolTracker():
    '''
    The main class of all petrol-tracking code
    '''
    
    def __init__(self):
        '''
        '''        
#        self.google_geocoder = geocoders.Google(domain='maps.google.co.ke', resource='maps', format_string="%s, Nairobi Kenya")         
        self.google_geocoder = geocoders.Google(domain='maps.google.co.ke', format_string="%s, Nairobi Kenya")         
    ##__init__()

    
    
    def geocode(self, location_string=None, exactly_one=False):
        '''
        Return "placename, (lat, lon)" of the location string, else return None if not found
        '''
        if not location_string: return None
             
        ## potentially more than one place will match... catch the ValueError exception if we asked for only one
        try:
            places = self.google_geocoder.geocode(location_string, exactly_one=False)
#            places = self.google_geocoder.geocode(location_string, exactly_one=exactly_one)
#            place, (lat, lon) = places

        ## FIXME: the geocoder complaining of too many queries (??)
        ## sleep for some time and then retry
        except geocoders.google.GTooManyQueriesError, e:
            return GOOGLE_TOO_MANY_QUERIES_ERROR
            
        ## > 1 results available for given location name
        except ValueError, e:
            ## FIXME: handle this exception better
            return TOO_MANY_RESULTS
        
        ## due to a bug in the geopy module, a "NameError: global name 'sys' is not defined" exception seems to be returned when there are no results for the given location name
        except NameError, ne:
            ## FIXME: handle this exception better
            return NO_RESULTS
        ##try-except

#        return place, (lat,lon)
        return places
    ##geocode()

    
    
    
    def proximity_search(self, lat=None, lon=None):
        '''
        '''
        if lat is None or lon is None:
            return "Invalid Latitude/Longitude values.\n\n"
        ##if
                
        try:
            center = geotypes.Point(
                                float(lat),
                                float(lon)
                            )
        except ValueError:
            return "Invalid Latitude/Longitude values"
        ##try-except
        
        ## any filters and/or orderings need to happen here (before passing it over to the proximity fetch function
        base_query = PetrolStation.all()
        
        ## perform a proximity fetch of the results
        results = PetrolStation.proximity_fetch(
                        base_query,
                        center,
                        max_results=MAX_RESULTS,
                        max_distance=MAX_DISTANCE*1000)
        
        return results
    ##proximity_search()    
        
        
        
##class PetrolTracker()




if __name__ == "__main__":
    print "Not yet capable of being run this way."