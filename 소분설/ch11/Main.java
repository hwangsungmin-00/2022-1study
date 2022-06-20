package hw.ch11;

public class Main {
	public static void main(String[] args) {
		System.out.println("c:\\> java Main");
		System.out.println("<<학번: 20200965 이름: 황성민>>");
		System.out.println();
		try {//황성민 수정
			Directory MyDocumentsdir = new Directory("MyDocuments", "20220401", "SeungHoonChoi");
			Directory MyDatadir = new Directory("MyData", "20220401", "SeungHoonChoi");
			Directory MyPicturesdir = new Directory("MyPictures", "20220401", "SeungHoonChoi");
			
			MyDocumentsdir.add(new File("HwangSungMin0.doc", "20220501", 1000, "SeungHoonChoi"));
			MyDocumentsdir.add(MyDatadir);
			
			MyDatadir.add(new File("HwangSungMin1.doc", "20220501", 2000, "SeungHoonChoi"));
			MyDatadir.add(new File("HwangSungMin2.java", "20220501", 3000, "SeungHoonChoi"));
			MyDatadir.add(MyPicturesdir);
			
			MyPicturesdir.add(new File("HwangSungMin3.gif", "20220601", 4000, "SeungHoonChoi"));
			MyPicturesdir.add(new File("HwangSungMin4.jpg", "20220601", 5000, "SeungHoonChoi"));
			MyPicturesdir.add(new File("HwangSungMin5.png", "20220601", 6000, "SeungHoonChoi"));
			
			MyDocumentsdir.printList();
		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
