package hw.ch03;

public class HwangSungMinDisplay extends AbstractDisplay {

	private String name; // ǥ���ؾ� �� ���ڿ��� �����ϴ� ����//Ȳ����: ����
	private String studentId;//Ȳ����: ����
	private int grade;//Ȳ����: ����

	private int width; // ����Ʈ ������ ����� ���ڿ��� ��

	public HwangSungMinDisplay(String name, String studentId, int grade) { // �����ڿ��� �Ѿ�� ���ڿ� string��//Ȳ����: ����
		this.name = name; // �ʵ忡 ���
		this.studentId=studentId;
		this.grade=grade;
		
	}

	public void open() { // �������̵��ؼ� ������ open�޼ҵ�
		printLine(); // �� Ŭ������ �޼ҵ� printLine���� ���� �׸��� �ִ�.
		System.out.println("�������� ��ǻ�Ͱ��а�");
	}

	public void print() { // print�޼ҵ��
		// �ʵ忡 ����� �� ���ڿ��� ���Ŀ� "|"�� �ٿ��� ǥ��.
		System.out.println("�й� "+studentId+" / "+grade+"�г�"+" / "+name);
	}

	public void close() { // close�޼ҵ��
		System.out.println("���ø� �޼ҵ� ���� �����Դϴ�.");
		// open�� ���� printLine�޼ҵ忡�� ���� �׸��� �ִ�.
		
		printLine();
	}

	// open�� close�κ��� ȣ��Ǵ� printLine�޼ҵ��.
	// private�̱� ������ �� Ŭ���� �������� ���ȴ�.
	private void printLine() {
		 
		System.out.println("===================="); 
		
	}

}
