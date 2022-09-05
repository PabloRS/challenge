# Code challenge with SPAN.

## How to run app.

### Using IntelliJ.
* Download jar file from (https://app.circleci.com/pipelines/github/PabloRS/challenge?branch=master).
  - select build under the most recent built pipeline.
  - go to ARTIFACTS tab and look for the jar file like 'challenge-0.0.1-SNAPSHOT.jar'
  - select it, and it would be downloaded, if there is no artifact, click on 'Rerun' in the top right corner and repeat steps.


### Downloading jar file
* Clone repository from https://github.com/PabloRS/challenge and import with IntelliJ.
* Move your input file to /resources/input if using IntelliJ or provide the path in parameters.
* Run mvn clean install and mvn spring-boot:run
* Run (java -jar ./target/challenge-0.0.1-SNAPSHOT.jar path_to_file) in the CLI.