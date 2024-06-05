[![Java CI](https://github.com/sshelyagovsky/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/sshelyagovsky/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/59f48ede5cb93c0cb0df/maintainability)](https://codeclimate.com/github/sshelyagovsky/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/59f48ede5cb93c0cb0df/test_coverage)](https://codeclimate.com/github/sshelyagovsky/java-project-78/test_coverage)
### Hexlet tests and linter status:
[![Actions Status](https://github.com/sshelyagovsky/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/sshelyagovsky/java-project-78/actions)

# "Валидатор данных"
- Валидация строк
- Валидация чисел
- Валидация объектов типа Map

# "Описание"
Валидатор функционирует следующим образом: сначала создается объект валидатора, затем мы создаем и настраиваем схему проверки данных. 
После этого мы проводим проверку данных, используя ранее созданную схему.

## Записи demo

#### DEMO

[![asciicast](https://asciinema.org/a/gucbikbWpFfy3NhIsGoEX46Rg.svg)](https://asciinema.org/a/gucbikbWpFfy3NhIsGoEX46Rg)


## Технологии

- [java](https://dev.java/learn/)
- [markdown](https://www.markdownguide.org/)


## Использование

(Запуск консольного приложения)
```bash
make validator
```

(Создание объекта Валидатор)
```console
import hexlet.code.*;
var v = new Validator();
```

(Валидация строк)
```console
var stringSchema = v.string();
```

(Валидация чисел)
```console
var numberSchema = v.number();
```

(Валидация объектов типа Map)
```console
var mapSchema = v.map();
```

(Создание схемы валидации для строк)
- Обязательность
```console
stringSchema.required();
```
- Минимальная длинна
```console
stringSchema.minLength();
```
- Содержит текст
```console
stringSchema.contains("Hexlet");
```

(Создание схемы валидации для чисел)

- Обязательность
```console
numberSchema.required();
```

- Проверка на положительное число. 0 - не положительное число
```console
numberSchema.positive();
```

- Находится в границе. Включая min и max
```console
numberSchema.range(min, max);
```

(Создание схемы валидации типа Map)

- Обязательность
```console
mapSchema.required();
```

- Размер Map должен быть равен length

```console
mapSchema.sizeof(length);
```

- Метод shape() используется для определения свойств объекта Map и создания схемы для валидации их значений.
```console
var v = new Validator();

var schema = v.map();

Map<String, BaseSchema<String>> schemas = new HashMap<>();

schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

schema.shape(schemas);

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1);

```

## Run install app

```bash
install:
	./gradlew clean installDist
```

## Run Dist

```bash
run-dist:
	./build/install/app/bin/app
```

## Run build

```bash
build:
	./gradlew clean build
```

## Run

```bash
run:
	./gradlew run
```

## Run test

```bash
test:
	./gradlew test
```

## Run generate report

```bash
report:
	./gradlew jacocoTestReport
```

## Run linter

```bash
lint:
	./gradlew checkstyleMain
```

## Run jshell

```bash
validator:
	./gradlew --console plain jshell
```bash


