# Build
mvn clean package && docker build -t com.mycompany/weatherservice .

# RUN

docker rm -f weatherservice || true && docker run -d -p 8080:8080 -p 4848:4848 --name weatherservice com.mycompany/weatherservice 