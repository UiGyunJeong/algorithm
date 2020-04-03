package com.uig.hackerrank.algorithm.lilys_homework;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {	
	
	// Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
    	
    	Integer[] origin1 = converter(arr);
    	Integer[] origin2 = Arrays.copyOf(origin1, origin1.length);
    	
    	Arrays.sort(origin1);
        Arrays.sort(origin2, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
        
        
        return Math.min(getSwapCount(Arrays.copyOf(arr, arr.length), origin1) , getSwapCount(Arrays.copyOf(arr, arr.length), origin2));
    }
    
    private static Integer[] converter(int[] arr) {
    	Integer[] result = new Integer[arr.length];
    	for(int i = 0; i < arr.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;
    }

    
    private static int getSwapCount(int[] arr, Integer[] sorted) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        
        int swapCount = 0;
        for(int i = 0; i < arr.length; i++) {
            //앞에서부터 index가 맞는지 확인한다.
        	if(sorted[i] != arr[i]) {
        		int moveIndex = indexMap.get(sorted[i]);
                int temp = arr[i];
                arr[i] = arr[moveIndex];
                arr[moveIndex] = temp;
                indexMap.replace(arr[moveIndex], moveIndex);
                indexMap.replace(arr[i], i);
                swapCount++;
                
            }
        }
        return swapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        int result = lilysHomework(new int[] {3, 4, 2, 5, 1});

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
