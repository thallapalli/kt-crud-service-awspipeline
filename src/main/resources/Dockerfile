FROM ubuntu:latest
MAINTAINER karnakar "karnakar@ymail.com"
RUN apt-get update && apt-get install -y openjdk-8-jdk
WORKDIR /usr/local/bin/

COPY kt-crud.jar .

CMD ["java","-jar","kt-crud.jar"]