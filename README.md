Fakeit
========

![alt text](https://github.com/moove-it/fakeit/blob/master/banner.png "Fakeit Github banner")

Download
--------

```xml
<dependency>
  <groupId>com.mooveit.fakeit</groupId>
  <artifactId>fakeit</artifactId>
  <version>0.1</version>
</dependency>
```
or Gradle:
```groovy
compile 'com.mooveit.fakeit:fakeit:0.1.0'
```

Basic usage
--------

Add Fakeit to your project and just call it like this:

```java
Fakeit.name().lastName
Fakeit.business().type()
Fakeit.address().city()
Fakeit.card().name()
```

This is the current list of fake data models available:

- Address
- Ancient
- Artist
- Beer
- Book
- Business
- Card
- Cat
- Chuck Norris
- Compass
- Demographic
- Esport
- File
- Food
- Friends
- Game of Thrones
- Harry Potter
- Name
        

Questions and issues
--------

For bug reports and feature requests, use [Github issue tracker]9https://github.com/moove-it/fakeit/issues)

Contributing
--------

All contributions are welcome!

For more information see the contributing guide.

License
--------

[MIT](https://github.com/moove-it/fakeit/blob/master/LICENSE)

Fakeit is mainted by [*Moove-it*](www.moove-it.com)
