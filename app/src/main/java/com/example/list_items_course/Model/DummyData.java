package com.example.list_items_course.Model;

import com.example.list_items_course.R;

public class DummyData {
    // Sample data for courses


    public static String[] courseImg = {
            String.valueOf(R.mipmap.c),   String.valueOf(R.mipmap.cpp),String.valueOf(R.mipmap.java),String.valueOf(R.mipmap.python),        };
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
            "Array in c" ,
            "String in c",


            "Array in C++",
            "String in C++ ",


            "Array in Java",
            "String in Java",

            "Array in Python",
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
            "Write a C program to find the sum of an array of integers.",
            "Implement a String Matching algorithm in C.",
            "Implement a function in C++ to reverse a string.",
            "Create a C++ program to find the largest and smallest element in an array.",
            "Write a Java program to calculate the average of a list of numbers.",
            "Write a Java program to split a string using a token.",
            "Create a Python program to check if a given string is a palindrome.",
            "Generate a list of even numbers in Python.",
    };

    public  static String[] programSolutions = {
               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

            "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",

               "#include <stdbool.h>\n" +
            "#include <stdio.h>\n" +
            "#include <stdlib.h>\n" +
            "\n" +
            "// An Interval\n" +
            "typedef struct Interval {\n" +
            "    int s, e;\n" +
            "} Interval;\n" +
            "\n" +
            "// Function used in sort\n" +
            "int mycomp(const void* a, const void* b)\n" +
            "{\n" +
            "    Interval* data_1 = (Interval*)a;\n" +
            "    Interval* data_2 = (Interval*)b;\n" +
            "    return (data_1->s - data_2->s);\n" +
            "}\n" +
            "\n" +
            "// Find maximum between two numbers.\n" +
            "int max(int num1, int num2)\n" +
            "{\n" +
            "    return (num1 > num2) ? num1 : num2;\n" +
            "}\n" +
            "\n" +
            "void mergeIntervals(Interval arr[], int n)\n" +
            "{\n" +
            "    // Sort Intervals in increasing order of\n" +
            "    // start time\n" +
            "    qsort(arr, n, sizeof(Interval), mycomp);\n" +
            "\n" +
            "    int index = 0; // Stores index of last element\n" +
            "    // in output array (modified arr[])\n" +
            "\n" +
            "    // Traverse all input Intervals\n" +
            "    for (int i = 1; i < n; i++) {\n" +
            "        // If this is not the first Interval and overlaps\n" +
            "        // with the previous one\n" +
            "        if (arr[index].e >= arr[i].s) {\n" +
            "            // Merge previous and current Intervals\n" +
            "            arr[index].e = max(arr[index].e, arr[i].e);\n" +
            "        }\n" +
            "        else {\n" +
            "            index++;\n" +
            "            arr[index] = arr[i];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    // Now arr[0..index-1] stores the merged Intervals\n" +
            "    printf(\"\\n The Merged Intervals are: \");\n" +
            "    for (int i = 0; i <= index; i++)\n" +
            "        printf(\"[%d, %d]\", arr[i].s, arr[i].e);\n" +
            "}\n" +
            "\n" +
            "// Driver program\n" +
            "int main()\n" +
            "{\n" +
            "    Interval arr[]\n" +
            "        = { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } };\n" +
            "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
            "    mergeIntervals(arr, n);\n" +
            "    return 0;\n" +
            "}",


    };

    public static int[] programTopicIDs = {1, 2, 4,3, 5,6, 8,7};

    public static int[] programIsReadValues = {0, 0, 0, 0, 0, 0, 0, 0};

    public static String[] programRemarks = {
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
