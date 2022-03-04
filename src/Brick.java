import acm.graphics.GRect;
import acm.util.RandomGenerator;

import java.awt.Color;

import static java.awt.Color.blue;

public class Brick extends GRect {

    //initialize the basic brick information
    public int brickLives;
    public int myRow;
    public int myPowerUp;

    //initialize custom colors for bricks
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

    //initialize the brick dimensions
    public static final int WIDTH = 44;
    public static final int HEIGHT = 20;

    /*

    POWER-UP ASSIGNMENTS:
    1- Paddle goes big
    2- Summons another ball
    3- Gives one more life

    POWER-UP PROBABILITY:
    1- 7%
    2- 10%
    3- 3%

    BRICK RATIO: 5% of all bricks will be power-up-bricks

     */

    public Brick(double x, double y, int row) {
        super(x, y, WIDTH, HEIGHT);

        //sets up the default fill
        setFilled(true);
        setFillColor(Color.RED);

        //setting up default lives
        this.brickLives = 0;

        //is this brick a power-up-brick?
        int powerUpProb = RandomGenerator.getInstance().nextInt(0-100);
        if(powerUpProb < 7){
            //this brick is a power-up-brick.
            //what type of power-up?
            int typeOfPWRUP = RandomGenerator.getInstance().nextInt(0-100);
            if(typeOfPWRUP >= 7){
                this.myPowerUp = 1;
            }else if(typeOfPWRUP >= 30 && typeOfPWRUP >=40){
                this.myPowerUp = 2;
            }else if(typeOfPWRUP >= 97 && typeOfPWRUP >=100){
                this.myPowerUp = 3;
            }
        }

        //setting up brick based off of what row it was assigned to
        if (row == 9 || row == 10 || row == 11) {

            this.brickLives = 0;
            setFillColor(blue3);

        } else if (row == 7 || row == 8) {

            this.brickLives = 1;
            setFillColor(green3);

        } else if (row == 5 || row == 6) {

            this.brickLives = 1;
            setFillColor(yellow3);

        } else if (row == 3 || row == 4) {

            this.brickLives = 2;
            setFillColor(purple3);

        }else if(row == 0 || row == 1 || row == 2) {

            this.brickLives = 2;
            setFillColor(red3);

        }
        myRow = row;
    }

    public void brickHit() {
        loseBrickLife(this.myRow);
    }

    public void loseBrickLife(int myRow) {

        System.out.println("Hit a " + getColor() + "brick.");

        this.brickLives = this.brickLives - 1;


        if(this.brickLives == 0) {

            if (myRow == 9 || myRow == 10 || myRow == 11) {
                setFillColor(blue2);
            } else if (myRow == 7 || myRow == 8) {
                setFillColor(green2);
            } else if (myRow == 5 || myRow == 6) {
                setFillColor(yellow2);
            } else if (myRow == 3 || myRow == 4) {
                setFillColor(purple2);
            } else if (myRow == 0 || myRow == 1 || myRow == 2) {
                setFillColor(red2);
            }
        }else if(this.brickLives == 1){
            if (myRow == 9 || myRow == 10 || myRow == 11) {
                setFillColor(blue1);
            } else if (myRow == 7 || myRow == 8) {
                setFillColor(green1);
            } else if (myRow == 5 || myRow == 6) {
                setFillColor(yellow1);
            } else if (myRow == 3 || myRow == 4) {
                setFillColor(purple1);
            } else if (myRow == 0 || myRow == 1 || myRow == 2) {
                setFillColor(red1);
            }
        }

    }

    private void setCustomFill() {

        this.setFilled(true);

        this.setFillColor(blue3);

    }

}
