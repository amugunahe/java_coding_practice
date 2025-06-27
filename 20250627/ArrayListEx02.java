package com.listex;

import java.util.*;

public class ArrayListEx02 {

	public static void main(String[] args) {

		final int LIMIT = 10;

		int[] arr = { 1, 2, 3, 4, 5 };
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int len1 = source.length();
		int len2 = arr.length;

		// System.out.println(length);

		List list = new ArrayList(length / LIMIT + 10);
		System.out.println(list.size());

		for (int i = 0; i < length; i += LIMIT) {

			if (i + LIMIT < length) {
				list.add(source.substring(i, i + LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}

		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
