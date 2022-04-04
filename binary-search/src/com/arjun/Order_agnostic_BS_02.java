/*
In the previous example we considered that the array was sorted in ascending order.
In this example it will not matter if the array is in ascending or descending order.
but still *sorted!*
 */

package com.arjun;

import java.util.Scanner;

public class Order_agnostic_BS_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = {1, 2, 3, 4, 5, 44, 333, 444}; //ascending order
        int[] arr2 = {455, 76, 56, 45, 34, 23};  //descending order
        System.out.print("Enter the target element: ");
        int target = in.nextInt();
        int ans = order_agnostic_binarysearch(arr2, target);
        System.out.println("The index for the target is: " + ans);
    }
    static int order_agnostic_binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(arr[start] == arr[end]){
            return -1; //when all the elements of the array is same
        }
        /*
        Checking whether the array is sorted in ascending or descending order.
         */
        if(arr[start] < arr[end]){
            return ascending_bs(arr, target);
        } else {
            return descending_bs(arr, target);
        }
    }
    //applying binary search for ascending order.
    static int ascending_bs(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid + 1;
            }
            if(arr[mid] > target){
                end = mid - 1;
            }
        }
        return -1; //target not found
    }
    //applying binary search for descending order.
    static int descending_bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                end = mid - 1;
            }
            if (target < arr[mid]) {
                start = mid + 1;
            }
        }
        return -1; //target not found.
    }
}
