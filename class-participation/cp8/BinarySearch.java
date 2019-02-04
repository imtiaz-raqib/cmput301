//----------------------------------------------
// Created by Imtiaz Raqib & Craig Miller
//----------------------------------------------

// The binary search method

public static int GetIndex(int a[], int l, int r, int x) {

    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        // If the element is present at the middle 
        // itself 
        if (a[mid] == x) 
            return mid; 
  
        // If element is smaller than mid, then 
        // it can only be present in left subarray 
        if (a[mid] > x) 
            return GetIndex(arr, l, mid - 1, x); 
  
        // Else the element can only be present 
        // in right subarray 
        return GetIndex(a, mid + 1, r, x); 
    }
    // If element is not present in the array
    return -1;
}


// Main test for the binary search method

int main(void) {

    int array[] = {3, 4, 6, 42, 68, 69, 89, 100, 101};
    int n = sizeof(array) / sizeof(array[0]); 
    int x = 69; 
    int result = GetIndex(array, 0, n - 1, x); 
    (result == -1) ? printf("Element is not present in array") : printf("Element is present at index %d", result); 
    return 0;
}