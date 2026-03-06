# 12-02-2026

### Maximum Sliding window

- For array of size n with window size k, total number of windows = n-k+1
- Result array of size n-k+1
- n=7, k=3
  - 2 8 43 12 27 67 7
  - OUTPUT : 43 43 43 67 67
- Brute force -> Time : (n-k+1)\*k
- Dequeue (Double ended queue)
  - offerFirst
  - offerLast
  - pollFirst
  - pollLast
- Monotonic queue (Monotonically decreasing - queue elements will be in decreasing order)

# 13-02-2026

### Non Linear Data Structures

- Tree
  - Many types
    - Binary, Ternary, n-ary (based on number of children)
    - BST
    - AVL, Red Black tree (Self balancing trees)
    - Heaps
- **Depth** no of edges from root to a particular node
- **Leaf Node** Node without any children
- **Height** Maximum of depths of all leaf nodes
- Searching or Travelsal :
  - Level order (uses BFS)
  - Inorder - Left-Root-Right
  - Preorder - Root-Left-Right
  - Postorder - Left-Right-Root
  - +1
- In problem statements : -1, N, null may indicate empty Node

# 17-02-2026

### **CAT 1 paper discussion**

- Even odd seperate is not two pointer approach it is iterative traversal
- In PQ priority determined by node value not position
- Minimum stack can be done with one stack using encryption
- In PQ if two nodes have same prioriy then FIFO

# 19-02-2026

### Recover the BST

- Intentionally two nodes were swapped, reswap them to recover the BST
- when traversing in inorder
  - 2 decreasing points then non adjacent nodes must be swapped
  - 1 decreasing point adjacent nodes must be swapped
- There might be a possibility

# 20-02-2026

???

# 26-02-2026

### Vertical Order Traversal

- Root will be having horizontal distance 0
- Left side verticals will be -ve and right side +ve
- Print the nodes left to right top to bottom in verticals
- Applications :
  - Nodes in same place -> ascending
  - Nodes in same vertica -> take only unique (non duplicates)
- Can use treemap to sort the verticals (keys) automatically
- For Top view we need only the first element of the list
- For bottom view we need only the last element of the list

# 27-02-2026

### Boundary Traversal

- Anti clockwise direction
- Traverse in order
  - left boundary
  - leaf nodes
  - right boundary (reverse bottom to top)

# 03-03-2026

### Graphs

- Nonlinear data structure consisting of vertices and edges
- Types of Graphs
  - Directed - Cyclic
  - Undirected - can be Cyclic or Acyclic
  - Weighted
  - Unweighted
- Traversion
  - BFS
  - DFS

### Breadth First Search

- Input
  - Iteration approach (input V and E initially)
    - Example :
      ```
      v = 5
      e = 6
      1 0
      0 2
      2 1
      from - to
      ```
  - Matrix (Adjacency Matrix)
    - matrix input with v rows and v columns where matrix[i][j] indicates if there is a connection between ith node and jth node
      ```java
      v = 3
      0 1 1
      0 0 0
      1 1 0
      // 0 -> not connected 1 -> connected
      ```
- Storing
  - Adjacency List
    - index represents the vertex
    - all the neighbours of vertex are at adj[index]
    ```java
      List<Integer>[] adj;
      // for directed 
      adj[source].add(destination);
      // for undirected
      adj[destination].add(source);
    ```

- For BFS we need to use Queue

# 05-03-2026

### Shortest path Algos : 
- Dijkstras
  - Disadvantages : Does not work for Negative edges
  - TC : O(E V)
- Belman ford
- ### Dail's algo
  - Works efficiently for small weights
  - Along with from to weight we also need max weight
  - In worst case all edges may have weight maxWeight and then the distance possible in worst case is E*maxWeight
  - Create buckets from 0 to maxWeight*e
  - bucket x represents that it is x kms from source
  E + MW*V
  Dail's Algo

  - Relaxation

# 06-03-2026
### Bellman Ford Algorithm
- Find cycles and handles negative edge weights
- If the distance changes then there is a cycle (Intitally with Integer.MAX_VALUE)
