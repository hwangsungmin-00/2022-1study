package hw.ch11;

public class File extends Entry {
	private String name;
	private String data;//Ȳ���� ����
	private String author;

	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public File(String name, String data, int size, String author) {//Ȳ���� ����
		this.name = name;
		this.size = size;
		this.data=data;
		this.author=author;
	}

	public String getName() {
		return name;
	}
	public String getData() {//Ȳ���� ����
		return data;
	}
	public String getAuthor() {//Ȳ���� ����
		return author;
	}
	
	public int getCount() {//Ȳ���� ����
		return 1;
	}

	public int getSize() {
		return size;
	}

	protected void printList(String prefix) {//Ȳ���� ����
		System.out.println(prefix + "/" + this+"["+getData()+"]"+"["+getCount()+"��]"+"["+getAuthor()+"]"); //this�� this.toString()
	}
}
