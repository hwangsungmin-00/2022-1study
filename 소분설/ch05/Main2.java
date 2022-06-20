package hw.ch05;

import hw.ch05.idcard.IDCardFactoryhwangsungmin2;

public class Main2 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("<<학번: 20200965 이름: 황성민>>");
		System.out.println();
		
        // 스레드 3개를 생성한 후 실행시킨다.
		new Main2("최승훈").start(); // Thread의 start()하면 자동으로 run( ) 이 자동으로 실행된다.
		new Main2("황성민").start();
		new Main2("황성원").start();
	}

	public void run() {
		IDCardFactoryhwangsungmin2 obj = IDCardFactoryhwangsungmin2.getInstance();
		System.out.println(getName() + ": obj = " + obj);
	}

	public Main2(String name) {
		super(name);
	}

	}

