package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        StringBuffer bf = new StringBuffer();
        boolean result = true;

        for(int i=0; i<A.length; i++){
            int su = A[i];

            if(su >= num){
                while(su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("+\n");
            }else{
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else {
                    bf.append("-\n");
                }
            }
        }

        if(result) {
            System.out.println(bf);
        }
    }
}