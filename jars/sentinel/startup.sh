#!/bin/bash

java -Dserver.port=9006 -Dcsp.sentinel.dashboard.server=localhost:9006 -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=8719 -jar sentinel-dashboard-1.7.1.jar