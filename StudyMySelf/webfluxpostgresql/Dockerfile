FROM openjdk:21
# ./gradlew build 해서 해당 프로젝트 빌드 파일 카피하기
COPY ./build/libs/webfluxpostgresql-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]