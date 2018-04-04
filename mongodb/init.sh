#!/usr/bin/env bash
if test -z "$MONGODB_ADDRESS_PASSWORD"; then
    echo "MONGODB_ADDRESS_PASSWORD not defined"
    exit 1
fi

echo "Creating mongo users..."
mongo address --eval "db.createUser({user: 'address', pwd: '$MONGODB_ADDRESS_PASSWORD', roles: [{role: 'readWrite', db: 'address'}]});"
echo "Mongo users created."


