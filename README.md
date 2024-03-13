ClientContactManager
ClientContactManager - это приложение, которое предоставляет управление контактными данными клиентов.
При запущенном приложении, можно зайти по веб адресу к базе данных:
http://localhost:8081/api/v1/contactManager-service/h2-console 
с логином sa и URL: jdbc:h2:mem:dbtest.

Доступ к Swagger UI для документации API: http://localhost:8081/api/v1/contactmanager-service/swagger-ui/index.html.

Приложение работает на порту 8081 и имеет базовый путь /api/v1/contactmanager-service.

Для удобства работы с API, в проекте также предоставлена папка "Collections Postman". 
В ней содержатся коллекции запросов для Postman, что облегчает тестирование и взаимодействие с API.
