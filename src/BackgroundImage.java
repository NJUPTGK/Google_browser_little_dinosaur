import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundImage {
    BufferedImage image;//主图片
    BufferedImage image1,image2;//轮播图片
    Graphics2D g2;//美工
    int x1,x2;//两个图片的横坐标
    static final int SPEED = 4;//滚动速度
    public BackgroundImage(){

        try {
            image1 = ImageIO.read(new File("image/map.png"));
            image2 = ImageIO.read(new File("image/map1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = new BufferedImage(800,300,BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        x1 = 0;
        x2 = 800;
        g2.drawImage(image1,x1,0,null);
        g2.drawImage(image2,x2,0,null);

    }
    public void roll(){
        x1 -= SPEED;
        x2 -= SPEED;
        if(x1<=-800){
            x1 = 800;
        }
        if(x2<=-800){
            x2 = 800;
        }
        g2.drawImage(image1,x1,0,null);
        g2.drawImage(image2,x2,0,null);
    }
}
