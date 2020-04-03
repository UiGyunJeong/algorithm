package com.uig.hackerrank.algorithm.fraudulent_activity_notifications;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	
    	int notiCount = 0;
    	int[] count = new int[200];
    	
    	for(int i = 0; i < d-1; i++) {
    		count[expenditure[i]]++;
    	}
    	
    	
        for(int i = d-1; i < expenditure.length-1; i++) {
        	count[expenditure[i]]++;
        	
            // d전일의 array를 넘겨서 중간 값을 받아온다.
            double median = getMedian(count, d);
            if(median * 2 <= expenditure[i+1]) notiCount++;
            
            count[expenditure[i-d+1]]--;
        }

        return notiCount;

    }
    
    
    private static double getMedian(int[] count, int d) {
    	
    	if(d % 2 == 0) {
    		int sum = 0;
    		int first = 0;
    		int second = 0;
    		for(int i = 0; i < count.length; i++) {
    			sum += count[i];
    			if(sum >= d/2 && first == 0) {
    				first = i;
    			}
    			if(sum >= d/2 + 1) {
    				second = i;
    				return ((double)first + second) / 2; 
    			}
    		}
    	}else {
    		int sum = 0;
    		for(int i = 0; i < count.length; i++) {
    			sum += count[i];
    			if(sum >= d/2 + 1) {
    				return i;
    			}
    				
    		}
    	}
		return 0;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
