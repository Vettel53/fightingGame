import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class gameLogic implements KeyListener {
    static final double FPS = 60.0; //Refresh Rate the game will use to check and call methods
    Thread gameThread;
    Random random;
    private Set<Integer> pressedKeys = new HashSet<>(); // Store key presses for movement etc.

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        pressedKeys.add(keycode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
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