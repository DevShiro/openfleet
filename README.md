# openfleet
Openfleet v2

## Dev startup
- ```./gradlew deployNodes```
- ```java -jar openfleet-corda/build/nodes/PartyA/corda.jar```
- Run ```OpenfleetUIApplication::main``` Needs shorten command line set to Jar Manifest
- Application running and connecting to PartyA's corda node on ```localhost:8080```
- H2 Console available on ```localhost:8080/h2-console```