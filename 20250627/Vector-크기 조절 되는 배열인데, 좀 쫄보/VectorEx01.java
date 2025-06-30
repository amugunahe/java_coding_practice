package com.listex;

import java.util.*;

public class VectorEx01 {

	public static void main(String[] args) {
		// Vector 객체를 생성하는데, 처음 용량(capacity)을 5로 잡는다는 뜻이다.
		// 즉, 처음부터 5개의 요소를 저장할 공간을 확보하는 거지.
		// 참고로 <E> 제네릭 안 썼는데, 요즘은 Vector<String> v = new Vector<>(5); 처럼
		// 어떤 타입 넣을 건지 명확히 해주는 게 좋다. 안 그럼 경고 뜬다.
		Vector<String> v = new Vector<>(5); // 용량이 5인 vector 생성  

		// 요소 3개를 추가한다. 현재 size는 3이 된다. capacity는 여전히 5다.
		v.add("1");
		v.add("2");
		v.add("3");
		print(v); // 현재 Vector의 상태 (내용, size, capacity)를 출력한다.
		          // 출력: [1, 2, 3], size:3, capacity:5

		// trimToSize() : Vector의 capacity를 현재 size와 같게 줄여버린다.
		// 지금 size가 3이니까, capacity도 3으로 줄어든다.
		// 남는 공간을 없애서 메모리 효율을 높일 때 쓴다.
		v.trimToSize();
		System.out.println(); // 한 줄 띄우고
		print(v); // 출력: [1, 2, 3], size:3, capacity:3

		// ensureCapacity(minCapacity) : Vector의 capacity를 지정된 최소 용량 이상으로 늘린다.
		// 현재 capacity가 3인데 6으로 늘려달라고 했으니, capacity가 6이 된다.
		// 나중에 많은 데이터를 추가할 거 같을 때 미리 공간을 확보해두는 용도다.
		v.ensureCapacity(6);
		System.out.println();
		print(v); // 출력: [1, 2, 3], size:3, capacity:6 (데이터는 그대로)

		// setSize(newSize) : Vector의 size를 강제로 조절한다.
		// 현재 size가 3인데 7로 늘렸으니, 비어있는 4칸은 'null'로 채워진다.
		// 만약 newSize가 현재 capacity보다 크면, capacity도 newSize에 맞춰서 자동으로 늘어난다.
		// (여기서는 capacity가 6이었는데 size 7로 늘리면서 capacity도 7이 된 거다.)
		// 만약 setSize(2)처럼 현재 size보다 작게 줄이면, 남는 요소들은 잘려서 없어진다.
		v.setSize(7);
		System.out.println();
		print(v); // 출력: [1, 2, 3, null, null, null, null], size:7, capacity:7

		// clear() : Vector 안의 모든 요소를 지워버린다.
		// size는 0이 되지만, capacity는 그대로 유지된다. (공간 자체는 남아있음)
		v.clear();
		System.out.println();
		print(v); // 출력: [], size:0, capacity:7
	}

	// Vector의 현재 상태 (내용, 실제 요소 개수, 전체 공간)를 출력하는 헬퍼 메서드다.
	public static void print(Vector<String> v) {
		System.out.println(v); // Vector 객체 자체를 출력하면 안에 있는 요소들이 나옴
		System.out.println("size:" + v.size()); // 현재 Vector에 들어있는 요소의 개수
		System.out.println("capacity:" + v.capacity()); // Vector가 최대로 저장할 수 있는 공간의 크기
	}

}
