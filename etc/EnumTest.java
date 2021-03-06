package com.doosan.test.prac2;

public class EnumTest {
	// 링크 : https://opentutorials.org/course/2517/14151
	enum Fruit {
		Apple, Peach, Banana;
		/*public*/ Fruit() {
			System.out.println("Call Constructor " + this);
		}
		/**
		 * Call Constructor Apple
		 * Call Constructor Peach
		 * Call Constructor Banana
		 * 생서자 Fruit 가 호춮되었기 때문에 출력된 것. 필드의 숫자만큼 호출된다. enum 은 생성자를 가질 수 있다.
		 * enum 의 생성자가 접근 제어자 private 만을 허용하기 때문에 public 을 허용하지 않고, Fruit 를 직접 생성할 수 없다.
		 */
	}
	
	enum Company {
		Google, Apple, Oracle;
	}
	
	public static void main(String[] args) {
	
//		if(Fruit.Apple == Company.Apple) {
//			System.out.print("사과와 회사는 같다.");
//		}
		// enum 이 서로 다른 상수 그룹에 대한 비교를 컴파일 시점에서 차단할 수 있다
		
		Fruit type = Fruit.Apple;
		switch(type) {
		case Apple:
			System.out.println(57 + " kcal"); // 실행됨
			break;
		case Peach:
			System.out.println(34 + "kcal");
			break;
		case Banana:
			System.out.println(93 + "kcal");
			break;
		}
	}
}

class EnumTest2 {
	enum Fruit {
		Apple("red"), Peach("pink"), Banana("yellow");
		public String color;
		Fruit(String color) {
			System.out.println("Call Constructor " + this);
			this.color = color;
		}
		String getColor() {
			return this.color;
		}
	}
	
	public static void main(String[] args) {
		
		Fruit type = Fruit.Apple;
		switch(type) {
		case Apple:
			System.out.println(57 + " kcal, " + Fruit.Apple.getColor());
			break;
		case Peach:
			System.out.println(34 + "kcal, " + Fruit.Peach.getColor());
			break;
		case Banana:
			System.out.println(93 + "kcal, " + Fruit.Banana.getColor());
			break;
		}
		
		for(Fruit f : Fruit.values()) {
			System.out.println(f + ", " + f.getColor());
		}
		Fruit[] fruitArr = Fruit.values();
	}
}

class EnumTest3 {
	
	public static void main(String[] args) {
		
		Fruit2 type = Fruit2.Apple;
		System.out.println(type);
	}
}
