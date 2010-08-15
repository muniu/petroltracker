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