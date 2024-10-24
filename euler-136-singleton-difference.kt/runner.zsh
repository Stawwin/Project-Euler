#!/usr/bin/env zsh
set -e

#
# The TASK  environment variable will be set automatically in the Einstein execution
# environment.
#
# For testing, try to set the TASK environment variable...
#
[[ -z $TASK ]] && [[ -f $PWD:t ]] && TASK=$PWD:t
[[ -z $TASK ]] && [[ -f $PWD:h:t ]] && TASK=$PWD:h:t

jar="${TASK%.kt}.jar"

# Fail (exit) immediately if any of the following commands fail.
#

kotlinc $TASK -include-runtime -d $jar < /dev/null

for n in 10 100 1000 10000 100000 100000 50000000
do
  print $ java -jar $jar $n
  java -jar $jar $n
done
