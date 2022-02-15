import acm.graphics.GOval;
import acm.graphics.GCanvas;

public class Ball extends GOval {

    private double deltaX = 1;
    private double deltaY = -1;
    public GCanvas screen;
    public boolean lost = false;

    public Ball(double x, double y, double size, GCanvas screen){

        super(x,y,size,size);
        setFilled(true);

        this.screen = screen;

    }

    public void handleMove(){
        //move the ball
        move(deltaX,deltaY*-1);

        //check to see if the ball is too high
        if (getY()<=0){
            deltaY *= -1;
        }

        //check to see if the ball is too low
        if(getY()>=screen.getHeight()-getHeight()){
            //set the lost flag
            lost = true;
            deltaX = 1;
            deltaY = -1;
        }

        //check to see if the ball hits the left side
        if(getX()<=0){
            //start moving right
            deltaX *= -1;
        }

        //check to see if the ball hits the right side
        if(getX()>=screen.getWidth()-getWidth()){
            //move to the left
            deltaX *= -1;
        }

    }

    public void bounce(){

        deltaY *= -1;

    }

    public void bounceLeft(){
        deltaY *= -1;
        deltaX = -Math.abs(deltaX);
    }

    public void bounceRight(){
        deltaY *= -1;
        deltaX = Math.abs(deltaX);
    }

}
