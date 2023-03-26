FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#WORKDIR /WEBApplication
#The first parameter tells Docker what file(s) you would like to copy into the image. .mvn/
#The second parameter tells Docker where you want that file(s) to be copied to. .mvn
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./

#RUN ./mvnw dependency:resolve

#COPY src ./src

#CMD ["./mvnw", "spring-boot:run"]
