#!/bin/bash 

export SPRING_PROFILES_ACTIVE=testing
export MONGODB_ADDRESS_PASSWORD=address
export MONGODB_ROOT_USERNAME=root
export MONGODB_ROOT_PASSWORD=root

docker rm address
docker rm address-mongodb

docker rmi ivanp81/address-mongodb
docker rmi ivanp81/address

docker-compose -f docker-compose.yml -f docker-compose.dev.yml up --build 



