package GUI;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

    final int origineTileSize = 32;
    final int scale = 1;

    final int tileSize = scale * origineTileSize;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;
    Player p = new Player(this);

    Thread gameThread;

    int playerX = 100;
    int playerY = 100;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
    }  

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null) {
            
            update(null);
            repaint();

            try {
                double remaingTime = nextDrawTime - System.nanoTime();
                remaingTime = remaingTime/1000000;

                if(remaingTime < 0) {
                    remaingTime = 0;
                }

                Thread.sleep((long) remaingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        p.Draw(g2);    
    }

}