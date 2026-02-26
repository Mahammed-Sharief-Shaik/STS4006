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
### **CAT 1 paper discussion**
- Even odd seperate is not two pointer approach it is iterative traversal
- In PQ priority determined by node value not position
- Minimum stack can be done with one stack using encryption 
- In PQ if two nodes have same prioriy then FIFO

# 19-02-2025

### Recover the BST
- Intentionally two nodes were swapped, reswap them to recover the BST
- when traversing in inorder 
  - 2 decreasing points then non adjacent nodes must be swapped
  - 1 decreasing point adjacent nodes must be swapped
- There might be a possibility 


# 20-02-2025
???


# 26-02-2025
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