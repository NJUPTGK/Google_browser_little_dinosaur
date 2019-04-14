public class FreshThread extends Thread {
    GamePanel p;
    public FreshThread(GamePanel p)
    {
        this.p = p;
    }
    @Override
    public void run() {
        while (!p.isFinish()){
            p.repaint();//重新绘制图片
            try {
                Thread.sleep(p.FRESH);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

    }
}

