import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable{

    // Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;
    final int FPS = 60;
    int ghostY = 100;
    int ghostX = 100;
    gameLogic gameLogic = new gameLogic();
    Thread gameThread;
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(gameLogic);
        this.setFocusable(true);
        startGameThread();
    }


    public void startGameThread () {

        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // = 0.016
        double nextDrawTime = System.nanoTime() + drawInterval; // Draw next frame 0.016 seconds later

        while(gameThread != null) {
            long currentTime  = System.nanoTime();
            //System.out.println(currentTime);
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; // Convert nanoseconds to milliseconds

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() {

        //System.out.println(gameLogic.getPressedKeys());
        if (gameLogic.getPressedKeys().contains(KeyEvent.VK_W)) {
            ghostY -= 5; // Move up
        }
        if (gameLogic.getPressedKeys().contains(KeyEvent.VK_A)) {
            ghostX -= 5; // Move down
        }
        if (gameLogic.getPressedKeys().contains(KeyEvent.VK_S)) {
            ghostY += 5; // Move left
        }
        if (gameLogic.getPressedKeys().contains(KeyEvent.VK_D)) {
            ghostX += 5; // Move right
        }

        System.out.println(ghostX + " " + ghostY);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(ghostX, ghostY, tileSize, tileSize);

        g2.dispose();
    }
}
