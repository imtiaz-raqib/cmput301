//----------------------------------------------
// Created by Imtiaz Raqib & Craig Miller
//----------------------------------------------

// The binary search method

public static int GetIndex(int a[], int x, int n) {

    if (a == null) {
        return -1;
    }
    if (n > a.length) {
        n = a.length;
    }

    int low = a;
    int high = n - 1;

}


// Main test for the binary search method

public static void main(String args[]) {

    int array[] = {3, 4, 6, 42, 68, 69, 89, 100, 101};

    int index = GetIndex(array, 69, 8);

    if (index == -1) {
        System.out.println("Index not found.");
    } else {
        System.out.println("Value found! " + index);
    }

}