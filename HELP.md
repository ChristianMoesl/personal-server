# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/gradle-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/html/native-image.html#native-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#using.devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#web.security)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/reference/htmlsingle/index.html#features.docker-compose)

### Guides
The following guides illustrate how to use some features concretely:

* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/gradle-plugin/reference/htmlsingle/#aot)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm webserver:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:
```
$ build/native/nativeCompile/webserver
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

