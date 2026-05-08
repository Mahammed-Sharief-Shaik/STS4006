Loop Detection

HashSet Approach

- Time Complexity : O(n)
- Space Complexity : O(n)

Two Pointers / Slow-Fast Pointers / Floyd’s Cycle Detection Algorithm (Optimal)

- Time Complexity : O(n)
- Space Complexity : O(1)

Sort the Bitonic DLL

Split → Reverse → Merge Approach

- Time Complexity : O(n)
- Space Complexity : O(1)

Two Pointers Approach

- Time Complexity : O(n)
- Space Complexity : O(1)

Segregate Even & Odd Nodes in a Linked List

Two Pointers Approach

- Time Complexity : O(n)
- Space Complexity : O(1)

Merge Sort for DLL

Split + Recursive Merge / Divide and Conquer Approach

- Time Complexity : O(n log n)
- Space Complexity : O(log n) recursive stack space

Minimum Stack

Two Stack Approach

- push() : O(1)
- pop() : O(1)
- getMin() : O(1)
- Space Complexity : O(n)

The Celebrity Problem

Stack Based Approach

- Time Complexity : O(n)
- Space Complexity : O(n)

Two Pointer / Elimination Approach (Optimal)

- Time Complexity : O(n)
- Space Complexity : O(1)

Iterative Tower of Hanoi

Stack Based Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n)

Stock Span Problem

Monotonic Stack Based Approach

- Time Complexity : O(n)
- Space Complexity : O(n)

Priority Queue using DLL
(Assuming DLL is maintained in sorted order)

Insertion / Offer / Add

- Time Complexity : O(n)

Deletion / Poll

- Time Complexity : O(1)

Peek

- Time Complexity : O(1)

Sort Queue without Extra Space

Queue + Selection Sort Based Approach

- Time Complexity : O(n^2)
- Auxiliary Space Complexity : O(1)

Stack Permutations

Using Queue and Stack

- Time Complexity : O(n)
- Space Complexity : O(n)

Maximum Sliding Window

Brute Force Approach

- Time Complexity : O((n-k+1) \* k)
- Worst Case : O(nk)
- Auxiliary Space Complexity : O(1)
- Output Array Space : O(n-k+1)

Monotonic Deque Approach (Optimal)

- Time Complexity : O(n)
- Auxiliary Space Complexity : O(k) for deque
- Output Array Space : O(n-k+1)

Recover the BST

Inorder Traversal Approach

- Time Complexity : O(n)
- Space Complexity : O(h) recursive stack space

where:

- h = log n for balanced tree
- h = n for skewed tree

Left View / Right View

Queue Based Level Order Traversal / BFS

- Time Complexity : O(n)
- Space Complexity : O(n)

Preorder DFS Approach

- Time Complexity : O(n)
- Space Complexity : O(h) recursive stack space

Top View / Bottom View / Vertical Order Traversal

BFS Approach (Optimal)

- Time Complexity : O(n)
- Space Complexity : O(n)

DFS Approach

- Time Complexity : O(n)
- Space Complexity : O(n) + O(h) recursive stack

Overall asymptotically : O(n)

Boundary Traversal

Left Boundary → Leaf Nodes → Right Boundary DFS Based Approach

- Time Complexity : O(n)
- Space Complexity : O(h) recursive stack

BFS (Graph Traversal)

For Adjacency List Representation

Using Queue

- Time Complexity : O(V + E)
- Space Complexity : O(V)

For Adjacency Matrix Representation

Using Queue

- Time Complexity : O(V^2)
- Space Complexity : O(V)

DFS (Graph Traversal)

For Adjacency List Representation

Using Stack (Iterative DFS)

- Time Complexity : O(V + E)
- Space Complexity : O(V)

Using Recursion

- Time Complexity : O(V + E)
- Space Complexity :
  O(V) for visited array +
  O(V) recursive stack in worst case

Overall : O(V)

For Adjacency Matrix Representation

Using Stack

- Time Complexity : O(V^2)
- Space Complexity : O(V)

Using Recursion

- Time Complexity : O(V^2)
- Space Complexity :
  O(V) for visited array +
  O(V) recursive stack

Overall : O(V)

