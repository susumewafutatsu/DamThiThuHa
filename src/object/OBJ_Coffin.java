package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Coffin extends SuperObject{

    public OBJ_Coffin(){
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coffin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collison = true;
    }
}
