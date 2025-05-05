package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;

    public Player(GamePanel gp) {
        this.gp = gp;
    }

    public void defaultPosition() {
        x = 100;
        y = 100;
    }

    public void Sprite() {
        try{
            stand = ImageIO.read(getClass().getResourceAsStream("RPG/Tiny/Characters(100x100)/Soldier/Soldier/Soldier.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void Draw(Graphics g2) {
        g2.drawImage(stand, x, y, gp.tileSize, gp.tileSize, null);
    }

    

    
}
