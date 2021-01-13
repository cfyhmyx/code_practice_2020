// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

public class Cp0801 {

    public static void main(String args[]) {
        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};
        int result = minSwap(A, B);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(n).
    public static int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[1000];
        int[] not_swap = new int[1000];
        swap[0] = 1;
        for (int i = 1; i < N; ++i) {
            not_swap[i] = swap[i] = N;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                not_swap[i] = not_swap[i - 1];
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);
                not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[N - 1], not_swap[N - 1]);
    }
}
