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