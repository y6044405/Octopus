package thread.gede.com.concurrent.BlockingQueue;

public class UserRequest {

    /** 编号 */
    private int id;

    public UserRequest() {

    }

    public UserRequest(int id) {
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
