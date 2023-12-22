# SpringApp AWS Tracking service

## Maven commands

> Generated documentation

* `mvn clean package`

> Built app-shaded.jar and ready to deploy it as aws lambda

* `mvn clean package shade:shade`

## Deployed

> Locally, you can find rob service under

* http://localhost:8080

### Sample Request

``
POST http://localhost:8080/tracking --header 'Content-Type: application/json' --data '{ "satellites": [{"name":"sputnik","distance":100 }, {"name":"explorer","distance":115.5 }, {"name":"asterix","distance":142.7}]}'
``

### Documentation

> It can be found under

* rob-service/target/generated-docs/index.html
