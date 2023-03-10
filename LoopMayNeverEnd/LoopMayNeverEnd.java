public class LoopMayNeverEnd {
    boolean done = false;
    public void work() {
        while(!this.done) {}
    }

    public void stopWork() {
        this.done = true;
    }

    public static void main(String[] argv) throws Exception {
        LoopMayNeverEnd obj = new LoopMayNeverEnd();
        Thread thread = new Thread(() -> obj.work());  // 线程1 死循环
        thread.start();
        Thread.sleep(1000L);
        System.out.print("after sleep");
        Thread thread2 = new Thread(() -> obj.stopWork());  // 线程2 修改标志位
        thread2.start();
    }
}