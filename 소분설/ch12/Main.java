package hw.ch12;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println("<<�й�: 20200965 �̸�: Ȳ����>>");
		System.out.println();
		
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("�й�: 20200965");
        md.add("�̸�: Ȳ����");
        md.add("�ڵ��� ��ȣ: 010-1234-5678");
        //md.show();

        Display d1 = new SideBorder(md, '%');
        //d1.show();

        Display d2 = new FullBorder(d1);
        //d2.show();
        
        Display d3=new UpDownBorder(d2, '=');
        //d3.show();
        
        Display d4=new MultiSideBorder(d3, '*', 3);
        d4.show();
        
    }
}
