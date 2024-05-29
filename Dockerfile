FROM yannoff/maven:3-openjdk-19 AS builder

WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn package

FROM openjdk:19-slim AS runner

COPY --from=builder /app/target/carros-facisa-back-0.0.1-SNAPSHOT.jar .
CMD java -jar carros-facisa-back-0.0.1-SNAPSHOT.jar