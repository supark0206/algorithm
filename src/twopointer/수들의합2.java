package twopointer;

import java.util.Arrays;
import java.util.Scanner;

/*
문제
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.
 */

public class 수들의합2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        int[] A = new int[n+1];
        for(int i = 1; i<=n; i++){
            A[i] = A[i-1] + sc.nextInt();
        }

        int count = 0;
        int start = 0;
        int end = 1;
        while(end <= n){
            int sum = A[end] - A[start]; // 부분합 계산
            if(sum == m){
                count++;
                start++;
            } else if (sum > m){
                start++;
            } else {
                end++; // 합이 작으면 end 증가하여 확장
            }
        }

        System.out.println(count);

    }
}