# ✧ Big O notation ✧

Big O notation is a crucial tool used in interviews to describe the computational complexity of an algorithm.
At first glance it appears to be incredibly mathsy and complicated, but when understood, it helps to analyse
and write code that is more optimised. That is exactly why it is crucial on interviews, where algorithmic 
thinking is exactly what is being tested. </br>

I think of it as of a tool that I use to judge and justify if what I wrote needs further optimisation or not.

---
## Breakdown
(not your mental one just yet but rather trying to demistify it) </br>
> With big O notation we express the runtime in terms of — brace yourself — how quickly it grows relative to the input, as the input gets arbitrarily large.

The reason why we need this approach is because it is hard to find out the exact runtime of an algorithm. 
It is dependent on hardware and many other factors.
This is why it is described in a relative manner - how much slower (more complex) does it get with more input.</br>

Since the way we measure it is relative, we need another unit than seconds to describe it. 
We know it is dependent on the data, that is why **we use n to denote input size**. 
> we can say things like the runtime grows "on the order of the size of the input" 
(O(n)) or "on the order of the square of the size of the input" (O(n<sup>2</sup>))

In using big O notation, we should focus on operations in our algorithm that quickly grow more complex, 
as the input size grows. </br>

It all seems very theoritical but it should get clearer with a few familiar examples.

---

## Basic examples
### O(1) - Constant time
A method runs in constant time when a the execution is not dependent on input size.
An example of such behaviour can be this: 
```java
public static int getFirst(int[] items) {
    return items[0];
}
```
No matter how big the array is. It fetches the first item without fetching others first in one operation.

### O(n) - Linear time
A method performs more operations if the input grows. The way n relates yto runtime is linear - 
it does not grow in an exponential manner. What it means in more programming and less mathsy terms is that 
for each item in the list, the method performs x more operations, not x times more operations. For instance:
```java
public static int printAll(int[] items) {
    for (int i = 0; i < items.length; i++){
        System.out.printf("Item [%d]: %d\n", i, items[i]);
    }
}
```
In that example, for each item in the list, one more print operation is performed.

### O(n<sup>2</sup>) - quadratic time
A method performs n times more operations for each item. It usually happens with nested loops, 
since for each item a program does something to each item in the array arriving to n*n growth in complexity-input size ratio.
An example of such behaviour is:
```java
public static int printAllPossibleSums(int[] items){
    for(firstNum : items){
        for(secondNum : items){
            System.out.printf("%d + %d\n", firstNum, secondNum);
        }
    }
}
```
The algorithm iterates through entire array for each item in the array to print out all possible sums using the items in the array.
If the array has 10 items, we have to print 100 times.

---

## Calculating complexity - how to O
### First - a clarification
****n conceptualisation**** ☞ In all previous examples n was the size of the input but n can also be the data itself. 
 Again, it sounds abstract so i will just show you another example of O(n), with the "data itself" approach:
```java
// O(n) - data itself
  public static void sayHiNTimes(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println("hi");
    }
}

// O(n) - data size
public static void printAllItems(int[] items) {
    for (int item : items) {
        System.out.println(item);
    }
}
```
### complexity is about the operations, not constants
☞ having more variables doesnt increase O notation:
```java
public static void printFirstItemThenFirstHalfThenSayHi100Times(int[] items) {
    // +1
    System.out.println(items[0]);

    // doesn't change anything
    int middleIndex = items.length / 2;
    int index = 0;

    // +n/2
    while (index < middleIndex) {
        System.out.println(items[index]);
        index++;
    }

    // +100
    for (int i = 0; i < 100; i++) {
        System.out.println("hi");
    }
}
```
This example in O notation is O(1 + n/2 + 100), which we just call O(n)
> Why can we get away with this? Remember, for big O notation we're looking at what happens as
n gets arbitrarily large. As n gets really big, adding 100 or dividing by 2 has a decreasingly significant effect.

### Complexity is about simplification :))
☞ That is why to figure out the runtime in big O terms, we drop the less significant terms.
Might be easier to show on the following example:
```java
public static void printAllNumbersThenAllPairSums(int[] numbers) {
    // +1
    System.out.println("these are the numbers:");
    
    // +n
    for (int number : numbers) {
        System.out.println(number);
    }

    // +1
    System.out.println("and these are their sums:");
    
    // +n^2
    for (int firstNumber : numbers) {
        for (int secondNumber : numbers) {
            System.out.println(firstNumber + secondNumber);
        }
    }
}
```
This fragment's complexity is O(1+n+1+n<sup>2</sup>), which can be simplified to O(n<sup>2</sup>), 
which is its most significant term.
> Again, we can get away with this because the less significant terms quickly become, well, less significant as
n gets big.

---

## More complex examples

