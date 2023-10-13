package com.example.list_items_course;

public class DummyData {
    // Sample data for courses


    static String[] courseImg = {
            String.valueOf(R.mipmap.c),   String.valueOf(R.mipmap.cpp),String.valueOf(R.mipmap.java),String.valueOf(R.mipmap.python),        };
    static String[] courseNames = {
            "C", "C++", "Java", "Python"
    };

    static int[] isActiveValues = {1, 0, 1, 1};

    static String[] remarks = {
            "Good", "Excellent", "Fair", "Fair"
    };

    // Sample data for PP_Topic table
    static int [] PP_TopicID= {
            1,2,3,4,5,6,7,8
    };
    static String[] topicNames = {
            "Array in c" ,
            "String in c",


            "Array in C++",
            "String in C++ ",


            "Array in Java",
            "String in Java",

            "Array in Python",
            "String in Python",



            };

    static  int[] topicIsActiveValues = {1, 1, 1, 1,1, 1, 1, 1};

    static  String[] topicRemarks = {
            "Good",
            "Average",
            "Fair",
            "Good",
            "Good",
            "Average",
            "Fair",
            "Good",

    };
  static  int[] courseIDs = {1, 1,  2, 2,  3, 3, 4, 4};
    // Sample data for PP_Program table
    static String[] programStatements = {
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Implement a function in C++ to reverse a string.",
            "Create a C++ program to find the largest and smallest element in an array.",
            "Write a Java program to calculate the average of a list of numbers.",
            "Write a Java program to split a string using a token.",
            "Create a Python program to check if a given string is a palindrome.",
            "Generate a list of even numbers in Python.",
    };

    static String[] programSolutions = {
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",
            "{ /* Your solution here */ }",

    };

    static int[] programTopicIDs = {1, 2, 4,3, 5,6, 8,7};

    static int[] programIsReadValues = {1, 1, 1, 1, 1, 1, 1, 1};

    static String[] programRemarks = {
            "This is a basic array sum problem.",
            "String reversal can be done in various ways.",
            "Calculating the average of a list.",
            "Check if a string is a palindrome.",
            "Bubble Sort is a simple sorting algorithm.",
            "Finding the min and max in an array.",
            "Recursive solution to calculate factorial.",
            "Generating a list of even numbers.",
    };


}
