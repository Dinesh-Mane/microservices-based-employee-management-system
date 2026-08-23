> **Note:** This project is currently in development. I’ll keep adding more microservices and Spring Cloud features as I go.

### Current Status

1. Added Employee & Department Services – CRUD APIs with JPA + separate my MySQL database for each each service.
2. For inter-service Communication – Tried All 3 Http clients (RestTemplate, WebClient and OpenFeign).
3. For Service registry -> Eureka – Service registration, discovery and load balancing.
4. Implemented API Gateway – Configured routes for different services.
5. Config Server – Centralized configuration using a Git repo.
6. Dynamic Refresh – Using `@RefreshScope` for config changes without restarting services.
7. RabbitMQ + Spring Cloud Bus – Added for refreshing config across services using `/actuator/busrefresh`.

> Config Server Note: For now, I’m using a separate Git repo called `config-server-repo` for the Config Server configuration files.
Later, I’ll point the Config Server Git URI to the `config-files` directory in this project, so everything can be kept in one place.
