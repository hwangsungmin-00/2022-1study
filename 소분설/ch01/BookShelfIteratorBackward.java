package hw.ch01;

public class BookShelfIteratorBackward implements Iterator {
	// 이 Iterator가 돌아다닐 책꽂이를 가리키는 속성
	private BookShelf bookShelf;
	// 현재 책 번호를 유지하는 속성
	private int index;
	
	public BookShelfIteratorBackward(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength()-1;  // 황성민: 책꽂이를 돌아다니기 전이므로, 마지막 위치로 초기화한다.
    }
	
	
	@Override
    public boolean hasNext() {
		// 황성민: 현재 책 번호가 0보다 작으면,
	    // 책꽂이에 돌아다닐 책이 더 이상 없으므로 false를 리턴한다.
        if (index < 0) {
            return false;
        } else {
            return true;
        }
    }

	@Override
	public Object next() {
		// 이 Iterator가 가리키는 책꽂이의 getBookAt(index)를 이용해서
		// index 책번호에 해당하는 책을 얻어와서 book에 저장한다.
		Book book = bookShelf.getBookAt(index);
		// 황성민: 현재 책번호를 1 증가시킨다.
		index--;
		// 얻어온 책을 반환한다.
		return book;
	}

}
