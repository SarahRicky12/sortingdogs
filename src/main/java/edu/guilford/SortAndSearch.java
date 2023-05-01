package edu.guilford;

public class SortAndSearch {
    // Add a static selectionSort method that takes an array of integers as a
    // parameter
    // and sorts the array using the selection sort algorithm
    public static void selectionSort(int[] array) {
        // Loop over all elements in the array and find the smallest one
        // Note it's a counting loop and a for loop is effective
        for (int i = 0; i < array.length; i++) {
            // Assume the smallest element is the first element
            int smallest = i;
            // Loop over all elements after the first element
            // End of the array has i = array.length - 1
            // j would start at array.length which is not less than array.length
            // the next loop won't do anything for the last element
            for (int j = i + 1; j < array.length; j++) {
                // If the current element is smaller than the smallest element
                if (array[j] < array[smallest]) {
                    // Set the smallest element to the current element
                    smallest = j;
                }
            }
            // Swap the smallest element with the first element
            swap(array, i, smallest);

        }

    }


    // Add a static quickSort method that takes an array of integers as a parameter and 
    //sorts the array using the quick sort algorithm
    public static void quickSort(int[] array) {
        // Call the recursive quickSort method 
        quickSort(array, 0, array.length - 1);
    }

    //Add a static quicksort method that takes an array of integers as 
    // a parameter and sorts the array using the quick sort algorithm
    // This method is recursive
    public static void quickSort(int[] array, int start, int end) {
        // If the low index is less than the high index
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, start, end);
            // Recursively call quickSort on the left side of the pivot
            quickSort(array, start, pivotIndex - 1);
            // Recursively call quickSort on the right side of the pivot
            quickSort(array, pivotIndex + 1, end);
        }
    }

    // Add a static partion method that takes an array of integers as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partition(int[] array, int start, int end) {
        // Set the pivot to the last element in the array
        int pivot = array[end];
        // Set the partition index to the start of the array
        int partitionIndex = start;
        // Loop over all elements in the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array[i] < pivot) {
                // Swap the current element with the element at the partition index
                swap(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }
        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, end);
        // Return the partition index
        return partitionIndex;
    }




    // Let's create a method that swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        // Create a temporary variable to hold the value of array[i]
        int temp = array[i];
        // Set array[i] to the value of array[j]
        array[i] = array[j];
        // Set array[j] to the value of temp
        array[j] = temp;
    }

    // Add a linear or sequential search algorithm
    public static int linearSearch(int[] array, int target) {
        // Loop over all elements in the array
        // We're going to go through each element one at a time and stop when we find what we're looking for
    
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the target
            if (array[i] == target) {
                // Return the index of the current element
                return i;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we cant find it)
        return -1;
    }

}
