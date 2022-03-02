Download Docker Desktop
Run <docker pull jboss/wildfly> in command line

Create the following Docker file as Dockerfile, no extension, and place it in a folder where you will also place project jars.
*****************************************************************************
FROM jboss/wildfly

ADD concurrency1.jar /opt/jboss/wildfly/standalone/deployments/

ADD concurrency2.jar /opt/jboss/wildfly/standalone/deployments/

ADD weatherman.war /opt/jboss/wildfly/standalone/deployments/

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
*****************************************************************************


1. After any mods to program, run: <mvn clean install> to build jars/wars
	a. jars/wars: concurrency1.jar, concurrency2.jar, weatherman.war
2. Move jars/wars from project target folders to folder where Dockerfile is located.
3. Either start an existing jboss/wildfly container in Docker Desktop or run this command: 
	<docker build --tag=jboss/wildfly-admin .> to build a new container from the folder where Dockerfile is located.
	a. Container will not show up in Docker desktop until step 4 is complete
4. Run container: <docker run -p 8080:8080 -p 9990:9990 -it jboss/wildfly-admin> After running this command
	the container appears in Docker desktop.
5. Weather data should be available on http://localhost:8080/weatherman/newyork and http://localhost:8080/weatherman/losangeles