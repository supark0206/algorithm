package math;

import java.util.Scanner;


/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
public class 소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        for(int i=M; i<=N; i++){
            int a = i;

            for(int j=i; j<=N; j++){

                if(a != j){
                    if(j / a == 1 && j % a == 0){
                        System.out.println(j);
                    }
                }
            }
        }

    }
}