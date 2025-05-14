# Kafka Message Stream Demo

This is a simple message streaming application built with Spring Boot and Apache Kafka. It demonstrates how to send and consume JSON-based messages via REST endpoints using Kafka as the messaging backbone.

---

## 🎯 Objective

- Showcase Kafka producer and consumer interaction using Spring Boot
- Send structured JSON messages via a REST API
- Store consumed messages into an in-memory H2 database
- Simulate a lightweight real-time message processing pipeline

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3.0.6
- Spring Web
- Spring Kafka
- Spring Data JPA
- H2 Database (in-memory)
- Apache Kafka (Confluent Platform 7.3.0)
- Podman (Docker alternative)

---

## ⚙️ Kafka Setup via Podman

Follow these steps to run Kafka and Zookeeper locally using Podman:

```🧭 Create a Shared Network

bash
podman network create kafkanet

🦉 Start Zookeeper Container
podman run -d --name zookeeper --network kafkanet -p 2181:2181 -e ZOOKEEPER_CLIENT_PORT=2181 -e ZOOKEEPER_TICK_TIME=2000 confluentinc/cp-zookeeper:7.3.0

📬 Start Kafka Broker Container
podman run -d --name kafka --network kafkanet -p 9092:9092 -e KAFKA_BROKER_ID=1 -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka:7.3.0

🚀 Run the Spring Boot Application
./mvnw spring-boot:run

🧪 Testing the API
curl -X POST "http://localhost:8080/api/messages" -H "Content-Type: application/json" -d '{"sender":"Yasin", "content":"Hello Kafka!"}' '''
