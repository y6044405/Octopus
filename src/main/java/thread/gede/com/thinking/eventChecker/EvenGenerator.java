package thread.gede.com.thinking.eventChecker;

public class EvenGenerator extends IntGenerator {

    private int currentEventValue = 0;

    @Override
    public synchronized int next() {
        ++currentEventValue;
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
