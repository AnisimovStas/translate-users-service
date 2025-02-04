# Используем JDK для сборки
FROM eclipse-temurin:23-jdk AS builder
WORKDIR /app

# Копируем файлы и собираем приложение
COPY . .
RUN chmod +x gradlew && ./gradlew build -x test

# Используем JRE для запуска
FROM eclipse-temurin:23-jre
WORKDIR /app

# Копируем JAR из builder-образа
COPY --from=builder /app/build/libs/*.jar /home/feral/opt/translate/users.jar

# Даем права на выполнение
RUN chmod +x /home/feral/opt/translate/users.jar

# Определяем переменные окружения
ENV JWT_SECRET=""
ENV USERS_DB_PASSWORD=""
ENV USERS_DB_USERNAME=""

# Запуск приложения
CMD java -DJWT.SECRET="$JWT_SECRET" -DUSERS.DB.PASSWORD="$USERS_DB_PASSWORD" -DUSERS.DB.USERNAME="$USERS_DB_USERNAME" -jar /home/feral/opt/translate/users.jar
