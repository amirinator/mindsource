# Sample Applications

The contained code are examples for a simple 'visitor' service and 'encryption/decryption' service.

#Installation
Download the code from the Github repo https://github.com/amirinator/mindsource

#Usage

Under the /target directory you can run the following examples

###Visitor Application
#####To Get a collection of visits for a specific date range (NOTE: Please inspect the file 'UsersVisitsSeedFile.txt' to view the valid visit timestamp ranges . You must provide a start and end timestamp in the following format:
```java
java -cp bin/MindSource-1.0-SNAPSHOT.jar com.amirinator.application.VisitorApplication "[applicationParameter]" "[start time range]" "[end time range]"
```
#####as an example to find a count of visits for a "range" execute the following command:
```java
java -cp bin/MindSource-1.0-SNAPSHOT.jar com.amirinator.application.VisitorApplication "range" "2019-01-01 04" "2019
-01-03 17"
```
#####To get a count of unique user visits for each product execute the following command:
```java
java -cp bin/MindSource-1.0-SNAPSHOT.jar com.amirinator.application.VisitorApplication "count"
-01-03 17"
```

###Visitor Application
#####To Get a return a decrypted MESSAGE then the width of characters encrypted and the encrypted MESSAGE must be specified in the following format:
```java
java -cp bin/MindSource-1.0-SNAPSHOT.jar com.amirinator.application.EncryptionApplication "WIDTH" "ENCRYPTED MESSAGE"
```
#####as an example to find a count of visits for a "range" execute the following command:
```java
java -cp bin/MindSource-1.0-SNAPSHOT.jar com.amirinator.application.EncryptionApplication "3" "ttyohhieneesiaabss"

```
will return "thisistheeasyoneab"