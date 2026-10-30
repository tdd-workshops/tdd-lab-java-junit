# Define default target
.DEFAULT_GOAL := help
.PHONY: help install-dependencies test

help:
	@grep -E '^[a-zA-Z0-9_-]+:.*?## .*$$' Makefile | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

install-dependencies: ## Downloads the pinned Gradle distribution and warms up the build cache
	./gradlew build

test: ## Runs the unit test
	./gradlew test
