abstract class Player {
    public abstract String playerName();
    public abstract int playerHealth();
    public abstract int playerDamage();
}

class playerNormal extends Player {
    public String playerName() {
        return "Titan";
    }

    public int playerHealth() {
        return 200;
    }

    public int playerDamage() {
        return 50;
    }

}