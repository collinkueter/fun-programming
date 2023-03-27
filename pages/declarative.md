---
layout: section
---

# Declarative vs Imperative

## Say you want to build an app that returns the current weather and forecast for a given location

---
---

# Imperative

Code describes a step-by-step process for a program’s execution

```text
Begin
Accept location from user input of either location name or ZIP code.
Call OpenWeather's Geocoding API to convert location data into geographic coordinates.
Call OpenWeather's Current Weather Data API.
Send geographic coordinates to OpenWeather. 
Call OpenWeather's Daily Forecast 16 Days API.
Resend geographic coordinates.
Parse JSON returned by the APIs to extract current weather and forecast data. 
Return current weather and forecast.
Display current weather and forecast to user.
End
```

---
---

# Declarative

Describes what you want the program to achieve rather than how it should run

```text
Begin
Location submitted by user is location name or ZIP code.
Location is converted into geographic coordinates.
Weather data is retrieved for geographic coordinates.
Weather data is displayed for user.
End
```

An example you might be familiar with: HTML
---
---

# Imperative Code Example

```java
public class Addition {
    public static Integer sum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list)
            sum += i;
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        list.add(9);

        Integer sum = Addition.sum(list);

        System.out.println(sum);
    }
}
```

---
---

# Declarative Code Example

```scala
val sum = List(5, 6, 7, 10, 9).sum
println(sum)
```