package thread.gede.com.thinking.synchronizedBlock;

public class PairManager1 extends PairManager {

    @Override
    public void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }

}
