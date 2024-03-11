package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Body_2 extends SuperObject{

    public OBJ_Body_2(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/body_2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
