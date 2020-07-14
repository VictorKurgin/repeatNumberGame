import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class Ball implements Runnable{
    static final int DIAMETER = 40;
    private int dX = 1;
    private int dY = 1;
    private int pX = (int) (Math.random()*500 + 10);
    private int pY = (int) (Math.random()*500 + 10);
    private int num;
    JComponent component;

    public Ball(int number, JComponent component){
        num = number;
        this.component = component;
    }

    public Ellipse2D.Double getShape(){
        return new Ellipse2D.Double(pX, pY, DIAMETER, DIAMETER);
    }

    public int getNum() {
        return num;
    }

    public int getpX() {
        return pX;
    }

    public int getpY() {
        return pY;
    }

    public void run(){
        while(true){
            move(BallsPanel.balls);
        }
    }
    public void move(Ball[] balls) {
        pX += dX;
        pY += dY;
        if (pX+DIAMETER >= component.getWidth()) {
            dX *= -1;
            pX = (component.getWidth() - (DIAMETER +1));
        }
        if(pX < 1){
            pX = 1;
            dX *= -1;
        }
        if (pY >= (component.getHeight() - DIAMETER)) {
            dY *= -1;
            pY = (component.getHeight() - (DIAMETER +1));
        }
        if(pY < 1){
            dY *= -1;
            pY = 1;
        }
        for (int j = 0; j < balls.length; j++) {
            if (num != j) {
                if( (Math.abs(pX - balls[j].pX) < DIAMETER ) && (Math.abs(pY - balls[j].pY) < DIAMETER) ){
                    while(getShape().intersects(balls[j].getpX(), balls[j].getpY(), balls[j].DIAMETER, balls[j].DIAMETER)) {
                        dX *= -1;
                        dY *= -1;
                        pX += dX;
                        pY += dY;
                        if (dX == balls[j].dX) balls[j].dX *= -1;
                        if (dY == balls[j].dY) balls[j].dY *= -1;
                        balls[j].pX += balls[j].dX;
                        balls[j].pY += balls[j].dY;
                    }
                }
            }
        }
        component.repaint();
        try {
            Thread.sleep(9);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
