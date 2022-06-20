package hw.ch04.tv;

import java.util.*;
import hw.ch04.framework.*;


public class TVFactory extends Factory {
	// Vector는 배열과 비슷하지만 전체 크기가 정해져 있지 않고
    private Vector modelNos = new Vector();

	// 이 공장의 제품인 IDCard를 생산한다.
    protected Product createProduct(String model) {
        return new TV_SungMinHwang(model);
    }

	// 생산된 제품의 owner를 등록(추가)한다.
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
