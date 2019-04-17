import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Obstacle {
    int x,y;
    BufferedImage image;
    BufferedImage cactus1,cactus2,cactus3;
    int speed;
    public Obstacle()
    {
        try {
            cactus1 = ImageIO.read(new File("image/cactus01.png"));
            cactus2 = ImageIO.read(new File("image/cactus02.png"));
            cactus3 = ImageIO.read(new File("image/cactus03.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random r = new Random();
        int temp = r.nextInt(3);//0-1
        if(temp==0){
            image=cactus1;
        }
        if(temp==1){
            image=cactus2;
        }
        if(temp==2){
            image = cactus3;
        }
        speed = BackgroundImage.SPEED;
        x = 800;
        y = 245-image.getHeight();

    }
    public void move(){
        x-=speed;
    }
}
