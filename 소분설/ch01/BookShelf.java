package hw.ch01;

public class BookShelf implements Aggregate {
     // 책꽂이의 책을 보관하기 위한 Book 배열을 선언한다.
	private Book[ ] books;  //배열 변수만 선언하고, 공간을 할당되지 않았다.
    private int last = 0; // 마지막 책이 꽂힌 위치를 저장한다.

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; // 여기서 배열 공간을 실제로 만들었음.
    }

	 // 입력인자인 index에 해당하는 책을 반환하는 메소드
    public Book getBookAt(int index) {
        return books[index];
    }

	// 책꽂이에 책을 꽂는 메소드
    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

	// 책꽂이의 책 개수를 반환하는 메소드
    public int getLength() {
        return last;
    }

	// 자신의 Iterator를 생성하여 반환하는 메소드
    public Iterator iterator() {
		// 자신을 인자로 하여 BookShelfIterator 객체를 생성하여 반환한다.
        //return new BookShelfIterator(this);  //this: 현재 책꽂이
        return new BookShelfIteratorBackward(this);
    }
}









