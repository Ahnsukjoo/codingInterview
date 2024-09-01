package array;

import java.util.*;

public class 행렬의_곱셈 {

    public static void main(String[] args) {
        testMatrixMultiplication(100);
        System.out.println("\n큰 행렬에 대한 테스트를 시작합니다. 시간이 오래 걸릴 수 있습니다...\n");
        testMatrixMultiplication(1000);
    }

    public static void testMatrixMultiplication(int size) {
        System.out.println(size + "x" + size + " 크기 행렬에 대한 테스트");
        int[][] arr1 = new int[size][size];
        int[][] arr2 = new int[size][size];

        // 행렬 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr1[i][j] = (int) (Math.random() * 3) + 1;
                arr2[i][j] = (int) (Math.random() * 3) + 1;
            }
        }

        // solution1 실행 및 시간 측정
        long startTime1 = System.currentTimeMillis();
        solution1Improved(arr1, arr2);
        long finishTime1 = System.currentTimeMillis();
        double executionTime1 = (finishTime1 - startTime1) / 1000.0;
        System.out.println("solution1 실행 시간: " + executionTime1 + "초");

        // solution2 실행 및 시간 측정
        long startTime2 = System.currentTimeMillis();
        solution2(arr1, arr2);
        long finishTime2 = System.currentTimeMillis();
        double executionTime2 = (finishTime2 - startTime2) / 1000.0;
        System.out.println("solution2 실행 시간: " + executionTime2 + "초");

        // 실행 시간 비교
        if (executionTime1 > executionTime2) {
            System.out.println("solution1이 solution2보다 " +
                String.format("%.2f", executionTime1 / executionTime2) + "배 더 걸립니다.");
        } else {
            System.out.println("solution2가 solution1보다 " +
                String.format("%.2f", executionTime2 / executionTime1) + "배 더 걸립니다.");
        }
    }

    public static int[][] solution1Improved(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int[][] answer = new int[N][N];
        int blockSize = 64; // 캐시 크기에 따라 조정 가능

        for (int i = 0; i < N; i += blockSize) {
            for (int j = 0; j < N; j += blockSize) {
                for (int k = 0; k < N; k++) {
                    for (int ii = i; ii < Math.min(i + blockSize, N); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, N); jj++) {
                            answer[ii][jj] += arr1[ii][k] * arr2[k][jj];
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < answer.length * answer[0].length; j++) {
                answer[j / answer[0].length][j % arr2[0].length] +=
                    arr1[j / arr2[0].length][i] * arr2[i][j % arr2[0].length];
            }
        }
        return answer;
    }

    public static int[][] solution2(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;
        int[][] answer = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}