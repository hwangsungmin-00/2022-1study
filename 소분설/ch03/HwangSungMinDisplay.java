package hw.ch03;

public class HwangSungMinDisplay extends AbstractDisplay {

	private String name; // 표시해야 할 문자열을 저장하는 변수//황성민: 수정
	private String studentId;//황성민: 수정
	private int grade;//황성민: 수정

	private int width; // 바이트 단위로 계산한 문자열의 폭

	public HwangSungMinDisplay(String name, String studentId, int grade) { // 생성자에서 넘어온 문자열 string을//황성민: 수정
		this.name = name; // 필드에 기억
		this.studentId=studentId;
		this.grade=grade;
		
	}

	public void open() { // 오버라이드해서 정의한 open메소드
		printLine(); // 이 클래스의 메소드 printLine에서 선을 그리고 있다.
		System.out.println("덕성여대 컴퓨터공학과");
	}

	public void print() { // print메소드는
		// 필드에 기억해 둔 문자열의 전후에 "|"를 붙여서 표시.
		System.out.println("학번 "+studentId+" / "+grade+"학년"+" / "+name);
	}

	public void close() { // close메소드는
		System.out.println("템플릿 메소드 패턴 숙제입니다.");
		// open과 같이 printLine메소드에서 선을 그리고 있다.
		
		printLine();
	}

	// open과 close로부터 호출되는 printLine메소드다.
	// private이기 때문에 이 클래스 내에서만 사용된다.
	private void printLine() {
		 
		System.out.println("===================="); 
		
	}

}
