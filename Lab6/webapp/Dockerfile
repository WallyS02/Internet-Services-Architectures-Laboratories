FROM nginx:1.23.3

LABEL org.opencontainers.image.title="webapp"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/webapp /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
