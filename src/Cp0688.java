// https://leetcode.com/problems/knight-probability-in-chessboard/

import java.util.HashMap;
import java.util.Map;

public class Cp0688 {

    public static void main(String args[]) {
        double result = knightProbability(8, 30, 6, 4);
        System.out.println(result);
    }

    private static int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    // Main idea: dfs with memorization.
    // Time: O(N*N*K).
    // Space: O(N*N*K).
    public static double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        return find(N,K,r,c, dp);
    }
    private static double find(int N,int K,int r,int c, double[][][] dp){
        if(r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if(K == 0)  return 1;
        if(dp[r][c][K] != 0) return dp[r][c][K];
        double rate = 0;
        for(int i = 0;i < moves.length;i++)   rate += 0.125 * find(N,K - 1,r + moves[i][0],c + moves[i][1], dp);
        dp[r][c][K] = rate;
        return rate;
    }

    /*public static double knightProbability(int N, int K, int r, int c) {
        Map<String, Double> map = new HashMap<>();
        return helper(N, K, r, c, 1, map);
    }

    private static double helper(int N, int K, int r, int c, double denominator, Map<String, Double> map) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        String key = "" + K + "#" + r + "#" + c;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (K == 0) {
            return 1.0 / denominator;
        }
        double probability = 0;
        for (int[] move : moves) {
            probability += helper(N, K - 1, r + move[0], c + move[1], denominator * 8, map);
        }
        map.put(key, probability);
        return probability;
    }*/

}
