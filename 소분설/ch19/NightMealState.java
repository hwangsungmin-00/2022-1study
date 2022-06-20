package hw.ch19;

public class NightMealState implements State {
	private static NightMealState singleton = new NightMealState();
    private NightMealState() {                              //�����ڴ� private
    }
    public static State getInstance() {                 // ������ �ϳ��� �ν��Ͻ��� ��´�
        return singleton;
    }
    public void doClock(Context context, int hour) {    // �ð�����
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 13) {                   
            context.changeState(NoonState.getInstance());       
        }
        else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {                // �ݰ���
        context.callSecurityCenter("Ȳ����-���:�߽Ľð� ���� �ݰ���");
        this.doAlarm(context);
    }
    public void doAlarm(Context context) {              //  ���
        context.callSecurityCenter("Ȳ����-���(�߽Ľð�)");
    }
    public void doPhone(Context context) {              // �Ϲ� ��ȭ
        context.recordLog("Ȳ����-�߽Ľð� ���� ��ȭ ����");
    }
    
    public void doCCTV(Context context)
    {
    	context.recordLog("Ȳ����-CCTV: �ػ� 300dpi�� ����");
    }
    public String toString() {                          // ���ڿ� ǥ��
        return "Ȳ����-[�߽Ľð� ��]";
    }
}
