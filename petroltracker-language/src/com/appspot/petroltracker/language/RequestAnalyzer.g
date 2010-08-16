//
// Copyright 2010 Saidimu Apale
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

grammar RequestAnalyzer;

options {
  language = Java;
}

@header	{
	package com.appspot.petroltracker.language;
}

@lexer::header	{
	package com.appspot.petroltracker.language;
}


request
	: query {System.out.println("query, " + $query.text);}
	| update {System.out.println("update, " + $update.text);}
	;


query
	: location (DELIMITER fueltype)?
	;


update
	: location DELIMITER petrolstation (DELIMITER fueltype)? DELIMITER price
	;
	
location
	:	IDENT*
	;
	
fueltype
	:	('petrol' | 'diesel')
	;

petrolstation
	: IDENT*
	;

price
	:	NUMBER
	;

NUMBER: INTEGER | FLOAT;	
fragment FLOAT: INTEGER '.' INTEGER+;
fragment INTEGER: '0'..'9'+;
IDENT : ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
DELIMITER: ',';
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};