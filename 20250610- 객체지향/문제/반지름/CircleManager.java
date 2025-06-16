package com.functionex;

import java.util.Scanner;

public class CircleManager {

	 public static void main(String[] args){
		 
		  Scanner sc = new Scanner(System.in);
		  Circle c[] = new Circle[3]; 
				  
		  for(int i = 0; i < c.length; i++){
		  System.out.print("x, y, radius >> ");
		  
		  System.out.print("x값 입력");
		  double x = sc.nextDouble();
		  
		  System.out.print("y값 입력");
		  double y = sc.nextDouble();
		  
		  System.out.print("반지름 입력");
		  int radius = sc.nextInt();
		  
		  c[i] = new Circle(x, y, radius);     // Circle 객체 생성
		  }		  
		  for(int i = 0; i < c.length; i++)
			 c[i].show();
		  }
	}


