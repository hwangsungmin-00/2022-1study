package hw.ch10;

public class Student implements Comparable<Student> {
	
	private String name;
	private String id;
	private int height;
	public Student(String name, String id, int height) {
		this.name=name;
		this.id=id;
		this.height=height;
	}
	
	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		//this.height, s.height
		
		if(s.height>this.height) {
			return 1;
		}
		else if(s.height<this.height)
		{
			return -1;
		}
		else {
		return 0;
		}
	}
	
	public String toString() {
		return "이름: "+name+", 학번: "+id+", 키: "+height;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getHeight() {
		return height;
	}
}
