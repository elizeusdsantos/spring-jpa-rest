# Challenge
Monster Challenge

## What do I used for?
- H2 Database
- SpringBoot
- Gradle

## How to run this app?
I tried to develop this example in the simplest way possible.

Because it's a spring-boot based app, it's pretty simple to run. You will need only Gradle and JAva installed and run using the following command in the root directory

```bash
gradle bootRun
```

## How to compile?
At the root of the project just type the following command:

```bash
gradle bootJar
```

An executable jar named spring-jpa-rest.jar will be created at `/build/libs` folder.

## [Continues] How does it work?
### General Aspects ##

The H2 Database is a very nice database and has a web console for you to browse through objects. To access, with the app running just access the url `http://localhost:8080/h2-console/`.
(user: sa; password: password)
I created two sql files at the resource's folder: one for schema generation, and the another one to database seed. 

## Avaliable resources ##
Basically whe have in this project Cities and Countries.
To insert a new country you may do a post request at: `/api/v1/countries`. Example:
```json
{
  "name": "Czech"
}
```  
To insert a new city you may make a post request at: `/api/v1/cities`. Example:
```json
{
  "name": "Prague2",
  "country": {
    "id": 4
  }
}
```  
You also may get a country by id making a get request at: `/api/v1/countries/{id}`
You can found a list of cities from a specific country making a get request at: `/api/v1/cities?country=[your_country_here]`

## What is missing ##
A documentation by swagger would fit very well.