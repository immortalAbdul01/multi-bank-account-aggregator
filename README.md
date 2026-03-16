# 🏦 Multi-Bank Account Aggregator

A **microservices-based financial aggregation platform** that connects multiple banking systems and exposes a **unified API layer** for applications to access account and financial data from different banks.

Modern fintech platforms often integrate with several banks simultaneously. Each bank has different APIs, formats, and authentication mechanisms. This project demonstrates how a centralized **Bank Aggregator Platform** can simplify this integration by acting as a **single gateway to multiple banking services**.

The system collects financial data from multiple banks, normalizes it, and provides a single standardized interface for applications.

---

# 🌍 Vision

Users frequently maintain accounts across multiple banks. Financial applications need a reliable way to access these accounts without building separate integrations for every bank.

The goal of this project is to create a **bank aggregation layer** that:

- connects to multiple banking systems
- standardizes account data
- exposes unified APIs
- enables fintech applications to build financial products faster

---


Each banking service exposes its own APIs while the aggregator service collects and standardizes the responses.

---

# 🔄 How the System Works

1. A client application sends a request to the **Bank Aggregator API**.
2. The aggregator communicates with multiple banking services.
3. Each bank returns account data in its own format.
4. The aggregator normalizes the responses.
5. The unified data is returned to the client.


---

# 🧩 Core Features

## Unified Banking API

Applications can access multiple banking systems through a **single API interface**.

Example:

