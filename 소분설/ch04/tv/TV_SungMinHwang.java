package hw.ch04.tv;

import hw.ch04.framework.*;

public class TV_SungMinHwang extends Product {
    private String modelNo;
    
    public TV_SungMinHwang(String modelNo) {
         this.modelNo=modelNo;
    }
    public void use() {
        System.out.println("�𵨹�ȣ " +modelNo+"�� TV�� ����մϴ�");
    }
    public String getmodelNo() {
        return modelNo;
    }
}
