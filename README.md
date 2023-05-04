## Essential Algorithms and Data Structures in Java

Need to prepare description.

## Algorithms
<pre style=" background-color: transparent;">
<a style="font-weight: bold; color: #008F11;" href="algorithms">Algorithms</a>
├── <a href="algorithms/arrays">Arrays</a>
│   ├── <a href="algorithms/arrays/searching">Searching</a>
│   │   ├── <a href="algorithms/arrays/searching/LinearSearch.java">Linear Search</a>
│   │   ├── Binary Search 
│   │   ├── Interpolation Search
│   │   ├── Exponential Search
│   │   ├── Jump Search 
│   │   └── Ternary Search
│   ├── Sorting
│   │   ├── Bubble Sort 
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
│   ├── Reversal
│   └── Cycle Detection
├── String
│   ├── String Matching
│   │   ├── Brute-force
│   │   ├── Rabin-Karp
│   │   ├── Knuth-Morris-Pratt
│   │   ├── Boyer-Moore
│   │   ├── Aho-Corasick
│   │   ├── Substring Matching
│   │   ├── Regular Expression Matching
│   │   └── Edit Distance
│   │       ├── Longest Common Subsequence 
│   │       ├── Levenshtein Distance
│   │       └── Hamming Distance
│   └── Compression
│       └── Huffman Coding
├── Hash
│   ├── Hash Functions
│   ├── Universal Hash
│   └── Bloom Filter    
├── Tree
│   └── Searching
│       ├── DFS
│       │   ├── Pre-order -  Root-Left-Right
│       │   ├── In-order -   Left-Root-Right
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
│   │  │   └── Edmonds-Karp
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
│   │   └── Union-Find
│   ├── Cycle Detection
│   ├── Coloring
│   ├── Bridges 
│   ├── Hamiltonian Cycle
│   └── Eulerian Path 
├── Recursion
│   ├── Dynamic Programming
│   │   ├── Fibonacci Numbers
│   │   ├── Knapsack 0/1
│   │   ├── Knapsack Unbounded
│   │   ├── Traveling Salesman
│   │   ├── Bellman-Ford  
│   │   ├── Floyd-Warshall 
│   │   ├── Edit distance
│   │   ├── Regular Expression Matching
│   │   ├── Longest Common Subsequence (LCS) 
│   │   ├── Longest Increasing Subsequence (LIS) 
│   │   ├── Longest Palindrome Subsequence (LPS)
│   │   ├── Shortest Common Supersequence (SCS)
│   │   ├── Matrix Chain Multiplication
│   │   ├── Maximum Subarray 
│   │   ├── Binomial coefficient
│   │   ├── Combination Sum
│   │   ├── Rod Cutting
│   │   ├── Jump Game
│   │   ├── Unique Paths
│   │   ├── Coin change   
│   │   └── Approaches
│   │       ├── Bottom-Up - Tabulation
│   │       ├── Top-Down - Memoization
│   │       └── Half-and-Half
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
│   ├── Huffman Coding
│   ├── Dijkstra's
│   ├── Prim's
│   ├── Kruskal's
│   ├── Coin Change
│   ├── Interval scheduling
│   ├── Job Scheduling 
│   └── Knapsack Unbounded
├── Randomized
│   ├── Quick Sort
│   ├── Fisher-Yates Shuffle
│   ├── Randomized Selection
│   ├── Las Vegas
│   └── Monte Carlo
├── Game theory
│   ├── Prisoner's Dilemma
│   ├── Minimax Algorithm
│   └── Nash Equilibrium
├── Cache
│   ├── LFU 
│   └── LRU 
├── Geometry
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Triangulation
│   └── Convex Hull
│       ├── Graham Scan
│       └── Jarvis March
├── Bit manipulation 
└── Math
    ├── Fibonacci Numbers
    ├── Factorial
    ├── Prime Numbers
    │   ├── Primality Check 
    │   │   └── Sieve of Eratosthenes
    │   └── Prime Factorization
    ├── Greatest Common Divisor (GCD)
    │   └── Euclidean Algorithm
    ├── Least Common Multiple (LCM)
    ├── Sum of Digits
    ├── Fast Powering
    ├── Fast Exponentiation
    ├── Chinese Remainder Theorem
    ├── Karatsuba algorithm
    ├── Number Reverse
    ├── Binomial Coefficient
    ├── Catalan Numbers
    ├── Pascal Triangle
    ├── Power of Two 
    ├── Euclidean Distance 
    ├── Fast Fourier Transform
    └── Matrix
        ├── Multiplication  
        ├── Inversion 
        ├── Power 
        ├── Transposition
        ├── Exponentiation
        ├── Square Rotation 
        └── Strassen's Multiplication
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
├── Linked Lists
│   ├── Singly Linked List 
│   ├── Doubly Linked List
│   └── Skip List
├── Stacks
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
│   ├── Fenwick tree
│   └── Segment tree
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
    │   └── Union-Find
    └── Representation in memory
        ├── Edge List
        ├── Adjacency matrix
        ├── Adjacency list
        ├── Objects
        └── Pointers
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