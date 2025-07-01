package com.listex;

import java.util.Map;
import java.util.TreeMap;

/* TreeMap
  - 정렬된 상태로 데이터가 추가된다.
  - sortedMap<K,V> subMap(K fromKey, K toKey)메소드 
  맵의 fromKey(키를 포함하고) ~toKey(키를 포함하지 않음)의 
  키의 범위를 가지는 부분을 리턴한다. 
 */
 


public class TreeMapEx01 {

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("만화", "마녀배달부키키");
		map.put("호러", "스크림");
		map.put("영화", "황혼에서 새벽까지");
		map.put("방화", "쉬리");
		map.put("TV", "X-Files");
		// System.out.println(map);
		
		Map<String, String> subMap = map.subMap("방화", "호러");
		System.out.println(subMap);
	}

}
