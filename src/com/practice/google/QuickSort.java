package com.practice.google;

public class QuickSort {

  public void sort(int[] a) {
    // Shuffle the array to get probabilistic good performance
    StdRandom.shuffle(a);    
    sort(a, 0, a.length - 1);
  }
  
  public void sort(int[] a, int lo, int hi) {
    if(hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }
  
  public int partition(int[] a, int lo, int hi) {
    //place the first item lo such that all smaller elements are to the left and greater elements are to the right
    int i = lo + 1;
    int j = hi;
    
    while(true) {
      
      while(a[i] < a[lo]) {
        i++;
        if(i == hi) {
          break;
        }
      }
      
      while(a[j] > a[lo]) {
        j--;
        if(j == lo) {
          break;
        }
      }
      
      if(i > j) {
        break;
      }
      
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    
    }
    int temp = a[j];
    a[j] = lo;
    lo = temp;
    return j;
  }

}
