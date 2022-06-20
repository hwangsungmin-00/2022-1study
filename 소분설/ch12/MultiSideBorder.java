package hw.ch12;

public class MultiSideBorder extends Border {
	private char borderChar;         // 장식이 되는 문자
	private int num;
    public MultiSideBorder(Display display, char ch, int num) {   // 생성자에서 Display와 장식문자를 지정
        super(display);
        this.num=num;
        this.borderChar = ch;
    }
    public int getColumns() {                       // 문자수는 내용물의 양쪽에 장식 문자분을 더한 것
        return num + display.getColumns() + num;
    }
    public int getRows() {                          // 줄수는 내용물의 줄수와 같음
        return display.getRows();
    }
    public String getRowText(int row) {             // 지정한 줄의 내용은 내용물의 지정 줄의 양쪽에 장식문자를 붙인 것
        return makeS(borderChar, num) + display.getRowText(row) + makeS(borderChar, num);
    }
    
    private String makeS(char ch, int count) {         // 문자ch를count개 연속 시킨 문자열을 만든다.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
