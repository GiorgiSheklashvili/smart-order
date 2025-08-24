# SmartOrder – Advanced E-Commerce Microservices System

##  Project Goal

This project is designed as a **production-grade microservices system** built using **Java**, **Spring Boot**, and **modern cloud-native technologies**. Its primary goal is to serve as a **learning and practice platform** to explore and master real-world architectures, tools, and patterns used in high-scale distributed systems.

---

## Tech Stack & Tools

| Area            | Tools / Technologies                     |
|-----------------|------------------------------------------|
| Language        | Java 21, Spring Boot 3.5.0, Spring Cloud |
| Architecture    | Microservices, Event-driven, DDD         |
| Messaging       | Apache Kafka, Spring Cloud Stream        |
| Orchestration   | Docker, Kubernetes, Helm                 |
| CI/CD           | Jenkins, GitHub Actions                  |
| Observability   | Prometheus, Grafana, Zipkin              |
| Security        | JWT, OAuth2, mTLS, Spring Security       |
| Database        | PostgreSQL, Redis, Amazon RDS            |
| Config Mgmt     | Spring Cloud Config + Kafka updates      |
| Cloud           | AWS (EKS, RDS, MSK, ElastiCache, S3)     |
| RPC             | gRPC, RSocket                            |
| Performance     | JMeter, Gatling, SQL Profiler            |
| Build Tools     | Gradle, Ant                              |
| Legacy Support  | WAR deployments on Tomcat/JBoss          |
| Bonus           | WebAssembly (WASM) integration           |

---

## Key Services

- `order-service`
- `user-service`
- `product-service`
- `inventory-service`
- `notification-service`
- `gateway-service`
- `config-service`
- `discovery-service`
- `recommendation-service`

---

## Learning Focus Areas

- Production-level configuration & automation
- High-concurrency Java + SQL performance tuning
- Secure service-to-service communication
- Cloud-native deployment with AWS & Helm
- Centralized logging, tracing, and monitoring
- Domain modeling using DDD

---

## Status

Actively under development as a **personal practice ground** for building resilient and scalable distributed systems. Contributions, suggestions, and feedback are welcome!
## How to Receive Updates from [GitHub Config Repo](https://github.com/GiorgiSheklashvili/smart-order-config)

Follow these steps to wire together Git → Spring Cloud Config → Kafka → Inventory Service with real-time property updates!
### Quick Command Summary

```bash
# 1. Start Kafka
docker-compose up -d

# 2. Run Config Server
cd config && ./mvnw spring-boot:run

# 3. Start Ngrok on port 8071
ngrok http 8071

# 4. Update service `application.yml` files:
#    Set:
#       spring.config.import: "optional:configserver:https://<your-ngrok-url>"

# 5. Configure Git webhook:
#    Point to: https://<your-ngrok-url>/monitor

# 6. Run Inventory Microservice
cd inventory && ./mvnw spring-boot:run

# 7. Push a change to the config repository (e.g., update inventory.threshold)

# 8. From WSL, verify the updated property:
curl http://192.168.50.206:8080/actuator/env | grep inventory.threshold
