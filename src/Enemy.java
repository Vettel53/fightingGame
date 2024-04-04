abstract class Enemy {
    public abstract String enemyName();

    public abstract int enemyHealth();

    public abstract int enemyDamage();

}

class Ralph extends Enemy {
    public String enemyName() {
        return "Ralph";
    }

    public int enemyHealth() {
        return 200;
    }

    public int enemyDamage() {
        return 50;
    }
}