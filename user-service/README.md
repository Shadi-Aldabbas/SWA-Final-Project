# SWA-Final-Project
# ** user-service**

********Kafka********

Open cmd in the kafka directory

To  start zookeeper run  bin/zookeeper-server-start.sh config/zookeeper.properties

To start broker in new window run bin/kafka-server-start.sh config/server.properties

It will run on port 9092 

To read the event run bin/kafka-console-consumer.sh --topic myTopicName --from-beginning --bootstrap-server localhost:9092



