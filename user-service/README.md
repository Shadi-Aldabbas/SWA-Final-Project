# SWA-Final-Project
# ** user-service**


********Cassandra********

TO check database from docker 

docker exec -it <Id> ---- Id is the id where the container is running

to see keyspaces run describe keyspaces;

use keyspaceName;

to see tables run describe tables;


 

********Kafka********

Open cmd in the kafka directory

To  start zookeeper run  bin/zookeeper-server-start.sh config/zookeeper.properties

To start broker in new window run bin/kafka-server-start.sh config/server.properties

It will run on port 9092 

To read the event run bin/kafka-console-consumer.sh --topic myTopicName --from-beginning --bootstrap-server localhost:9092

********Docker********

Open cmd in the directory where the app is going to be deckorized

first run for cassandra docker ==> docker compose up -d

then run for .jar file ==> mvn clean package -DskipTests

then run ==>  docker build --tag=user-service-image:latest .

then run ==> docker run --name user-service -p9002:9002 user-service-image:latest 


