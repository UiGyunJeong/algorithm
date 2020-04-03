package com.uig.hackerrank.algorithm.the_full_counting_sort;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.math.*;
import java.nio.file.FileSystems;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	static StringBuilder[] list = new StringBuilder[100];

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
    	
    	for(int i = 0; i < arr.size(); i++) {
    		
    		int index = Integer.valueOf(arr.get(i).get(0));
    		if(null == list[index]) {
    			list[index] = new StringBuilder();
    		}
    		
    		if(i < arr.size() / 2)
    			list[index].append("- ");
    		else
    			list[index].append(arr.get(i).get(1) + " ");
    	}
    	
  
    	

//    	Collections.sort(arr, new Comparator<List<String>>() {
//
//			@Override
//			public int compare(List<String> o1, List<String> o2) {
//				if (Integer.valueOf(o1.get(0)) > Integer.valueOf(o2.get(0)))
//					return 1;
//				else if (Integer.valueOf(o1.get(0)) == Integer.valueOf(o2.get(0)))
//					return 0;
//				return -1;
//			}
//        	
//        	
//		});
    	
    	for (StringBuilder stb : list) {
    		if(stb == null) continue;
    		System.out.print(stb.toString());
		}


    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Solution.class.getResource("case1.txt").getFile()));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        countSort(arr);

        bufferedReader.close();
    }
}
