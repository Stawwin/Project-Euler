#!/usr/bin/env zsh
#
# The TASK  environment variable will be set automatically in the Einstein execution
# environment.
#
# For testing, try to set the TASK environment variable...
#
[[ -z $TASK ]] && [[ -f $PWD:t ]] && TASK=$PWD:t
[[ -z $TASK ]] && [[ -f $PWD:h:t ]] && TASK=$PWD:h:t

# Fail (exit) immediately if any of the following commands fail.
#
set -e

for n in 5 15 25
do
  print $ go run $TASK $n
  go run $TASK $n
done
