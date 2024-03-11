package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Legs_1 extends SuperObject{

    public OBJ_Legs_1(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/leg_1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
