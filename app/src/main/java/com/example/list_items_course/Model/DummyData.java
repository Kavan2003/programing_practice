package com.example.list_items_course.Model;

import com.example.list_items_course.R;

public class DummyData {
    // Sample data for courses


    public static String[] courseImg = {
            String.valueOf(R.mipmap.c),
            String.valueOf(R.mipmap.cpp),
            String.valueOf(R.mipmap.java),
            String.valueOf(R.mipmap.python),
    };
    public static String[] courseNames = {
            "C", "C++", "Java", "Python"
    };

    public static int[] isActiveValues = {1, 0, 1, 1};

    public static String[] remarks = {
            "Good", "Excellent", "Fair", "Fair"
    };

    // Sample data for PP_Topic table
    public static int [] PP_TopicID= {
            1,2,3,4,5,6,7,8
    };
    public static String[] topicNames = {
            " Array in c" ,
            "String in c",


            " Array in C++",
            "String in C++ ",


            " Array in Java",
            "String in Java",

            " Array in Python",
            "String in Python",



            };

    public  static  int[] topicIsActiveValues = {1, 1, 1, 1,1, 1, 1, 1};

    public static  String[] topicRemarks = {
            "Good",
            "Average",
            "Fair",
            "Good",
            "Good",
            "Average",
            "Fair",
            "Good",

    };
    public static  int[] courseIDs = {1, 1,  2, 2,  3, 3, 4, 4};

    // Sample data for PP_Program table

    public static String[] programStatements = {
            // Data for Course ID 1
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Solve a quadratic equation in C programming.",
            "Create a program to calculate factorial in C.",
            "Write a C program to find the largest element in an array.",
            "Implement a linked list in C.",
            "Develop a simple calculator in C.",
            "Create a program to reverse a string in C.",
            "Write a C program to calculate the area of a circle.",
            "Implement a binary search algorithm in C.",

            // Data for Course ID 2
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Solve a quadratic equation in C programming.",
            "Create a program to calculate factorial in C.",
            "Write a C program to find the largest element in an array.",
            "Implement a linked list in C.",
            "Develop a simple calculator in C.",
            "Create a program to reverse a string in C.",
            "Write a C program to calculate the area of a circle.",
            "Implement a binary search algorithm in C.",


            // Data for Course ID 3
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Solve a quadratic equation in C programming.",
            "Create a program to calculate factorial in C.",
            "Write a C program to find the largest element in an array.",
            "Implement a linked list in C.",
            "Develop a simple calculator in C.",
            "Create a program to reverse a string in C.",
            "Write a C program to calculate the area of a circle.",
            "Implement a binary search algorithm in C.",


            // Data for Course ID 4
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Solve a quadratic equation in C programming.",
            "Create a program to calculate factorial in C.",
            "Write a C program to find the largest element in an array.",
            "Implement a linked list in C.",
            "Develop a simple calculator in C.",
            "Create a program to reverse a string in C.",
            "Write a C program to calculate the area of a circle.",
            "Implement a binary search algorithm in C.",

    };


