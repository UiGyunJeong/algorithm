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
    	long[] count = new long[n+1];  // 0부터 n까지 만드는 방법의 수를 여기에 저장한다.
    	count[0] = 1;  // 초기값을 1로 잡아야 아래 for문에서 첫번째 값처리를 따로 안해도 된다.
    	
    	for(int i = 0; i < c.size(); i++) {  // 첫번째 코인부터 마지막 코인까지
    		for(long j = c.get(i); j <= n; j++) {  // 코인값부터 n값까지 방법의 수를 update하기 위한 loop 
    			count[(int) j] += count[(int) (j-c.get(i))];  // j값까지 방법의 수는 j-coin의 값까지 방법의 숫자와 같다.
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
