package Main;

import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;
    public  AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public  void setObject(){
        double randomDouble = Math.random() * 50; // Số ngẫu nhiên từ 0.0 đến 20.999...
        int randomNumber = (int) randomDouble; // Chuyển đổi thành số nguyên
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = randomNumber * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;
    }
}
