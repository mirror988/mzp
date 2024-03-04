#!/bin/bash
# Author: Chenlei

CMD_DIR=$(cd $(dirname $0); pwd)
cd "$CMD_DIR/.."
CURRENT_DIR=$(pwd)
echo User dir: "$CURRENT_DIR"
CONF_DIR="$CURRENT_DIR/conf"
LIB_DIR="$CURRENT_DIR/lib"
ARGS=$*

# get file name.
FILE_PATH="$LIB_DIR/bootapp"
files=$(ls "$FILE_PATH")
for filename in $files
do
   echo Main Jar: $filename
done
if [[  -f "$CONF_DIR/application.yml" || -f "$CONF_DIR/bootstrap.yml" ]]; then
    echo "Startup app $filename with parameter: $ARGS "
    nohup java \
    -server \
    -Dthin.lib.path="$LIB_DIR" \
    -Dspring.config.location="$CONF_DIR/" \
    -Dkoca.config.location="config" \
    -Dlogging.config="$CONF_DIR/logback-spring.xml" \
    -Dspring.banner.location="file:$CONF_DIR/banner.txt" \
    -Duser.timezone=GMT+08 \
    -jar "$LIB_DIR/bootapp/$filename" \
    $ARGS \
    >./nohup.log 2>&1 &
else
    echo "Configuration folder or files is not exist."
fi