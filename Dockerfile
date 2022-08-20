FROM 241174/ubuntu-postgresql-jdk8:latest

#Author of the Docker File
# MAINTAINER Ratnesh Note: MAINTAINER has been deprecated for LABEL, 
# LABEL is a key value pair 
LABEL "Maintainer"="Ratnesh"

ADD . /usr/local/docker-pgsql-connector
RUN cd /usr/local/docker-pgsql-connector && mvn assembly:assembly
CMD ["java", "-cp", "/usr/local/docker-pgsql-connector/target/docker-postgresql-connector-1.0.0-SNAPSHOT.jar", "com.docker.postgresql.MyPostgresqlConnection"]