package hw.ch12;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println("<<학번: 20200965 이름: 황성민>>");
		System.out.println();
		
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("학번: 20200965");
        md.add("이름: 황성민");
        md.add("핸드폰 번호: 010-1234-5678");
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
