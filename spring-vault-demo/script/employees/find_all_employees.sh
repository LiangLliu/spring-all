#!/bin/bash

#curl -X GET --header 'Accept: application/json' 'http://localhost:8080/employees?page=0&size=10'
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/employees?page=0&size=10' | json_pp