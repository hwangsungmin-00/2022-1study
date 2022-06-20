package hw.ch05;

import hw.ch05.idcard.IDCardFactoryhwangsungmin1;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("<<학번: 20200965 이름: 황성민>>");
		System.out.println();

		// Singleton 객체를 두 번 얻어온다.
        IDCardFactoryhwangsungmin1 factory1 = IDCardFactoryhwangsungmin1.getOwner();
        IDCardFactoryhwangsungmin1 factory2 = IDCardFactoryhwangsungmin1.getOwner();

		// 두 개의 Singleton 객체의 주소가 같은지 비교한다.
        if (factory1 == factory2) {
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        } else {
            System.out.println("factory1과 factory2는 다른 인스턴스입니다.");
        }
	}

}
