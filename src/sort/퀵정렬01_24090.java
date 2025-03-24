package sort;

import java.util.Scanner;

/*
오늘도 서준이는 퀵 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 퀵 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.

크기가 N인 배열에 대한 퀵 정렬 의사 코드는 다음과 같다.

quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- partition(A, p, r);  # 분할
        quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
        quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
    }
}

partition(A[], p, r) {
    x <- A[r];    # 기준원소
    i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
    for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
        if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
    if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
    return i + 1;
}

출력
K 번째 교환되는 두 개의 수를 작은 수부터 한 줄에 출력한다. 교환 횟수가 K 보다 작으면 -1을 출력한다.
 */


public class 퀵정렬01_24090 {
    static int count = 0;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 크기 N, 저장 횟수 K
        int N = sc.nextInt();
        K = sc.nextInt();


        // 배열 A 입력 받기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        quick_sort(A, 0, N-1);

        if(count<K){
            System.out.println(-1);
        }
    }

    public static void quick_sort(int[] A, int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quick_sort(A, p, q - 1);  //왼쪽 부분 배열 정렬
            quick_sort(A, q + 1, r);  //오른쪽 부분 배열 정렬
        }
    }

    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for (int j = p; j < r; ++j) { // <= r-1까지 반복해야 함
            if (A[j] <= x) {
                i++;
                swap(A, i, j); // 교환 수행
            }
        }

        if (i + 1 != r) { // 피벗 위치 조정
            swap(A, i + 1, r);
        }

        return i+1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

        count++; // 교환 횟수 증가
        if (count == K) {
            System.out.println(Math.min(A[i], A[j]) + " " + Math.max(A[i], A[j]));
        }
    }
}