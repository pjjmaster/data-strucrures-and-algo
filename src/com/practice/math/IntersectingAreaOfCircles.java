package com.practice.math;

import java.util.Scanner;

public class IntersectingAreaOfCircles {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		double rr0 = r1 * r1;
		double rr1 = r2 * r2;
		double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		System.out.println(d);
		double part1 = r1 * r1 * Math.acos((d * d + r1 * r1 - r2 * r2) / 2 * d * r1);
		double part2 = r2 * r2 * Math.acos((d * d + r2 * r2 - r1 * r1) / 2 * d * r2);
		double part3 = 0.5 * Math.sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2));

		double inter = part1 + part2 + part3;

		System.out.println(inter);
		if (d > r1 + r2)
		  {
		    System.out.println("do not intersect");
		  }
		double phi = (Math.acos((rr0 + (d * d) - rr1) / (2 * r1 * d))) * 2;
		double theta = (Math.acos((rr1 + (d * d) - rr0) / (2 * r2 * d))) * 2;
		double area1 = 0.5 * theta * rr1 - 0.5 * rr1 * Math.sin(theta);
		double area2 = 0.5 * phi * rr0 - 0.5 * rr0 * Math.sin(phi);
		System.out.println(area1 + area2);

		sc.close();

	}

}
