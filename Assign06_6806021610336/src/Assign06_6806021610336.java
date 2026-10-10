/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign06_6806021610336.java
 */ 

import java.awt.Font;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Assign06_6806021610336 {
    score sc = new score();
    double[] point = new double[3];
    public static void main(String[] args) throws Exception {
        Assign06_6806021610336 app = new Assign06_6806021610336();
        app.mainProgram();
    }
    public void mainProgram() {
        while (true) {
            String input = JOptionPane.showInputDialog(null,"Enter number student (0-exit)","Input",JOptionPane.INFORMATION_MESSAGE);
            if (checkvalue(input)){
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 20) report(num);
                else if (num == 0){
                    JOptionPane.showMessageDialog(null, "Exit Program.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    break;
                } 
                else JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 20.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            else
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void genScore() {
        Random rand = new Random();
        sc = new score(rand.nextDouble(30), rand.nextDouble(40), rand.nextDouble(30));
        point[0] = sc.GetMid();
        point[1] = sc.GetFinal();
        point[2] = sc.GetHomework();    
    }

    public boolean checkvalue(String value){
        String temp = value;
        if (temp.isEmpty()) return false;
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void report(int num) {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%-10s %-12s %-10s %-13s %-10s %-10s\n", "No.", "Midterm", "Final", "Homework", "Total", "Grade"));
        for (int head = 0; head < 65; head++) report.append("=");
        report.append("\n");
        for (int i = 0; i < num; i++) {
            genScore();
            report.append(String.format("%-12d %-12.0f %-10.0f %-13.0f %-10.0f %-10s\n", i + 1, point[0], point[1], point[2], sc.toSum(), sc.toGrade()));
        }
        JTextArea textArea = new JTextArea(report.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); 
        textArea.setMargin(new Insets(10, 10, 10, 10)); 
        JOptionPane.showMessageDialog(null, textArea, "Report", JOptionPane.INFORMATION_MESSAGE);
    }
}

