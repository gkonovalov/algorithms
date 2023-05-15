## Essential Algorithms and Data Structures

Need to prepare description.

## Algorithms
<pre>
<a href="src/algorithms"><b>Algorithms</b></a>
├── Strings
│   └── String Matching
│       ├── Brute-force
│       ├── Rabin-Karp
│       ├── Knuth-Morris-Pratt
│       ├── Boyer-Moore
│       ├── Aho-Corasick
│       ├── Substring Matching
│       ├── Regular Expression Matching
│       └── Edit Distance
│           ├── Longest Common Subsequence 
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
│   ├── Reversal
│   └── Cycle Detection
├── Hashing
│   ├── Hash Functions
│   └── Universal Hash 
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
├── Randomized
│   ├── Quick Sort
│   ├── Fisher-Yates Shuffle
│   ├── Randomized Selection
│   ├── Las Vegas
│   └── Monte Carlo
├── Compression
│   └── Huffman Coding
├── Game theory
│   ├── Prisoner's Dilemma
│   ├── Minimax Algorithm
│   └── Nash Equilibrium
├── Geometry
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Voronoi diagram
│   ├── Triangulation
│   └── Convex Hull
│       ├── Graham Scan
│       └── Jarvis March
└── Math
    ├── Fibonacci Numbers
    ├── Factorial
    ├── Prime Numbers
    │   ├── Sieve of Eratosthenes
    │   ├── Primality test 
    │   │   └── Miller-Rabin
    │   └── Prime Factorization
    ├── Greatest Common Divisor (GCD)
    │   └── Euclidean Algorithm
    ├── Least Common Multiple (LCM)
    ├── Chinese Remainder Theorem
    ├── Sum of Digits
    ├── Fast Powering
    ├── Fast Exponentiation
    ├── Karatsuba Algorithm
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
    └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/"><b>Representation in memory</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/EdgeList.java"><b>Edge List</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyMatrix.java"><b>Adjacency Matrix</b></a>
        └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java"><b>Adjacency List</b></a>
</pre>


## Coding Problems and Techniques
<pre>
Problems
├── Arrays
│   ├── Searching
│   │   └── Binary Search
│   ├── Prefix Sum
│   ├── Sliding Window 
│   ├── Two pointers
│   └── Range Sum 
├── Strings
│   ├── Is Palindrome
│   ├── Palindrome Substrings
│   └── Reverse String
├── Linked List
│   └── Cache
│       ├── LFU 
│       └── LRU
├── Stacks
├── Queues
├── Hash Table
├── Tree
├── Graphs
├── Recursion
│   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/"><b>Dynamic Programming</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/easy/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │   ├── Knapsack 0/1
│   │   ├── Knapsack Unbounded
│   │   ├── Traveling Salesman
│   │   ├── Dijkstra's
│   │   ├── Bellman-Ford  
│   │   ├── Floyd-Warshall 
│   │   ├── Edit distance
│   │   ├── Regular Expression Matching
│   │   ├── Longest Common Subsequence (LCS) 
│   │   ├── Longest Increasing Subsequence (LIS) 
│   │   ├── Longest Palindrome Subsequence (LPS)
│   │   ├── Shortest Common Supersequence (SCS)
│   │   ├── Maximum sum increasing subsequence
│   │   ├── Matrix Chain Multiplication
│   │   ├── Maximum Subarray Sum
│   │   ├── Binomial coefficient
│   │   ├── Combination Sum
│   │   ├── Rod Cutting
│   │   ├── Jump Game
│   │   ├── Unique paths in a grid
│   │   ├── Partition problem
│   │   ├── Russian dolls envelope
│   │   ├── Dungeon game
│   │   ├── Subset sum problem
│   │   ├── Minimum path sum
│   │   ├── Counting paths in a grid
│   │   ├── Wildcard matching
│   │   ├── Word break
│   │   ├── Paint house
│   │   ├── Palindrome partitioning
│   │   ├── Maximum product subarray
│   │   └── Coin change
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
│   ├── Knapsack Unbounded
│   ├── Interval scheduling
│   ├── Job Scheduling 
│   └── Coin Change
├── Bit manipulation
└── NP-complete problems
     ├── Travelling salesman
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