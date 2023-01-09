FROM maven:3.8.6-jdk-11
WORKDIR /carina-solvd
COPY ./src /carina-solvd/src
COPY pom.xml /carina-solvd
RUN mvn clean test
CMD ["mvn","test"]
EXPOSE 3000