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

    static final int TICKS = 60; //Refresh Rate the game will use to check and call methods

    final int[] x = new int[GAME_BLOCKS];   //Array Holding the Main Character x position value
    final int[] y = new int[GAME_BLOCKS];   //Array Holding the Main Character y position value


    Random random;

    gameLogic(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        //this.addKeyListener(new MyKeyAdapter()); this needs to be implemented still
        startGame();
    }

    public void startGame(){

    }





    public void actionPerformed(ActionEvent e){
        /*if(running){
            checkMovement();
            checkEnemy();
            checkWall();            These are juse placeholder function names for functions that will be called every time the game is refreshed/tick so it will be checking if you moved and 
            checkRoom();            then edit the x,y values of the character then call the repaint(); so that it updates the screen to move your character.
        }
        repaint();
    */}

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