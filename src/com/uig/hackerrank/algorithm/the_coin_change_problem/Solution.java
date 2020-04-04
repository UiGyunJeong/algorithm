package com.uig.hackerrank.algorithm.the_coin_change_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
    public static long getWays(int n, List<Long> c) {
    	long[] count = new long[n+1];  // 0���� n���� ����� ����� ���� ���⿡ �����Ѵ�.
    	count[0] = 1;  // �ʱⰪ�� 1�� ��ƾ� �Ʒ� for������ ù��° ��ó���� ���� ���ص� �ȴ�.
    	
    	for(int i = 0; i < c.size(); i++) {  // ù��° ���κ��� ������ ���α���
    		for(long j = c.get(i); j <= n; j++) {  // ���ΰ����� n������ ����� ���� update�ϱ� ���� loop 
    			count[(int) j] += count[(int) (j-c.get(i))];  // j������ ����� ���� j-coin�� ������ ����� ���ڿ� ����.
    		}
    	}
    	return count[n];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> c = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cTemp[i]);
            c.add(cItem);
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);
        System.out.println(ways);
//        bufferedWriter.write(String.valueOf(ways));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
