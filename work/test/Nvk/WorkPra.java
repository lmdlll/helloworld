package Nvk;

import java.util.Scanner;

/**
 * 小王工作和休息锻炼
 *  4
 *  1 0 1 0
 *  0 1 1 0
 *
 */
public class WorkPra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        helper(A, B, N);
    }

    public static void helper(int[] A, int[] B, int N) {
        int[] dpA = new int[N];
        int[] dpB = new int[N];
        dpA[0] = A[0];
        dpB[0] = B[0];
        for (int i = 1; i < N; i++) {
            if (A[i - 1] == 0) {
                dpA[i] = Math.max(dpA[i - 1], dpB[i - 1]) + A[i];
            } else {
                dpA[i] = dpB[i - 1] + A[i];
            }
            if (B[i - 1] == 0) {
                dpB[i] = Math.max(dpA[i - 1], dpB[i - 1]) + B[i];
            } else {
                dpB[i] = dpA[i - 1] + B[i];
            }
        }
        System.out.println(N - Math.max(dpA[N - 1], dpB[N - 1]));
    }
}
