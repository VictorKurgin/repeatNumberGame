import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setTitle("Повтори число");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            for(int i = 0;i<frame.ballsPanel.balls.length; i++){
                new Thread(frame.ballsPanel.balls[i], String.valueOf(i)).start();
            }
        });
    }
}