> **Note:** This project is currently in development.  

### Current Status

1. Added Employee & Department Services – CRUD APIs with JPA + separate my MySQL database for each each service.
2. For inter-service Communication – Tried All 3 Http clients (RestTemplate, WebClient and OpenFeign).
3. For Service registry -> Eureka – Service registration, discovery and load balancing.
4. Implemented API Gateway – Configured routes for different services.
5. Config Server – Centralized configuration using a Git repo.
6. Dynamic Refresh – Using `@RefreshScope` for config changes without restarting services.
7. RabbitMQ + Spring Cloud Bus – Added for refreshing config across services using `/actuator/busrefresh`.

**Testing / Development Results:**

<img width="1910" height="1023" alt="dynamic reload using spring cloud bus and rabbitmq 01" src="https://github.com/user-attachments/assets/19161492-b55e-4c7a-b571-0e73a980e0cc" />

<img width="1918" height="1018" alt="dynamic reload using spring cloud bus and rabbitmq 02" src="https://github.com/user-attachments/assets/06c31a14-a8be-410f-9361-49da822b600b" />


<img width="1918" height="893" alt="image" src="https://github.com/user-attachments/assets/68bd5b55-21f4-433a-a243-147e4772d772" />


<img width="1891" height="966" alt="dynamic reload using spring cloud bus and rabbitmq 03" src="https://github.com/user-attachments/assets/b7f44da9-6b49-4f3f-840c-320ab5046f49" />


<img width="1465" height="551" alt="dynamic reload using spring cloud bus and rabbitmq 04" src="https://github.com/user-attachments/assets/21f085dc-bc67-40a9-99c2-7e3f7467ebb0" />


<img width="1433" height="546" alt="dynamic reload using spring cloud bus and rabbitmq 05" src="https://github.com/user-attachments/assets/915f46ea-c619-4b1c-8a06-2e9b4c726562" />



> Config Server Note: For now, I’m using a separate Git repo called `config-server-repo` for the Config Server configuration files.
Later, I’ll point the Config Server Git URI to the `config-files` directory in this project, so everything can be kept in one place.

config-server-repo link: https://github.com/Dinesh-Mane/config-server-repo
