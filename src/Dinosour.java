import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dinosour {
    int x,y;//恐龙的坐标
    BufferedImage image;//恐龙的图片
    public Dinosour()
    {
        try {
            image = ImageIO.read(new File("image/long3.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
