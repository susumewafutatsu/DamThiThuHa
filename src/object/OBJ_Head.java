package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Head extends SuperObject{
    public OBJ_Head(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/head-1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
