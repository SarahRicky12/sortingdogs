package edu.guilford;

import java.util.Random;
import java.util.Scanner;

public class DogSort 
{

    public static void main( String[] args )
    {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    //generate an array of random dogs
    Dogs[] dogArray = new Dogs[1000];
    for (int i = 0; i < dogArray.length; i++) {
        dogArray[i] = new Dogs();
    }
    //ask the user to enter an integer for how many dogs to print
    System.out.println("How many dogs would you like to print?");
    int numDogs = scan.nextInt();
    //print the dogs
    for (int i = 0; i < numDogs; i++) {
        System.out.println(dogArray[i].toString());
    }


    //create an array of dog weights
    int[] weightArray = new int[10];
    for (int i = 0; i < weightArray.length; i++) {
        weightArray[i] = dogArray[i].getWeight();
    }
    //print the array of dog weights 
    System.out.println("Array of dog weights before sorting:");
    // for (int i = 0; i < weightArray.length; i++) {
    //     System.out.print(weightArray[i] + ", ");
    // }
    System.out.println(arrayToString(weightArray));

    long startTime = System.nanoTime();
    //sort the array of dog weights using the selection sort 
    SortAndSearch.selectionSort(weightArray);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Selection sort took " + (duration / 1.e6) + " milliseconds");

    //print the sorted array of dog weights
    System.out.println("\nSorted array of dog weights:");
    System.out.println(arrayToString(weightArray));



    //Shuffle the array for the next test
    shuffle(weightArray);
    //sort the array using quicksort
    startTime = System.nanoTime();
    SortAndSearch.quickSort(weightArray);
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("Quick sort took " + (duration / 1.e6) + " milliseconds");

    shuffle(weightArray);
    // use linear search to find a random value 
    int target = rand.nextInt(1, 150);
    startTime = System.nanoTime();
    int index = SortAndSearch.linearSearch(weightArray, target);
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("Linear search took " + (duration / 1.e6) + " milliseconds");

}

// Create a method that takes an array as an input and returns it as
// a string on one line with commas between each element. This method will
// utilize a StringBuilder object to build the string.
public static String arrayToString(int[] array) {
    // Create a StringBuilder object
    StringBuilder sb = new StringBuilder();
    // Loop over all elements in the array
    for (int i = 0; i < array.length; i++) {
        // Append the current element to the StringBuilder object
        sb.append(array[i]);
        // If the current element is not the last element
        if (i < array.length - 1) {
            // Append a comma and a space to the StringBuilder object
            sb.append(", ");
        }

    }
    // Return the StringBuilder object as a string
    return sb.toString();
}

public static void shuffle(int[] array) {
    // Loop over all elements in the array
    for (int i = 0; i < array.length; i++) {
        // Generate a random index between 0 and array.length - 1
        int randomIndex = (int) (Math.random() * array.length);
        // Swap the current element with the random element
        swap(array, i, randomIndex);
    }
}

// Add a static method to swap two elements in an array
public static void swap(int[] array, int i, int j) {
    // Store the value of the first element in a temporary variable
    int temp = array[i];
    // Set the value of the first element to the value of the second element
    array[i] = array[j];
    // Set the value of the second element to the value of the temporary variable
    array[j] = temp;
}

}