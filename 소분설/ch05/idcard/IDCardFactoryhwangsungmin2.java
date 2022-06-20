package hw.ch05.idcard;

import hw.ch05.framework.Product;

public class IDCardFactoryhwangsungmin2 extends Product {
	private static IDCardFactoryhwangsungmin2 owner=null;

    // private이나 public 으로 선언되어 있지 않으면, 
    // 같은 패키지에 속한 클래스들만이 이 생성자를 호출할 수 있다.
    private IDCardFactoryhwangsungmin2() {
    	//부모의 인자없는 생상자가 먼저 호출
        System.out.println(" 카드를 만듭니다.");
        this.owner = owner;
        slowdown();  // 생성 시 1초간 쉰다.  
    }
    public void use() {
        System.out.println(owner + "의 카드를 사용합니다.");
    }
    synchronized public static IDCardFactoryhwangsungmin2 getInstance() {
    	//public static IDCardFactoryhwangsungmin2 getInstance() {
    		if (owner == null) {
    			owner = new IDCardFactoryhwangsungmin2();
    		}
    		return owner;
    	}
    public IDCardFactoryhwangsungmin2 getOwner() {
        return owner;
    }
    
    private void slowdown() {
		try {
			Thread.sleep(3000);  // 이 메소드를 호출한 스레드는 1000 밀리초, 즉 1초가 CPU를 내놓고 쉰다.    
		} catch (InterruptedException e) {
		}
	}
}
