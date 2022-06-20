package hw.ch11;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {
	private String name; // ���丮�� �̸�
	//Ȳ���� ����
	private String data;
	private String author;

	private Vector directory = new Vector(); // ���丮 ��Ʈ���� ����

	public Directory(String name) { // ������
		this.name = name;
	}
	//Ȳ���� ����
	public Directory(String name, String data, String author) { // ������
		this.name = name;
		this.data=data;
		this.author=author;
	}

	public String getName() { // �̸��� ��´�.
		return name;
	}
	
	//Ȳ���� ����
	public int getCount()
	{
		int count=0;
		
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			// entry�� Entry Ÿ������ ����Ǿ� �ְ�,
			// Entry�� File�̳� Directory�� �θ� Ŭ�����̱� ������ �� �� ������ �� �ִ�.
			Entry entry = (Entry) it.next(); //Object�� Entry�� Ÿ��ĳ����
			// entry�� ���丮�� ��쿡��, �ٽ� �� ���丮�� getCount( )�� ��������� ȣ��ȴ�. 
			count += entry.getCount(); 
			// => �׸��� ���빰�� ���Ͻ� �ȴ�.
		}
		return count;
	}

	public int getSize() { // ����� ��´�.
		int size = 0;
		// �ڽ��� ������ �ִ� ��� ��Ʈ���� ���ؼ�, getSize( )ȣ���Ͽ� ���Ѵ�.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			// entry�� Entry Ÿ������ ����Ǿ� �ְ�,
			// Entry�� File�̳� Directory�� �θ� Ŭ�����̱� ������ �� �� ������ �� �ִ�.
			Entry entry = (Entry) it.next(); //Object�� Entry�� Ÿ��ĳ����
			// entry�� ���丮�� ��쿡��, �ٽ� �� ���丮�� getSize( )�� ��������� ȣ��ȴ�. 
			size += entry.getSize(); 
			// => �׸��� ���빰�� ���Ͻ� �ȴ�.
		}
		return size;
	}

	public Entry add(Entry entry) { // ��Ʈ���� �߰�
		// �Է����ڷ� ���� Entry(File �Ǵ� Directory ��ü)�� ���Ϳ� �����Ѵ�.
		directory.add(entry);
		return this;
	}

	protected void printList(String prefix) { // ��Ʈ���� �϶�
		System.out.println(prefix + "/" + this);
		// �ڽ��� ������ �ִ� ��� ��Ʈ���� ���ؼ�, printList( )ȣ���Ѵ�.
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			entry.printList(prefix + "/" + name);
		}
	}
}
