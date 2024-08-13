# 1. Maven 빌드 단계
FROM maven:3.9.8-eclipse-temurin-11 AS build

# 2. 프로젝트 소스 복사
COPY . /app

# 3. 작업 디렉토리 설정
WORKDIR /app

# 4. Maven을 사용하여 프로젝트 빌드 (테스트 생략)
RUN mvn clean package -DskipTests

# 5. Tomcat 베이스 이미지
FROM rapidfort/tomcat9-openjdk11-lb

# 6. 빌드된 WAR 파일을 Tomcat의 웹앱 디렉토리에 복사
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# 7. Tomcat 실행 (기본 설정으로 이미 ENTRYPOINT가 설정되어 있음)