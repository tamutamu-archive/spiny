#!/usr/bin/env bash
# Linux platform bash file
echo "author godcheese"
CURRENT_DIR=`pwd`
cd $CURRENT_DIR
cd ..
mvn spring-boot:run -Dspring-boot.run.profiles=dev -DskipTests=true -Dmaven.javadoc.skip=true
cd $CURRENT_DIR