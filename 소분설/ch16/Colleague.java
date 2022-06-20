package hw.ch16;

//‘카운셀러’에게 상담하러 오는 멤버를 나타내는 인터페이스
public interface Colleague {
	// 중재자 설정 메소드
	// Mediator 인터페이스를 구현한 LoginFrame 클래스가 첫번째로 호출하는 메소드
	// “내가 카운셀러니까 기억해두세요”라는 의미
	public abstract void setMediator(Mediator mediator);

	// “카운셀러가 내리는 지시”에 해당함
	// 멤버의 상태를 “유효” 또는 “무효”로 바꾸는 일을 수행한다.
	public abstract void setColleagueEnabled(boolean enabled);
}
