CRUD API
The REST API performs CRUD operations on Animal objects as described below.

Installation
* Get the project
clone

[git clone https://github.com/uncg-csc340/f24-crud-api-jpa.git](https://github.com/drblume/CRUDAPI.git)

download zip.

API Endpoints

Get list of Animals
Request
`GET /animal/all`

`http://localhost:8080/animal/all`
Response
 [

 { "aniamlId": 1, "name": "sample1", "scientificName": null, "species": "sample1", "habitat":"sample1", "description": null}, 

 { "aniamlId": 2, "name": "sample2", "scientificName": null,"species": "sample2", "habitat":"sample2", "description":null}, 

 { "aniamlId": 3, "name": "sample3", "scientificName": null, "species": "sample3", "habitat":"sample3", "description":null}

 ]

Get a specific Animal
Request
GET /animal/{animalId}

http://localhost:8080/animal/1

Response
{
  { "aniamlId": 1, "name": "sample1", "scientificName": null, "species": "sample1", "habitat":"sample1", "description":null}
}
Create a new Animal

Request
`POST /animal/new`

`http://localhost:8080/animal/new` --data '{ "aniamlId": 4, "name": "sample4", "scientificName": null, "species": "sample4", "habitat":"sample4", "description":null}'
Response
[

 { "aniamlId": 1, "name": "sample1", "scientificName": null, "species": "sample1", "habitat":"sample1", "description":null}, 

 { "aniamlId": 2, "name": "sample2", "scientificName": null,"species": "samle2", "habitat":"sample2", "description":null}, 

 { "aniamlId": 3, "name": "sample3", "scientificName": null, "species": "sample3", "habitat":"sample3", "description":null},

 { "aniamlId": 4, "name": "sample4", "scientificName": null, "species": "sample4", "habitat":"sample4", "description":null}
 
]

Get Animals by species
Request
`GET /animal/species/bird`

`http://localhost:8080/animal/species/bird`
Response
 [

	{"aniamlId": 1, "name": "sample1", "scientificName": null, "species": "bird", "habitat":"sample1", description":null},

	{"aniamlId": 1, "name": "sample3", "scientificName": null, "species": "bird", "habitat":"sample3", description":null}

 ]
 
Get Animals with related substrings
Request
`GET /animal/search?name=blue`

`http://localhost:8080/animal/honors?gpa=3.5`
Response
[

	{"aniamlId": 1, "name": "Blue Jay", "scientificName": null, "species": "bird", "habitat":"sample1", description":null},

	{"aniamlId": 3, "name": "Blue Whale", "scientificName": null, "species": "whale", "habitat":"sample3", description":null}
 
]

Update an existing Animal
Request
`PUT /animal/update/{animalId}`

`http://localhost:8080/animal/update/1` --data ' {"aniamlId": 1, "name": "sampleUpdated", "scientificName": null, "species": "sample1", "habitat":"sample1", "description":null}'

Response
{
  "aniamlId": 1, "name": "sampleUpdated", "scientificName": null, "species": "sample1", "habitat":"sample1", "description":null
}

Delete an existing Animal
Request
`DELETE /animal/delete/{animalId}`

`http://localhost:8080/animal/delete/1`
Response
[

 { "aniamlId": 2, "name": "sample2", "scientificName": null,"species": "samle2", "habitat":"sample2", "description":null}, 

 { "aniamlId": 3, "name": "sample3", "scientificName": null, "species": "sample3", "habitat":"sample3", "description":null},

 { "aniamlId": 4, "name": "sample4", "scientificName": null, "species": "sample4", "habitat":"sample4", "description":null}
 
]
