# Java - Bootstrapping JUnit

This project is ready to go in a [dev container](https://containers.dev/), so you
don't need Java or Gradle installed on your machine at all — the
[ghcr.io/tdd-workshops/devcontainer-java](https://ghcr.io/tdd-workshops/devcontainer-java)
image provides everything needed.

## Getting started

Pick whichever option is easiest for you:

1. **GitHub Codespaces** — on GitHub, click **Code → Create codespace on main**.

2. **VS Code** — install the [Dev Containers] extension, open this folder and
   run **Dev Containers: Reopen in Container**.

3. **Other dev container compatible tools** (Gitpod, Cursor, etc.) — open this
   repository; they pick up `.devcontainer/devcontainer.json` automatically.

The first time the container starts, `make install-dependencies` runs
automatically (via `postCreateCommand`). It uses the Gradle wrapper to download
the Gradle version pinned in `gradle/wrapper/gradle-wrapper.properties`, fetches
the dependencies declared in `build.gradle`, and builds and tests the project
once, so the caches are warm before you start pairing. VS Code picks up the
wrapper too, so IntelliSense and the Test Explorer use the same build.

## Running the tests

From a terminal inside the dev container:

```shell
./gradlew test
```

or:

```shell
make test
```

You should see something like this:

```shell
> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test UP-TO-DATE

BUILD SUCCESSFUL in 948ms
3 actionable tasks: 3 up-to-date
```

Run `make help` to see all available targets.

## Project layout

- `src/main/java/HelloWorld.java` — the code under test:

  ```java
  public class HelloWorld {
    public String say() {
        return "Hello, World!";
    }
  }
  ```

- `src/test/java/HelloWorldTest.java` — the test suite:

  ```java
  import org.junit.Test;
  import org.junit.Assert;

  public class HelloWorldTest {
      @Test
      public void shouldSayHelloWorld() {
          HelloWorld helloWorld = new HelloWorld();

          Assert.assertEquals("Hello, World!", helloWorld.say());
      }
  }
  ```

- `build.gradle` — the `java` plugin, the Maven Central repository and the JUnit
  dependency
- `settings.gradle` — names the project
- `gradlew`, `gradlew.bat` and `gradle/wrapper/` — the Gradle wrapper, which pins
  the exact Gradle version every attendee gets
- `Makefile` — common tasks (`make help`)
- `.devcontainer/devcontainer.json` — dev container configuration

## About JUnit

JUnit is the de-facto standard unit testing framework for Java: a test is an
ordinary method annotated with `@Test`, and expectations are expressed as calls
to the static methods on `Assert`:

```java
Assert.assertEquals("Hello, World!", helloWorld.say());
```

Gradle only tells you which test failed, so when an assertion breaks the useful
detail is one click away in the HTML report it writes under
`build/reports/tests/test/index.html`. For example, change `say()` to return
`"Hello, everyone!"` and `./gradlew test` reports:

```shell
> Task :test FAILED

HelloWorldTest > shouldSayHelloWorld FAILED
    java.lang.AssertionError at HelloWorldTest.java:9

1 test completed, 1 failed

BUILD FAILED in 2s
```

while the report shows the expected and actual values side by side.

## About dev containers

Dev containers standardise a project's development environment in a
`.devcontainer/devcontainer.json` file at the root of the repository. Any tool
that understands the [dev container spec](https://containers.dev/) — VS Code,
GitHub Codespaces, Gitpod, and others — will build or reuse the same container
image, so every participant in a workshop gets an identical setup. The old
Gitpod-specific task configuration has been replaced by this single, portable
definition, with the Gradle wrapper pinning the build tool version.

[Dev Containers]: https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers
