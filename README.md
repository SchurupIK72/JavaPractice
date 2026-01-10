# Automation Tests Project

Java проект для тренировки автотестирования с использованием:
- **JUnit 5** - фреймворк для написания тестов
- **Selenium** - для веб-тестирования
- **Page Object Model** - паттерн организации тестов
- **AssertJ** - удобные assertions
- **WebDriverManager** - автоматическое управление драйверами браузеров

## Структура проекта

```
automation-tests/
├── pom.xml                           # Maven конфигурация
├── src/
│   └── test/
│       ├── java/com/automation/
│       │   ├── base/
│       │   │   └── BaseTest.java     # Базовый класс с управлением WebDriver
│       │   ├── pages/
│       │   │   ├── BasePage.java     # Базовый Page Object
│       │   │   └── GoogleMainPage.java # Пример Page Object
│       │   └── tests/
│       │       ├── BasicUnitTests.java    # Примеры unit-тестов
│       │       └── GoogleSearchTest.java  # Примеры веб-тестов
│       └── resources/
│           └── logback-test.xml      # Конфигурация логирования
└── logs/                             # Директория для логов тестов
```

## Установка и запуск

### Предварительные требования
- Java 11+
- Maven 3.6+
- Chrome или Firefox браузер

### Команды Maven

```bash
# Установить зависимости
mvn clean install

# Запустить все тесты
mvn test

# Запустить тесты конкретного класса
mvn test -Dtest=GoogleSearchTest

# Запустить тесты с определенным паттерном в имени
mvn test -Dtest=*Basic*

# Запустить один конкретный тест
mvn test -Dtest=GoogleSearchTest#testGooglePageTitle
```

## Примеры тестов

### Простой unit-тест
```java
@Test
@DisplayName("Простая проверка суммы")
void testSimpleArithmetic() {
    int result = 5 + 3;
    assertThat(result).isEqualTo(8);
}
```

### Параметризованный тест
```java
@ParameterizedTest
@ValueSource(strings = {"Java", "Python", "JavaScript"})
void testLanguages(String language) {
    assertThat(language).isNotEmpty();
}
```

### Веб-тест с Page Object
```java
@Test
void testSearchField() {
    driver.navigate().to("https://www.google.com");
    boolean isVisible = googlePage.isElementVisible(By.name("q"));
    assertThat(isVisible).isTrue();
}
```

## Основные компоненты

### BaseTest
Базовый класс для всех тестов с методами:
- `initChromeDriver()` - инициализация Chrome
- `initFirefoxDriver()` - инициализация Firefox
- `closeBrowser()` - закрытие браузера
- `getCurrentUrl()` - получить URL
- `getPageTitle()` - получить заголовок страницы

### BasePage
Page Object Model базовый класс с методами:
- `clickElement(By)` - клик с ожиданием
- `enterText(By, String)` - ввод текста
- `getText(By)` - получить текст элемента
- `isElementVisible(By)` - проверка видимости
- `navigateTo(String)` - переход на страницу

### AssertJ Assertions
Примеры проверок:
```java
assertThat(value).isEqualTo(expected);
assertThat(text).contains("substring");
assertThat(list).hasSize(5);
assertThat(number).isPositive();
```

## Логирование

Логи записываются в `logs/test.log`. Уровень логирования можно настроить в `logback-test.xml`.

## Дальнейшая тренировка

1. Добавьте новые Page Objects для других сайтов
2. Напишите тесты логирования (login/logout)
3. Тесты заполнения форм
4. Работа с таблицами и списками
5. Скриншоты при ошибках
6. Parallel тестирование

---

Удачи в изучении автотестирования! 🚀
