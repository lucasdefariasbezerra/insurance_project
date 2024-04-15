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

after running the command to setup the container, you should see the image below. I use postman, but any REST API client tool is fine.
