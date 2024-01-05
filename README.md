## Algorithms and Data Structures

> **_Donald Knuth:_**  "An algorithm must be seen to be believed".

Welcome to curated GitHub repository, featuring a comprehensive collection of fundamental Algorithms and 
Data structures organized into various categories to cater to the needs of software engineers and 
computer science students. Each Algorithm and Data structure is systematically classified, ensuring easy 
navigation and efficient learning. You will find concise explanations and clear Java implementation code,
making it easy to understand and implement the concepts in your projects.

Additionally, the repository includes sample problems and solutions, designed to help practice and 
apply the concepts learned from each Algorithm and Data structure. 
These problems serve as valuable exercises to enhance your problem-solving skills.

## Algorithms
<pre>
<a href="src/main/java/com/gkonovalov/algorithms/"><b>Algorithms</b></a>
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
│       └── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/"><b>Edit Distance</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/LevenshteinDistance.java"><b>Levenshtein Distance</b></a>
│           └── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/HammingDistance.java"><b>Hamming Distance</b></a>
├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/"><b>Arrays</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/"><b>Searching</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/LinearSearch.java"><b>Linear Search</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/BinarySearch.java"><b>Binary Search</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/ExponentialSearch.java"><b>Exponential Search</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/JumpSearch.java"><b>Jump Search</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/InterpolationSearch.java"><b>Interpolation Search</b></a>
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/TernarySearch.java"><b>Ternary Search</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/"><b>Sorting</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/BubbleSort.java"><b>Bubble Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/SelectionSort.java"><b>Selection Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/InsertionSort.java"><b>Insertion Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/MergeSort.java"><b>Merge Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort"><b>Quick Sort</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort/QuickSortPartitionHoare.java"><b>Partition Hoare</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort/QuickSortPartitionLomuto.java"><b>Partition Lomuto</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort/QuickSort3WayPartitioning.java"><b>3-Way Partitioning</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/HeapSort.java"><b>Heap Sort</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/CountingSort.java"><b>Counting Sort</b></a>
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/BucketSort.java"><b>Bucket Sort</b></a>
│   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/"><b>Selection</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/quickselect/"><b>Quick Select</b></a>
│       │   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/quickselect/QuickSelectPartitionHoare.java"><b>Partition Hoare</b></a>
│       │   └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/quickselect/QuickSelectPartitionHoare.java"><b>Partition Lomuto</b></a>
│       └── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/MedianOfMedians.java"><b>Median of medians</b></a>
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
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/dfs/DFS.java"><b>DFS</b></a> 
│   │ 	│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/dfs/DFSPath.java"><b>Path</b></a> 
│   │ 	│   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/dfs/DFSID.java"><b>DFS-ID</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/BFS.java"><b>BFS</b></a>
│   │ 	│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/BFSPath.java"><b>Path</b></a> 
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/BidirectionalBFS.java"><b>Bidirectional BFS</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath"><b>Shortest Path</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/bfs/BFS.java"><b>BFS</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/dijkstra/"><b>Dijkstra's</b></a>
│   │ 	    │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/dijkstra/DijkstraEager.java"><b>Eager</b></a>
│   │ 	    │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/dijkstra/DijkstraLazy.java"><b>Lazy</b></a>
│   │ 	    ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/BellmanFord.java"><b>Bellman–Ford</b></a>
│   │ 	    ├──	<a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/FloydWarshall.java"><b>Floyd-Warshall</b></a>
│   │ 	    └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/AStar.java"><b>A-star</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst"><b>Minimum Spanning Tree</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/prim/"><b>Prim’s</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/prim/MSTPrimEager.java"><b>Eager</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/prim/MSTPrimLazy.java"><b>Lazy</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTKruskal.java"><b>Kruskal’s</b></a>
│   ├── Network Flow
│   │   ├── Maximum Flow
│   │   │   ├── Ford-Fulkerson
│   │   │   ├── Edmonds-Karp
│   │   │   ├── Push-Relabel
│   │   │   └── Dinic's
│   │   ├── Minimum Cut 
│   │   │   └── Karger's
│   │   └── Maximum Bipartite
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/"><b>Sorting</b></a>
│   │ 	└── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/"><b>Topological Sort</b></a>
│   │       ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/TopologicalSortKahn.java"><b>Kahn's</b></a>
│   │       └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/sorting/topological/TopologicalSortTarjan.java"><b>Tarjan's</b></a> 
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/"><b>Connectivity</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/Bridge.java"><b>Bridge</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/Connectivity.java"><b>Connectivity</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/cc/"><b>Connected Components</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/"><b>Strongly Connected Components</b></a>
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/SCCKosarajuSharir.java"><b>Kosaraju-Sharir's</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/scc/SCCTarjan.java"><b>Tarjan's</b></a>
│   │   └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind"><b>Union-Find</b></a>
│   │        ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/QuickFind.java"><b>Quick Find</b></a>
│   │        └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/quickunion/QuickUnion.java"><b>Quick Union</b></a>
│   │            ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/quickunion/QuickUnionWeighted.java"><b>Weighted</b></a>
│   │            └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/connectivity/unionfind/quickunion/QuickUnionWeightedPathCompression.java"><b>Weighted with Path Compression</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/CycleDetection.java"><b>Cycle Detection</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/Bipartite.java"><b>Is Bipartite</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/MColoring.java"><b>Graph coloring</b></a>
│   ├── Eulerian Path
│   ├── Eulerian Cycle
│   ├── Hamiltonian Path
│   └── Hamiltonian Cycle
├── Divide and Conquer
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/searching/BinarySearch.java"><b>Binary Search</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/MergeSort.java"><b>Merge Sort</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort/"><b>Quick Sort</b></a>
│   └── Strassen's Matrix multiplication
├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/"><b>Recursion</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/Factorial.java"><b>Factorial</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/dp"><b>Dynamic Programming</b></a>
│   │   ├── Approaches
│   │   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java#L25"><b>Top-Down  - Memoization</b></a>
│   │   │   └── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java#L45"><b>Bottom-Up - Tabulation</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/BellmanFord.java"><b>Bellman–Ford</b></a>
│   │ 	├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/FloydWarshall.java"><b>Floyd-Warshall</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/strings/matching/editdistance/LevenshteinDistance.java"><b>Levenshtein Distance</b></a>
│   │   ├── Regular Expression Matching
│   │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/MatrixChainMultiplication.java"><b>Matrix Chain Multiplication</b></a>
│   │   └── Binomial Coefficient
│   └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/"><b>Backtracking</b></a>
│       └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/"><b>Combinatorics</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Permutations.java"><b>Permutations</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Combinations.java"><b>Combinations</b></a>
│           ├── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Subsets.java"><b>Subsets</b></a>
│           └── <a href="src/main/java/com/gkonovalov/algorithms/recursion/backtracking/combinatorics/Partitions.java"><b>Partitions</b></a>
├── Greedy
│   ├── Huffman Coding
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/searching/shortestpath/dijkstra/DijkstraLazy.java"><b>Dijkstra's Lazy</b></a>
│   └── Minimum Spanning Tree
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/prim/MSTPrimLazy.java"><b>Prim’s Lazy</b></a>
│       └── <a href="src/main/java/com/gkonovalov/algorithms/graphs/mst/MSTKruskal.java"><b>Kruskal’s</b></a>
├── Randomized
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/sorting/quicksort/QuickSortPartitionLomuto.java#L47"><b>Randomized Quick Sort</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/randomized/FisherYatesShuffle.java"><b>Fisher-Yates Shuffle</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/algorithms/arrays/selection/quickselect/QuickSelectPartitionLomuto.java#L52"><b>Randomized Quick Select</b></a>
│   ├── Las Vegas
│   └── Monte Carlo
├── <a href="src/main/java/com/gkonovalov/algorithms/gametheory/"><b>Game Theory</b></a>
│   ├── Minimax
│   └── <a href="src/main/java/com/gkonovalov/algorithms/gametheory/prisonersdilemma/PrisonersDilemma.java"><b>Prisoner's Dilemma</b></a>
├── <a href="src/main/java/com/gkonovalov/algorithms/geometry/"><b>Geometry</b></a>
│   ├── Closest Pair of Points
│   ├── Line Intersection
│   ├── Voronoi Diagram
│   ├── Delaunay Triangulation
│   └── <a href="src/main/java/com/gkonovalov/algorithms/geometry/convexhull/"><b>Convex Hull</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/algorithms/geometry/convexhull/GrahamScan.java"><b>Graham Scan</b></a>
│       └── <a href="src/main/java/com/gkonovalov/algorithms/geometry/convexhull/JarvisMarch.java"><b>Jarvis March</b></a>
├── <a href="src/main/java/com/gkonovalov/algorithms/bits/BitsOperations.java"><b>Bits Operations</b></a>
└── <a href="src/main/java/com/gkonovalov/algorithms/math"><b>Math</b></a>
    ├── <a href="src/main/java/com/gkonovalov/algorithms/math/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
    ├── <a href="src/main/java/com/gkonovalov/algorithms/math/Factorial.java"><b>Factorial</b></a>
    ├── <a href="src/main/java/com/gkonovalov/algorithms/math/primenumbers"><b>Prime Numbers</b></a>
    │   ├── <a href="src/main/java/com/gkonovalov/algorithms/math/primenumbers/SieveOfEratosthenes.java"><b>Sieve of Eratosthenes</b></a>
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
    └── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix"><b>Matrix</b></a>
        ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/MatrixInversion.java"><b>Inversion</b></a>
        ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/MatrixTransposition.java"><b>Transposition</b></a>
        ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/MatrixSquareRotation.java"><b>Square Rotation</b></a>
        └── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/MatrixMultiplication.java"><b>Multiplication</b></a>  
            ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/MatrixExponentiation.java"><b>Exponentiation</b></a> 
            ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/SparseMatrixMultiplication.java"><b>Sparse Matrix</b></a>
            ├── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/MatrixChainMultiplication.java"><b>Chain</b></a>
            └── <a href="src/main/java/com/gkonovalov/algorithms/math/matrix/multiplication/MatrixStrassenMultiplication.java"><b>Strassen's</b></a>
