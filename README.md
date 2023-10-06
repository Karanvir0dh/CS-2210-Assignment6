# CS-2210-Assignment6
Repository for Assignment 6 of CS2210 (Data Structures and Algorithms)
Overview:
This assignment explores the implementation of m-way trees, a tree that can have more than two children. Specifically, we focus on a type of m-way tree called a B-tree.

Objectives:
-Understand the structure and operations of m-way trees.
-Implement an m-way search tree that adheres to B-tree principles.
-Handle tree insertions, considering various cases of node capacity.
-Output the tree after operations.
Details:
4-way Search Tree:

![340multi2](https://github.com/Karanvir0dh/CS-2210-Assignment6/assets/137131993/1e0062d0-ae8b-4e38-b572-97c12728e999)
An m-way search tree is defined where each node has:

-m children

-m-1 key fields

-The keys within each node are in ascending order.

-Specific relations between keys and children, as described in the assignment.

Insertion into a B-tree:

B-trees grow at the root, and three insertion scenarios are provided:

-Key insertion into a leaf with room.

-Key insertion into a full leaf.

-Key insertion when the root is full.

For this assignment, a Java program will be written to handle these cases and perform the specific insertions of values 71 and 84.

Tasks:
Implement an m-way search tree following B-tree principles.

Implement Cases 1 through 3 for insertion.

Display the tree after each operation.
