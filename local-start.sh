#!/bin/sh
####################################################################
##
## It is not a script to run on the actual Jenkins server.
## It tells you what to do on the CI(like Jenkins) server.
##
## CI server requirements
##  - JDK >= 8
##  - git core
##  - docker engine
##
####################################################################
### step 1. build frontend & bake image
#cd notification-web-frontend && yarn generate && yarn docker-build
### step 2. build backend & bake image
#cd .. && ./gradlew jibDockerBuild
### container run
docker-compose -f docker-compose-local.yml up -d
#############################################################################################
