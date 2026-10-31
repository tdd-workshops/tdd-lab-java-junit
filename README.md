# Java JUnit - Gilded Rose Refactoring Kata

This repository contains the Java version of Emily Bache's
[Gilded Rose Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata),
using JUnit Jupiter and Gradle.

Read [the requirements](GildedRoseRequirements.md), add tests to characterize the
existing behavior, then refactor `GildedRose.updateQuality()` and add support for
Conjured items. Do not alter the `Item` class or the `items` property.

## Getting started

This project is ready to go in a [dev container](https://containers.dev/), so you
don't need Java or Gradle installed on your machine. Pick whichever option is
easiest for you:

1. **GitHub Codespaces** — on GitHub, click **Code → Create codespace on main**.
   To open another branch, first select it from the branch selector above the
   file list. Then click **Code → Codespaces** and choose
   `Create codespace on <branch>`. The codespace will contain that branch's code.
2. **VS Code** — install the [Dev Containers] extension, open this folder and
   run **Dev Containers: Reopen in Container**.
3. **Other dev container compatible tools** (Gitpod, Cursor, etc.) — open this
   repository; they pick up `.devcontainer/devcontainer.json` automatically.

The first time the container starts, `./gradlew build` runs automatically. The
Gradle wrapper downloads the pinned Gradle version, fetches the dependencies,
and builds and tests the project so the caches are warm before you start pairing.

## Running the tests

From a terminal inside the dev container:

```shell
./gradlew test
```

Run `./gradlew tasks` to list every available Gradle task. Gradle writes an HTML
test report to `build/reports/tests/test/index.html`.

## Project layout

- `src/main/java/com/gildedrose/GildedRose.java` — the legacy code to refactor
- `src/main/java/com/gildedrose/Item.java` — the item model, which must not change
- `src/test/java/com/gildedrose/GildedRoseTest.java` — the starting JUnit test
- `GildedRoseRequirements.md` — the kata requirements
- `build.gradle` — the Java plugin and JUnit Jupiter dependencies
- `settings.gradle` — names the project
- `gradlew`, `gradlew.bat` and `gradle/wrapper/` — the pinned Gradle wrapper
- `.devcontainer/devcontainer.json` — dev container configuration

[Dev Containers]: https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers
