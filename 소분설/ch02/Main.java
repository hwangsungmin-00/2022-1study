package hw.ch02;

import java.io.*;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println("�й�: 20200965 �̸�: Ȳ����");
		System.out.println("------------------------");
		System.out.println();
		
        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");
           
            f.setValue("Year", "2019");//Ȳ����: ����
            f.setValue("bornYear", "2000");
            f.setValue("StudentId", "20200965");
            f.setValue("Name", "HwangSungmin");
            f.setValue("Location", "Seoul");
            f.writeToFile("HwangSungMin.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