    public static String[] programSolutions = {
            // Solutions for Course ID 1
            "#include <stdio.h>\n" +
                    "#include <limits.h>\n" +
                    "\n" +
                    "// Number of vertices in the graph\n" +
                    "#define V 9\n" +
                    "\n" +
                    "// Function to find the vertex with the minimum distance value\n" +
                    "// from the set of vertices not yet included in the shortest path tree\n" +
                    "int minDistance(int dist[], int sptSet[]) {\n" +
                    "    int min = INT_MAX, min_index;\n" +
                    "\n" +
                    "    for (int v = 0; v < V; v++) {\n" +
                    "        if (sptSet[v] == 0 && dist[v] <= min) {\n" +
                    "            min = dist[v];\n" +
                    "            min_index = v;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    return min_index;\n" +
                    "}\n" +
                    "\n" +
                    "// Function to print the constructed distance array\n" +
                    "void printSolution(int dist[], int n) {\n" +
                    "    printf(\"Vertex \\t Distance from Source\\n\");\n" +
                    "    for (int i = 0; i < V; i++)\n" +
                    "        printf(\"%d \\t\\t %d\\n\", i, dist[i]);\n" +
                    "}\n" +
                    "\n" +
                    "// Function that implements Dijkstra's single source shortest path algorithm\n" +
                    "// for a graph represented using adjacency matrix representation\n" +
                    "void dijkstra(int graph[V][V], int src) {\n" +
                    "    int dist[V];     // The output array dist[i] holds the shortest distance from src to i\n" +
                    "    int sptSet[V];   // sptSet[i] is true if vertex i is included in the shortest\n" +
                    "                     // path tree or the shortest distance from src to i is finalized\n" +
                    "\n" +
                    "    // Initialize all distances as INFINITE and sptSet[] as false\n" +
                    "    for (int i = 0; i < V; i++) {\n" +
                    "        dist[i] = INT_MAX;\n" +
                    "        sptSet[i] = 0;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Distance of source vertex from itself is always 0\n" +
                    "    dist[src] = 0;\n" +
                    "\n" +
                    "    // Find shortest path for all vertices\n" +
                    "    for (int count = 0; count < V - 1; count++) {\n" +
                    "        // Pick the minimum distance vertex from the set of vertices not\n" +
                    "        // yet processed. u is always equal to src in the first iteration.\n" +
                    "        int u = minDistance(dist, sptSet);\n" +
                    "\n" +
                    "        // Mark the picked vertex as processed\n" +
                    "        sptSet[u] = 1;\n" +
                    "\n" +
                    "        // Update dist value of the adjacent vertices of the picked vertex\n" +
                    "        for (int v = 0; v < V; v++) {\n" +
                    "            // Update dist[v] only if it is not in the sptSet, there is an edge from\n" +
                    "            // u to v, and the total weight of path from src to v through u is\n" +
                    "            // less than the current value of dist[v]\n" +
                    "            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX\n" +
                    "                && dist[u] + graph[u][v] < dist[v]) {\n" +
                    "                dist[v] = dist[u] + graph[u][v];\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    // Print the constructed distance array\n" +
                    "    printSolution(dist, V);\n" +
                    "}\n" +
                    "\n" +
                    "int main() {\n" +
                    "    // Example graph represented using an adjacency matrix\n" +
                    "    int graph[V][V] = {\n" +
                    "        {0, 4, 0, 0, 0, 0, 0, 8, 0},\n" +
                    "        {4, 0, 8, 0, 0, 0, 0, 11, 0},\n" +
                    "        {0, 8, 0, 7, 0, 4, 0, 0, 2},\n" +
                    "        {0, 0, 7, 0, 9, 14, 0, 0, 0},\n" +
                    "        {0, 0, 0, 9, 0, 10, 0, 0, 0},\n" +
                    "        {0, 0, 4, 14, 10, 0, 2, 0, 0},\n" +
                    "        {0, 0, 0, 0, 0, 2, 0, 1, 6},\n" +
                    "        {8, 11, 0, 0, 0, 0, 1, 0, 7},\n" +
                    "        {0, 0, 2, 0, 0, 0, 6, 7, 0}\n" +
                    "    };\n" +
                    "\n" +
                    "    // Applying Dijkstra's algorithm starting from vertex 0\n" +
                    "    dijkstra(graph, 0);\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n",
            "This is the solution for implementing a String Matching algorithm in C.",
            "Here's the solution for solving a quadratic equation in C programming.",
            "This is the solution to calculate the factorial of a number in C.",
            "Here's the solution to find the largest element in an array in C.",
            "This is the solution for implementing a linked list in C.",
            "Here's the code for developing a simple calculator in C.",
            "This is the solution to reverse a string in C.",
            "Here's the code for calculating the area of a circle in C.",
            "This is the solution for implementing a binary search algorithm in C.",

            // Solutions for Course ID 2
            "This is the solution for implementing a function to reverse a string in C++.",
            "Here's the code for matrix multiplication in C++.",
            "This is the solution for a simple tic-tac-toe game in C++.",
            "Here's the code for a basic student management system in C++.",
            "This is the solution to calculate the power of a number in C++.",
            "Here's the code for operator overloading in C++.",
            "This is the solution for performing file operations in C++.",
            "Here's the code for a basic banking system in C++.",
            "This is the solution for simple inheritance in C++.",
            "Here's the code for implementing a linked list in C++.",

            // Solutions for Course ID 3
            "This is the solution for calculating the average of a list of numbers in Java.",
            "Here's the code for finding the largest and smallest numbers in an array in Java.",
            "This is the solution to simulate a simple ATM machine in Java.",
            "Here's the code for a basic address book application in Java.",
            "This is the solution to find the Fibonacci series in Java.",
            "Here's the code for implementing exception handling in Java.",
            "This is the solution for basic multithreading in Java.",
            "Here's the code for a basic calculator application in Java.",
            "This is the solution for file handling in Java.",
            "Here's the code for implementing a basic GUI application in Java.",

            // Solutions for Course ID 4
            "This is the solution to check if a given string is a palindrome in Python.",
            "Here's the code to generate a list of prime numbers in Python.",
            "This is the solution to find the factorial of a number in Python.",
            "Here's the code for a basic dictionary application in Python.",
            "This is the solution for text processing in Python.",
            "Here's the code for developing a basic chat application using Python sockets.",
            "This is the solution for performing web scraping in Python.",
            "Here's the code for creating a simple Python game like Tic-Tac-Toe.",
            "This is the solution to implement a basic REST API in Python.",
            "Here's the code for developing a basic web application using Python and Flask."
    };


//    public static int[] programTopicIDs = {1, 2, 4,3, 5,6, 8,7,1, 2, 4,3, 5,6, 8,7,1, 2, 4,3, 5,6, 8,7,1, 2, 4,3, 5,6, 8,7,1, 2, 4,3, 5,6, 8,7};
public static int[] programTopicIDs = {
        // Topic IDs for Course ID 1
        1, 2, 3, 4, 5, 6, 7, 8, 1,2,

        // Topic IDs for Course ID 2
        1, 2, 3, 4, 5, 6, 7, 8, 1,2
,

        // Topic IDs for Course ID 3
        1, 2, 3, 4, 5, 6, 7, 8, 1,2,

        // Topic IDs for Course ID 4
        1, 2, 3, 4, 5, 6, 7, 8, 1,2,
};

