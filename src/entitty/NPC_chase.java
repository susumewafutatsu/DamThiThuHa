package entitty;
import java.awt.*;
import java.io.IOException;
import java.util.Random;
import Main.GamePanel;

import javax.imageio.ImageIO;

public class NPC_chase extends Entity{

    public NPC_chase(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 2;

        getImage();
    }
    public void getImage(){
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/main_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/main_up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/main_up_3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/main_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/main_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/main_down_3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/main_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/main_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/main_left_3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/main_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/main_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/main_right_3.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction() {
        actionLockCounter++;
        if(actionLockCounter == 120){

            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if(i<=25){
                direction="up";
            }
            if(i>25 && i <= 50){
                direction="down";
            }
            if(i>50 && i <= 75){
                direction = "left";
            }
            if(i>75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
}
