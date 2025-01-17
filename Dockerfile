FROM maven:3.8.3 as compile
WORKDIR /qr_code
COPY ./ /qr_code
RUN mvn clean package
FROM openjdk:17
COPY --from=compile ./qr_code/target/qr_code.jar ./
ENTRYPOINT ["java","-jar", "qr_code.jar"]