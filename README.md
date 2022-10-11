# ASLib

Small set of APIs to do simple daily tasks. From the version 12.0.0, it is updated to use Java language level 11 and its modular design. This library is composed of three **jar** packages and the **pom.xml** file:

- ASLib-12.0.0.jar
- ASLib-12.0.0-javadoc.jar
- ASLib-12.0.0-sources.jar
- pom.xml

It was intended to be a Maven dependency, but so far, it needs to be manually installed in the local repository.

### Installation

1. Go to the [releases](https://github.com/AdrianoSiqueira/ASLib/releases/latest "latest release") page and download the zip package.
1. Extract the zip package.
1. Run the following command inside the extracted folder:
   ```shell
   mvn install:install-file -Dfile=ASLib-12.0.0.jar -DpomFile=pom.xml
   ```
   All the three packages will be installed automatically.

For more information about how to install external jars, see the Maven's [documentation](https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html).

### Usage

After installation, add the dependence in the **pom.xml**:

```
<dependency>
    <groupId>com.github.adrianosiqueira</groupId>
    <artifactId>ASLib</artifactId>
    <version>12.0.0</version>
</dependency>
```

### Documentation

The documentation of the library can be found in the [wiki](https://github.com/AdrianoSiqueira/ASLib/wiki) section.
