package hw.ch04.tv;

import hw.ch04.framework.*;

public class TV_SungMinHwang extends Product {
    private String modelNo;
    
    public TV_SungMinHwang(String modelNo) {
         this.modelNo=modelNo;
    }
    public void use() {
        System.out.println("모델번호 " +modelNo+"인 TV를 사용합니다");
    }
    public String getmodelNo() {
        return modelNo;
    }
}
