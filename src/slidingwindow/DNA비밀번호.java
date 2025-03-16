package slidingwindow;

import java.util.Scanner;

public class DNA비밀번호 {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        char[] A = new char[5];
        myArr = new int[4];
        checkArr = new int[4];
        checkSecret = 0;
        int result = 0;

        A = sc.nextLine().toCharArray();
        for(int i=0; i<4; i++){
            checkArr[i] = sc.nextInt();
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        for(int i=0; i<P; i++){
            Add(A[i]);
        }

        if(checkSecret == 4) result++;

        for(int i=P; i<S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) result++;
        }

        System.out.println(result);
    }

    public static void Add(char c){
        switch(c){
            case 'A' :
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
        }
    }

    public static void Remove(char c){
        switch(c){
            case 'A' :
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
            case 'C' :
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
            case 'G' :
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
            case 'T' :
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
        }
    }
}
