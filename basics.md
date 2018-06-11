###  char <===> int

char to int
char increase
assign int to char
```java
char a = 'h';
System.out.println(a + 1);
//105

System.out.println((char)( a + 1 ));
//i

char s = 100;
System.out.println(s);
//d

char x = 'a';
int[] arr = new int[256];
arr[x] =121;
//Correct
```


### int, Integer under array and ArrayList
```java
// in java8 stream is better to convert
int[] intarray = new int[]{1,2,3,4,6};

// to Integer[]
Integer[] arr = new Integer[intarray.length];
for (int i = 0 ; i < intarray.length; i++) {
    arr[i] = Integer.valueOf(intarray[i]);
}
//to List<Integer>
List<Integer> list = new ArrayList<>();
//ERROR :
list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//CORRECT:
for (int i: intarray) {
    list.add(i);
}

```

### char & Character
```java
char s = 100;
System.out.println("equals: " + (new Character('d')).equals(s)); 
// true
System.out.println("==: " + (new Character('d') == s));
// true
```



### Collections

* reverse list
```java
Collections.reverse(list);
```
* define a List array
```java
List<Integer>[] listarr = new List[10];

//The following is wrong:
List<Integer>[] listarr = new List<Integer>[10];
```
* sublist
```java
List<Integer> list = Arrays.asList(1,2,3,4,5);
list.subList(0, 3); //fromIndex, toIndex 
```

### Map/TreeMap
* TreeMap -- get last
```java
TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
Map.Entry<Integer, List<Integer>> entry = tmap.pollLastEntry();
List<Integer> list = entry.getValue();
```


| Collections   | Get   | ContainsKey  | Next  | Data Structure  |
| ------------- |:-----:| ------------:|-----:|-----:|
|HashMap        | O(1)  | O(1)         | O(h / n)    | Hash Table|
|LinkedHashMap  | O(1)| O(1)| O(1)               | Hash Table + Linked List|
|TreeMap        | O(log n)| O(log n)| O(log n)| Red-black tree|
|ConcurrentHashMap| O(1)| O(1)| O(h / n)| Hash Tables|
|ConcurrentSkipListMap| O(log n)| O(log n)| O(1)| Skip List|
|IdentityHashMap| O(1)| O(1)| O(h / n)| Array|
|WeakHashMap    | O(1)| O(1)| O(h / n)| Hash Table|
|EnumMap| O(1)  | O(1)| O(1)| Array|




### int <===> long
* int to long, auto convert

```java
int a = 34;
void test(long param) {
  System.out.println(param);
}
test(a);
```


### char space 
* An ASCII character in 8-bit ASCII encoding is 8 bits (1 byte), though it can fit in 7 bits.
 
* An ISO-8895-1 character in ISO-8859-1 encoding is 8 bits (1 byte).
 
* A Unicode character in UTF-8 encoding is between 8 bits (1 byte) and 32 bits (4 bytes).
 
* A Unicode character in UTF-16 encoding is between 16 (2 bytes) and 32 bits (4 bytes), though most of the common characters take 16 bits. This is the encoding used by Windows internally.
 
* A Unicode character in UTF-32 encoding is always 32 bits (4 bytes).
 
* An ASCII character in UTF-8 is 8 bits (1 byte), and in UTF-16 - 16 bits.
 
* The additional (non-ASCII) characters in ISO-8895-1 (0xA0-0xFF) would take 16 bits in UTF-8 and UTF-16.


### integer space 
* ref: https://stackoverflow.com/questions/29251563/use-of-wrapper-class-increases-size-of-object
```
The instances of these classes will typically be the same size. On most JVMs, it uses 32-bit references so your wrapper with two 32-bit values (int or references) will be the same, about 24 bytes in total on a 64-bit JVM.

In a 64-bit JVM, the default header size is 12 bytes, the references will be 32-bit with Compressed Oops, and an 8 byte alignment will be a total size of 24 bytes.

Header - 12 bytes with 64-bit class references
int or ref - 4 bytes
int or ref - 4 bytes
align to multiple of 8 - +4 bytes
==========
Total - 24 bytes
If the references are 64-bit (e.g. > 64 GB heaps) it will use 8 bytes per reference and the total size will be 32 bytes. However, if the alignment is 16 as well (for heaps between 32 - 64 GB) then the pair of int wrapper will also be 32 bytes.

If you are concerned about total space consumed, and the Integer is not cached i.e. is a new Integer, the total space can be a further 16 bytes per Integer. If the Integer is cached, it doesn't use any more space.
```
>>>>>>> 27d8c00d0af7a870b9cf64df6002c7aba10da4ed
