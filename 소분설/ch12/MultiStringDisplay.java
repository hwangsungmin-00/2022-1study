package hw.ch12;

import java.util.Vector;

public class MultiStringDisplay extends Display {
	private Vector body = new Vector(); // 표시 문자열

	private int columns = 0; // 최대 문자수

	public void add(String msg) { // 문자열 추가
		body.add(msg);
		updateColumn(msg);
	}

	public int getColumns() { // 문자수
		return columns;
	}

	public int getRows() { // 줄 수
		return body.size();
	}

	public String getRowText(int row) { // 줄의 내용
		return (String) body.get(row); //object를 string으로 형변환해서 return
	}

	// 더 긴 문자열이 추가되면, 나머지 문자열들은 각각 알맞은 갯수의 빈 칸을 추가한다.
	private void updateColumn(String msg) { // 문자수를 갱신한다.
		if (msg.getBytes().length > columns) { // 더 긴 문자열이 들어오면
			columns = msg.getBytes().length; // 더 긴 문자열의 길이로 업데이트
		}
		//더 짧은 문자열에 빈칸 추가
		for (int row = 0; row < body.size(); row++) {
			int fills = columns - ((String) body.get(row)).getBytes().length;
			if (fills > 0) {
				body.set(row, body.get(row) + spaces(fills)); // row 위치를, 갱신된 문자열로 대치한다.
			}
		}
	}

	// count 만큼의 공백 문자열을 만든다.
	private String spaces(int count) { 
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < count; i++) {
			buf.append(' ');
		}
		return buf.toString();
	}
}
