package hw.ch01;

// 모든 Iterator가 가져야 할 메소드를 선언한 인터페이스
public interface Iterator {
	// 원소가 더 있는지 검사할 때 사용되는 메소드
    public abstract boolean hasNext(); 
    public abstract Object next(); // 그 다음 원소를 얻어돌 때 사용되는 메소드 
}