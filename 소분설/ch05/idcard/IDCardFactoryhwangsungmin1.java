package hw.ch05.idcard;

import hw.ch05.framework.Product;

public class IDCardFactoryhwangsungmin1 extends Product {
    private static IDCardFactoryhwangsungmin1 owner;

    // private�̳� public ���� ����Ǿ� ���� ������, 
    // ���� ��Ű���� ���� Ŭ�����鸸�� �� �����ڸ� ȣ���� �� �ִ�.
    private IDCardFactoryhwangsungmin1(IDCardFactoryhwangsungmin1 owner) {
    	//�θ��� ���ھ��� �����ڰ� ���� ȣ��
    	System.out.println(owner + "�� ī�带 ����ϴ�.");
        this.owner = owner;
    }
    public void use() {
    	System.out.println(owner + "�� ī�带 ����մϴ�.");
    }
    public static IDCardFactoryhwangsungmin1 getOwner() {
        return owner;
    }
}
