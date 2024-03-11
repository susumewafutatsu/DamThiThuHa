package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Leg_2 extends SuperObject{

    public OBJ_Leg_2(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/leg_2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
