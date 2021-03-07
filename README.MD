#How to run

To create an instance of a consumer we should run the following command and define that environments variables.

```java -jar -Dserver.port=4002 -Dspring.kafka.consumer.group-id=library-bogota -Dspring.profiles.active=mysql -Dlibrary.campus=Chico target/library-events-consumer-0.0.1-SNAPSHOT-spring-boot.jar```

Change spring.kafka.consumer.group-id to use a different consumer group.
spring.profiles.active could be mysql or mongodb depending which database do you want to use.

##MySql Docker
```docker run -p 3306:3307 --name mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7.33```

##Mongo Docker
```docker run -p 27017:27017 --name some-mongo -d mongo:latest```