    public static int[] programIsReadValues = {
            // Is Read Values for Course ID 1
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

            // Is Read Values for Course ID 2
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

            // Is Read Values for Course ID 3
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

            // Is Read Values for Course ID 4
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public static String[] programRemarks = {
            "1This is a basic array sum problem.",
            "2String reversal can be done in various ways.",
            "3Calculating the average of a list.",
            "4Check if a string is a palindrome.",
            "5Bubble Sort is a simple sorting algorithm.",
            "6Finding the min and max in an array.",
            "7Recursive solution to calculate factorial.",
            "8Generating a list of even numbers.",
            "9This is a basic array sum problem.",
            "0String reversal can be done in various ways.",
            "11Calculating the average of a list.",
            "12Check if a string is a palindrome.",
            "13Bubble Sort is a simple sorting algorithm.",
            "Finding the min and max in an array.",
            "Recursive solution to calculate factorial.",
            "Generating a list of even numbers.",
            "This is a basic array sum problem.",
            "String reversal can be done in various ways.",
            "Calculating the average of a list.",
            "Check if a string is a palindrome.",
            "Bubble Sort is a simple sorting algorithm.",
            "Finding the min and max in an array.",
            "Recursive solution to calculate factorial.",
            "Generating a list of even numbers.",
            "This is a basic array sum problem.",
            "String reversal can be done in various ways.",
            "Calculating the average of a list.",
            "Check if a string is a palindrome.",
            "Bubble Sort is a simple sorting algorithm.",
            "Finding the min and max in an array.",
            "Recursive solution to calculate factorial.",
            "Generating a list of even numbers."
            ,
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers.",
            "Generating a list of even numbers."
    };


}
