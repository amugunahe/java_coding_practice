package com.listex;

import java.util.*;

public class VectorEx02 {

	private static final String colors[] = { "검정", "노랑", "녹색", "파랑", "주황", "연두" };

	public static void main(String[] args) {

		Vector<String> v = new Vector<>();

		for (String str : colors) {
			v.add(str);
		}
		System.out.println(v);
		System.out.println("요소 개수: " + v.size());
		System.out.println();
		System.out.println("첫번째 요소: " + v.firstElement());
		System.out.println("네번째 요소: " + v.get(3));
		System.out.println("마지막 요소: " + v.lastElement());

		// 첫번째 요소를 "흰색"으로 변경
		v.set(0, "흰색");
		System.out.println("첫번째 요소: " + v.firstElement());
		System.out.println("요소 개수: " + v.size());

		// 첫번째 요소에 빨강 추가
		v.insertElementAt("빨강", 0);
		System.out.println("첫번째 요소: " + v.firstElement());
		System.out.println("요소 개수: " + v.size());

		// 전체 출력
		System.out.println("\n 전체 출력");
		for (String str : v) {
			System.out.print(str + " ");
		}
		System.out.println();

		// 오름차순 정령
		Collections.sort(v);
		System.out.println("\n오름차순 정렬후 출력");
		for (String str : v) {
			System.out.print(str + " ");
		}
		System.out.println();

		// 검색: 오름차순 정렬된 자료에서만 검색을 할 수 있음
		int index = Collections.binarySearch(v, "보라");

		// 검색하고자 하는 자료가 없을 경우 음수 출력
		System.out.println("\n보라: " + index + "에 위치");

		// 내림 차순 정렬
		Collections.sort(v, Collections.reverseOrder());
		System.out.println("\n내림차순 정렬후 출력");
		for (String str : v) {
			System.out.print(str + " ");
		}
		System.out.println();

		// 내림 차순 검색
		index = Collections.binarySearch(v, "파랑", Collections.reverseOrder());
		System.out.println("\n파랑: " + index + "에 위치");

		// 검색
		String s = "노랑";
		if (v.contains(s)) {
			int i = v.indexOf(s) + 1;
			System.out.println(s + "--> 위치:" + i);
		}
		// 삭제
		v.remove(0);
		v.remove("파랑");
	}
}
