package hw.ch03;

public class Main {
	public static void main(String[] args) {
		System.out.println("�й�: 20200965 �̸�: Ȳ����");
		System.out.println("------------------------");
		System.out.println();
		// Ȳ����: ����
		AbstractDisplay d1 = new HwangSungMinDisplay("Ȳ����", "20200965", 3);
		
		d1.display(10);
	}
}
