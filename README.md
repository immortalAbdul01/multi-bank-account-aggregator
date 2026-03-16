# Multi-Bank Account Aggregator

A microservices-based financial aggregation platform built with Java and Spring Boot. It connects to multiple banking systems, normalises their responses, and exposes a single unified API for client applications.

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

---

## What It Does

Modern fintech apps need data from multiple banks simultaneously. Each bank has its own API format, field naming, and response structure. Instead of building separate integrations every time, this platform acts as a central gateway:

```
Client App  →  Bank Aggregator (8080)  →  Bank Alpha (8081)
                                        →  Bank Beta  (8082)
```

The aggregator fans out requests to each bank in parallel, maps their different schemas to a single canonical model, and returns one clean unified response.

---

## Services

| Service | Port | Responsibility |
|---|---|---|
| `bank-aggregator-service` | 8080 | Orchestration, normalisation, public API |
| `bank-alpha-service` | 8081 | Simulated Bank A with its own data model |
| `bank-beta-service` | 8082 | Simulated Bank B with a different schema |

---

## Getting Started

**Prerequisites:** Java 17+, Maven

Clone the repo and start each service in a separate terminal:

```bash
# Terminal 1: Bank Alpha
cd bank-alpha-service
./mvnw spring-boot:run

# Terminal 2: Bank Beta
cd bank-beta-service
./mvnw spring-boot:run

# Terminal 3: Aggregator
cd bank-aggregator-service
./mvnw spring-boot:run
```

---

## API Usage

### Get all accounts for a user

```http
GET /api/accounts/{userId}
```

**Example:**

```bash
curl http://localhost:8080/api/accounts/user123
```

**Response:**

```json
[
  {
    "id": "ALPHA-001",
    "accountHolderName": "Abdul Khan",
    "balance": 85000.00,
    "accountType": "SAVINGS",
    "currency": "INR",
    "bankSource": "ALPHA"
  },
  {
    "id": "BETA-002",
    "accountHolderName": "Abdul Khan",
    "balance": 42500.50,
    "accountType": "CURRENT",
    "currency": "INR",
    "bankSource": "BETA"
  }
]
```

Each bank returns data in its own format. The aggregator maps both to the same `AccountDTO` model before responding.

---

## Project Structure

```
multi-bank-account-aggregator/
├── bank-aggregator-service/
│   └── src/main/java/
│       ├── controller/       # REST endpoints
│       ├── service/          # Orchestration logic
│       ├── client/           # Per-bank HTTP clients
│       └── dto/              # Unified AccountDTO model
│
├── bank-alpha-service/
│   └── src/main/java/
│       ├── controller/
│       └── model/            # Alpha-specific response format
│
└── bank-beta-service/
    └── src/main/java/
        ├── controller/
        └── model/            # Beta-specific response format
```

---

## How Normalisation Works

Bank Alpha and Bank Beta return different JSON structures for the same concept:

```json
// Bank Alpha
{ "accountNumber": "ALPHA-001", "availableBalance": 85000.00, "holderName": "..." }

// Bank Beta
{ "acct_id": "BETA-002", "balance": 42500.50, "customer_name": "..." }
```

Each bank has a dedicated mapper class in the aggregator that transforms its response into the common `AccountDTO`. Adding a new bank means adding one new mapper, nothing else changes.

---

## Roadmap

- [ ] JWT authentication on aggregator endpoints
- [ ] Circuit breaker with Resilience4j for bank downtime handling
- [ ] Redis caching for balance data
- [ ] Docker Compose setup for one-command startup
- [ ] Distributed tracing with Micrometer + Zipkin
- [ ] Swagger UI for interactive API docs

---

## Real-World Context

This architecture mirrors what platforms like Plaid (US), Tink (EU), and India's RBI Account Aggregator framework do in production. The core pattern is the same: normalise heterogeneous bank APIs behind a single contract so upstream apps don't care about what's underneath.

---

## License

MIT
