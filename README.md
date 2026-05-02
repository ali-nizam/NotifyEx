# NotifyEx

![Build Status](https://github.com/ali-nizam/NotifyEx/actions/workflows/ci.yml/badge.svg)
![License](https://img.shields.io/github/license/ali-nizam/NotifyEx)

A cloud-native notification engine featuring **Multi-Protocol Entry Points (REST & Event-Driven)**. Built with Quarkus and Hexagonal Architecture to provide seamless integration for both synchronous and asynchronous workloads.

---

## 🏗️ Architecture
This project implements **Hexagonal Architecture (Ports & Adapters)** to ensure business logic remains agnostic of infrastructure and frameworks.

* **Domain**: Pure business logic and entity models (Zero dependencies).
* **Infrastructure**: Framework-specific implementations (Quarkus, Persistence, Messaging).
* **Adapters**: Entry points (REST, MQ) and Outbound integrations (SMTP, SQS, Twilio).

---

## 🛠️ Tech Stack
* **Framework**: [Quarkus](https://quarkus.io/) (Java 21)
* **API Standard**: Jakarta REST (JAX-RS) with Jackson
* **Validation**: Hibernate Validator (Jakarta Validation)
* **Observability**: SmallRye Health (Liveness/Readiness probes)

---

## 🚀 Development & Running

### Running in Dev Mode
You can run your application in dev mode that enables live coding using:
```shell
./mvnw quarkus:dev