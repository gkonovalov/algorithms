## Algorithms and Data Structures

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
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/"><b>Sorting</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/BubbleSort.java"><b>Bubble Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/SelectionSort.java"><b>Selection Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/InsertionSort.java"><b>Insertion Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/MergeSort.java"><b>Merge Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort.java"><b>Quick Sort</b></a>
│   │   ├── Radix Sort 
│   │   ├── Heap Sort
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
├── Bit Manipulation
├── Randomized
│   ├── Quick Sort
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/randomized/FisherYatesShuffle.java"><b>Fisher-Yates Shuffle</b></a>
│   ├── Randomized Selection
│   ├── Las Vegas
│   └── Monte Carlo
├── Game Theory
│   ├── Minimax
│   └── Prisoner's Dilemma
├── Geometry
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Voronoi Diagram
│   ├── Triangulation
│   └── Convex Hull
│       ├── Graham Scan
│       └── Jarvis March
└── Math
    ├── Fibonacci Numbers
    ├── Factorial
    ├── Prime Numbers
    │   ├── Sieve of Eratosthenes
    │   ├── Primality Test 
    │   │   └── Miller-Rabin
    │   └── Prime Factorization
    ├── Greatest Common Divisor (GCD)
    │   └── Euclidean Algorithm
    ├── Least Common Multiple (LCM)
    ├── Chinese Remainder Theorem
    ├── Sum of Digits
    ├── Fast Powering
    ├── Fast Exponentiation
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
├── <a href="src/main/java/com/gkonovalov/datastructures/arrays"><b>Arrays</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/arrays/Array.java"><b>Array</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/arrays/DynamicArray.java"><b>Dynamic Array</b></a>
│   ├── Circular Buffer
│   └── Suffix Arrays
├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist"><b>Linked Lists</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/SinglyLinkedList.java"><b>Singly Linked List</b></a>  
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/DoublyLinkedList.java"><b>Doubly Linked List</b></a> 
│   └── Skip List
├── <a href="src/main/java/com/gkonovalov/datastructures/stack/Stack.java"><b>Stacks</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/queues"><b>Queues</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/queues/Queue.java"><b>Queue</b></a>
│   └── <a href="src/main/java/com/gkonovalov/datastructures/queues/Deque.java"><b>Deque</b></a>
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
│       └── Word Search
├── Greedy
│   ├── Knapsack Unbounded
│   ├── Interval Scheduling
│   ├── Job Scheduling 
│   └── Coin Change
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