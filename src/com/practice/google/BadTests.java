package com.practice.google;

/*

"We have a suite of tests that pass when run individually, but fail when run together. Specifically, there are two tests that cannot be run together. 
We are given an 'oracle' function that can tell us whether a set of tests pass or fail when run together in constant time. 
We need to write a function to find the 'bad pair'"

Helper function:

boolean doFail(Set<Integer> testNumbers);
Function to implement:

// signature can be anything that returns the two bad tests (pair, array of size 2, list of size two, helper object .. etc)
// input could also be an array, set, or list - that part wasn't too important
int[] badTests(List<Integer> testNumbers);

*/

public class BadTests{

  
  // brute force
  public int[] badTests(int[] testNumbers) {
    
    for(int i=0; i<testNumbers.length; i++) {
      for(int j=i+1; j< testNumbers.length;j++) {
        if(doFail(new HashSet<>(List.of(testNumbers[i], testNumbers[j])) {
          return new int[]{testNumbers[i], testNumbers[j]};
        }
      }
    }
  }
  
  
}
