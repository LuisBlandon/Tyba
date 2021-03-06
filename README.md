# Getting Started
These instructions will get you a copy of the project up and running on your local machine for automation testing purposes.

# Installing

## Prerequisites
Install previously 

> Install Java 8 and Maven in your local machine
> Install TestNG and Surfire plugin in your eclipse

## Dependencies

Step by step process to get environment running

> Clone the repository to your local machine `https://github.com/LuisBlandon/Tyba.git`

> Now install Maven dependencies

```shell
$ mvn clean install -U
```

# Running Tests

> Run all tests with

```shell
$ mvn test
```

> Run only specific tests with 

```shell
$ mvn test -Dcucumber.options="--tags @tagname
```

3. Run in eclipse: go to RunTest.java class and execute with Run AS -> JunitTest

## Environment

1. Modify file env.properties value ENV_KEY to setup environment to execute automation test, Define Environment, possible values Docker, Dev, Test, ExampleEnv
2. Modify Run configuration to define environment VM Arguments:  -DENV_KEY=Dev


**Authors**
* **Luis Blandon** - *Initial work*
