package hw.ch10;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println();
		System.out.println("<<�й�: 20200965 �̸�: Ȳ����>>");
		System.out.println();
		System.out.println("<���� ���>");
		
        Student[] data = {
            new Student("Ȳ����", "20200965", 162),
            new Student("������", "20200709", 158),
            new Student("������", "20200818", 159),
            new Student("������", "20200675", 153),
            new Student("�����", "20200831", 160)
            
        };
        System.out.println("(1) by InsertSorter:");
        SortAndPrint sap1 = new SortAndPrint(data, new InsertSorter());
        sap1.execute();
        sap1.timeexecution();
        
        System.out.println();
        
        Student[] data2 = {
                new Student("Ȳ����", "20200965", 162),
                new Student("������", "20200709", 158),
                new Student("������", "20200818", 159),
                new Student("������", "20200675", 153),
                new Student("�����", "20200831", 160)
                
            };
        System.out.println("(2) by BubbleSorter:");
        SortAndPrint sap2 = new SortAndPrint(data2, new BubbleSorter());
        sap2.execute();
        sap2.timeexecution2();
    }
}
