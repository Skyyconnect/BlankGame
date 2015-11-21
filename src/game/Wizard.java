package game;

public class Wizard extends Sprite {

    private final int INITIAL_X = 400;

    public Wizard(int x, int y) {
        super(x, y);

        Wizard();
    }

    private void Wizard() {

        loadImage("src/res/Wizard.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}