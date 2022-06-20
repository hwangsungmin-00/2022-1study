package hw.ch05.idcard;

import hw.ch05.framework.Product;

public class IDCardFactoryhwangsungmin1 extends Product {
    private static IDCardFactoryhwangsungmin1 owner;

    // private이나 public 으로 선언되어 있지 않으면, 
    // 같은 패키지에 속한 클래스들만이 이 생성자를 호출할 수 있다.
    private IDCardFactoryhwangsungmin1(IDCardFactoryhwangsungmin1 owner) {
    	//부모의 인자없는 생상자가 먼저 호출
    	System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }
    public void use() {
    	System.out.println(owner + "의 카드를 사용합니다.");
    }
    public static IDCardFactoryhwangsungmin1 getOwner() {
        return owner;
    }
}
