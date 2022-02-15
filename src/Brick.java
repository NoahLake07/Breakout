import acm.graphics.GRect;

import java.awt.Color;

import static java.awt.Color.blue;

public class Brick extends GRect {

    public int brickLives;
    public int myRow;

    public Color blue3 = new Color(26, 158, 255);
    public Color blue2 = new Color(10, 112, 183);
    public Color blue1 = new Color(7, 86, 138);

    public Color green3 = new Color(0, 176, 15);
    public Color green2 = new Color(4, 140, 20);
    public Color green1 = new Color(2, 107, 15);

    public Color purple3 = new Color(126, 5, 189);
    public Color purple2 = new Color(105, 2, 154);
    public Color purple1 = new Color(95, 3, 136);

    public Color red3 = new Color(222, 0, 0);
    public Color red2 = new Color(168, 2, 2);
    public Color red1 = new Color(133, 1, 1);

    public Color yellow3 = new Color(255, 212, 0);
    public Color yellow2 = new Color(187, 153, 4);
    public Color yellow1 = new Color(143, 120, 0);

    public static final int WIDTH = 44;
    public static final int HEIGHT = 20;

    public Brick(double x, double y, int row) {
        super(x, y, WIDTH, HEIGHT);

        setFilled(true);

        if (row == 0 || row == 1) {
            this.brickLives = 0;
            setFillColor(blue3);

        } else if (row == 3 || row == 4) {
            this.brickLives = 1;
            setFillColor(green3);

        } else if (row == 5 || row == 6) {
            this.brickLives = 1;
           setFillColor(yellow3);

        } else if (row == 7 || row == 8) {
            this.brickLives = 2;
            setFillColor(purple3);

        }else if(row == 2 || row == 3) {
            this.brickLives = 0;
            setFillColor(red3);

        }
    }

    public void brickHit() {
        loseBrickLife(this.brickLives);
    }

    private void loseBrickLife(int myRow) {
        this.brickLives = this.brickLives - 1;
    }

    private void setCustomFill() {

        this.setFilled(true);

        this.setFillColor(blue3);

    }

}
