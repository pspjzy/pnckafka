# pnckafka
## problem:
All the code is in the main method in KafkaStream class
1. I use GenericRecord as Serde, not sure if that's right. Also I don't know how to get accountid from stream.
2. I have error on line 59 about cast issue.


## Steps

1. Create topic

./scripts/topics_create.sh
   Created topic Balance.
   Created topic Customer.
   Created topic CustomerBalance.

2. Register schemas

./mvnw schema-registry:register

3. Generate kafka data

./mvnw avro:schema
