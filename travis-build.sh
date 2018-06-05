#!/bin/bash
set -e

export EXIT_STATUS=0

./gradlew -Dgeb.env=firefoxHeadless test || EXIT_STATUS=$?

exit $EXIT_STATUS
