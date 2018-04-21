# address-service

This is a proof-of-concept application which demonstrates, against a simple Spring Boot application, the following: 

- component containerization through Docker
- various type of test coming from the test pyramid
- Continous integration with a Jenkins Pipeline

## Run the test

#### Unit test  
```
$ mvn test
```

#### Integration\Component test
```
$ mvn verify
```
#### Acceptance test
```
$ mvn verify -Pacceptance-tests -Dacceptance.advertise.url=URL_TO_ADVERTISE_TESTING_ENVIRONMENT -Dacceptance.advertise-search.url=URL_TO_ADVERTISE_SEARCH_TESTING_ENVIRONMENT
```

## Build the project

```
$ mvn clean package
```

#### Build Docker images
```
export SPRING_PROFILES_ACTIVE=*a spring profile (e.g testing, prod)*
export MONGODB_ADDRESS_PASSWORD=*password for address db*
export MONGODB_ROOT_USERNAME=*root username for MongoDB*
export MONGODB_ROOT_PASSWORD=*root password for MongoDB*

$ docker-compose -f docker-compose.yml -f docker-compose.dev.yml build 
```

## How to run

#### Development mode 
```
$ docker-compose -f docker-compose.yml -f docker-compose.dev.yml up
```
**docker-compose.dev.yml** inherits **docker-compose.yml** with additional possibility to build images locally and expose all containers ports for convenient development.

#### Production mode
```
$ docker-compose up
```
## Pipeline

# Feedback welcome
As this is a proof-of-concept mistake and miserunderstunding are possible. Every type of feedback is welcome to improve it.  