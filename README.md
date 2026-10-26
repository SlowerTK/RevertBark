# RevertBark

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/revertbark?style=flat-square&logo=modrinth&label=downloads&color=1BD96A)](https://modrinth.com/mod/revertbark)
[![Modrinth Version](https://img.shields.io/modrinth/v/revertbark?style=flat-square&label=version)](https://modrinth.com/mod/revertbark/versions)
[![Minecraft](https://img.shields.io/modrinth/game-versions/revertbark?style=flat-square&label=minecraft)](https://modrinth.com/mod/revertbark/versions)
[![License](https://img.shields.io/badge/license-Unlicense-blue?style=flat-square)](LICENSE)

**Bone meal grows the bark back on stripped logs.**

<p align="center">
  <img src="https://cdn.modrinth.com/data/z4suwyVn/images/135593fc9cf77940e19f5bd722c186289bfcaa5a.gif" width="640" alt="Using bone meal on a stripped log">
</p>

<p align="center"><a href="#-по-русски">Русская версия ↓</a></p>

## What it does

One of those small inconsistencies in Minecraft: you can strip a log, but you can never undo it. RevertBark fixes that.

- Use **bone meal** on a stripped log, stem, wood or hyphae — the bark grows back
- **No new items, no new blocks, no recipes** — it only extends the vanilla bone meal behaviour
- Works **client and server side**, so it behaves the same in singleplayer and on a server
- Plays the vanilla bone meal particles and sound, so it feels like part of the game

## Install

The easiest way — install from **[Modrinth](https://modrinth.com/mod/revertbark)** with the Modrinth App or Prism Launcher.

Manually:

1. Install **Fabric Loader** (or NeoForge) for your Minecraft version.
2. Put the mod jar into `.minecraft/mods`.
3. Make sure **[Fabric API](https://modrinth.com/mod/fabric-api)** is installed as well — the mod depends on it.

| | |
| --- | --- |
| Minecraft | 1.20.1 – 1.21.1 |
| Loaders | Fabric, NeoForge |
| Side | Client and server |
| Dependency | Fabric API (Fabric builds) |

## Build from source

Requires **JDK 17**.

```bash
./gradlew build
```

The jar lands in `build/libs/`. The Gradle configuration in this repository builds the **Fabric** version; NeoForge builds are published on Modrinth.

## Project layout

| Path | Purpose |
| --- | --- |
| `src/main/java/org/revertbark/` | Mod entry point and bone meal logic |
| `src/main/java/org/revertbark/client/` | Client entry point (particles) |
| `src/main/resources/` | `fabric.mod.json`, mixins, assets |
| `gradle.properties` | Minecraft, loader and Fabric API versions |
| `build.gradle` | Fabric Loom setup |

## Credits

- Idea: **Paradise_Man**
- Code: **SlowerTK**

## License

[Unlicense](LICENSE) — public domain.

---

## 🇷🇺 По-русски

**Костная мука возвращает кору обтёсанным брёвнам.**

<p align="center">
  <img src="https://cdn.modrinth.com/data/z4suwyVn/images/135593fc9cf77940e19f5bd722c186289bfcaa5a.gif" width="640" alt="Костная мука на обтёсанном бревне">
</p>

### Что делает

В Minecraft можно обтесать бревно, но нельзя вернуть всё обратно. RevertBark это исправляет.

- Примените **костную муку** на обтёсанное бревно, стебель, древесину или гифы — кора отрастает обратно
- **Никаких новых предметов, блоков и рецептов** — мод только расширяет поведение ванильной костной муки
- Работает **на клиенте и на сервере**, так что ведёт себя одинаково в одиночной игре и на сервере
- Использует ванильные частицы и звук костной муки, поэтому не выбивается из игры

### Установка

Проще всего — поставить с **[Modrinth](https://modrinth.com/mod/revertbark)** через Modrinth App или Prism Launcher.

Вручную:

1. Установите **Fabric Loader** (или NeoForge) для своей версии Minecraft.
2. Положите jar мода в `.minecraft/mods`.
3. Убедитесь, что стоит **[Fabric API](https://modrinth.com/mod/fabric-api)** — мод от него зависит.

| | |
| --- | --- |
| Minecraft | 1.20.1 – 1.21.1 |
| Загрузчики | Fabric, NeoForge |
| Сторона | Клиент и сервер |
| Зависимость | Fabric API (для Fabric-сборок) |

### Сборка из исходников

Нужен **JDK 17**.

```bash
./gradlew build
```

Готовый jar появится в `build/libs/`. Конфигурация Gradle в этом репозитории собирает **Fabric**-версию; сборки для NeoForge публикуются на Modrinth.

### Благодарности

- Идея: **Paradise_Man**
- Код: **SlowerTK**

### Лицензия

[Unlicense](LICENSE) — общественное достояние.
