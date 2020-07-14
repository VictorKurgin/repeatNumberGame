import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameLogic implements ActionListener {
    JFrame frame;
    static int targetNumber = (int) (Math.random()*100_000_000 + 10000000);
    static ArrayList<Integer> inputNumber;
    private int goal;
    NumbersPanel numbersPanel;

    public GameLogic(MyFrame frame, NumbersPanel numbersPanel){
        this.frame = frame;
        inputNumber = new ArrayList<>();
        this.numbersPanel = numbersPanel;
    }

    public static int getTargetNumber(){
        return targetNumber;
    }
    public void setGoal(){
        for(int i = 0; i < inputNumber.size(); i++ ){
            goal = goal * 10 + inputNumber.get(i);
        }
    }

    public void clearInputNumber(){
        NumbersPanel.inputNumberField.setText("Ваше число: ");
        inputNumber.clear();
        goal = 0;
    }
    public void clearLastNumber(){
        if(inputNumber.size()<1) return;
        inputNumber.remove(inputNumber.size()-1);
        NumbersPanel.inputNumberField.setText("Ваше число: " + arrayToString(inputNumber));
    }
    public String arrayToString(ArrayList<Integer> array){
        String str = "";
        for (Integer i : array){ str += i; }
        return str;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        setGoal();
        UIManager.put("OptionPane.yesButtonText", "выйти из игры");
        UIManager.put("OptionPane.noButtonText", "повторить игру");
        if (goal == targetNumber) {
            int result = JOptionPane.showConfirmDialog(frame, "Поздравляем, Вы победили!!!\nВыберите дальнейшие действия", "You win!!!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.YES_OPTION) System.exit(0);
            if (result == JOptionPane.NO_OPTION) {
                targetNumber = (int) (Math.random()*100_000_000 + 10000000);
                numbersPanel.textField.setText("Введите это число: " + targetNumber);
                clearInputNumber();
            }
        } else {
            int result = JOptionPane.showConfirmDialog(frame, "Вы проиграли, число составлено не верно.\nХотите продолжить игру?", "неверно", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) clearInputNumber();
            if(result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
}