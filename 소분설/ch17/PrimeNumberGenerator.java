package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator {
	private Random random = new Random();   // 난수발생기
    private int number;                     // 현재의 수
    public int getNumber() {                // 수를 취득한다.
        return number;
    }
    public void execute() {
        for (int i = 0; i < 100; i++) {
            number = random.nextInt(100);
            if(isPrimeNumber(number)==false)
            {
            	notifyObservers();  
            }		
    		try {
    			Thread.sleep(10);
    		} catch (InterruptedException e) {
    		}
        }
    }
    
    public boolean isPrimeNumber(int num) {
    	//boolean isPrime = false;
    	for (int k = 2; k < number; k++) {
            // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
            if (number % k == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                return true;
            }
        }
    	return false;
    }
}
