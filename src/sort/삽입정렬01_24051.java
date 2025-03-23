package sort;

import java.io.IOException;
import java.util.Scanner;

/*
늘도 서준이는 삽입 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 삽입 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.

크기가 N인 배열에 대한 삽입 정렬 의사 코드는 다음과 같다.

insertion_sort(A[1..N]) { # A[1..N]을 오름차순 정렬한다.
    for i <- 2 to N {
        loc = i - 1;
        newItem = A[i];

        # 이 지점에서 A[1..i-1]은 이미 정렬되어 있는 상태
        while (1 <= loc and newItem < A[loc]) {
            A[loc + 1] <- A[loc];
            loc--;
        }
        if (loc + 1 != i) then A[loc + 1] = newItem;
    }
}
 */


public class 삽입정렬01_24051 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 크기 N, 저장 횟수 K
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 배열 A 입력 받기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 저장 횟수를 추적할 변수
        int count = 0;

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = A[i];

            while (loc >= 0 && newItem < A[loc]) {
                A[loc + 1] = A[loc];
                loc--;
                count++;
                if (count == K) {
                    System.out.println(A[loc + 1]);
                    return;
                }
            }

            if (loc + 1 != i) {
                A[loc + 1] = newItem;
                count++;
                if (count == K) {
                    System.out.println(A[loc + 1]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}