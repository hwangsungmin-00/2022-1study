package hw.ch05.idcard;

import hw.ch05.framework.Product;

public class IDCardFactoryhwangsungmin2 extends Product {
	private static IDCardFactoryhwangsungmin2 owner=null;

    // private�̳� public ���� ����Ǿ� ���� ������, 
    // ���� ��Ű���� ���� Ŭ�����鸸�� �� �����ڸ� ȣ���� �� �ִ�.
    private IDCardFactoryhwangsungmin2() {
    	//�θ��� ���ھ��� �����ڰ� ���� ȣ��
        System.out.println(" ī�带 ����ϴ�.");
        this.owner = owner;
        slowdown();  // ���� �� 1�ʰ� ����.  
    }
    public void use() {
        System.out.println(owner + "�� ī�带 ����մϴ�.");
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
			Thread.sleep(3000);  // �� �޼ҵ带 ȣ���� ������� 1000 �и���, �� 1�ʰ� CPU�� ������ ����.    
		} catch (InterruptedException e) {
		}
	}
}
