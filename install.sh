#!/bin/bash
kubectl create secret generic cloudsql-user-credentials --from-literal=username=james --from-literal=password=tpm1234
kubectl create secret generic cloudsql-proxy-credentials --from-file=credentials.json=../key.json