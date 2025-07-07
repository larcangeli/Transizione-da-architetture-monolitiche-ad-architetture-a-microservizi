# Transizione da Architetture Monolitiche ad Architetture a Microservizi

A comprehensive dissertation project showcasing the evolution from monolithic architectures to microservices architectures through practical Spring Boot implementations.

## 🏗️ Project Overview

This repository demonstrates three different architectural approaches to building the same e-commerce product management system:

1. **Layered Monolith** - Traditional layered architecture
2. **Clean Monolith** - Clean Architecture principles applied to monolithic design
3. **Modular Monolith** - Spring Modulith-based modular monolith as a stepping stone to microservices

## 📁 Project Structure

```
├── layered-monolith/     # Traditional layered monolithic architecture
├── clean-monolith/      # Clean architecture monolithic implementation
├── modular-monolith/    # Spring Modulith-based modular monolith
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker (for containerization)

### Running Any Project

Each project can be built and run using the following commands:

```bash
# Build the project
mvn clean package

# Build Docker image (replace [project-name] with: layered-monolith, clean-monolith, or modular-monolith)
docker build -f docker/Dockerfile --tag [project-name]:0.0.1-SNAPSHOT .

# Run the Docker container
docker run --name [project-name] -p 8080:8080 [project-name]:0.0.1-SNAPSHOT
```

### API Endpoints

All implementations expose the same REST API:

- `GET /product-composite/{productId}` - Get a product with its recommendations and reviews
- `GET /product-composite` - Get all products
- `POST /product-composite` - Create a new product
- `DELETE /product-composite/{productId}` - Delete a product

## 🏛️ Architecture Patterns

### 1. Layered Monolith
Traditional three-layer architecture:
- **Presentation Layer**: REST controllers
- **Business Layer**: Service classes
- **Data Layer**: Repository pattern with JPA

### 2. Clean Monolith
Implements Clean Architecture principles:
- **Use Cases**: Business logic isolated from frameworks
- **Adapters**: Interface adapters for external concerns
- **Entities**: Core business entities
- **Dependency Inversion**: High-level modules don't depend on low-level modules

### 3. Modular Monolith
Uses Spring Modulith for modular design:
- **Product Module**: Core product management
- **Recommendation Module**: Product recommendations
- **Review Module**: Product reviews
- **Named Interfaces**: Well-defined module boundaries
- **Event-Driven Communication**: Modules communicate via events

## 🔧 Key Features

### Domain Model
The system manages:
- **Products**: Core product information
- **Recommendations**: Product recommendations with ratings
- **Reviews**: Customer reviews and feedback

### Technology Stack
- **Spring Boot**: Application framework
- **Spring Data JPA**: Data persistence
- **Spring Modulith**: Modular monolith support (modular-monolith only)
- **H2 Database**: In-memory database for simplicity
- **Docker**: Containerization
- **OpenAPI/Swagger**: API documentation

### Modular Monolith Highlights
- **Module Verification**: Automated tests ensure module boundaries
- **Documentation Generation**: PlantUML diagrams for module structure
- **Event Publishing**: Loose coupling between modules
- **Shared Interfaces**: Clear contracts between modules

## 📊 Module Architecture (Modular Monolith)

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Product       │    │ Recommendation  │    │     Review      │
│   Module        │    │    Module       │    │    Module       │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ • ProductService│    │ • RecService    │    │ • ReviewService │
│ • ProductRepo   │    │ • RecRepo       │    │ • ReviewRepo    │
│ • ProductDTO    │    │ • RecDTO        │    │ • ReviewDTO     │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │  Event Bus      │
                    │ (Spring Events) │
                    └─────────────────┘
```

## 🧪 Testing

### Module Verification (Modular Monolith)
```bash
# Run modularity tests
mvn test -Dtest=ModularityTest
```

This will:
- Verify module structure and boundaries
- Generate module documentation
- Create PlantUML diagrams

## 📈 Evolution Path

This project demonstrates the evolution path:

1. **Layered Monolith** → Traditional starting point
2. **Clean Monolith** → Better separation of concerns
3. **Modular Monolith** → Preparation for microservices
4. **Microservices** → (Future step) Extract modules into separate services

## 📚 Learning Objectives

- Understanding different monolithic architecture patterns
- Implementing Clean Architecture principles
- Using Spring Modulith for modular design
- Preparing monoliths for microservices migration
- Event-driven communication patterns
- Module boundary verification and documentation

## 🤝 Contributing

This is an educational project demonstrating architectural patterns. Feel free to explore the code and adapt the patterns for your own projects.

## 📄 License

This project is for educational purposes as part of a dissertation on architectural transitions.

---

**Note**: Each module in the modular monolith is designed to be easily extractable into a separate microservice, demonstrating a practical migration path from monolith to microservices.
