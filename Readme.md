# 11-12-2025

- DS
  - Linear
    - Static
      - Array
    - Dynamic
      - Stack
      - Queue
      - LinkedList
        - Single
        - Double
        - Circular
  - Non Linear
    - Tree
    - Graphs
    - Tries

### Creating a Node

### Creating a LinkedList

### HW : Creating a DLL, CLL

# 12-12-2025

### Loop detection in LL using two pointer approach

#### Time Complexity : O(n)

##### In worst case fast pointer traverses the entire LL and ends at fast==null

#### Space Complexity : O(1)

##### Not Using anything but pointers no additional data structures

# 16-12-2025

### Segregate Even and Odd nodes in a Single Linked List

- input n=0 means empty LL
- Even tail can be null when data is like 3 7 9 11

# 18-12-2025

### Bitonic Sort

- biotonic: increasing or decreasing or increase then decrease or decrease then increase

#### Time Complexity : O(n)

#### Space Complexity : O(1)

# 19-12-2025

### Merge sort in Double Linked List

#### Time Complexity : O(n log(n))

#### Space Complexity : O(1)

# 06-01-2026

### Minimum Stack

- Find the minimum after pop operations
- Use two stacks
  1. One Normal for data
  1. One for storing all the minimum elements

### Stack

- Linear Data structure
- FIFO
- LIFO
- Operations
  - Push
  - Pop
  - Peek
  - setMin()
- Stack Overflow & Stack Underflow Exceptions

#### Time Complexity : O(1) for all operations

#### Space Complexity : O(n) two stacks (worst case input is in descending order)

# 08-01-2026

### The Celebrity Problem

- Constraints
  1. Eveyone knows them
  1. They don't know anyone
- Input 2-D matrix : array[i][j]=1 indicates that i knows j else 0
- Output always 1 celebrity or None
- if(mat[a][b]==1) a can not be celebrity and b can be
  push back b
- if ((matrix[celebrity][i] == 1 || matrix[i][celebrity] == 0))
  return -1;
- Either celebrity knows someone or someone don't know celebrity then he/she is not a celebrity

# 09-01-2026

### Iterative Tower of Hanoi

- 3 poles :
  1. Source
  1. Destination
  1. Helper or Auxilary
- We need to transfer all discs from source to destination
- Can not place a large disc on a small one
- for n discs **2^n - 1** moves required
- 3 stacks - Source, Destination, Auxilary
- there are 3 possible moves involving
  1. Source and Destination
  1. Source and Auxilary
  1. Auxilary and Destination
- if n is even first step is source to Auxilary so swap A and D

# 20-01-2026

### Stock Span Problem

- Number of elements smaller to its left stop if we encounter big element
- 
  - 25 8 31 16 64 29 32 7
  - 1  1 3  1  5  1  2  1
- Use stack -> store indices
- monotonic stack 



