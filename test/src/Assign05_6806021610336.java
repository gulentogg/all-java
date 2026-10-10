/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign05_6806021610336.java
 */ 
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Assign05_6806021610336 {
    static double[] reportdatas = new double[12];
    static double[] percent = new double[12];
    static double total = 0;
    public static void main(String[] args) {
        mainProgram();
    }

    public static void mainProgram(){
        String menu = "Menu Sale Report\n" +
                      "-----------------------\n"+
                      "1. Generate Sale\n" +
                      "2. Report Sale\n" +
                      "3. Exit\n" +
                      "Enter choice:";
        while(true){
            String input = JOptionPane.showInputDialog(null,menu,"Input",JOptionPane.QUESTION_MESSAGE);
            if (input.equals("1")){
                gensale(reportdatas);
                JOptionPane.showMessageDialog(null, "Generate sale finish.","Message",JOptionPane.INFORMATION_MESSAGE);
            }
            else if (input.equals("2")) reportsale(reportdatas);
            else if (input.equals("3")) break;
            else JOptionPane.showMessageDialog(null, "No choice.");
        }
        JOptionPane.showMessageDialog(null, "Exit program.");
    }

    public static void gensale(double [] datas){
        total = 0;
        Random rnd = new Random();
        for (int i = 0; i < datas.length; i ++){
            datas[i] = 100000 + rnd.nextDouble(800000);
            total += datas[i];
        }
        for (int i = 0; i < datas.length; i ++){
            reportdatas[i] = datas[i];
            percent[i] = (datas[i] / total) * 100;
        }

    }

    public static void reportsale(double [] datas){
        JTextArea area = new JTextArea();
        double ptotal = 0;
        DecimalFormat df = new DecimalFormat(".00");
        String output = ("NO.") + "\t" + ("Sales") + "\t" + ("Percent") + "\n";
        output += "===============================\n";
        for (int i = 0; i < datas.length; i++) {
            output += (i+1) + "\t" + (df.format(datas[i])) + "\t" + (df.format(percent[i])) + "\n";
            ptotal += percent[i];
        }
        output += "===============================\n";
        output += ("Total") + "\t" + (df.format(total)) + "\t" + (df.format(ptotal));
        area.setText(output);
        JOptionPane.showMessageDialog(null, area );
    }
}
