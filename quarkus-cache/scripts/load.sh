#!/usr/bin/env bash
export EP=http://localhost:8080/api
#export EP=http://jcache-quarkus-test.apps.cluster-cph-5bcc.cph-5bcc.example.opentlc.com/api

curl --header "Content-Type: application/json" \
  --request POST \
  -d '{"person":"Shaaf","address":"Denmark","secNumber":"00100","verifiedPerson":false,"verifiedDebts":false,"verifiedTaxes":false,"verifiedPartners":false}' \
  $EP
echo " "