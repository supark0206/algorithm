package etc;

import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxLength = sc.nextInt();
        String str = sc.next();

        char[] chr = str.toCharArray();
        int result = 0;

        for(int i = 0; i<maxLength; i++){
            result += chr[i];
        }

        System.out.println(result);

    }
}