package hw.ch17;
import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();   // 난수발생기
    private int number;                     // 현재의 수
    public int getNumber() {                // 수를 취득한다.
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
