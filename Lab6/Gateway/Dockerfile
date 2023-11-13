FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="gateway"
LABEL org.opencontainers.image.version="0.0.1"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1"

ENV SERVER_PORT=8080

ENV MUSIC_GATEWAY_HOST=localhost:8080
ENV MUSIC_MUSICIAN_URL=http://localhost:8081
ENV MUSIC_INSTRUMENT_URL=http://localhost:8082

EXPOSE 8080

COPY target/gateway-${VERSION}.jar /opt/gateway/gateway.jar

CMD ["java", "-jar", "/opt/gateway/gateway.jar"]
