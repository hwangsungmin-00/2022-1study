package hw.ch10;

public class InsertSorter implements Sorter {
	public static double t3;
	//���� �ð��� ��� �Ӽ�
	public void sort(Comparable[] data) {
		
		//����ð�
		double t1=System.nanoTime();
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				//data�� �����̸� �ε�ȣ�� �� ����
				//data�� ��ü�̸� �޼ҵ�� ���ؾ� ��
				//���ϴ� �޼ҵ� �̸�: compareTo()
				if (data[i].compareTo(data[j]) > 0) { // data[i] �� data[j] ���� ũ��
					// ���� ��ȯ�Ѵ�.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
				}
			}
		}
		
		//����ð�
		double t2=System.nanoTime();
		//���� �ð� ����ؼ� �Ӽ��� ��Ƶ�
		t3=t2-t1;
		
	}
	//����ð��� ���� �޼���
		public static void getExecutionTime()
		{
			System.out.println("* execution time: "+t3+"(miliseconds)");
		}
	
	
}
