# Graph : interview failed questoin in clone graph

## Graph needs a system learning

## 3 standard ways to represent graph

#### edge lists
```java
// group of edges to represent
[ [0,1], [0,6], [0,8], [1,4], [1,6], [1,9], [2,4], [2,6], [3,4], [3,5], [3,8], [4,5], [4,9], [7,8], [7,9] ]
```
> Edge lists are simple, but if we want to find whether the graph contains a particular edge, we have to search through the edge list. If the edges appear in the edge list in no particular order, that's a linear search through |E| ∣E∣vertical bar, E, vertical bar edges. Question to think about: How can you organize an edge list to make searching for a particular edge take O(\lg E) O(lgE) time? The answer is a little tricky.

#### adjacency matrices
* example [link] (https://ka-perseus-images.s3.amazonaws.com/549bca1a52774846b25caff86d244d03ee63fd38.png)

###### Pros

* Constant time to find out whether an edge is present

###### Crons

* Space is O(V2) -- v is vertex
* to Undirected graph, the adjacency matrix is symmetric: the row i ii, column j jj entry is 1 if and only if the row j jj, column i ii entry is 1

#### Adjacency list
Exmple [link] (https://ka-perseus-images.s3.amazonaws.com/cc82379521bd84738e86d6cf9552738ca9138420.png)
```java
//Example - 2
[ [1, 6, 8],
  [0, 4, 6, 9],
  [4, 6],
  [4, 5, 8],
  [1, 2, 3, 5, 9],
  [3, 4],
  [0, 1, 2],
  [8, 9],
  [0, 3, 7],
  [1, 4, 7] ]
```
* Actually, use a int[Set<Integer>] could represent graph better

* for weight graph, represent the order still necessary
###### Crons
###### Pros
* get to vertex in constant time
* Time Complexity for find out the edge
> constant time for int[Set<Integer>]
> O(d) for int[int[]], d is degree,which is length of inside array. 



* refer: https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs

