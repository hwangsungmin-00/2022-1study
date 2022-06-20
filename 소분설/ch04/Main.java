package hw.ch04;

import java.util.Hashtable;
import java.util.Iterator;

import hw.ch04.framework.*;
import hw.ch04.tv.*;

public class Main {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("<<학번: 20200965 이름: 황성민>>");
		System.out.println();
		// TODO Auto-generated method stub
        Factory factory = new TVFactory();
        
        Product tv0 = factory.create("20200965");
        Product tv1 = factory.create("111");
        Product tv2 = factory.create("222"); 
        Product tv3 = factory.create("333"); 
        
        tv0.use();
        tv1.use();
        tv2.use();
        tv3.use();
        System.out.println();
        
        ((TVFactory)factory).printAllModelNumbers();

	}

}
