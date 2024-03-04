#!/bin/bash
# Author: Wuzhibin
# get current folder.
CMD_DIR=$(cd $(dirname $0); pwd) 
cd $CMD_DIR/.. 
echo cmd  dir is:-----$CMD_DIR
CURRENT_DIR=$(pwd)
echo current dir is:-----$CURRENT_DIR

# stop app
if [  -f "$CURRENT_DIR/application.pid" ]; then
    echo "stop app ............"
    PID_NUMBER=$(cat $CURRENT_DIR/application.pid)
    echo Curent pid is:----- $PID_NUMBER
    kill -9 $PID_NUMBER
else
    echo "App is not start"
fi
