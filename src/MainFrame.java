import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel p;
    public MainFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭规则
        p = new GamePanel();
        Container c = getContentPane();//获取窗体的主容器
        c.add(p);//把游戏面板添加到主容器中
        addKeyListener(p);//添加键盘事件监听
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setBounds(340,150,750,320);//坐标和长宽
        frame.setVisible(true);//设置可见
    }
    public void restart(){

    }

}