### Mysterious O(2n)
```java
public int fibonacci(int number) {
  if (number <= 1) {
    return number;
  } else {
    return fibonacci(number - 1) + fibonacci(number - 2);
  }
}
```
represents a function whose performance doubles for every element in the input. 
This example is the recursive calculation of Fibonacci numbers. 
The function falls under O(2n) as the function recursively calls itself twice for each input number
until the number is less than or equal to one.

### Mysterious O(n!) - exponential time
One classic example is the traveling salesman problem through brute-force search.

If there are N cities, the brute force method will try each and every permutation of these N cities to find which one 
is cheapest. Now the number of permutations with N cities is N! making it's complexity factorial (O(N!)).

Simplest example:

```java
void nFacRuntimeFunc(int n) {
  for(int i=0; i<n; i++) {
    nFacRuntimeFunc(n-1);
  }
}
```



### Mysterious O(log(n)) & O(n*log(n)) - logarithmic and linear logarithmic time
Let's start with how to recognise the examples of it in the wild. 
The most common attributes of a logarithmic function are:
- the choice of the next element on which to perform some action is one of several possibilities, and
- only one will need to be chosen.

or:
- the elements on which the action is performed are digits of n

This is why, for example, looking up people in a phone book is O(log n). 
You don't need to check every person in the phone book to find the right one; 
instead, you can simply divide-and-conquer by looking based on where their name is alphabetically, 
and in every section you only need to explore a subset of each section before you eventually find someone's phone number.

Of course, a bigger phone book will still take you a longer time, but it won't grow as quickly as the proportional 
increase in the additional size.

****O(log n)****: Given a person's name, find the phone number by picking a random point about halfway through 
the part of the book you haven't searched yet, then checking to see whether the person's name is at that point. 
Then repeat the process about halfway through the part of the book where the person's name lies. 
(This is a binary search for a person's name.)

****O(n log n)****: We want to personalize the phone book, so we're going to find each person or business's name 
in their designated copy, then circle their name in the book and write a short thank-you note for their patronage.

Example of O(log(n)) - binary search
```java
import java.util.*;
class Main{  
 public static void main(String args[]){  
    int numArray[] = {5,10,15,20,25,30,35}; 
    System.out.println("The input array: " + Arrays.toString(numArray));
    //key to be searched
    int key = 20;
    System.out.println("\nKey to be searched=" + key);
    //set first to first index
    int first = 0;
    //set last to last elements in array
    int last=numArray.length-1; 
    //calculate mid of the array
    int mid = (first + last)/2;  
    //while first and last do not overlap
    while( first <= last ){  
        //if the mid < key, then key to be searched is in the first half of array
        if ( numArray[mid] < key ){  
            first = mid + 1;     
        }else if ( numArray[mid] == key ){ 
            //if key = element at mid, then print the location
            System.out.println("Element is found at index: " + mid);  
            break;  
        }else{  
            //the key is to be searched in the second half of the array
            last = mid - 1;  
        }  
        mid = (first + last)/2;  
   }  
   //if first and last overlap, then key is not present in the array
   if ( first > last ){  
      System.out.println("Element is not found!");  
   }       
 }  
}
```

---
# Space complexity - final boss
In all of the examples above, we focus on time complexity. Sometimes the optimisation focus lays in memory.
In such case, we use space complexity to measure performance - total size of allocated memory relative to the input size.
## O(1) - fixed number of variables
```java
public static void sayHiNTimes(int n) {
    // i: +1
    for (int i = 0; i < n; i++) {
        System.out.println("hi");
    }
}
```
## O(n) - scales with the size of the input
```java
public static String[] arrayOfHiNTimes(int n) {
    // array allocates n Strings: +n
    String[] hiArray = new String[n];
    for (int i = 0; i < n; i++) {
        hiArray[i] = "hi";
    }
    return hiArray;
}
```

## a little space disclaimer
```java
  public static int getLargestItem(int[] items) {
    int largest = Integer.MIN_VALUE;
    for (int item : items) {
        if (item > largest) {
            largest = item;
        }
    }
    return largest;
}
```
This example has space complexity of O(1), since when we talk about memory in this context, we do not include the space
needed to store the input itself.


---
### references
1. [Interview cake - big O notation](https://www.interviewcake.com/article/java/big-o-notation-time-and-space-complexity), accessed on 3.09.2022
2. [John Feminella on Stack Overflow on O(log(n))](https://stackoverflow.com/a/2307314), accessed on 03.09.2022
3. [Java binary search - example of O(log(n))](https://www.softwaretestinghelp.com/binary-search-in-java/), accessed on 03.09.2022
4. [Learning big O notation on complexity](https://dzone.com/articles/learning-big-o-notation-with-on-complexity), accessed on 03.09.2022
5. [sepp2k on Stach Overflow on O(n!)](https://stackoverflow.com/a/3953257), accessed on 03.09.2022
6. [codaddict on Stach Overflow on O(n!)](https://stackoverflow.com/a/3953255), accessed on 03.09.2022