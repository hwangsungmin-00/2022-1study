package hw.ch05;

import hw.ch05.idcard.IDCardFactoryhwangsungmin2;

public class Main2 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("<<�й�: 20200965 �̸�: Ȳ����>>");
		System.out.println();
		
        // ������ 3���� ������ �� �����Ų��.
		new Main2("�ֽ���").start(); // Thread�� start()�ϸ� �ڵ����� run( ) �� �ڵ����� ����ȴ�.
		new Main2("Ȳ����").start();
		new Main2("Ȳ����").start();
	}

	public void run() {
		IDCardFactoryhwangsungmin2 obj = IDCardFactoryhwangsungmin2.getInstance();
		System.out.println(getName() + ": obj = " + obj);
	}

	public Main2(String name) {
		super(name);
	}

	}

