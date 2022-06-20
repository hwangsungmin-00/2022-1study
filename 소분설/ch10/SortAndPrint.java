package hw.ch10;

public class SortAndPrint {
    Comparable[] data;
    Sorter sorter;
    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    public void execute() {
        print();
        sorter.sort(data);
        print();
    }
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
            System.out.println();
        }
        System.out.println("");
    }
    
    public void timeexecution() {
    	InsertSorter.getExecutionTime();
    }
    public void timeexecution2() {
    	BubbleSorter.getExecutionTime();
    }
    
}
