package hw.ch01;

// 책꽂이에 꽂힌 책을 차례차례 돌아다니는데 사용될 클래스
public class BookShelfIterator implements Iterator {
    // 이 Iterator가 돌아다닐 책꽂이를 가리키는 속성
	private BookShelf bookShelf;
    // 현재 책 번호를 유지하는 속성
	private int index;

	// 입력인자인 BookShelf 객체를 자기 속성인 bookShelf에 저장한다.
	// 나중에 이 속성을 이용해서 책꽂이를 돌아다닌다.
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;  // 책꽂이를 돌아다니기 전이므로, 0으로 초기화한다.
    }

    // 책꽂이에 접근할 책이 더 있는지 검사하는 메소드
    public boolean hasNext() {
		// 현재 책 번호가 책꽂이에 있는 책 개수보다 작으면,
	    // 책꽂이에 돌아다닐 책이 더 있는 것이므로 true를 반환한다.
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

	// 다음 책을 얻어오고자 할 때 호출되는 메소드
	// 반환형이 Object 타입이다. 
	//  - Object는 모든 클래스의 부모 클래스이므로 모든 자식을 가리킬 수 있다.  
	//  - 즉, 모든 타입의 객체를 반환할 수 있다.
	//  - 실제로 반환되는 객체는 Book 타입이므로, 올바른 반환형으로 선언된 것이다.
    public Object next() {
        // 이 Iterator가 가리키는 책꽂이의 getBookAt(index)를 이용해서
		// index 책번호에 해당하는 책을 얻어와서 book에 저장한다.
		Book book = bookShelf.getBookAt(index);
        // 현재 책번호를 1 증가시킨다.
		index++;
		// 얻어온 책을 반환한다.
        return book;
    }
}






