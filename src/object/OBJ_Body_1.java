package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Body_1 extends SuperObject{

    public OBJ_Body_1(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/body_1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
