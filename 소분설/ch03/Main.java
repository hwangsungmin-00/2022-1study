package hw.ch03;

public class Main {
	public static void main(String[] args) {
		System.out.println("학번: 20200965 이름: 황성민");
		System.out.println("------------------------");
		System.out.println();
		// 황성민: 수정
		AbstractDisplay d1 = new HwangSungMinDisplay("황성민", "20200965", 3);
		
		d1.display(10);
	}
}
