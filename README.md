Knowledge Registry Address Expression Tool Suite (KRAETS)
===
Knowledge Registry Address Expression Tool Suite (KRAETS) contains a reference implementation of Knowledge Registry and address expressions or A-Expressions to demonstrate how Knowledge Query Language (KQL) works. This reference implementation includes (1) a compiler for A-Expressions, (2) implementation of KQL by embedding A-Expressions in SQL (Structured Query Language) that returns query results with provenance information, (3) Common Cyber Environment Representation (CCER) ontology schema, (5) an ontology for email corpus that conforms to CCER ontology, and its implementation in a Knowledge Registry, (6) Python based topic modeling algorithms with embedded  KQL queries over Enron email data corpus stored in a MongoDB data store. More details of this reference implementation is below.

A-Expression compiler: A-Expression compiler consists of a lexer and a  parser, both of which are implemented using ANTLR, an open source software. 

Knowledge Query Language (KQL) implementation: KQL is an enhanced version of SQL that allows embedding of A-Expressions in SQL queries. A KQL may have one or more A-Expressions. All of the A-Expressions are translated into tables, rows, and column information of the underlying datastore.in this case, implemented using MongoDB. The SQL statements resulting from the translation of KQL statements are processed with UnityJDBC, a Java based commercial library. This library translates SQL statements into queries that  can be processed by SQL and NoSQL databases. In KRAETS, the SQL statements are translated into MongoDB queries.

Common Cyber Environment Representation (CCER) ontology schema: The Registry Ontology schema is defined using Common Cyber Environment Representation (CCER) ontology.  Ontology topics represented by CCER are: Networks (OSI Layer 3 and Layer 2); Computers/Hosts and Servers; Applications and OS; Services (DHCP, DNS, ADDS, Proxy, HTTP);and Probes.

An email data ontology instance conforming to the CCER ontology schema. This ontology is an instance of  the CCER based Knowledge Registry ontology schema. The Knowledge Registry and the email ontology instance are implemented using a set of JSON files.

KQL Examples: KRAETS includes several examples of KQL queries (SQL queries with embedded A-Expressions). These queries are made from Python scripts implementing topic modeling algorithms over Enron email corpus. The Python queries embed the KQL queries in them. The KQL Translator translates A-Expressions using the email ontology instance implemented in the Knowledge Registry. Once the A-Expressions are translated into physical tables, rows, and  columns of the data store, and the SQL query is rewritten using the physical tables and row/column information before it is passed on to the UnityJDBC driver that executes the SQL expression on the email data store implemented over MongoDB.


Instructions to build the project
==
<ul>
	<li>Use eclipse indigo - antlr3 plugin doesn't work anywhere else</li>
	<li>Download the antlr3 plugin</li>
	<li>Click on the grammar file ("aexp17.g" in /src/main/java, and it will open up a dialog about ANTLR. See the screenshot in this directory to what antlr directories you need to specify from /src/main/resources</li>
	<li>Convert the project to ANTLR by right clicking on kql-engine, and then clicking on Congigure</li>
	<li><b>Required Step </b> - Make some simple change on grammar file or rebuild project, and save. The grammar will be compiled then</li>
	<li>get unityjdbc from the vendor and install - see below </li>
	<li>git clone a-expression, and do mvn clean install from command line</li>
	<li>cd kql_engine and mvn clean install from command line. You will not get any errors except all the tests will fail looking for mongoDB connection</li>
	<li>Install Brew - see below</li>
	<li>Install and run MongoDB - see below </li>
	<li>Run one of the tests in kql. It should go past connecting to MongoDB, but will fail saying could not locate data</li>
	<li> Import data into MongoDB - see below</li>
	<li> Now run "mvn clean install" on kql, and everything should work! </li>
</ul>

<h3>UnityJDBC Install</h3>

Follow instructions at UnityJDBC to install on Mac. It should install on /Applications....
YOu can get a 30day evaluation copy.
To use unityjdbc run:

mvn install:install-file -Dfile=/Applications/UnityJDBC/mongodb_unityjdbc_full.jar -DgroupId=mongodb.jdbc -DartifactId=unityjdbc -Dversion=1 -Dpackaging=jar

<h3>Brew install</h3>

Make sure you have set-up http proxy in your .profile
export HTTP_PROXY="llproxy.llan.ll.mit.edu:8080"
export http_proxy="llproxy.llan.ll.mit.edu:8080"

Run the ruby script to fetch and install brew (you will get teh script from brew website)

setenv PATH "/usr/local/bin:$PATH #Otherwise you will have to cd /usr/local/bin, and then run brew

<h3>MongoDB Install</h3>

Once you installed brew, "brew install mongodb"

sudo mkdir /data/db
sudo chnod a+rw db

Run mongodb server from the commandline
 mongod
 
<h3> Import data to MongoDB </h3>

1. Clone and set-up email-modeler project, including downloading Enron corpus
2. Run importScript.py
