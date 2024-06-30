#!/bin/bash

# Git 리포지토리에서 최신 코드를 가져옵니다.
git pull origin develop

# 애플리케이션 빌드
./gradlew app:build

# Docker Compose를 사용하여 컨테이너 실행
docker-compose down
docker-compose up -d --build