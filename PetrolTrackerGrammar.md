A few suggestions on formats, and some basic syntax-trees generated through ANTLR.

The actual ANTLR grammar file:
  * https://code.google.com/p/petroltracker/source/browse/petroltracker-language/src/com/appspot/petroltracker/language/RequestAnalyzer.g


### Syntax ###


  * **'Koinange Street, petrol'**
> (location, fuel type) : full query syntax

![http://petroltracker.googlecode.com/files/query-request-syntax-tree.1.png](http://petroltracker.googlecode.com/files/query-request-syntax-tree.1.png)


  * **'Muthaiga'**
> (location only) : brief query syntax . Fuel type defaults to petrol.

![http://petroltracker.googlecode.com/files/query-request-syntax-tree.2.png](http://petroltracker.googlecode.com/files/query-request-syntax-tree.2.png)


  * **'Westlands, Kobil, diesel, 99.2'**
> (location, station name, fuel type, price) : full update syntax

![http://petroltracker.googlecode.com/files/update-request-syntax-tree.1.png](http://petroltracker.googlecode.com/files/update-request-syntax-tree.1.png)


  * **'Lavington, Kobil, 99.3'**
> (location, station name, price): brief update syntax. Fuel type defaults to petrol.

![http://petroltracker.googlecode.com/files/update-request-syntax-tree.2.png](http://petroltracker.googlecode.com/files/update-request-syntax-tree.2.png)