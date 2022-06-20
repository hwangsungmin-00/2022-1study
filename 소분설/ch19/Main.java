package hw.ch19;

public class Main extends Thread {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 15; hour < 24; hour++) {
                frame.setClock(hour);   //시각의 설정
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
