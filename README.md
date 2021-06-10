#Kafka Stream

##Prerequisites
- Install Kafka on mac: **brew install kafka**
- Start zookeeper: **zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties**
- Start kafka: **kafka-server-start /usr/local/etc/kafka/server.properties**
- To list entry in topic: **kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning**