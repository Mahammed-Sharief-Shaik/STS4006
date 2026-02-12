# 12-02-2025

### Maximum Sliding window
- For array of size n with window size k, total number of windows = n-k+1
- Result array of size n-k+1
- n=7, k=3
    - 2 8 43 12 27 67 7
    - OUTPUT : 43 43 43 67 67
- Brute force -> Time : (n-k+1)*k
- Dequeue (Double ended queue)
    - offerFirst
    - offerLast
    - pollFirst
    - pollLast
- Monotonic queue (Monotonically decreasing - queue elements will be in decreasing order)

---
