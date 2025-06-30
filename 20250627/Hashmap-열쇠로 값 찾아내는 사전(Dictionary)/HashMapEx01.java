package com.listex;

import java.util.*;

public class HashMapEx01 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("만화", "마녀딸배키키");
		map.put("호러", "스크림");
		map.put("영화", "황혼에서 새벽까지");
	
		System.out.println(map);
		// System.out.println(map);
	
		String key;
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			key = it.next();
			System.out.println(map.get(key));
		}
		System.out.println();
	
		map.put("영화","달마야 놀자~~");
		System.out.println(map);
	
	}

}
