FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="musician"
LABEL org.opencontainers.image.version="0.0.1"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1"

ENV SERVER_PORT=8081

#ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:music-musician
#ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
#ENV SPRING_DATASOURCE_USERNAME=admin
#ENV SPRING_DATASOURCE_PASSWORD=password

#ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
#ENV SPRING_JPA_GENERATE_DDL=true
#ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

#ENV SPRING_H2_CONSOLE_enabled=true

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=admin

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.PostgreSQLDialect
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.postgresql.Driver
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

EXPOSE 8081

COPY target/musician-${VERSION}.jar /opt/musician/musician.jar

CMD ["java", "-jar", "/opt/musician/musician.jar"]
