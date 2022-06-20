package hw.ch04.tv;

import java.util.*;
import hw.ch04.framework.*;


public class TVFactory extends Factory {
	// Vector�� �迭�� ��������� ��ü ũ�Ⱑ ������ ���� �ʰ�
    private Vector modelNos = new Vector();

	// �� ������ ��ǰ�� IDCard�� �����Ѵ�.
    protected Product createProduct(String model) {
        return new TV_SungMinHwang(model);
    }

	// ����� ��ǰ�� owner�� ���(�߰�)�Ѵ�.
    protected void registerProduct(Product product) {
		modelNos.add(((TV_SungMinHwang)product).getmodelNo());
    }
    public void printAllModelNumbers() {
        Iterator i=modelNos.iterator();
        
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
    }
}
