package hw.ch01;

public class Main {
	// 모든 자바 프로그램은 main() 메소드부터 시작된다.
    public static void main(String[] args) {
		System.out.println("학번: 20200965 이름: 황성민");
		System.out.println("------------------------");
		System.out.println();
		
    	// 황성민: 최대 6권의 책을 담을 수 있는 책꽂이를 생성한다.
        BookShelf bookShelf = new BookShelf(6);
        //Aggregate bookShelf2 = new BookShelf(4);
        // 황성민: 6권의 책을 꽂는다.
        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("소프트웨어분석설계", "최승훈"));
        bookShelf.appendBook(new Book("프로그래머수학", "이주영"));
        bookShelf.appendBook(new Book("컴퓨터동작원리", "유견아"));
        bookShelf.appendBook(new Book("컴퓨터그래픽스", "이경미"));
        bookShelf.appendBook(new Book("토끼와 거북이", "황성민"));
        

		// 책꽂이의 Iterator를 얻어온다.
        // 실제 생성되는 객체의 타입은 BookShelfIterater이다.
		Iterator it = bookShelf.iterator();
        
		// 책이 계속해서 있으면 while 루프를 돈다.
		// 책이 더 있는지 검사하기 위해서, iterator의 hasNext()를 호출한다.
		while (it.hasNext()) {
			Book book = (Book)it.next(); // 다음 책을 얻어온다.
			// 위 문장 대신에
			// Object book = it.next();
			// 을 사용하면 안 된다.
            // 왜냐하면, 아래에서 book.getName()을 호출하는데,
			// Object 타입은 getName() 을 지원하지 않는다.
			// 따라서,  it.next( )가 반환한 Object 형을 Book 형으로 "강제형변환"해야 한다.

			// 책의 이름을 출력한다.
			System.out.println("" + book.getName()+", "+book.getAuthor());
           
        }

    }
}





