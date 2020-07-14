import javax.swing.*;
import java.awt.*;

class NumbersPanel extends JPanel {
    public JLabel textField;
    static JLabel inputNumberField = new JLabel("Ваше число: ");
    public NumbersPanel(){
        textField = new JLabel("Введите это число: " + GameLogic.getTargetNumber() + "   ");
        textField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        inputNumberField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        add(textField);
        add(inputNumberField);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
    }
}