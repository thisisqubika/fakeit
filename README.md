Fakeit
========

![alt text](https://github.com/moove-it/fakeit/blob/master/banner.png "Fakeit Github banner")

This library is a port of the Ruby gem [Faker](https://github.com/stympy/faker). It generates realistic fake data — like names, emails, dates, countries — for a variety of scenarios, including automated testing and database population.

The library was originally created for Android projects, but it can be used in any Java or Kotlin project.

Download
--------

You can use either Maven:
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.moove-it</groupId>
  <artifactId>fakeit</artifactId>
  <version>v0.5</version>
</dependency>
```
or Gradle:
```groovy
// In your project's build.gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

//In your module's build.gradle
dependencies {
  compile 'com.github.moove-it:fakeit:v0.5'
}
```

Basic Usage
--------

Fakeit can be used in Java and Kotlin applications - no Android context needed!

Run the sample app to check all the available models and generate some random values.

First you need to initialize Fakeit:

```java
// Default locale is en for english data.
Fakeit.init()

// You can also pass a Locale or a String locale to change the language.
// See supported languages below.
Fakeit.init(locale)
```

Then, you need to import the module into each file where it will be used with:
```java
import com.mooveit.library.Fakeit;
```

Finally, generate fake data like this:

```java
Fakeit.name().lastName()
Fakeit.business().type()
Fakeit.address().city()
Fakeit.card().name()
```

Supported Data Models
--------

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

Supported Languages
--------

- Catalan - Catalunya (ca-CAT)
- Catalan (ca)
- Danish - Denmark (da-DK)
- Deutsch - Österreich (de-AT)
- Deutsch - Schweiz (de-CH)
- Deutsch (de)
- English - Australia (en-AU)
- English - Australian Slang (en-au-ocker)
- English - Phonetic Nonsense from The Muppet's Swedish Chef (en-BORK)
- English - Canada (en-CA)
- English - Great Britain (en-GB)
- English - India (en-IND)
- English - Nepal (en-NEP)
- English - Nigeria (en-NG)
- English - New Zealand (en-NZ)
- English - Pakistan (en-PAK)
- English - Singapore (en-SG)
- English - Uganda (en-UG)
- English - United States (en-US)
- English - South Africa (en-ZA)
- English (en)
- Spanish - Mexico (es-MX)
- Spanish (es)
- Farsi (fa)
- Finnish - Finland (fi-FI)
- French (fr)
- Hebrew (he)
- Indonesian (id)
- Italian (it)
- Japenese (ja)
- Korean (ko)
- Norwegian - Norway (nb-NO)
- Netherlands (nl)
- Polish (pl)
- Portuguese - Brazil (pt-BR)
- Portuguese (pt)
- Russian (ru)
- Slovak (sk)
- Swedish (sv)
- Turkish (tr)
- Ukranian (uk)
- Vietnamese (vi)
- Chinese - China (zh-CN)
- Chinese - Taiwan (zh-TW)

Unique Values
--------

You can also use Fakeit to generate unique values:

```java
Fakeit.getUniqueValue()
```

Questions and Issues
--------

For bug reports and feature requests, use [Github issue tracker](https://github.com/moove-it/fakeit/issues)

Contributing
--------

See the [contribution guide](CONTRIBUTING.md).

License
--------

[MIT](https://github.com/moove-it/fakeit/blob/master/LICENSE)

Fakeit is maintained by © [Moove-it](http://www.moove-it.com)
