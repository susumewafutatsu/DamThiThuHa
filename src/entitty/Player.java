package entitty;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;

/**
 *
 * @author arima
 */
public class Player extends Entity{

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        //Size box character
        soliArea = new Rectangle();
        soliArea.x = gp.tileSize/6;
        soliArea.y = gp.tileSize/3;
        soliAreaDefaultX = soliArea.x;
        soliAreaDefaultY = soliArea.y;
        soliArea.width = gp.tileSize - soliArea.x * 2;
        soliArea.height = gp.tileSize - soliArea.y;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        //let's start
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 6;
        direction = "down";
    }
    public  void getPlayerImage(){
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
    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed){
                direction = "up";
            }
            else if(keyH.downPressed){
                direction = "down";
            }
            else if(keyH.leftPressed){
                direction = "left";
            }
            else if(keyH.rightPressed){
                direction = "right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false){
                switch (direction){
                    case "up":   worldY -= speed;break;
                    case "down": worldY += speed;break;
                    case "left": worldX -= speed;break;
                    case "right":worldX += speed;break;
                }
            }

            spriteCounter++;
            if (spriteCounter >12){
                if (spriteNum == 1){
                    spriteNum = 2;
                }else if (spriteNum == 2){
                    spriteNum = 3;
                }
                else if (spriteNum == 3){
                    spriteNum=1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                if (spriteNum == 3){
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3){
                    image = down3;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3){
                    image = left3;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
    public Point getPlayerPosition() {
        return new Point(worldX, worldY);
    }
}