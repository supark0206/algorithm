package twopointer;

import java.util.Arrays;
import java.util.Scanner;
/*

심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다. 예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다. 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.



두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다. 둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000)

 */
import java.util.Arrays;
import java.util.Scanner;

public class 먹을것먹힐것_7795 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] merge = new int[N+M];

            for (int a = 0; a < N+M; a++) {
                merge[a] = sc.nextInt();
            }

            Arrays.sort(merge, 0, N);       // A 정렬
            Arrays.sort(merge, N, N + M);   // B 정렬
            int count = 0;
            int a = 0;
            int b = N;

            while(a<b){
                if(merge[a] > merge[b]){
                    count++;
                    if(b == N+M-1){
                        b = N;
                        a++;
                    } else {
                        b++;
                    }
                }else if(merge[a] <= merge[b]){
                    b = N;
                    a++;
                }
            }

            System.out.println(count);
        }
    }
}


/*
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            int bIndex = 0;

            for (int a = 0; a < N; a++) {
                while (bIndex < M && B[bIndex] < A[a]) {
                    bIndex++;
                }
                count += bIndex;
            }

            System.out.println(count);
        }
    }

 */