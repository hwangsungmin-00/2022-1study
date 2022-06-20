package hw.ch12;

public class MultiSideBorder extends Border {
	private char borderChar;         // ����� �Ǵ� ����
	private int num;
    public MultiSideBorder(Display display, char ch, int num) {   // �����ڿ��� Display�� ��Ĺ��ڸ� ����
        super(display);
        this.num=num;
        this.borderChar = ch;
    }
    public int getColumns() {                       // ���ڼ��� ���빰�� ���ʿ� ��� ���ں��� ���� ��
        return num + display.getColumns() + num;
    }
    public int getRows() {                          // �ټ��� ���빰�� �ټ��� ����
        return display.getRows();
    }
    public String getRowText(int row) {             // ������ ���� ������ ���빰�� ���� ���� ���ʿ� ��Ĺ��ڸ� ���� ��
        return makeS(borderChar, num) + display.getRowText(row) + makeS(borderChar, num);
    }
    
    private String makeS(char ch, int count) {         // ����ch��count�� ���� ��Ų ���ڿ��� �����.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
