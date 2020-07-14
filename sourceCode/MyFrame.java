import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    static int WIDTH = 800;
    static int HEIGHT = 600;
    JButton sendNumberButton;
    public NumbersPanel numbersPanel = new NumbersPanel();
    GameLogic gameLogic = new GameLogic(this, numbersPanel);
    public JButton deleteButton = new JButton("Удалить последнюю цифру");
    public JButton deleteAllButton = new JButton("Очистить ваше число");
    public JPanel buttonsPanel = new JPanel();
    BallsPanel ballsPanel;

    public MyFrame(){
        super();
        this.setSize(WIDTH, HEIGHT);
        sendNumberButton = new JButton("<html>подтвердить" + "<br>число<br>");
        sendNumberButton.setFont(new Font(Font.SERIF, Font.PLAIN, 17));
        sendNumberButton.setFocusPainted(false);
        sendNumberButton.setPreferredSize(new Dimension(140, HEIGHT));
        sendNumberButton.addActionListener(gameLogic);
        add(sendNumberButton, BorderLayout.EAST);

        deleteButton.setPreferredSize(new Dimension(getWidth()/2-15,45));
        deleteButton.addActionListener(event -> {
            gameLogic.clearLastNumber();
        });

        deleteAllButton.setPreferredSize(new Dimension(getWidth()/2-15, 45));
        deleteAllButton.addActionListener(event -> {
            gameLogic.clearInputNumber();
        });

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 5));
        buttonsPanel.add(deleteAllButton);
        buttonsPanel.add(deleteButton);

        numbersPanel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        add(numbersPanel, BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.SOUTH);
        ballsPanel = new BallsPanel();
        add(ballsPanel);
    }
}