Dial’s Algorithm
(Works efficiently when edge weights are small non-negative integers)

- Time Complexity : O(VW + E)

Space Complexity :

- O(V + maxDistance)

Optimized Circular Bucket Version

- Space Complexity : O(V + W)

where:

- V = vertices
- E = edges
- W = maximum edge weight

Bellman-Ford Algorithm

- Time Complexity : O(V \* E)
- Space Complexity : O(V) for distance array

Topological Sort

BFS (Kahn’s Algorithm)

- Time Complexity : O(V + E)
- Space Complexity : O(V)

DFS Based

- Time Complexity : O(V + E)
- Space Complexity : O(V)

Heap Sort

Building Heap

- O(n)

Heapify Operations

- O(log n) repeated n times

Overall Time Complexity

- O(n log n)

Space Complexity

- O(1) (In-place sorting)

HashMap to TreeMap (Only MCQs)

Insertion into HashMap

- Time Complexity : O(n)

Conversion to TreeMap

- Constructor / putAll() : O(n log n)
- For-each insertion : O(n log n)

Space Complexity

- O(n) — for storing both maps

Types of Sets (Only MCQs)

HashSet

- add(), remove() : O(1) average
- contains() : O(1) average
- Iteration Order : Unordered
- Space Complexity : O(n)

LinkedHashSet

- add(), remove() : O(1) average
- contains() : O(1) average
- Iteration Order : Insertion Order
- Space Complexity : O(n)

TreeSet

- add(), remove() : O(log n)
- contains() : O(log n)
- Iteration Order : Sorted Order
- Space Complexity : O(n)

Distributing Items when a Person Cannot Take More than Two Items of Same Type

Frequency Counting

- Time Complexity : O(n)

Validation Check

- Time Complexity : O(m)

where:

- m = number of unique item types

Overall Time Complexity

- O(n)

Space Complexity

- O(m) using HashMap

Fibonacci Problem

Recursive Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n) recursion stack

Memoization (Top-Down DP)

- Time Complexity : O(n)
- Space Complexity : O(n)

Tabulation (Bottom-Up DP)

- Time Complexity : O(n)
- Space Complexity : O(n)

Space Optimized DP

- Time Complexity : O(n)
- Space Complexity : O(1)

Longest Common Subsequence (LCS)

Recursive Approach

- Time Complexity : O(2^(n+m))
- Space Complexity : O(n + m)

Memoization

- Time Complexity : O(n \* m)
- Space Complexity : O(n \* m)

Tabulation

- Time Complexity : O(n \* m)
- Space Complexity : O(n \* m)

Space Optimized

- Time Complexity : O(n \* m)
- Space Complexity : O(m)

Longest Palindromic Subsequence (LPS)

Recursive Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n)

Memoization

- Time Complexity : O(n^2)
- Space Complexity : O(n^2)

Tabulation

- Time Complexity : O(n^2)
- Space Complexity : O(n^2)

Space Optimized

- Time Complexity : O(n^2)
- Space Complexity : O(n)

Longest Increasing Subsequence (LIS)

Recursive Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n)

Memoization

- Time Complexity : O(n^2)
- Space Complexity : O(n^2)

Tabulation

- Time Complexity : O(n^2)
- Space Complexity : O(n^2)

Space Optimized

- Time Complexity : O(n^2)
- Space Complexity : O(n)

Optimal Binary Search Based LIS

- Time Complexity : O(n log n)
- Space Complexity : O(n)

Subset Sum Problem

Recursive Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n)

Memoization

- Time Complexity : O(n \* target)
- Space Complexity : O(n \* target)

Tabulation

- Time Complexity : O(n \* target)
- Space Complexity : O(n \* target)

Space Optimized

- Time Complexity : O(n \* target)
- Space Complexity : O(target)

0/1 Knapsack

Recursive Approach

- Time Complexity : O(2^n)
- Space Complexity : O(n) recursion stack

Memoization

- Time Complexity : O(n \* W)
- Space Complexity : O(n \* W)

Tabulation

- Time Complexity : O(n \* W)
- Space Complexity : O(n \* W)

Space Optimized

- Time Complexity : O(n \* W)
- Space Complexity : O(W)
