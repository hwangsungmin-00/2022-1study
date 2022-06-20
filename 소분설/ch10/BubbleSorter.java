package hw.ch10;

public class BubbleSorter implements Sorter {
	public static double t6;
	@Override
	public void sort(Comparable[] data) {
		// TODO Auto-generated method stub
		double t4=System.nanoTime();
		
		for(int i = 0; i < data.length-1; i++) { 
			for(int j = 0; j < data.length-1-i; j++) { 
				if(data[j].compareTo(data[j+1]) > 0) {
					Comparable tmp = data[j]; 
					data[j] = data[j+1]; 
					data[j+1] = tmp; 
				}
			}
		}
		//현재시간
		double t5=System.nanoTime();
		//실행 시간 계산해서 속성에 담아둠
		t6=t5-t4;
		
	}
	public static void getExecutionTime()
	{
		System.out.println("* execution time: "+t6+"(miliseconds)");
	}

}
