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
A handler for test-UI-related AppEngine requests
"""

import os
import wsgiref.handlers
from google.appengine.api import users
from google.appengine.ext import webapp
from google.appengine.ext.webapp import template

class HandleRequests(webapp.RequestHandler):
    '''
    A handler for test-UI-related AppEngine requests
    '''
    
    def __init__(self):
        '''
        '''
        webapp.RequestHandler.__init__(self)
    ##__init__()
    
    
    def get(self):
        '''
        '''
        ## grab a 
        user = users.get_current_user()
        
        ## if the user is logged-in...
        if user:
            nickname = user.nickname()
            url = users.create_logout_url(self.request.uri)
            url_linktext = 'Sign Out'
            
            template_values = {
                    'nickname':  nickname,
                    'url': url,
                    'url_linktext': url_linktext,
            }

            path = os.path.join(os.path.dirname(__file__), 'templates/test_ui_template.html')
            self.response.out.write(template.render(path, template_values))
    
##class HandleRequests()



def main():
    application = webapp.WSGIApplication([
                                ('/test/.*', HandleRequests),
                            ],
                            debug=False)
    
    wsgiref.handlers.CGIHandler().run(application)


if __name__ == '__main__':
    main()