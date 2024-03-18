package oy.tol.tra;
public class Algorithms {
    public static <T> void reverse(T [] array){
        /* TODO:
         1. Edit the test data files to see if the reverse() really works or not.
         2. Execute the IntArrayTests to see that some of them fail.
         3. Study the code below and try to find what is the issue.
         4. Use the debugger to see the execution and variable values if necessary.
         5. Fix the issue.
         6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java, as instructed in the readme file.
        */
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
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
}
