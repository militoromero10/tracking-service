# SpringApp AWS Tracking service

## Maven commands

> Generated documentation

* `mvn clean package`

> Built app-shaded.jar and ready to deploy it as aws lambda

* `mvn clean package shade:shade`

## Deployed

> Locally, you can find rob service under

* http://localhost:8080

> AWS Deploy
 
* https://d3tik7rsg5.execute-api.us-east-2.amazonaws.com/api

### Sample Request
#### Local sample
`
POST http://localhost:8080/tracking --header 'Content-Type: application/json' --data '{ "satellites": [{"name":"sputnik","distance":100 }, {"name":"explorer","distance":115.5 }, {"name":"asterix","distance":142.7}]}'
`
#### AWS sample
`
curl --location 'https://d3tik7rsg5.execute-api.us-east-2.amazonaws.com/api/tracking' \
--header 'Content-Type: application/json' \
--data '{
"satellites": [ {  "name":"sputnik", "distance":100 },  { "name":"explorer", "distance":115.5  },
{  "name":"asterix", "distance":142.7 } ]
}'
`
### Documentation

> It can be found under

* tracking-service/target/generated-docs/index.html
