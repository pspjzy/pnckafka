#!/usr/bin/env bash

curl --request POST \
  --url http://localhost:8082/topics/Customer \
  --header 'accept: application/vnd.kafka.v2+json' \
  --header 'content-type: application/vnd.kafka.avro.v2+json' \
  --data '{
    "key_schema": "{\"name\":\"key\",\"type\": \"string\"}",
    "value_schema_id": "2",
    "records": [
        {
            "key" : "789",
            "value": {
                "customerId": "789",
                "name": "11",
                "phoneNumber": "888-888-8888",
                "accountId": "0345"
            }
        }
    ]
}'

curl --request POST \
  --url http://localhost:8082/topics/Balance \
  --header 'accept: application/vnd.kafka.v2+json' \
  --header 'content-type: application/vnd.kafka.avro.v2+json' \
  --data '{
    "key_schema": "{\"name\":\"key\",\"type\": \"string\"}",
    "value_schema_id": "1",
    "records": [
        {
            "key" : "0345",
            "value": {
                "balanceId": "11",
                "accountId" : "0345",
                "balance" : 2.34
            }
        }
    ]
}'
