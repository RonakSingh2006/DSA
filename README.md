# Data Structures and Algorithms (DSA) in Java

This repository contains efficient implementations of various Data Structures and Algorithms in Java. It covers a wide range of topics from basic bit manipulation to advanced graph algorithms and dynamic programming.

## 📂 Contents

### 🌳 Advanced Data Structures
* **Binary Lifting**: `KthAncesstor` - Finding the Kth ancestor of a node in a tree.
* **Fenwick Tree (Binary Indexed Tree)**: Efficient prefix sums and updates.
* **Segment Tree**:
    * Standard Segment Tree for range queries.
    * **Lazy Propagation**: Optimized updates for range modifications.
* **Trie**:
    * Standard Trie implementation (Insert, Search, StartsWith).
    * `Trie2` (Count Words Equal To, Count Words Starting With, Erase).
    * **Max XOR**: Finding maximum XOR of two numbers in an array using Trie.
    * **Complete String**: Finding the longest string with all prefixes present.
    * **Count Substrings**: Counting distinct substrings.

### 🕸️ Graph Algorithms
* **Shortest Paths**:
    * **Dijkstra's Algorithm**: Single-source shortest path.
    * **Floyd Warshall**: All-pairs shortest path.
* **Minimum Spanning Tree (MST)**:
    * **Prim's Algorithm**
    * **Kruskal's Algorithm** (using DSU)
* **Disjoint Set Union (DSU)**: Union-Find data structure with path compression and union by rank.
* **Traversals & Components**:
    * Connected Components.
    * **Alien Dictionary**: Topological sort application.

### 💡 Dynamic Programming (DP)
* **Classic Problems**:
    * Fibonacci Sequence (Recursion, Memoization, Tabulation, Optimized).
    * Longest Common Subsequence (LCS).
    * Coin Change.
    * Rod Cutting.
    * Matrix Chain Multiplication (MCM).
    * Boolean Parenthesization.
* **Grid/Array DP**:
    * Maximal Rectangle in a binary matrix.
    * Burst Balloons.

### 🔄 Recursion & Backtracking
* **N-Queens**: Solving the N-Queens problem (placing N queens on an NxN board).
* **Sudoku Solver**: Solving a 9x9 Sudoku board.
* **Maze Problems**:
    * Rat in a Maze.
    * Unique Paths.
* **Subsequences**: Generating all subsequences, subsets, and binary strings.
* **Sorting**: Merge Sort implementation.

### 🔣 String Algorithms
* **KMP Algorithm**: Knuth-Morris-Pratt pattern searching.
* **Rabin-Karp Algorithm**: Pattern searching using hashing.

### ⚡ Bit Manipulation
* **Basics**: Get, Set, Clear, and Toggle bits.
* **Tricks**:
    * Check if a number is a Power of Two.
    * Count number of Set Bits.
    * Find the rightmost Set Bit.
    * Swap two numbers without a temporary variable.

### 🔢 Sorting Algorithms
* **Count Sort**: Efficient sorting for specific ranges.
* **Radix Sort**: Non-comparative integer sorting.
* **Cyclic Sort**: Sorting numbers in a range from 1 to N.

### 🧠 Mathematics & CP Tricks
* **Fermat's Little Theorem**: Modular inverse calculation.
* **Difference Array**: Efficient range updates.
* **XOR Basis**: Maximum XOR subsequences.

## 🚀 How to Run

You can run any file using a standard Java compiler.

**Using Terminal:**
1.  Compile the Java file:
    ```bash
    javac path/to/File.java
    ```
2.  Run the compiled class:
    ```bash
    java path.to.File
    ```

**Example (Running KMP):**
```bash
javac StringAlgorithms/KMP.java
java StringAlgorithms.Main
