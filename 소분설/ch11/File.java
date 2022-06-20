package hw.ch11;

public class File extends Entry {
	private String name;
	private String data;//È²¼º¹Î ¼öÁ¤
	private String author;

	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public File(String name, String data, int size, String author) {//È²¼º¹Î ¼öÁ¤
		this.name = name;
		this.size = size;
		this.data=data;
		this.author=author;
	}

	public String getName() {
		return name;
	}
	public String getData() {//È²¼º¹Î ¼öÁ¤
		return data;
	}
	public String getAuthor() {//È²¼º¹Î ¼öÁ¤
		return author;
	}
	
	public int getCount() {//È²¼º¹Î ¼öÁ¤
		return 1;
	}

	public int getSize() {
		return size;
	}

	protected void printList(String prefix) {//È²¼º¹Î ¼öÁ¤
		System.out.println(prefix + "/" + this+"["+getData()+"]"+"["+getCount()+"°³]"+"["+getAuthor()+"]"); //this´Â this.toString()
	}
}
