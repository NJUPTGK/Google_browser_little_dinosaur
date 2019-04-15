import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dinosour {
    int x,y;//恐龙的坐标
    BufferedImage image;//图片
    BufferedImage image1,image2;
    int stepTimer = 0;//计时器
    int fresh = GamePanel.FRESH;//刷新时间
    boolean jumpState;//跳跃的状态
    int jumpHeight = 100;//跳跃的高度
    final int LOWEST_Y = 200;//跳跃的最低点
    int jumpValue = 0;//跳跃的增变量(速度)
    public Dinosour()
    {
        try {
            image1 = ImageIO.read(new File("image/long3.png"));
            image2 = ImageIO.read(new File("image/long2.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        x = 50;
        y = LOWEST_Y;
    }
    public void move(){
        step();//踏步
        if(jumpState){//当起跳的时候
            if(y>=LOWEST_Y){//如果站在地上
                jumpValue=-10;
            }
            if(y<=LOWEST_Y-jumpHeight){
                jumpValue = 10;
            }
            y+=jumpValue;
            if(y>=LOWEST_Y){
                jumpState = false;
            }
        }
    }
    void step()
    {
        int tmp = stepTimer/200%2;
        switch (tmp)
        {
            case 0:
                image = image1;
                break;
            case 1:
                image = image2;
                break;
        }
        stepTimer += fresh;//计时器递增
    }
    public void jump(){//跳跃
        jumpState = true;
    }
}
