import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//面板
public class GamePanel extends JPanel {
    BufferedImage image;//主图片
    Graphics2D g2;//绘图工具，美工
    Dinosour golden;
    BufferedImage background;
    public GamePanel(){
        image = new BufferedImage(800,300,BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        golden = new Dinosour();
        try {
            background = ImageIO.read(new File("image/map.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    private void paintImage()//绘制图片
    {
        g2.drawImage(background,0,0,this);
        g2.drawImage(golden.image,golden.x,golden.y,this);//
    }

    @Override
    public void paint(Graphics g) {
        paintImage();
        g.drawImage(image,0,0,this);//把主图片贴在面板上
    }
}
