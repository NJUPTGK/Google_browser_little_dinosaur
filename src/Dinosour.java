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
        y = 200;
    }
    public void move(){
        step();//踏步
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
        stepTimer += fresh;
    }
}
