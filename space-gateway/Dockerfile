FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="space-gateway"
LABEL org.opencontainers.image.authors="Iwona Bendig"
LABEL org.opencontainers.image.source="https://github.com/iben0402/spring-boot-pg-tasks/tree/docker"
LABEL org.opencontainers.image.url="https://github.com/iben0402/spring-boot-pg-tasks/"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Space project, spaceships and astronauts"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:space-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV SPACE_GATEWAY_HOST=localhost:8080
ENV SPACE_ASTRONAUT_URL=http://localhost:8081
ENV SPACE_SPACESHIP_URL=http://localhost:8082

EXPOSE 8080

COPY target/space-gateway-${VERSION}.jar /opt/space-gateway/space-gateway.jar

CMD ["java", "-jar", "/opt/space-gateway/space-gateway.jar"]
