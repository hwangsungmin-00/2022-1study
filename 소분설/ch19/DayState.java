package hw.ch19;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {                                // 생성자는 private
    }
    public static State getInstance() {                 // 유일한 하나의 인스턴스를 얻는다
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시각설정
        if (hour < 9 || (17 <= hour&&hour<20)) {
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) {                   
            context.changeState(NoonState.getInstance());       
        } else if (20 <= hour && hour < 24) {                   
            context.changeState(NightMealState.getInstance());       
        }                                                    
    }
    public void doUse(Context context) {                // 금고사용
        context.recordLog("금고사용(주간)");
    }
    public void doAlarm(Context context) {              //  비상벨
        context.callSecurityCenter("비상벨(주간)");
    }
    public void doPhone(Context context) {              // 일반 통화
        context.callSecurityCenter("일반 통화(주간))");
    }
    
    public void doCCTV(Context context)
    {
    	context.recordLog("CCTV: 해상도 600dpi로 변경");
    }
    public String toString() {                          //문자열 표현
        return "[주간]";
    }
}
