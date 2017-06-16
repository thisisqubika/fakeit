Fakeit
========

![alt text](https://github.com/moove-it/fakeit/blob/master/banner.png "Fakeit Github banner")

This library is a port of the Ruby gem [Faker](https://github.com/stympy/faker). It generates realistic fake data — like names, emails, dates, countries — to be used in your JVM development environment. It can be used in a variety of scenarios, including automated testing and database population.

The library was meant to be used on Android, but it can be used in projects based on Java or Kotlin.

Download
--------
Maven
```xml
<dependency>
  <groupId>com.github.moove-it</groupId>
  <artifactId>fakeit</artifactId>
  <version>v0.5</version>
</dependency>
```
or Gradle:
```groovy
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  compile 'com.github.moove-it:fakeit:v0.5'
}
```

Basic usage
--------

Fakeit can be used in Java and Kotlin applications. No need of Android context.
Run the sample app to check all the available models and generate some random values.

First you need to initialize Fakeit:

```java
// Default locale is en
Fakeit.init()

// Or you can pass a Locale or a String locale
Fakeit.init(locale)
```

And then, call the methods like this:

```java
Fakeit.name().lastName()
Fakeit.business().type()
Fakeit.address().city()
Fakeit.card().name()
```

This is the current list of fake data models available:

- Address
- Ancient
- App
- Artist
- Bank
- Beer
- Book
- Business
- Card
- Cat
- Chuck Norris
- Code
- Company
- Compass
- Date
- Demographic
- Educator
- Esport
- File
- Food
- Friends
- Game of Thrones
- Hacker
- Harry Potter
- Hey Arnold
- Hipster
- Internet
- Job
- Lord of the Rings
- Lorem
- Music
- Name
- Phone number
- Pokemon
- Rick and Morty
- Rock band

Unique value
--------

Now you can ask Fakeit for unique values.

```java
Fakeit.getUniqueValue()
```

Questions and issues
--------

For bug reports and feature requests, use [Github issue tracker](https://github.com/moove-it/fakeit/issues)

Contributing
--------

See the [contribution guide](CONTRIBUTING.md).

License
--------

[MIT](https://github.com/moove-it/fakeit/blob/master/LICENSE)

Fakeit is maintained by © [Moove-it](http://www.moove-it.com)
