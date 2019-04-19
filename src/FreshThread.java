import javax.swing.*;
import java.awt.*;

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
        Container c = p.getParent();
        while(!(c instanceof MainFrame)){//判断左边那个对象是不是右边那个类
            c = c.getParent();
        }
        MainFrame f = (MainFrame) c;
        //弹出通知
        JOptionPane.showMessageDialog(f,"游戏结束");
        f.restart();
    }
}

