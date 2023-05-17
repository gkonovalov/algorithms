## Essential Algorithms and Data Structures

Need to prepare description.

## Algorithms
<pre>
<a href="src/algorithms"><b>Algorithms</b></a>
├── Strings
│   ├── Compression
│   │   └── Huffman Coding
│   └── String Matching
│       ├── Naive String Search
│       ├── Brute-force
│       ├── Rabin-Karp
│       ├── Knuth-Morris-Pratt
│       ├── Boyer-Moore
│       ├── Aho-Corasick
│       ├── Regular Expressions
│       │   └── Thompson NFA
│       └── Edit Distance
│           ├── Levenshtein Distance
│           └── Hamming Distance
├── <a href="src/algorithms/arrays"><b>Arrays</b></a>
│   ├── <a href="src/algorithms/arrays/searching"><b>Searching</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/LinearSearch.java"><b>Linear Search</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/BinarySearch.java"><b>Binary Search</b></a> <a href="https://www.youtube.com/watch?v=P3YID7liBug">[i]</a><a href="src/problems/leetcode/arrays/binarysearch/">[p]</a>
│   │   ├── Interpolation Search
│   │   ├── Exponential Search
│   │   ├── Jump Search 
│   │   └── Ternary Search
│   ├── Sorting
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/BubbleSort.java"><b>Bubble Sort</b></a>
│   │   ├── Merge Sort 
│   │   ├── Quick Sort 
│   │   ├── Radix Sort 
│   │   ├── Heap Sort
│   │   ├── Insertion Sort
│   │   ├── Selection Sort
│   │   ├── Counting Sort
│   │   └── Bucket Sort
│   ├── Selection
│   │   └── Quick Select
│   └── Kadane
├── Linked List
│   └── <a href="src/main/java/com/gkonovalov/algorithms/linkedlist/FloydCycleDetection.java"><b>Floyd's Cycle Detection</b></a>
├── Tree
│   └── Searching
│       ├── DFS
│       │   ├── Pre-order  - Root-Left-Right
│       │   ├── In-order   - Left-Root-Right
│       │   └── Post-order - Left-Right-Root
│       ├── BFS 
│       │   └── Level-order
│       └── Bidirectional Search
├── Graphs
│   ├── Searching
│   │ 	├── DFS 
│   │ 	│   └── DFS-ID
│   │ 	├── BFS
│   │ 	├── Shortest Path
│   │ 	│   ├── Dijkstra's
│   │ 	│   ├── A-star
│   │ 	│   ├── Bellman–Ford
│   │ 	│   └──	Floyd-Warshall
│   │ 	└── Minimum Spanning Tree
│   │ 	    ├── Prim’s 
│   │ 	    └── Kruskal’s
│   ├─ Network Flow
│   │  ├── Maximum Flow
│   │  │   ├── Push-Relabel
│   │  │   ├── Ford-Fulkerson
│   │  │   ├── Edmonds-Karp
│   │  │   └── Dinic's
│   │  ├── Minimum Cut 
│   │  │   └── Karger's
│   │  └── Maximum Bipartite
│   ├── Sorting
│   │ 	└── Topological Sort
│   │       ├── Kahn
│   │       └── Tarjan 
│   ├── Connectivity
│   │   ├── Connected Components
│   │   ├── Strongly Connected Component
│   │   │   ├── Kusaraju
│   │   │   └── Tarjan
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind"><b>Union-Find</b></a>
│   ├── Cycle Detection
│   ├── Coloring
│   ├── Bridges 
│   ├── Hamiltonian Cycle
│   └── Eulerian Path 
├── Recursion
│   ├── Dynamic Programming
│   │   ├── Dijkstra's
│   │   ├── Bellman-Ford  
│   │   ├── Floyd-Warshall 
│   │   ├── Levenshtein Distance
│   │   └── Approaches
│   │       ├── Bottom-Up - Tabulation
│   │       ├── Top-Down  - Memoization
│   │       └── Half-and-Half
│   └── Backtracking
│       └── Combinatorics
│           ├── Permutations
│           ├── Combinations
│           ├── Subsets
│           └── Partitions
├── Greedy
│   ├── Huffman Coding
│   ├── Dijkstra's
│   ├── Prim's
│   └── Kruskal's
└── Randomized
    ├── Quick Sort
    ├── Fisher-Yates Shuffle
    ├── Randomized Selection
    ├── Las Vegas
    └── Monte Carlo
</pre>

