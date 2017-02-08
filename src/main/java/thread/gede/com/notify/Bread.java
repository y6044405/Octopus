package thread.gede.com.notify;

public class Bread {

    private int id = -1;

    public Bread(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + "";
    }

}