</pre>

## Data Structures
<pre>
<a href="src/main/java/com/gkonovalov/datastructures/"><b>Data Structures</b></a>
├── <a href="src/main/java/com/gkonovalov/datastructures/strings/String.java"><b>String</b></a>
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
│   ├── <a href="src/main/java/com/gkonovalov/problems/arrays/MaximumSubarray.java"><b>Maximum Sum Subarray - Kadane's </b></a>
│   ├── Sliding Window
│   ├── <a href="src/main/java/com/gkonovalov/problems/arrays/twopointers/"><b>Two Pointers</b></a>
│   ├── Searching
│   │   └── <a href="src/main/java/com/gkonovalov/problems/arrays/searching/binarysearch/"><b>Binary Search</b></a>
│   └── Range Sum 
├── Strings
│   ├── <a href="src/main/java/com/gkonovalov/problems/strings/SpellingCorrection.java"><b>Spelling Correction</b></a>
│   ├── Reverse String
│   ├── Anagram Checking
│   └── Palindromes
│       ├── Palindrome Checking
│       ├── Palindrome Substrings
│       └── Longest Palindromic Substring
├── <a href="src/main/java/com/gkonovalov/problems/linkedlist/"><b>Linked List</b></a>
│   ├── <a href="src/main/java/com/gkonovalov/problems/linkedlist/reversal/"><b>Reversal</b></a>
│   └── <a href="src/main/java/com/gkonovalov/problems/linkedlist/cache/"><b>Cache</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/problems/linkedlist/cache/LRUCache.java"><b>LRU</b></a>
│       └── LFU 
├── Stacks
├── Queues
├── Hash Table
├── Trees
│   ├── Binary Search Tree
│   └── Trie-trees
├── <a href="src/main/java/com/gkonovalov/problems/graph/"><b>Graphs</b></a>
│   └── <a href="src/main/java/com/gkonovalov/problems/graph/searching"><b>Searching</b></a>
│       ├── <a href="src/main/java/com/gkonovalov/problems/graph/searching/bfs"><b>BFS</b></a>
│       └── <a href="src/main/java/com/gkonovalov/problems/graph/searching/dfs"><b>DFS</b></a>
├── Recursion
│   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/"><b>Dynamic Programming</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/FibonacciNumbers.java"><b>Fibonacci Numbers</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/Knapsack01.java"><b>Knapsack 0/1</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/KnapsackUnbounded.java"><b>Knapsack Unbounded</b></a>
│   │   ├── Traveling Salesman
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/LongestCommonSubsequence.java"><b>Longest Common Subsequence (LCS)</b></a>
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/LongestIncreasingSubsequence.java"><b>Longest Increasing Subsequence (LIS)</b></a> 
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/LongestPalindromicSubstring.java"><b>Longest Palindrome Subsequence (LPS)</b></a>
│   │   ├── Shortest Common Supersequence (SCS)
│   │   ├── Maximum Sum Increasing Subsequence
│   │   ├── Maximum Subarray Sum
│   │   ├── Combination Sum
│   │   ├── Rod Cutting
│   │   ├── <a href="src/main/java/com/gkonovalov/problems/recursion/dp/JumpGame.java"><b>Jump Game</b></a>
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
│   │   ├── Staircase
│   │   └── Coin Change
│   └── <a href="src/main/java/com/gkonovalov/problems/recursion/backtracking/"><b>Backtracking</b></a>
│       ├── Traveling Salesman 
│       ├── <a href="src/main/java/com/gkonovalov/problems/recursion/backtracking/NQueens.java"><b>N-Queens</b></a>
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
3. Navigate to `algorithms` root directory.
4. Select `setting.gradle`

------------
Georgiy Konovalov 2023 (c) [MIT License](LICENSE)