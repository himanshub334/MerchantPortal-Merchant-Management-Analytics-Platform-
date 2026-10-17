# MerchantPortal — Merchant Management & Analytics Platform

A portfolio-ready full-stack starter for merchant onboarding, transaction analytics, standardized API errors, and delivery metrics.

## Stack
- Java 17, Spring Boot 3, Spring Data JPA, Bean Validation
- PostgreSQL, Redis cache
- Angular 15, TypeScript, Angular Material, reactive forms
- JUnit 5, Mockito, GitHub Actions, JaCoCo, Docker Compose, OpenAPI
- Architecture Decision Record (ADR) and sprint metrics template

## Features
- Multi-step merchant onboarding UI with client-side validation and async merchant-name availability check
- REST API for merchants, merchant summary analytics, and sprint metrics
- Global `@ControllerAdvice` with consistent `ErrorResponse` (`timestamp`, `status`, `code`, `message`, `traceId`)
- Redis caching for merchant summary responses (falls back to application behavior when Redis is unavailable only if configured)
- PostgreSQL persistence with schema managed by Hibernate for local development
- Swagger UI and sample data seeding
- CI workflow and coverage reporting configuration
- ADR comparing Angular, React, and Vue, plus a sprint metrics template

## Quick start with Docker
1. Copy `.env.example` to `.env` and adjust credentials.
2. Run `docker compose up --build`.
3. Backend API: http://localhost:8080/api
4. Swagger UI: http://localhost:8080/swagger-ui/index.html
5. Angular dev server is intended to run locally at http://localhost:4200.

The compose file starts PostgreSQL, Redis, and the backend. Start the Angular app separately:
```bash
cd frontend
npm install
npm start
```

## Local backend run
Requires Java 17+ and Maven:
```bash
cd backend
mvn spring-boot:run
```

## Tests
```bash
cd backend
mvn test
```
Tests are included for service validation and standardized error handling. Run them in an environment with Maven and dependency access.

## Important scope notes
This is a learning/demo project, not a production-hardened merchant acquiring system. Analytics are generated from demo data, no payment card data is stored, and authentication/authorization, production secrets management, deployment, and CloudWatch integration must be added/configured for a real deployment. Sprint metrics are illustrative templates and must not be represented as measured production outcomes.
# MerchantPortal-Merchant-Management-Analytics-Platform-
