package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import static slidingwindow.BlobYum.sum;
/*

문제
크기 N인 정수형 배열 X가 있을 때, X의 부분 배열(X의 연속한 일부분) 중 각 원소의 합이 가장 큰 부분 배열을 찾는 Maximum subarray problem(최대 부분배열 문제)은 컴퓨터 과학에서 매우 잘 알려져 있다.

여러분은 N과 배열 X가 주어졌을 때, X의 maximum subarray의 합을 구하자. 즉, max1 ≤ i ≤  j ≤ N (X[i]+...+X[j])를 구하자.

입력
입력 파일의 첫 번째 줄에 테스트 케이스의 수를 의미하는 자연수 T가 주어진다. 그 다음에는 T개의 테스트 케이스가 주어진다.

각 테스트케이스 별로 첫 번째 줄에 배열의 크기 N이 주어진다. (1 ≤ N ≤ 1,000)

그리고 두 번째 줄에 배열 X의 내용을 나타내는 N개의 정수가 공백으로 구분되어 주어진다. 이때 주어지는 수는 절댓값이 1,000보다 작은 정수이다.

출력
각 테스트케이스 별로 maximum subarray의 합을 줄로 구분하여 출력한다.
15
4
 */

public class MaximumSubarray {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int max = Integer.MIN_VALUE;
            int N = sc.nextInt();
            int current = 0;

            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                current = Math.max(num, current + num);
                max = Math.max(max, current);
            }

            System.out.println(max);
        }


    }
}