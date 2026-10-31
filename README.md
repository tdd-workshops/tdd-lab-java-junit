# Java - Bootstrapping JUnit

This project is ready to go in a [dev container](https://containers.dev/), so you
don't need Java or Gradle installed on your machine at all — the
[ghcr.io/tdd-workshops/devcontainer-java](https://ghcr.io/tdd-workshops/devcontainer-java)
image provides everything needed.

## Getting started

Pick whichever option is easiest for you:

1. **GitHub Codespaces** — on GitHub, click **Code → Create codespace on main**.
   To open another branch, first select it from the branch selector above the
   file list. Then click **Code → Codespaces** and choose
   `Create codespace on <branch>`. The codespace will contain that branch's code.

2. **VS Code** — install the [Dev Containers] extension, open this folder and
   run **Dev Containers: Reopen in Container**.

3. **Other dev container compatible tools** (Gitpod, Cursor, etc.) — open this
   repository; they pick up `.devcontainer/devcontainer.json` automatically.

The first time the container starts, `./gradlew build` runs automatically (via
`postCreateCommand`). The Gradle wrapper downloads the Gradle version pinned in
`gradle/wrapper/gradle-wrapper.properties`, fetches the dependencies declared in
`build.gradle`, and builds and tests the project once, so the caches are warm
before you start pairing. VS Code picks up the wrapper too, so IntelliSense and
the Test Explorer use the same build.

## Running the tests

From a terminal inside the dev container:

```shell
./gradlew test
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

Run `./gradlew tasks` to list every task the build offers.

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
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  public class HelloWorldTest {
      @Test
      void shouldSayHelloWorld() {
          HelloWorld helloWorld = new HelloWorld();

          assertEquals("Hello, World!", helloWorld.say());
      }
  }
  ```

- `build.gradle` — the `java` plugin, the Maven Central repository, the JUnit
  Jupiter dependency and the `useJUnitPlatform()` switch that tells Gradle to run
  tests with the JUnit Platform
- `settings.gradle` — names the project
- `gradlew`, `gradlew.bat` and `gradle/wrapper/` — the Gradle wrapper, which pins
  the exact Gradle version every attendee gets (the image ships Gradle too, but
  the wrapper keeps the build reproducible wherever it is run)
- `.devcontainer/devcontainer.json` — dev container configuration

## About JUnit

JUnit is the de-facto standard unit testing framework for Java. This project uses
JUnit Jupiter, the current programming model for writing tests, which the JUnit
Platform runs. A test is an ordinary method annotated with `@Test`, and an
expectation is a call to a static assertion method:

```java
assertEquals("Hello, World!", helloWorld.say());
```

Compared with the old JUnit 4 style, the annotations and assertions come from
`org.junit.jupiter.api` (there is no `org.junit.Assert` any more), neither the
test class nor its methods have to be `public`, and failures are reported as
`org.opentest4j.AssertionFailedError`, which carries the expected and actual
values rather than just a message.

Gradle only names the test that broke, so the useful detail is one click away in
the HTML report it writes under `build/reports/tests/test/index.html`. For
example, change `say()` to return `"Hello, everyone!"` and `./gradlew test`
reports:

```shell
> Task :test FAILED

HelloWorldTest > shouldSayHelloWorld() FAILED
    org.opentest4j.AssertionFailedError at HelloWorldTest.java:10

1 test completed, 1 failed

BUILD FAILED in 1s
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
