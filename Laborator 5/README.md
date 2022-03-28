Compulsory 

An object-oriented model of the problem

Implement the following methods representing commands that will manage the content of the catalog:

add: adds a new entry into the catalog;

toString: a textual representation of the catalog;

save: saves the catalog to an external file using JSON format; you may use Jackson or other library;

load: loads the catalog from an external file

Homework 

Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command

Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, SaveCommand, LoadCommand, ViewCommand, ReportCommand, InfoCommand)

list: prints the list of items on the screen;

view: opens an item using the native operating system application (see the Desktop class);

report: creates (and opens) an HTML report representing the content of the catalog, using a template engine such as FreeMarker 

Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.

The application will signal invalid date or the commands that are not valid using custom exceptions

The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

Bonus 

Suppose there is an official set of concepts (keywords), and that each item has a list of such concepts and evolve your model in order to support this new feature.

Create large instances of the problem
