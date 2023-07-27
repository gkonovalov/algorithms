## Algorithms and Data Structures

Need to prepare description.

## Algorithms
<pre>
<a href="src/algorithms"><b>Algorithms</b></a>
├── <a href="src/main/java/com/gkonovalov/algorithms/strings/"><b>Strings</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/strings/sorting/"><b>Sorting</b></a>
│   │   └── LSD Radix Sort 
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
│       └── <a href="src/algorithms/strings/matching/editdistance/"><b>Edit Distance</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/LevenshteinDistance.java"><b>Levenshtein Distance</b></a>
│           └── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/HammingDistance.java"><b>Hamming Distance</b></a>
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
│       └── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/BFS.java"><b>BFS</b></a> 
│           └── <a href="src/main/java/com/gkonovalov/algorithms/tree/searching/BFS.java#L22"><b>Level-order traversal</b></a>
├── <a href="src/main/java/com/gkonovalov/algorithms/graphs"><b>Graphs</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching"><b>Searching</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/dfs/"><b>DFS</b></a> 
│   │ 	│   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/dfs/DFSID.java"><b>DFS-ID</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/"><b>BFS</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/BidirectionalBFS.java"><b>Bidirectional BFS</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath"><b>Shortest Path</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/DijkstraLazy.java"><b>Dijkstra's Lazy</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/Dijkstra.java"><b>Dijkstra's Eager</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/BellmanFord.java"><b>Bellman–Ford</b></a>
│   │ 	    ├──	<a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/FloydWarshall.java"><b>Floyd-Warshall</b></a>
│   │ 	    └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/AStar.java"><b>A-star</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst"><b>Minimum Spanning Tree</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTPrimLazy.java"><b>Prim’s Lazy</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTPrim.java"><b>Prim’s Eager</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTKruskal.java"><b>Kruskal’s</b></a>
│   ├── Network Flow
│   │   ├── Maximum Flow
│   │   │   ├── Push-Relabel
│   │   │   ├── Ford-Fulkerson
│   │   │   ├── Edmonds-Karp
│   │   │   └── Dinic's
│   │   ├── Minimum Cut 
│   │   │   └── Karger's
│   │   └── Maximum Bipartite
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/"><b>Sorting</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/"><b>Topological Sort</b></a>
│   │       ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/TopologicalSortKahn.java"><b>Kahn's</b></a>
│   │       └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/TopologicalSortTarjan.java"><b>Tarjan's</b></a> 
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/"><b>Connectivity</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/cc/"><b>Connected Components</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/"><b>Strongly Connected Components</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/SCCKosarajuSharir.java"><b>Kosaraju-Sharir's</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/SCCTarjan.java"><b>Tarjan's</b></a>
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind"><b>Union-Find</b></a>
│   │        ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/QuickFind.java"><b>Quick Find</b></a>
│   │        ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/QuickUnion.java"><b>Quick Union</b></a>
│   │        ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/QuickUnionWeighted.java"><b>Quick Union Weighted</b></a>
│   │        └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/QuickUnionWeightedPathCompression.java"><b>Quick Union Weighted with Path Compression</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/CycleDetection.java"><b>Cycle Detection</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/Bipartite.java"><b>Is Bipartite</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/MColoring.java"><b>Graph coloring</b></a>
│   ├── Eulerian Cycle
│   ├── Eulerian Path
│   ├── Eulerian Tour
│   └── Hamiltonian Cycle
├── Divide and Conquer
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/BinarySearch.java"><b>Binary Search</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/MergeSort.java"><b>Merge Sort</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort.java"><b>Quick Sort</b></a>
│   └── Strassen's Matrix multiplication
├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/"><b>Recursion</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/Factorial.java"><b>Factorial</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/dp"><b>Dynamic Programming</b></a>
│   │   ├── Approaches
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java#L25"><b>Top-Down  - Memoization</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java#L45"><b>Bottom-Up - Tabulation</b></a>
│   │   │   └── Half-and-Half
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/BellmanFord.java"><b>Bellman–Ford</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/FloydWarshall.java"><b>Floyd-Warshall</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/LevenshteinDistance.java"><b>Levenshtein Distance</b></a>
│   │   ├── Regular Expression Matching
│   │   ├── Matrix Chain Multiplication
│   │   └── Binomial Coefficient
│   └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/"><b>Backtracking</b></a>
│       └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/"><b>Combinatorics</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Permutations.java"><b>Permutations</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Combinations.java"><b>Combinations</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Subsets.java"><b>Subsets</b></a>
│           └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Partitions.java"><b>Partitions</b></a>
├── Greedy
│   ├── Huffman Coding
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/Dijkstra.java"><b>Shortest Path Dijkstra's</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTPrim.java"><b>MST Prim’s </b></a>
│   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTKruskal.java"><b>MST Kruskal’s</b></a>
├── Randomized
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/QuickSort.java#L46"><b>Randomized Quick Sort</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/randomized/FisherYatesShuffle.java"><b>Fisher-Yates Shuffle</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/QuickSelect.java#L44"><b>Randomized Quick Select</b></a>
│   ├── Las Vegas
│   └── Monte Carlo
├── <a href="src/main/java/com/gkonovalov/algorithms/gametheory/"><b>Game Theory</b></a>
│   ├── Minimax
│   └── <a href="src/main/java/com/gkonovalov/algorithms/gametheory/prisonersdilemma/PrisonersDilemma.java"><b>Prisoner's Dilemma</b></a>
├── Geometry
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Voronoi Diagram
│   ├── Delaunay Triangulation
│   └── Convex Hull
│       ├── Graham Scan
│       └── Jarvis March
└── <a href="src/main/java/com/gkonovalov/algorithms/math"><b>Math</b></a>
    ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
    ├── <a href="src/main/java/com/gkonovalov/algorithms/math/Factorial.java"><b>Factorial</b></a>
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
│   └── Suffix Arrays
├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist"><b>Linked Lists</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/SinglyLinkedList.java"><b>Singly Linked List</b></a>  
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/linkedlist/DoublyLinkedList.java"><b>Doubly Linked List</b></a> 
│   └── Skip List
├── <a href="src/main/java/com/gkonovalov/datastructures/stack/Stack.java"><b>Stacks</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/queues"><b>Queues</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/queues/Queue.java"><b>Queue</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/queues/Deque.java"><b>Deque</b></a>
│   └── <a href="src/main/java/com/gkonovalov/datastructures/queues/CircularQueue.java"><b>Circular Queue</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables"><b>Hash Tables</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashMap.java"><b>HashMap</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashSet.java"><b>HashSet</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/SparseVector.java"><b>Sparse Vector</b></a>
│   └── Collision Resolution
│       ├── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashMap.java#L159"><b>Separate Chaining</b></a>
│       └── <a href="src/main/java/com/gkonovalov/datastructures/hashtables/HashSet.java#L107"><b>Open Addressing</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/bloomfilter/BloomFilter.java"><b>Bloom Filter</b></a> 
├── <a href="src/main/java/com/gkonovalov/datastructures/trees/"><b>Trees</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/BinarySearchTree.java"><b>Binary Search Tree</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/trie"><b>Trie-trees</b></a>
│   │    ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/trie/Trie.java"><b>Prefix Tree - Trie</b></a>
│   │    └── Suffix Tree
│   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps"><b>Heaps</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java"><b>Binary Heap - Priority Queue</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java#L124"><b>Min Heap</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/BinaryHeap.java#L122"><b>Max Heap</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/heaps/IndexedBinaryHeap.java"><b>Indexed Binary Heap</b></a>
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
    ├── Types
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L32"><b>Undirected Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L59"><b>Directed Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L106"><b>Weighted Undirected Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L122"><b>Weighted Directed Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L51"><b>Cyclic Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L51"><b>Acyclic Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L71"><b>Directed Acyclic Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L97"><b>Labeled Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/graphs/representation/AdjacencyList.java#L78"><b>Bipartite Graph</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/datastructures/trees/TreeNode.java"><b>Tree</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/"><b>Forest</b></a>
    │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst"><b>Spanning Tree</b></a>
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
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │   ├── Knapsack 0/1
│   │   ├── Knapsack Unbounded
│   │   ├── Traveling Salesman
│   │   ├── Longest Common Subsequence (LCS) 
│   │   ├── Longest Increasing Subsequence (LIS) 
│   │   ├── Longest Palindrome Subsequence (LPS)
│   │   ├── Shortest Common Supersequence (SCS)
│   │   ├── Maximum Sum Increasing Subsequence
│   │   ├── Maximum Subarray Sum
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
│       ├── Traveling Salesman 
│       ├── N-Queens
│       ├── Knight's Tour 
│       ├── Sudoku Solver
│       ├── Unique Paths
│       ├── Rat in a Maze 
│       ├── Subset Sum
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