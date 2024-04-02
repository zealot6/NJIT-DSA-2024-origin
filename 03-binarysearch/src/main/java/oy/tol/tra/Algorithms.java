package oy.tol.tra;

import java.util.Arrays;

public  class Algorithms{
    public static int  binarySearch2(int aValue,Integer[]arr,int from,int toIndex)
    {
      if(from<=toIndex)
      {
        int mid=from+(toIndex-from)/2;
        if(arr[mid]<aValue)
        {
            return binarySearch(aValue, arr, mid+1, toIndex);
        }
        else if(arr[mid]==aValue)
        {
            return mid;
        }
        else{
            return binarySearch(aValue, arr, from, mid-1);
        }
      }    
      return -1;      
    }
   
    public static <T extends Comparable<T>> int binarySearch(T target, T[] arr, int from, int toIndex) {
        if (from <= toIndex) {
            int mid = from + (toIndex - from) / 2;
    
            int compareResult =  arr[mid].compareTo(target);
            
            if (compareResult < 0) {
                return binarySearch(target, arr, mid + 1, toIndex);
            } else if (compareResult == 0) {
                return mid; 
            } else {
                return binarySearch(target, arr, from, mid - 1);
            }
        }
        
        return -1;
    }
    
    
    public static  <T extends Comparable<T>> void fastSort(T[]arr)
    {
        QuickSort(arr, 0, arr.length-1);
    }
   
    public static <T extends Comparable<T>> void sort(T [] array) {
        if (array == null ||array.length <= 1) {
            return;
        }
  
        for (int i = 1; i < array.length; i++) {
            T score = array[i];
            int j = i - 1;
  
            while (j >= 0 && array[j].compareTo(score)>0 ) {
                array[j + 1] = array[j];
                j--;
            }
  
            array[j + 1] = score;
        }
    }
    


    private static <T extends Comparable<T>>  void QuickSort(T[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            QuickSort(arr, left, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>>  int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if  (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static <T extends Comparable<T>>  void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  }
