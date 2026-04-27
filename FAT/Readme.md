# 31-03-2026

### Only MCQS

#### Collections

- interface List
  - class ArrayList
  - class LinkedList
  - interface Vector
    - class Stack
- interface Queue
  - class PriorityQueue
  - interface Dequeue
    - class ArrayDequeue
    - class LinkedList
- **_interface Map and Set interface (in syllabus)_**

---

- interface Map
  - HashMap - Random Order
  - LinkedHashMap - Follows the insertion order
  - TreeMap - Sorted order based on keys
- interface Set
  - HashSet
  - LinkedHashSet
  - TreeSet

# 07-04-2026

### Distributing items when a person cannot take more than two items of the same type

- arr = {1,1,2,3,1}
- k = number of persons = 2

# 09-04-2026

- DP
  - Memoization (Top-Down) : If process start at solution and goes to base condition
  - Tabulation (Bottom-up) : base to Solution

### Fibonacci - Tabulation and Memoization

### Longest Common Subsequence (LCS)

- start from end i=s1.length()-1, j=s2.length()-1
- if(s1[i]==s2[j])
  - lcs(s1,s2,i-1,j-1) + 1
- not matching (s1[i]!=s2[j])
  - move i : lcs(s1,s2, i-1, j)
  - move j : lcs(s1,s2, i, j-1)
  - Math.max(lcs(s1,s2, i, j-1),lcs(s1,s2, i-1, j))
- Base : i<0 | j<0 ---> return 0

# 10-04-2026

### Longest Increasing Subsequence (LIS)

# 16-04-2026
### Longest Palindromic subsequence (LPS)

# 17-04-2026
### Subset sum problem

