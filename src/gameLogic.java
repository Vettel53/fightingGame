import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;


public class gameLogic extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 800; //Screen resolution Width ex: 1920x1080p tihs would be the 1920
    static final int SCREEN_HEIGHT = 600;//Screen resolution Heigh ex: 1920x1080p tihs would be the 1080

    static final int BLOCK_SIZE = 30; // Size of the UNIT/BLOCKS

    static final int GAME_BLOCKS = (SCREEN_HEIGHT*SCREEN_WIDTH)/BLOCK_SIZE; //Amount of BLOCKS that will be in the Window/Screen
    int ghostY = 100;
    int ghostX = 100;

    static final int TICKS = 60; //Refresh Rate the game will use to check and call methods

    final int[] x = new int[GAME_BLOCKS];   //Array Holding the Main Character x position value
    final int[] y = new int[GAME_BLOCKS];   //Array Holding the Main Character y position value


    Random random;

    gameLogic(){

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null); // set layout to null for now, other layouts are available we should probably use
        ImageIcon icon = new ImageIcon("src/images/ghost.png");  // Load from images directory "ghost.png"

        JLabel ghostPlayer = new JLabel(icon); // Create a JLabel with the loaded image
        this.add(ghostPlayer); // Add the image to frame

        ghostPlayer.setBounds(ghostX, ghostY, icon.getIconWidth(),icon.getIconHeight()); // getIconHeight and width gets the images width/height
        // setBounds(x, y, width, height) : Sets the images position and size when LAYOUT IS == NULL

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    ghostY -= 5; // Move image up
                    ghostPlayer.setLocation(ghostX,ghostY);
                    revalidate();// Used to recalculate the images layout
                    repaint(); //Re-renders the FRAME
                    System.out.println("PRESSING W"); // Check if key event is working
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    ghostX -= 5; // Move right
                    ghostPlayer.setLocation(ghostX,ghostY);
                    revalidate(); // Used to recalculate the images layout
                    repaint(); // Re-renders the FRAME
                    System.out.println("PRESSING A"); // Check if key event is working
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    ghostY += 5; // Move down
                    ghostPlayer.setLocation(ghostX,ghostY);
                    revalidate(); // Used to recalculate the images layout
                    repaint(); // Re-renders the FRAME
                    System.out.println("PRESSING S"); // Check if key event is working
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    ghostX += 5; // Move right
                    ghostPlayer.setLocation(ghostX,ghostY);
                    revalidate(); // Used to recalculate the images layout
                    repaint(); // Re-renders the FRAME
                    System.out.println("PRESSING D"); // Check if key event is working
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e){

    }

}



class enemyStats {
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;

    public enemyStats (String name, int health, int damage) {
        this.enemyName = name;
        this.enemyHealth = health;
        this.enemyDamage = damage;
    }

    public String getName() {
        return enemyName;
    }

    public int getHealth() {
        return enemyHealth;
    }

    public int getDamage() {
        return enemyDamage;
    }

}

class playerStats {
    private String playerName;
    private int playerHealth;
    private int playerDamage;

    public playerStats (String name, int health, int damage) {
        this.playerName = name;
        this.playerHealth= health;
        this.playerDamage = damage;
    }

    public String getName() {
        return playerName;
    }

    public int getHealth() {
        return playerHealth;
    }

    public int getDamage() {
        return playerDamage;
    }

}

class CombatSystem {

    Scanner scnr = new Scanner(System.in); // System scanner = scnr
    enemyGeneration enemyGen = new enemyGeneration(); // Object enemyGeneration.java
    Player titanPlayer = new playerNormal();
    playerStats playerStats = new playerStats(titanPlayer.playerName(), titanPlayer.playerHealth(), titanPlayer.playerDamage());

    public void startMenu() {
        int userInput;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("\nEnter 1 to start game: ");
                userInput = scnr.nextInt();
                    if (userInput == 1) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid int, try again");
                    }
            } catch (InputMismatchException e) {
                System.out.println("Invalid int, try again");
                scnr.next();
            }
        }

        welcomeMessage(); // Print Welcome Message

    }

    public void welcomeMessage() {
        System.out.println("\nWelcome to an early version of a math-battle game inspired by");

        enemyGen.combatSystem(); // Begin Combat System
    }

    public void combatStart(Enemy randomEnemy) {
        String enemyName = randomEnemy.enemyName();
        int enemyHealth = randomEnemy.enemyHealth(); // Store Randomly picked enemies stats
        int enemyDamage = randomEnemy.enemyDamage();

        enemyHealth -= 50;

        System.out.printf("The %s got hit! Their health is now: %d", enemyName, enemyHealth);
    }

}