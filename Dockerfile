FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk add --no-cache ttf-dejavu && rm -rf /var/cache/apk/*
ADD target/flowable-rest-custom-docker-0.0.1-SNAPSHOT.jar app.jar
ADD wait-for-something.sh .
RUN chmod +x wait-for-something.sh
ENTRYPOINT ["java", "-jar", "app.jar"]