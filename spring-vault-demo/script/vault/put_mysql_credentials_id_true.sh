#!/bin/bash

export VAULT_ADDR='http://127.0.0.1:8200'
export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"

vault kv put cubbyhole/mysql username=root password=123456
