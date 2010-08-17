#!/usr/bin/env python
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
# Copyright 2010 Saidimu Apale (saidimu@gmail.com)
#

__author__ = "saidimu@gmail.com (Saidimu Apale)"

"Defines models for the PetrolTracker system"

from google.appengine.ext import db
from geo.geomodel import GeoModel


## direct-message statuses
INCOMING_MSG    = "Incoming Message"
OUTGOING_MSG    = "Outgoing Message"
DIRTY_MSG       = "UNSENT Outgoing Message"

## product types
PRODUCT_PETROL  = "petrol"
PRODUCT_DIESEL  = "diesel"


class User(db.Model):
    '''
    Models a Twitter user (not all the properties are modelled, just the ones needed for this project
    '''

    screen_name     = db.StringProperty(required=True, default=None)                ## twitter username    
    created_at      = db.DateTimeProperty(required=True, auto_now_add=True)         ## the date of this price object creation in the datastore
#    id              = db.IntegerProperty(required=True)                            ## not certain what this is (I think it is twitter's numeric ID for this user)
#    email           = db.EmailProperty()                                           ## user's' email address
#    name            = db.StringProperty(required=True)                             ## twitter "real name"
##class User()




class Message(db.Model):
    '''
    Models a Twitter message received/sent by the system
    '''
    
    id                  = db.IntegerProperty(default=0)                             ## not certain what this is (I think it is twitter's numeric ID for this message)
    text                = db.StringProperty(required=True, default=None)            ## the actual text of the message
    user                = db.ReferenceProperty(reference_class=User, collection_name="messages")     ## a reference to the user this message involved (either as a sender or as a recipient)
#    direction           = db.BooleanProperty(required=True, default=INCOMING_MSG)  ## whether this message was sent or received by the system
    status              = db.StringProperty(required=True, default=INCOMING_MSG)    ## whether this message was sent or received by the system (if sent, whether it has been actually sent or is still "dirty", i.e. to be sent but not yet sent)
#    twitter_created_at  = db.DateTimeProperty()                                     ## the date of this message creation as provided by twitter
    created_at          = db.DateTimeProperty(required=True, auto_now_add=True)     ## the date of this message object creation in the datastore
##class Message()





class PetrolStation(GeoModel):
    '''
    A location-aware model for a petrol stations (xtended from class GeoModel)
    '''
    canonical_name  = db.StringProperty(required=True, default=None)                ## the official name as found in company websites etc
    other_names     = db.StringListProperty(default=[])                             ## names commonly used by others
    created_at      = db.DateTimeProperty(required=True, auto_now_add=True)         ## the date of this price object creation in the datastore
##class PetrolStation()




class PricePoint(db.Model):
    '''
    Models a single price value (in Kenya Shillings) and related data:
    - the actual price value
    - what fuel-type it refers to (petrol/diesel etc)
    - when it was entered
    - what message originated it
    - what petrol station it refers to
    - a confidence level attached to this price (the result of a calculation involving many other variables)
    '''
    value           = db.FloatProperty(required=True, default=0.0)                  ## a particular price submitted for a petrol station
    product_type    = db.StringProperty(required=True, default=PRODUCT_PETROL)      ## what fuel-type this price point is about (petrol/diesel etc)
    petrol_station  = db.ReferenceProperty(required=True, reference_class=PetrolStation, collection_name="price_points")     ## a reference to the Message object of this price point
    message_origin  = db.ReferenceProperty(required=True, reference_class=Message, collection_name="price_point")     ## a reference to the Message object that this price point was derived from
    confidence      = db.FloatProperty(default=0.0)                                 ## the confidence level calculated for this price point
    created_at      = db.DateTimeProperty(required=True, auto_now_add=True)         ## the date of this price object creation in the datastore
##class PricePoint()
