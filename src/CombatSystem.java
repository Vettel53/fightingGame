import java.util.*;

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

//class enemyStats {
//    private String enemyName;
//    private int enemyHealth;
//    private int enemyDamage;
//
//    public enemyStats (String name, int health, int damage) {
//        this.enemyName = name;
//        this.enemyHealth = health;
//        this.enemyDamage = damage;
//    }
//
//    public String getName() {
//        return enemyName;
//    }
//
//    public int getHealth() {
//        return enemyHealth;
//    }
//
//    public int getDamage() {
//        return enemyDamage;
//    }
//
//}

public class CombatSystem {

    Scanner scnr = new Scanner(System.in);

    enemyStats ralphStats = new enemyStats("Ralph", 200, 50);

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

        System.out.println(" ____  _____ ____ _____ ___ _   ___   __  ____");
        System.out.println("|  _ \\| ____/ ___|_   _|_ _| \\ | \\ \\ / / |___ \\");
        System.out.println("| | | |  _| \\___ \\ | |  | ||  \\| |\\ V /    __) |");
        System.out.println("| |_| | |___ ___) || |  | || |\\  | | |    / __/");
        System.out.println("|____/|_____|____/ |_| |___|_| \\_| |_|   |_____|");
    }

    public void combatStart() {

        String enemyName = ralphStats.getName();
        int enemyHealth = ralphStats.getHealth();
        int enemyDamage = ralphStats.getDamage();

        //string playerName =

    }

}
