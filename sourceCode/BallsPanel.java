import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class BallsPanel extends JPanel {
    static Ball[] balls;
    public BallsPanel(){
        balls = new Ball[10];
        for(int i = 0;i<balls.length; i++){
            balls[i] = new Ball(i, this);
        }
        addMouseListener(new MouseHandler());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        for(Ball ball : balls){
            g2.draw(ball.getShape());
            g2.drawString(Integer.toString(ball.getNum()), (ball.getpX()+15), (ball.getpY()+28));
        }
    }
    public Ball find (Point2D p){
        for(Ball ball : balls){
            if(ball.getShape().contains(p)) return ball;
        }
        return null;
    }

    private class MouseHandler extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            Ball current = find(event.getPoint());

            if(find(event.getPoint()) != null) {
                GameLogic.inputNumber.add(current.getNum());
                NumbersPanel.inputNumberField.setText(NumbersPanel.inputNumberField.getText()+current.getNum());
            }
        }
    }
}