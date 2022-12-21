package com.practice.google;

public class MergeSort {

  public void mergeSort(int[] array) {
      int[] aux = new int[array.length];
      sort(array, aux, 0, array.length-1);
  }
  
  public void sort(int[] a, int[] aux, int hi, int lo) {
  
    int mid = lo + (hi-lo)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    merge(a, aux, lo, hi, mid);
  }
  
  
  public void merge(int[] a, int[] aux, int lo, int hi, int mid) {
   
    for(int i = 0; i < hi; i++) {
      aux[i] = a[i];
    }
    
    int i = lo; 
    int j = mid + 1;
    
    for(int k = lo; k < a.length; k++) {
      // If left sorted array is exhausted copy elements from right array  
      if(i > mid) {
        a[k] = aux[j];
        j++;
      }// If right sorted array is exhausted copy elements from left array  
      else if(j > hi) {
        a[k] = aux[i];
        i++;
      } //compare actual elements 
      else if(aux[i] < aux[j]) {
        a[k] = aux[i];
        i++;
      } else {
        a[k] = aux[j];
        j++;
      }
    }
    
    
  }
  
}
