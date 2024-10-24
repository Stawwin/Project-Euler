#!/usr/bin/env zsh
#
# The TASK environment variable will be set automatically in the Einstein execution
# environment.
#
# For testing, try to set the TASK environment variable...
#
[[ -z $TASK ]] && [[ -f $PWD:t ]] && TASK=$PWD:t
[[ -z $TASK ]] && [[ -f $PWD:h:t ]] && TASK=$PWD:h:t

# Fail (exit) immediately if any of the following commands fail.
#
set -e

jar="${TASK%.kt}.jar"

kotlinc $TASK -include-runtime -d $jar > /dev/null

for n in 50 10 15 20 25
do
  print $ java -jar $jar $n
  java -jar $jar $n
done
