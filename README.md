# Documentación

Se está utilizando Java 21 y Springboot 3.2.4

En las ``application.properties`` colocar la url en **spring.datasource.url**
de la base de datos a leer.

Por defecto: *localhost:3308/futbol*

Correr el comando ``docker compose up -d``
esto crea una bd con la url *localhost:3308* y automaticamente crea un
schema **futbol**. Esto se hace por si no se desea crear manualmente el schema

El esquema de la base de datos se está creando al iniciar y destruyendo al finalizar para así 
tener siempre la data inicial

Si se desea cambiar este comportamiento colocar **spring.jpa.hibernate.ddl-auto** en *update*

# Iniciar

Ejecutar (después de esperar que docker compose up -d termine y se pueda realizar la conexión) ``mvn spring-boot:run``

Swagger: http://localhost:8080/swagger-ui/index.html




