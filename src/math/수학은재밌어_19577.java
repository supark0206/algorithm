package math;

import java.io.IOException;
import java.util.Scanner;

/*
문제
오일러는 수학을 정말 좋아해서 하루 종일 수학 공부만 하는 수학쟁이이다.

어느 날 오일러는 수학 공부를 하기 위해서 수학 책을 읽고 있던 중에 오일러 피 함수에 대해서 설명하는 부분을 보게 되었다. 오일러 피 함수는 다음과 같이 설명이 되어 있었다.

오일러 피 함수란 φ(n)으로 표기하며 1부터 n까지의 양의 정수 중에서 n과 서로소인 수의 개수를 나타내는 함수이다.

예를 들면 φ(6)은 1부터 6까지의 수 중 6과 서로소인 수의 개수를 말하는데 이는 1과 5로 두 개가 있으므로 φ(6) = 2이다.

오일러는 책의 내용을 곰곰이 읽던 중 어떤 문제가 떠올랐다. 문제의 내용은 다음과 같다.

어떤 양의 정수 n이 있다고 할 때, xφ(x) = n을 만족하는 양의 정수 x가 존재하는가?

고민에 빠진 오일러를 본 당신은 오일러의 궁금증을 해결해주기 위해서 직접 문제를 풀기로 결심했다. 그러므로 당신은 xφ(x) = n을 만족하는 x를 구하는 프로그램을 작성하면 된다.

입력
첫 번째 줄에 n이 입력으로 주어진다. (1 ≤ n ≤ 109)

출력
xφ(x) = n을 만족하는 양의 정수 x가 존재하면 최소의 x를, 존재하지 않으면 −1을 출력한다.
 */

public class 수학은재밌어_19577 {
    static int sol(int x) {
        int result = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                while (x % i == 0) {
                    x /= i;
                }
                result -= result / i;
            }
        }
        if (x > 1) {
            result -= result / x;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = -1;

        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                if ((long)d * sol(d) == n) {
                    if (answer == -1 || d < answer) {
                        answer = d;
                    }
                }
                int other = n / d;
                if ((long)other * sol(other) == n) {
                    if (answer == -1 || other < answer) {
                        answer = other;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
