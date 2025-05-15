FROM ghcr.io/graalvm/native-image-community:21

WORKDIR /app

COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

RUN chmod +x ./gradlew
COPY src ./src

RUN ./gradlew nativeCompile -x test --no-daemon

# Stage 2: Create the runtime image
FROM alpine:3.19

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=builder /app/build/native/nativeCompile/bulletinboard-app ./bulletinboard-app
RUN chown appuser:appgroup ./bulletinboard-app
USER appuser
EXPOSE 8080
ENTRYPOINT ["./bulletinboard-app"]
