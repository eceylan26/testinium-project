package com.testinium.basic.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        if (line < 1) {
            System.out.println("Line can't be less than 1");
            System.exit(0);
        }

        /*System.out.println("  *  ");
        System.out.println(" *** ");
        System.out.println("*****");*/

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line; i++) {
            for(int j= 0;j<line-(i+1);j++){
                sb.append(" ");
                System.out.println("e");
            }

            for(int k=0;k<2*(i+1)-1;k++){
                sb.append("*");
                System.out.println("c");
            }

            for(int m= 0;m<line-(i+1);m++){
                sb.append(" ");
                System.out.println("e");
            }

            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}
