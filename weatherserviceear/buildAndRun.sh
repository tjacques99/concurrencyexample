#!/bin/sh
mvn clean package && docker build -t com.mycompany/weatherserviceear .
docker rm -f weatherserviceear || true && docker run -d -p 8080:8080 -p 4848:4848 --name weatherserviceear com.mycompany/weatherserviceear 
