#!/bin/bash

$PULSAR_HOME/bin/pulsar-admin tenants create $TENANT
$PULSAR_HOME/bin/pulsar-admin namespaces create $TENANT/$NAMESPACE

