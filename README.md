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
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/BinarySearch.java"><b>Binary Search</b></a>
│   │   ├── Exponential Search
│   │   ├── Jump Search 
│   │   └── Ternary Search
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/"><b>Sorting</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/BubbleSort.java"><b>Bubble Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/SelectionSort.java"><b>Selection Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/InsertionSort.java"><b>Insertion Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/MergeSort.java"><b>Merge Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort.java"><b>Quick Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort3WayPartitioning.java"><b>3-Way Quick Sort</b></a>
│   │   ├── Radix Sort 
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/HeapSort.java"><b>Heap Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/CountingSort.java"><b>Counting Sort</b></a>
│   │   └── Bucket Sort
│   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/"><b>Selection</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/QuickSelect.java"><b>Quick Select</b></a>
│       └── Median of medians
├── <a href="src/main/java/com/gkonovalov/algorithms/linkedlist"><b>Linked List</b></a>
│   └── <a href="src/main/java/com/gkonovalov/algorithms/linkedlist/FloydCycleDetection.java"><b>Floyd's Cycle Detection</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/trees/TreeNode.java"><b>Tree</b></a>
│   └── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching"><b>Searching</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/DFS.java"><b>DFS</b></a>
│       │   ├── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/DFS.java#L28"><b>Pre-order traversal</b></a>
│       │   ├── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/DFS.java#L57"><b>In-order traversal</b></a>
│       │   └── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/DFS.java#L85"><b>Post-order traversal</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/BFS.java"><b>BFS</b></a> 
│       │   └── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/BFS.java#L22"><b>Level-order traversal</b></a>
│       └── Bidirectional Search
├── <a href="src/main/java/com/gkonovalov/algorithms/graphs"><b>Graphs</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching"><b>Searching</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/DFS.java"><b>DFS</b></a> 
│   │ 	│   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/DFSID.java"><b>DFS-ID</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/BFS.java"><b>BFS</b></a>
│   │ 	├── Shortest Path
│   │ 	│   ├── Dijkstra's
│   │ 	│   ├── A-star
│   │ 	│   ├── Bellman–Ford
│   │ 	│   └──	Floyd-Warshall
│   │ 	└── Minimum Spanning Tree
│   │ 	    ├── Prim’s 
│   │ 	    └── Kruskal’s
│   ├── Network Flow
│   │   ├── Maximum Flow
│   │   │   ├── Push-Relabel
│   │   │   ├── Ford-Fulkerson
│   │   │   ├── Edmonds-Karp
│   │   │   └── Dinic's
│   │   ├── Minimum Cut 
│   │   │   └── Karger's
│   │   └── Maximum Bipartite
│   ├── Sorting
│   │ 	└── Topological Sort
│   │       ├── Kahn
│   │       └── Tarjan 
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/"><b>Connectivity</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/ConnectedComponents.java"><b>Connected Components</b></a>
│   │   ├── Strongly Connected Component
│   │   │   ├── Kusaraju
│   │   │   └── Tarjan
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind"><b>Union-Find</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/CycleDetection.java"><b>Cycle Detection</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/Bipartite.java"><b>Is Bipartite</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/Coloring.java"><b>Coloring</b></a>
│   ├── Bridges 
│   ├── Eulerian Cycle
│   ├── Eulerian Path
│   ├── Eulerian Tour
│   └── Hamiltonian Cycle
├── Greedy
│   ├── Huffman Coding
│   ├── Dijkstra's
│   ├── Prim's
│   └── Kruskal's
├── Randomized
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort.java"><b>Quick Sort</b></a>
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
<a href="src/main/java/com/gkonovalov/datastructures/"><b>Data Structures</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/arrays"><b>Arrays</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/arrays/Array.java"><b>Array</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/arrays/DynamicArray.java"><b>Dynamic Array</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/arrays/CircularBuffer.java"><b>Circular Buffer</b></a>
│   └── Suffix Arrays
├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist"><b>Linked Lists</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/SinglyLinkedList.java"><b>Singly Linked List</b></a>  
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/DoublyLinkedList.java"><b>Doubly Linked List</b></a> 
│   └── Skip List
├── <a href="src/main/java/com/gkonovalov/datastructures/stack/Stack.java"><b>Stacks</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/queues"><b>Queues</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/queues/Queue.java"><b>Queue</b></a>
│   └── <a href="src/main/java/com/gkonovalov/datastructures/queues/Deque.java"><b>Deque</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/hashing/hashtables"><b>Hash Tables</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashMap.java"><b>HashMap</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashSet.java"><b>HashSet</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/SparseVector.java"><b>Sparse Vector</b></a>
│   └── Collision Resolution
│       ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashMap.java"><b>Separate Chaining</b></a>
│       └── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashSet.java"><b>Open Addressing</b></a>
├── Bloom Filter 
├── <a href="src/main/java/com/gkonovalov/datastructures/trees/"><b>Trees</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/BinarySearchTree.java"><b>Binary Search Tree</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/trie"><b>Trie-trees</b></a>
│   │    ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/trie/Trie.java"><b>Prefix Tree - Trie</b></a>
│   │    └── Suffix Tree
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps"><b>Heaps</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java"><b>Binary Heap - Priority Queue</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java#L124"><b>Min Heap</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java#L122"><b>Max Heap</b></a>
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
└── <a href="src/main/java/com/gkonovalov/datastructures/graphs/Graph.java"><b>Graphs</b></a>
    └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/"><b>Representation in memory</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java"><b>Adjacency List</b></a>
        ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyMatrix.java"><b>Adjacency Matrix</b></a>
        └── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/EdgeList.java"><b>Edge List</b></a>
</pre>


## Coding Problems and Techniques
<pre>
<a href="src/main/java/com/gkonovalov/problems/"><b>Problems</b></a>
├── Arrays
│   ├── Prefix Sum
│   ├── <a href="src/main/java/com/gkonovalov/problems/arrays/MaximumSubarray.java"><b>Max Subarray Sum</b></a>
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
│   │   ├── Approaches
│   │   │   ├── Bottom-Up - Tabulation
│   │   │   ├── Top-Down  - Memoization
│   │   │   └── Half-and-Half
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │   ├── Knapsack 0/1
│   │   ├── Knapsack Unbounded
│   │   ├── Traveling Salesman
│   │   ├── Dijkstra's
│   │   ├── Bellman-Ford  
│   │   ├── Floyd-Warshall 
│   │   ├── Levenshtein Distance
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
│       ├── Combinatorics
│       │   ├── Permutations
│       │   ├── Combinations
│       │   ├── Subsets
│       │   └── Partitions
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