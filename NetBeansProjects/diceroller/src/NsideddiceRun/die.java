package NsideddiceRun;

import java.util.Random;

public class die {

    /*
    roll
    getvalue
    getside
    setsides
     */
    private int sides;
    private int value;
    private Random generator;

    public die(int sides) {
        this.sides = sides;
        generator = new Random();
        this.value = this.roll();
    }

    public die(int sides, int seed) {
        this.sides = sides;
        this.generator = new Random(seed);
    }

    public int roll() {
        this.value = this.generator.nextInt(this.sides) + 1;
        return this.value;
    }

    public int getvalue() {
        return this.value;
    }
//getters and setters make the properts accessable by others.

    public int getsides() {
        return this.sides;
    }

    public void setsides(int sides) {
        this.sides = sides;

    }
}
