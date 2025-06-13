package com.test;

/* 문2] 사칙연산자를 입력받아 계산하는 프로그램을 구현하시오.
연산자는 +, -, *, / 네가지로 하고, 피연산자는 모두 실수로 함
    
0으로 나누기 연산시에는 -> 0으로 나눌수 없습니다.를 출력하라.
*/

import java.util.*;

public class HomeWork02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double num1, num2;

		char cal;

	System.out.print("첫번째 수 입력: ");
	num1 = sc.nextDouble();
	
	System.out.print("연산기호 입력(+, -, *, /): ");
	cal = sc.next().charAt(0);
	
	System.out.print("두번째수 입력:");
	num2 = sc.nextDouble();
	
	switch (cal) {
	case '+':
		System.out.printf("%.2f + %.2f = %.2f", num1, num2, num1 + num2);
		break;
	case '-':
		System.out.printf("%.2f - %.2f = %.2f", num1, num2, num1 - num2);
		break;
	case '*':
		System.out.printf("%.2f * %.2f= %.2f", num1, num2, num1 * num2);
		break;
	case '/':
		if (num2 == 0) {
			System.out.println("0으로 나눌수 없습니다 ");
		}
		else {
			System.out.printf("%.2f / %.2f = %.2f", num1, num2, num1/num2);
		}
		break;
	default: 
		System.out.println("잘못되었습니다.");
		}
	}
}

/* 답안] if문 활용

  Scanner sc = new Scanner(System.in);

        double a, b, res = 0;
        String op;

        System.out.print("첫번째 정수: ");
        a = sc.nextDouble();

        System.out.print("연산자 입력: ");
        op = sc.next();

        System.out.print("두번째 정수: ");
        b = sc.nextDouble();

        // 연산자 조건 처리
        if (op.equals("+")) {   // op.equals- 내용을 비교하는 함수  
            res = a + b;
        } else if (op.equals("-")) {
            res = a - b;
        } else if (op.equals("*")) {
            res = a * b;
        } else if (op.equals("/")) {
            if (b == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                return;
            }
            res = a / b;
        } else {
            System.out.println("연산자가 아닙니다.");
            return;
        }

        System.out.printf("%.2f %s %.2f = %.2f%n", a, op, b, res);
    }
}

 	
답안] switch문 활용

        Scanner sc = new Scanner(System.in);

        double a, b, res = 0;
        String op;

        System.out.print("첫번째 정수: ");
        a = sc.nextDouble();

        System.out.print("연산자 입력 (+, -, *, /): ");
        op = sc.next();

        System.out.print("두번째 정수: ");
        b = sc.nextDouble();

        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                } else {
                    res = a / b;
                }
                break;
            default:
                System.out.println("연산자가 아닙니다.");
                return;
        }
 System.out.printf("%.2f %s %.2f = %.2f%n", a, op, b, res);
    }
}

*/
