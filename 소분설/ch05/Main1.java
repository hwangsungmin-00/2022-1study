package hw.ch05;

import hw.ch05.idcard.IDCardFactoryhwangsungmin1;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("<<�й�: 20200965 �̸�: Ȳ����>>");
		System.out.println();

		// Singleton ��ü�� �� �� ���´�.
        IDCardFactoryhwangsungmin1 factory1 = IDCardFactoryhwangsungmin1.getOwner();
        IDCardFactoryhwangsungmin1 factory2 = IDCardFactoryhwangsungmin1.getOwner();

		// �� ���� Singleton ��ü�� �ּҰ� ������ ���Ѵ�.
        if (factory1 == factory2) {
            System.out.println("factory1�� factory2�� ���� �ν��Ͻ��Դϴ�.");
        } else {
            System.out.println("factory1�� factory2�� �ٸ� �ν��Ͻ��Դϴ�.");
        }
	}

}
