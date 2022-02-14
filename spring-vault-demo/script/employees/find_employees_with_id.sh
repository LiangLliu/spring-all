#!/bin/bash

#curl -X GET --header 'Accept: application/json' 'http://localhost:8080/employees/1'
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/employees/1' | json_pp