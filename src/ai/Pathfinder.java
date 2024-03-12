package ai;
import java.util.ArrayList;
import Main.GamePanel;
public class Pathfinder {
    GamePanel gp;
    Node [] [] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;
    public Pathfinder(GamePanel gp) {
        this.gp = gp;
        instantiateNodes();
    }
    public void instantiateNodes() {
        node = new Node[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            node[col][row] = new Node(col, row);
            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

}
