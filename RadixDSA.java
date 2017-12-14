/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Yingjie(Chelsea) Wang
 */
import java.util.Arrays;

public class RadixDSA   {

   private String a[];
   private String workingSet[];
   private int nElems  = 0;
   private int size = 0, maxLen = 0;
   
   //declare the size of array
   public RadixDSA(int size)   {
      this.size = size;
      a = new String[size];
      workingSet = new String[size];
   }
   
   //adding elements into array
   public void push(int i) {
      //check whether input elements are larger than size
      if(nElems == size)   {
         System.out.println("****OVERFLOW****");
         return;
      }
      //a[nElems++] = Integer.toBinaryString(i);
      a[nElems++] = Integer.toString(i);
   }
   
   //display the array
   public void display()   {
      for (int i = 0; i < nElems; i++) {
         System.out.print(a[i] + " ");
      }
      System.out.printf("%n");
      System.out.println("****END****");
      return;
   }
   
   //display the array in dec order
   public void displayDec()   {
      for(int i = 0; i<nElems; i++) { 
         System.out.print(Integer.parseInt(a[i], 2) + " ");
      }
      System.out.println("****END****");
      return;
   }
   
   //display the working set
   public void displayWS() {
      for(int i = 0; i<nElems; i++) {
         System.out.print("Element " + i + ": " + workingSet[i] + "; ");
      }
      System.out.println("****END****");
   }
   
   //the base can be changed by putting in different base
   public void rSortO(int base)  {
         copy(a, workingSet);
         //copy(rSort(nElems, 0, workingSet), a);
         //rSort(0, nElems-1, 0);
         //copy(workingSet, a);
         int[] arr = new int[workingSet.length];
         for (int i = 0; i < workingSet.length; i++) {
        	 arr[i] = Integer.valueOf(workingSet[i]);
         }
         radixsort(arr, workingSet.length, base);
         for (int i = 0; i < workingSet.length; i++) {
        	 a[i] = String.valueOf(arr[i]);
         }      
   }

   private void copy(String[] from, String[] to)  {
      for(int j = 0; j < from.length; j++)   {
            to[j] = from[j];
      }
   }
   
   public void pad()   {
      //System.out.println("****" + maxLen + "'s****");
      for (int i = 0; i < nElems; i++) {
         a[i] = padLeft(a[i]);
      }
   }
   
   private String padLeft(String s) {
         Integer t = new Integer(maxLen);
         String q = "%0" + t.toString() + "d";
         return String.format(/*"%010d"*/q, Integer.parseInt(s));  
   }
   
   public void maxLen()   {
      for(int i = 0; i < nElems; i++)  {
         if(a[i].length() > maxLen) {
            maxLen = a[i].length();
         }
      }
   }

   // A utility function to get maximum value in arr[]
   static int getMax(int arr[], int n)
   {
       int max = arr[0];
       for (int i = 1; i < n; i++)
           if (arr[i] > max)
               max = arr[i];
       return max;
   }

   // A function to do counting sort of arr[] according to
   // the digit represented by exp.
   static void countSort(int arr[], int n, int exp, int base)
   {
       int output[] = new int[n]; // output array
       int i;
       int count[] = new int[base];
       Arrays.fill(count,0);

       //count of occurrences
       for (i = 0; i < n; i++)
           count[ (arr[i]/exp)%base ]++;

       //count[i] stores actual position of this digit
       for (i = 1; i < base; i++)
           count[i] += count[i - 1];

       // output array
       for (i = n - 1; i >= 0; i--)
       {
           output[count[ (arr[i]/exp)%base ] - 1] = arr[i];
           count[ (arr[i]/exp)%base ]--;
       }

       // Copy the output array to array
       for (i = 0; i < n; i++) {
           arr[i] = output[i];
           System.out.print(arr[i] + " ");
       }
       System.out.println();

   }

   //Using Radix Sort
   static void radixsort(int arr[], int n, int base)
   {
       //get maximum number of digits
       int m = getMax(arr, n);

       //count sort for every digit
       for (int exp = 1; m/exp > 0; exp *= base)
           countSort(arr, n, exp, base);
   }
}
