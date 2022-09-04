# ⚡︎ Hash Maps and Tables ⚡︎
## First, maps
Hash maps are a bit like arrays with an ability to access the data by the key rather than
an index. It is especially handy when storing key pairs of data.
### java shenanigans
#### example usage
```java
// Import the HashMap class
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
  }
}
```
#### Operations
```java
// access value
capitalCities.get("England");
// remove an item
capitalCities.remove("England");
// remove all items
capitalCities.clear();
// get size
capitalCities.size();
```

#### Iteration
```java
// Print values
for (String i : capitalCities.values()) {
  System.out.println(i);
}

// Print keys
for (String i : capitalCities.keySet()) {
    System.out.println(i);
}

// Print keys and values
for (String i : capitalCities.keySet()) {
    System.out.println("key: " + i + " value: " + capitalCities.get(i));
}
```
## Hash table
It sounds similar so let's look at the differences (in java context that is)
- HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
- HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value.
- HashMap is faster than HashTable.
- HashMap iterator is fail-safe where HashTable iterator is not fail-safe.
- HashMap extends AbstractMap class where HashTable extends Dictionary class.

```java
import java.util.Map;

public class Tester {
   public static void main(String args[]) {

      Map<String, String> map = new HashMap<String, String>();

      map.put("1", "One");
      map.put("2", "Two");
      map.put("3", "Three");
      map.put("5", "Five");
      map.put("6", "Six");

      System.out.println("HashMap: " + map);

      Map<String, String> map1 = new Hashtable<String, String>();
   
      map1.put("1", "One");
      map1.put("2", "Two");
      map1.put("3", "Three");
      map1.put("5", "Five");
      map1.put("6", "Six");

      System.out.println("HashTable: " + map1);
   }
}
```

### References
1. [W3schools - Java hash map](https://www.w3schools.com/java/java_hashmap.asp), accessed on 04.09.2022
2. [tutorialspoint - hash map vs table](https://www.tutorialspoint.com/Difference-between-HashMap-and-HashTable-in-Java), accessed on 04.09.2022