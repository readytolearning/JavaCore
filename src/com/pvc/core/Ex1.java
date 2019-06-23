package com.pvc.core;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int  a , b , c;
        System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        a =scanner.nextInt();
        String st = scanner.next();
        char st1 = scanner.next().charAt(0);
        System.out.println(st);
        switch (st){
            case "+" : System.out.println("Hello + ");
                        break;
            case "-" : System.out.println("Hello - ");
                        break;
        }
        switch (st1){
            case '+' : System.out.println("Hello + ");
                break;
            case '-' : System.out.println("Hello - ");
                break;

        }

    }
}