## Data Structures
<pre>
Data Structures
├── Strings
├── Arrays
│   ├── Array
│   ├── Dynamical Array 
│   ├── Circular Buffer
│   └── Suffix Arrays
├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist"><b>Linked Lists</b></a>
│   ├── Singly Linked List 
│   ├── Doubly Linked List
│   └── Skip List
├── <a href="src/main/java/com/gkonovalov/datastructures/stack/Stack.java"><b>Stacks</b></a>
├── Queues
│   ├── Queue
│   └── Dequeue
├── Hash Tables 
│   ├── Hash Table
│   │   ├── Separate Chaining
│   │   └── Open Addressing
│   ├── HashMap
│   ├── HashSet
│   └── Dictionary
├── Hash
│   └── Bloom Filter 
├── Trees
│   ├── Binary Trees
│   ├── Binary Search Tree
│   ├── Trie-trees
│   │    ├── Prefix Tree
│   │    └── Suffix Tree
│   ├── Heaps
│   │   ├── Binary Heap - Priority Queue 
│   │   │   ├── Min Heap
│   │   │   └── Max Heap
│   │   └── Fibonacci Heaps
│   ├── Self-balanced
│   │   ├── AVL Tree
│   │   ├── Red Black Tree
│   │   ├── B Tree
│   │   │   └── B+ Tree
│   │   ├── 2-3 Tree
│   │   ├── Splay Tree
│   │   └── Treaps
│   ├── Cartesian Tree
│   ├── K-D Tree
│   ├── Fenwick Tree
│   └── Segment Tree
└── Graphs
    ├── Types
    │   ├── Simple Graph
    │   ├── Directed Graph
    │   ├── Undirected Graph
    │   ├── Weighted Graph
    │   ├── Unweighted Graph
    │   ├── Cyclic Graph
    │   ├── Acyclic Graph
    │   ├── Labeled Graph
    │   ├── Infinite Graph
    │   ├── Bipartite Graph
    │   ├── Spanning Tree
    │   ├── Tree
    │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind"><b>Union-Find</b></a>
    └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/"><b>Representation in memory</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/EdgeList.java"><b>Edge List</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyMatrix.java"><b>Adjacency Matrix</b></a>
        └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java"><b>Adjacency List</b></a>
</pre>


## Coding Problems and Techniques
<pre>
Problems
├── Arrays
│   ├── Prefix Sum
│   ├── Sliding Window 
│   ├── Two Pointers
│   ├── Searching
│   │   └── Binary Search
│   └── Range Sum 
├── Strings
│   ├── Reverse String
│   ├── Anagram Checking
│   └── Palindromes
│       ├── Palindrome Checking
│       ├── Palindrome Substrings
│       └── Longest Palindromic Substring
├── Linked List
│   ├── Reversal
│   └── Cache
│       ├── LRU
│       └── LFU 
├── Stacks
├── Queues
├── Hash Table
├── Trees
│   ├── Binary Search Tree
│   └── Trie-trees
├── Graphs
├── Recursion
│   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/"><b>Dynamic Programming</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │   ├── Knapsack 0/1
│   │   ├── Knapsack Unbounded
│   │   ├── Traveling Salesman
│   │   ├── Regular Expression Matching
│   │   ├── Longest Common Subsequence (LCS) 
│   │   ├── Longest Increasing Subsequence (LIS) 
│   │   ├── Longest Palindrome Subsequence (LPS)
│   │   ├── Shortest Common Supersequence (SCS)
│   │   ├── Maximum Sum Increasing Subsequence
│   │   ├── Matrix Chain Multiplication
│   │   ├── Maximum Subarray Sum
│   │   ├── Binomial Coefficient
│   │   ├── Combination Sum
│   │   ├── Rod Cutting
│   │   ├── Jump Game
│   │   ├── Partition problem
│   │   ├── Russian Dolls Envelope
│   │   ├── Dungeon Game
│   │   ├── Subset Sum problem
│   │   ├── Minimum Path Sum
│   │   ├── Unique Paths in a Grid
│   │   ├── Counting Paths in a Grid
│   │   ├── Wildcard Matching
│   │   ├── Word Break
│   │   ├── Paint House
│   │   ├── Palindrome Partitioning
│   │   ├── Maximum Product Subarray
│   │   └── Coin Change
│   └── Backtracking
│       ├── N-Queens
│       ├── Knight's Tour 
│       ├── Sudoku Solver
│       ├── Unique Paths
│       ├── Rat in a Maze 
│       ├── Subset Sum
│       ├── Traveling Salesman 
│       ├── Word Search
│       └── Combinatorics
│           ├── Permutations
│           ├── Combinations
│           ├── Subsets
│           └── Partitions
├── Greedy
│   ├── Knapsack Unbounded
│   ├── Interval Scheduling
│   ├── Job Scheduling 
│   └── Coin Change
├── Game Theory
│   └── Prisoner's Dilemma
├── Geometry
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Voronoi Diagram
│   ├── Triangulation
│   └── Convex Hull
│       ├── Graham Scan
│       └── Jarvis March
├── Math
│   ├── Fibonacci Numbers
│   ├── Factorial
│   ├── Prime Numbers
│   │   ├── Sieve of Eratosthenes
│   │   ├── Primality Test 
│   │   │   └── Miller-Rabin
│   │   └── Prime Factorization
│   ├── Greatest Common Divisor (GCD)
│   │   └── Euclidean Algorithm
│   ├── Least Common Multiple (LCM)
│   ├── Chinese Remainder Theorem
│   ├── Sum of Digits
│   ├── Fast Powering
│   ├── Fast Exponentiation
│   ├── Binomial Coefficient
│   ├── Catalan Numbers
│   ├── Pascal Triangle
│   ├── Power of Two 
│   ├── Euclidean Distance
│   └── Matrix
│       ├── Multiplication  
│       ├── Inversion 
│       ├── Power 
│       ├── Transposition
│       ├── Exponentiation
│       ├── Square Rotation 
│       └── Strassen's Multiplication
├── Bit Manipulation
└── NP-complete problems
     ├── Travelling Salesman
     ├── Knapsack
     ├── SAT
     ├── Clique
     ├── Factorization
     └── Hamiltonian Cycle
</pre>


## Requirements
JDK 8.0 or later.

## Development

To open the project in Intellij Idea:

1. Go to *File* menu or the *Welcome Screen*
2. Click on *Open...*
3. Navigate to `essential-algorithms` root directory.
4. Select `setting.gradle`

------------
Georgiy Konovalov 2023 (c) [MIT License](LICENSE)