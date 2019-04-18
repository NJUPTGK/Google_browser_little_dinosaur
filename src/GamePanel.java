import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//面板
public class GamePanel extends JPanel implements KeyListener{
    BufferedImage image;//主图片
    Graphics2D g2;//绘图工具，美工
    Dinosour golden;//恐龙
    BackgroundImage  background;//背景对象

    ArrayList<Obstacle> list = new ArrayList<Obstacle>();//集合
    int addObstacleTimer = 0;
    boolean finish = false;//游戏结束
    static final int FRESH = 20;//刷新时间,毫秒
    public GamePanel(){
        image = new BufferedImage(800,300,BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        golden = new Dinosour();
        background = new BackgroundImage();
        list.add(new Obstacle());
        FreshThread t = new FreshThread(this);//刷新线程
        t.start();
    }
    private void paintImage()//绘制图片
    {
        golden.move();//让恐龙移动
        background.roll();//背景滚动

        g2.drawImage(background.image,0,0,this);
       // Rectangle r1 = golden.getfeedBounds();
        //g2.setColor(Color.BLACK);
        //g2.fillRect(r1.x,r1.y,r1.width,r1.height);
        g2.drawImage(golden.image,golden.x,golden.y,this);//绘制恐龙
        if(addObstacleTimer >= 1300){
            Random r = new Random();
            int a = r.nextInt(100);
            if(a>40){
                list.add(new Obstacle());
            }
            addObstacleTimer = 0;
        }
        for(int i=0;i<list.size();i++) {
            Obstacle o = list.get(i);
            o.move();
            //r1 = o.getBound();
            //g2.fillRect(r1.x,r1.y,r1.width,r1.height);
            g2.drawImage(o.image,o.x,o.y,this);//绘制障碍
            if(o.getBound().intersects(golden.getHeadBounds())||o.getBound().intersects(golden.getfeedBounds())){
                gameOver();
            }
        }
        addObstacleTimer+=FRESH;//计时器计时

    }
    public void gameOver()
    {
        finish = true;
    }

    @Override
    public void paint(Graphics g) {
        paintImage();
        g.drawImage(image,0,0,this);//把主图片贴在面板上
    }

    public boolean isFinish() {
        return finish;
    }

    @Override
    public void keyTyped(KeyEvent e) {//按键的类型

    }

    @Override
    public void keyPressed(KeyEvent e) {//按键按下
        int code = e.getKeyCode();//获取按下的键盘编码
        if(code==KeyEvent.VK_SPACE){
            golden.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {//按键抬起

    }
}
