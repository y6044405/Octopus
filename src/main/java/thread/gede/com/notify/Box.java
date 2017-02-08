package thread.gede.com.notify;

public class Box {

    /** 栈顶指针，表示目前栈顶面包的位置 */
    private int index = 0;

    /** 栈内数据，最多只能放十个 */
    private Bread[] breads = new Bread[10];

    /**
     * 入栈操作，将创建的面包放入box栈底
     * 此时栈顶指针+1
     * @param bread
     */
    public synchronized void push(Bread bread) {
        //判断关键字用while而不是if
        while (index == breads.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        breads[index] = bread;
        index++;
    }

    /**
     * 出栈，将栈顶的面包拿出
     * 此时栈顶指针-1
     * @return
     */
    public synchronized Bread pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        System.out.println("拿出的面包id是:" + index + ",面包是:" + breads[0].toString());
        return breads[index];
    }

}
