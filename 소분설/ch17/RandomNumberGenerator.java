package hw.ch17;
import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();   // �����߻���
    private int number;                     // ������ ��
    public int getNumber() {                // ���� ����Ѵ�.
        return number;
    }
    public void execute() {
        for (int i = 0; i < 100; i++) {
            number = random.nextInt(100);
 	            notifyObservers();  		
    		try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    		}
        }
    }
}
