package hw.ch10;

public class InsertSorter implements Sorter {
	public static double t3;
	//실핼 시간을 담는 속성
	public void sort(Comparable[] data) {
		
		//현재시간
		double t1=System.nanoTime();
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				//data가 숫자이면 부등호로 비교 가능
				//data가 객체이면 메소드로 비교해야 함
				//비교하는 메소드 이름: compareTo()
				if (data[i].compareTo(data[j]) > 0) { // data[i] 가 data[j] 보다 크면
					// 서로 교환한다.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
				}
			}
		}
		
		//현재시간
		double t2=System.nanoTime();
		//실행 시간 계산해서 속성에 담아둠
		t3=t2-t1;
		
	}
	//실행시간을 얻어가는 메서드
		public static void getExecutionTime()
		{
			System.out.println("* execution time: "+t3+"(miliseconds)");
		}
	
	
}
