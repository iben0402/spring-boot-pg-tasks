FROM nginx:1.25

LABEL org.opencontainers.image.title="space-ng"
LABEL org.opencontainers.image.authors="Iwona Bendig"
LABEL org.opencontainers.image.source="https://github.com/iben0402/spring-boot-pg-tasks/tree/docker"
LABEL org.opencontainers.image.url="https://github.com/iben0402/spring-boot-pg-tasks/"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Space project, spaceships and astronauts"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"
ENV API_URL http://localhost:8080/api

ADD dist/space-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/

EXPOSE 80


