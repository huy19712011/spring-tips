FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl as builder

WORKDIR /app
ADD spring-boot-kubernetes-demo /app/spring-boot-kubernetes-demo
RUN cd spring-boot-kubernetes-demo && ./mvnw -Dmaven.test.skip=true clean package


FROM bellsoft/liberica-runtime-container:jre-21-musl

WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
COPY --from=builder /app/spring-boot-kubernetes-demo/target/*.jar /app/app.jar