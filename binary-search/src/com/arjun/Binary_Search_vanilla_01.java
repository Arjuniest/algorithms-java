package com.arjun;


import java.util.Scanner;

/*
IMP: Here we are assuming that the array is strictly sorted in ascending order.
 */

/*
Takes input of the target from the user and prints its index number.
 */

public class Binary_Search_vanilla {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {12,34,56,78,98,776,3562,3598};
        System.out.print("Enter the target: ");
        int target = in.nextInt();
        int ans = binarysearch(arr, target);
        System.out.println("The target is found in index no. : " + ans);
    }

    //return the index when target is found
    //return -1 when the target is not found
    static int binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            /*
            Finding the middle element:
            it is possible that (start + end) / 2 exceeds the range of integers in Java so the below formula is used.
             */
            int mid = start + (end - start) / 2;
            if (target == arr[mid]){
                return mid;
            }
            if (target > arr[mid]){
                start = mid + 1;
            }
            if (target < arr[mid]){
                end = mid - 1;
            }
        }
        return -1; //target not found
    }
}
