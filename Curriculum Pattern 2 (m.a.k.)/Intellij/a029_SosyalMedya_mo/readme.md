# Data Transfer Between Microservices:
- with Feign Client -> AuthMicroService to UserMicroService
- with Feign Client -> UserMicroService to AuthMicroService
- with RabbitMq -> AuthMicroService to UserMicroService
- with RabbitMq -> UserMicroService to ElasticMicroService (to form elastic data for fast search)
- with Feign Client -> ElasticMicroService to UserMicroService ->to ElasticMicro Service (Elastic/utility/GetAllData - init() metodu ile ilk verinin çekilmesi)