package hw.ch19;

public class NightMealState implements State {
	private static NightMealState singleton = new NightMealState();
    private NightMealState() {                              //생성자는 private
    }
    public static State getInstance() {                 // 유일한 하나의 인스턴스를 얻는다
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시각설정
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 13) {                   
            context.changeState(NoonState.getInstance());       
        }
        else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {                // 금고사용
        context.callSecurityCenter("황성민-비상:야식시간 때의 금고사용");
        this.doAlarm(context);
    }
    public void doAlarm(Context context) {              //  비상벨
        context.callSecurityCenter("황성민-비상벨(야식시간)");
    }
    public void doPhone(Context context) {              // 일반 통화
        context.recordLog("황성민-야식시간 때의 통화 녹음");
    }
    
    public void doCCTV(Context context)
    {
    	context.recordLog("황성민-CCTV: 해상도 300dpi로 변경");
    }
    public String toString() {                          // 문자열 표현
        return "황성민-[야식시간 때]";
    }
}
