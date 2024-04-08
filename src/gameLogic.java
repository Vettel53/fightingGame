import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.Timer;

public class GameLogic extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 800; // Screen resolution Width ex: 1920x1080p tihs would be the 1920
    static final int SCREEN_HEIGHT = 600;// Screen resolution Heigh ex: 1920x1080p tihs would be the 1080

    static final int BLOCK_SIZE = 30; // Size of the UNIT/BLOCKS

    static final int GAME_BLOCKS = (SCREEN_HEIGHT * SCREEN_WIDTH) / BLOCK_SIZE; // Amount of BLOCKS that will be in the
                                                                                // Window/Screen
    int ghostY = 0;
    int ghostX = 0;

    static final int TICKS = 60; // Refresh Rate the game will use to check and call methods

    final int[] x = new int[GAME_BLOCKS]; // Array Holding the Main Character x position value
    final int[] y = new int[GAME_BLOCKS]; // Array Holding the Main Character y position value

    Boolean running = false; //This bool serving as a check for if the game is running will be set to true upon start method 
    Timer timer;
    Random random;

    int scene = 0; //This is important// This variable will serve as the indicator as to what level/scene you are on so the main menu = 0 , level1 = 1, level2 = 2 ...

    int interaction = -1; // Temporary but using this as a variable for storing certain key states -1 = nothing , 0 = Escape Ksey , 1 Enter Key 
    JLabel ghostPlayer; //Declared this here Cause it had to be in a global scope for the handleKey Press functions
    

    GameLogic(){

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null); // set layout to null for now, other layouts are available we should probably use
        ImageIcon icon = new ImageIcon("src/images/ghostRe.png");  // Load from images directory "ghost.png"

        ghostPlayer = new JLabel(icon); // Create a JLabel with the loaded image
        this.add(ghostPlayer); // Add the image to frame

        ghostPlayer.setBounds(ghostX, ghostY, icon.getIconWidth(),icon.getIconHeight()); // getIconHeight and width gets the images width/height
        // setBounds(x, y, width, height) : Sets the images position and size when LAYOUT IS == NULL


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {  
                handleKeyPress(e.getKeyCode()); //Calls this method for the key presses (Just more organized)
            }
        });
        start();
    }

    public void start() {
        mainMenu();
        running = true;
        timer = new Timer(TICKS,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {  //This method just sets up the Graphics/paint stuff mainly the g variable so we can use stuff like g.setColor("RED");
        super.paintComponent(g);
        render(g);
    }

    public void handleKeyPress(int keyCode) { // Made this method to store the keypresses also made it switch instead of if statements
        switch (keyCode) {
            case KeyEvent.VK_W:
                ghostY -= BLOCK_SIZE; // Move image up
                ghostPlayer.setLocation(ghostX,ghostY);
                revalidate();// Used to recalculate the images layout
                repaint(); // Re-renders the FRAME
                System.out.println("PRESSING W"); // Check if key event is working
                break;
            case KeyEvent.VK_A:
                ghostX -= BLOCK_SIZE; // Move Left
                ghostPlayer.setLocation(ghostX,ghostY);
                revalidate(); // Used to recalculate the images layout
                repaint(); // Re-renders the FRAME
                System.out.println("PRESSING A"); // Check if key event is working
                break;
            case KeyEvent.VK_S:
                ghostY += BLOCK_SIZE; // Move Down
                ghostPlayer.setLocation(ghostX,ghostY);
                revalidate(); // Used to recalculate the images layout
                repaint(); // Re-renders the FRAME
                System.out.println("PRESSING S"); // Check if key event is working
                break;
            case KeyEvent.VK_D:
                ghostX += BLOCK_SIZE; // Move right
                ghostPlayer.setLocation(ghostX,ghostY);
                revalidate(); // Used to recalculate the images layout
                repaint(); // Re-renders the FRAME
                System.out.println("PRESSING D"); // Check if key event is working
                break;
            case KeyEvent.VK_ENTER:
                interaction = 1; 
                repaint();
                System.out.println("PRESSING ENTER");
                break;
            case KeyEvent.VK_ESCAPE:
                interaction = 0;
                repaint();
                System.out.println("PRESSING ESCAPE");
                break;
        }
        repaint();
    }

    public void render(Graphics g) {  //This method will be where the rendering of new levels/stages will be and it will ideally call a function for each levels logic.
        if (running) {
            switch (scene) {
                case 0: // Case 0 is just the main menu screen
                    ImageIcon menuIcon = new ImageIcon("src/images/MainMenu.png");
                    Image menuImage = menuIcon.getImage();

                    g.drawImage(menuImage, 0, 0, this.getWidth(), this.getHeight(), this); // This sets the Main Menu Background Image 
                    mainMenu();// Calls the mainMenu(); method for logic
                    break;

                case 1: // Case 1 will be Level 1 and should have a levelOne(); method
                    this.setBackground(Color.BLUE);
                    break;

            }

        }
    }

    public void mainMenu() { // Main Menu Logic Method

        if (interaction == 1) { // If entered is Pressed it starts game
            System.out.println("Start Initiated");
            interaction = -1;
            scene = 1;
            repaint();
        }
        if (interaction == 0) { //If Escape is Pressed exits with System.exit(0);
            System.out.println("Exit Initiated");
            System.exit(0);
        }
    }
    

    

    public void actionPerformed(ActionEvent e) { // This function will just have rapid events occuring in the background like if we wanted a random moving objects etc
        if (running) {
            
        }
        repaint();
    }

}

class enemyStats {
    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;

    public enemyStats(String name, int health, int damage) {
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

    public playerStats(String name, int health, int damage) {
        this.playerName = name;
        this.playerHealth = health;
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
    playerStats playerStats = new playerStats(titanPlayer.playerName(), titanPlayer.playerHealth(),
            titanPlayer.playerDamage());

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