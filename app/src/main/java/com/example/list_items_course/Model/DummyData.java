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
            "Hii this is the solution for finding the sum of an array of integers in C.",
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
