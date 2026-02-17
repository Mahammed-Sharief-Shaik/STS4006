# 12-02-2025

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

# 13-02-2025

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

# 17-02-2025
CAT 1 paper discussion
- Even odd seperate is not two pointer approach it is iterative traversal
- In PQ priority determined by node value not position
- Minimum stack can be done with one stack using encryption 
- In PQ if two nodes have same prioriy then FIFO