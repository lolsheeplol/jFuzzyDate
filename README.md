# jFuzzyDate

jFuzzyDate is a Java library that helps to build human readable date/time messages with internationalized content.


Maven:
```xml
<dependency>
    <groupId>net.sf.jfuzzydate</groupId>
    <artifactId>jfuzzydate</artifactId>
    <version>0.2.11</version>
</dependency>
```

Gradle:
```gradle
dependencies {
  implementation 'net.sf.jfuzzydate:jfuzzydate:0.2.11'
}
```

[jFuzzyDate jar downloads](https://search.maven.org/artifact/net.sf.jfuzzydate/jfuzzydate/0.2.11/jar) are available from Maven Central.


### Example:
```java
@Test 
public void testFormatDurationLongLocale() {
    final FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl( DefaultFuzzingConfiguration.getInstance());

    assertEquals("a minute", impl.formatDuration(30 * 1000, EN));
    assertEquals("two minutes", impl.formatDuration(60 * 2 * 1000, EN));
    assertEquals("35 minutes", impl.formatDuration(60 * 35 * 1000, EN));
    assertEquals("a day", impl.formatDuration(SECONDS_DAY * 1000, EN));
    assertEquals("5 days", impl.formatDuration(SECONDS_DAY * 5 * 1000, EN));
    assertEquals("a week", impl.formatDuration(SECONDS_DAY * 7 * 1000, EN));
}

private void testDistance(final String expectedString, final long seconds, final Locale locale) {
    final FuzzyDateFormatterImpl impl = new FuzzyDateFormatterImpl( DefaultFuzzingConfiguration.getInstance());

    final long now = new Date().getTime();

    assertEquals(expectedString, impl.formatDistance(new Date(now + (seconds * 1000)), locale));
}
```

### Licence

jFuzzyDate is released under the [GNU Lesser General Public License (LGPL)](http://www.gnu.org/licenses/lgpl.txt).

```
Copyright (C) 2020 jFuzzyDate.


                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
```
