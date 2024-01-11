#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./space-astronaut/; sh ./build.sh; cd ..
    cd ./space-spaceship/; sh ./build.sh; cd ..
    cd ./space-gateway/; sh ./build.sh; cd ..
    cd ./space-ng/; sh ./build.sh; cd ..
}

main "$@"
