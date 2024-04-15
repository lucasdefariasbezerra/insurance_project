# Insurance_project

<p align="center">The insurance project is works as microservice application to calculate insurnce budget given a car information and a series of claims considering drivers and cars involved.</p>


<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=IN%20PROGRESS&color=GREEN&style=for-the-badge"/>
</p>

## ✔️ stack

- ``Java 17``
- ``InteliJ IDEA``
- ``Springboot``
- ``Hibernate``
- ``Spring Data JPA``
- H2


## ✔️ features

- ``insurance insertion``
-  ``insurance budget calculator``
-  ``insurance update (TODO)``
-  ``insurance removal (TODO)``


# Instalation guide

To deploy the microservice you should have installed Java 17 as well as docker. For debugging purposes, please install an IDE of your choice.
Intellij community is enough for debugging teams microservice codebase.

After downloading and installing the according tools, you run the following commands to setup the database.

```bash
chmod +x gradlew && ./gradlew build -x test
```

After the jar file is generated you can execute the docker commands to build the microservice image and run the container, where its going to be deployed

```bash
docker build -t ms-insurance .


docker run -d -p 8080:8080 --name insurance-ms-container ms-insurance
```

after running the command to setup the container, you should see the image below. I use postman, but any REST API client tool is fine. The image below show how the REST client works

![Screenshot from 2024-04-14 23-32-38](https://github.com/lucasdefariasbezerra/insurance_project/assets/36819882/def6ef1c-c27f-4cdc-9735-f3601244b473)


# APIs

<h1>INSURANCE INSERTION </h1>
<p>this is the API you need to run in order to execute the insurance register: <b>http://localhost:8080/insurance/budget</b></p>

<p>this is the PAYLOAD REQUEST </p>

```json
{
    "car" : {
       "carId": 2,
       "model": "Polo",
       "manufacturer" : "Volkswagem",
       "year" : "2018",
       "fipeValue" : 40000 
    },
    "driverList": [
        {
           "document" : "23345567123",
           "birthDate" : "11/08/1980",
           "isMain": "true" 
        },
        {
           "document" : "23398567323",
           "birthDate" : "11/08/1999",
           "isMain": "false" 
        }
    ],
    "customer" : {
           "document" : "23345567123",
           "birthDate" : "11/08/1980",
           "name" : "Luis Marcos Souza" 
        },
    "claimList" : [
        {
            "driverDocument" : "23398567323",
            "carId" : 1,
            "eventDate" : "11/10/2021"
        }
    ]
}
```
<h1>INSURANCE PRICE CALCULATOR</h1>
<p>this is the API you need to run in order to execute the insurance register: <b>http://localhost:8080/insurance/budget/{insuranceId}</b></p>
<p>this is how the payload should look like</p>

```json
{
    "customerName": "Luis Marcos Souza",
    "carModel": "Polo",
    "fipeValue": 40000.0,
    "insurancePrice": 3200.0
}
```


