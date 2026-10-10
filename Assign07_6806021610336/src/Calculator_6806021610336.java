/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Calculator_6806021610336.java
 */ 

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Calculator_6806021610336 implements ActionListener{

    public static void main(String[] args) {
        new Calculator_6806021610336("cal", 600, 400);
    }
    // เมธอดหลักสำหรับเริ่มต้นโปรแกรม โดยสร้างอินสแตนซ์ของคลาส Calculator_stdid เพื่อแสดงหน้าต่างของเครื่องคิดเลข

    String num = "", operator = "";
    double result = 0;
    JFrame window;
    JButton [] button;
    JTextField textField;
    JPanel panel;
    Container c;
    Font font = new Font("Tahoma", Font.BOLD, 24);
    // ประกาศตัวแปรและกำหนดค่าเริ่มต้นสำหรับเครื่องคิดเลข เช่น ตัวแปรสำหรับเก็บตัวเลขที่กรอกเข้ามา ตัวแปรสำหรับเก็บผลลัพธ์ และตัวแปรสำหรับเก็บตัวดำเนินการ รวมถึงการประกาศส่วนต่าง ๆ ของหน้าต่างและฟอนต์ที่ใช้ในเครื่องคิดเลข

    public Calculator_6806021610336(String title , int width , int height){
        
        window = new JFrame(title);
        window.setSize(width , height);
        c = window.getContentPane();
        c.setLayout(new FlowLayout());
        CreateTextField();
        CreateBtn(new String[] {"1","2","3","/","4","5","6","*","7","8","9","-","0",".","c","+","="});
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    // สร้างหน้าต่างและกำหนดค่าต่าง ๆ รวมถึงเรียกใช้เมธอดในการสร้างส่วนต่าง ๆ ของหน้าต่าง เช่น ส่วนของการแสดงผลและปุ่มต่าง ๆ ของเครื่องคิดเลข
    
    public void CreateBtn(String [] btnname){
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black,1));
        panel.setLayout(new GridLayout(4, 4, 5 , 5));
        panel.setPreferredSize(new Dimension(350, 200));
        button = new JButton[btnname.length];
        for(int i = 0 ; i < btnname.length ; i++){
            button[i] = new JButton(btnname[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
            if (btnname[i].equals("=")) break;
            panel.add(button[i]);
        }
        c.add(panel);
        button[btnname.length - 1].setFont(font);
        button[btnname.length - 1].addActionListener(this);
        button[btnname.length - 1].setPreferredSize(new Dimension(350,50));
        c.add(button[btnname.length - 1]);
    }
    // สร้างปุ่มต่าง ๆ ของเครื่องคิดเลข โดยใช้ลูปในการสร้างปุ่มตามจำนวนที่กำหนดในอาร์เรย์ btnname และเพิ่ม ActionListener ให้กับแต่ละปุ่ม รวมถึงจัดเรียงปุ่มในรูปแบบ GridLayout และเพิ่มปุ่ม "=" ที่มีขนาดใหญ่กว่าปุ่มอื่น ๆ

    public void CreateTextField(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 50));
        panel.setBorder(new LineBorder(Color.black,1));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
        textField = new JTextField(14);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(textField);
        c.add(panel);
    }
    // สร้างส่วนของหน้าต่างสำหรับแสดงผลลัพธ์ของเครื่องคิดเลข โดยใช้ JTextField ที่ไม่สามารถแก้ไขได้และจัดตำแหน่งข้อความให้อยู่ทางขวา

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button[0]){
            num += "1";
            textField.setText(num);
        }
        else if (e.getSource() == button[1]){
            num += "2";
            textField.setText(num);
        }
        else if (e.getSource() == button[2]){
            num += "3";
            textField.setText(num);
        }
        else if (e.getSource() == button[4]){
            num += "4";
            textField.setText(num);
        }
        else if (e.getSource() == button[5]){
            num += "5";
            textField.setText(num);
        }
        else if (e.getSource() == button[6]){
            num += "6";
            textField.setText(num);
        }
        else if (e.getSource() == button[8]){
            num += "7";
            textField.setText(num);
        }
        else if (e.getSource() == button[9]){
            num += "8";
            textField.setText(num);
        }
        else if (e.getSource() == button[10]){
            num += "9";
            textField.setText(num);
        }
        else if (e.getSource() == button[12]){
            num += "0";
            textField.setText(num);
        }
        else if (e.getSource() == button[13]){
            if (!num.contains(".") && !num.equals("")){
                num += ".";
                textField.setText(num);
            }
        }
        else if (e.getSource() == button[3]){
            textField.setText("");
            result = Double.parseDouble(num);
            num = "" ; 
            operator = "/";
        }
        else if (e.getSource() == button[7]){
            textField.setText("");
            result = Double.parseDouble(num);
            num = "" ; 
            operator = "*";
        }
        else if (e.getSource() == button[11]){
            textField.setText("");
            result = Double.parseDouble(num);
            num = "" ; 
            operator = "-";
        }
        else if (e.getSource() == button[15]){
            textField.setText("");
            result = Double.parseDouble(num);
            num = "" ; 
            operator = "+";
        }
        else if (e.getSource() == button[14]){
            textField.setText("");
            num = "";
            textField.setText(num);
        }
        else if (e.getSource() == button[16]){
            calculate(result, Double.parseDouble(num), operator);
            textField.setText(Double.toString(calculate(result, Double.parseDouble(num), operator)));
            num = "";
            result = 0;
        }
    }
    // เมธอดสำหรับจัดการกับเหตุการณ์ที่เกิดขึ้นเมื่อมีการคลิกปุ่มต่าง ๆ ของเครื่องคิดเลข โดยตรวจสอบว่าปุ่มที่ถูกคลิกคือปุ่มใดและดำเนินการตามนั้น เช่น การกรอกตัวเลข การเลือกตัวดำเนินการ หรือการล้างข้อมูล

    public double calculate(double num1, double num2, String operator){
        if (operator.equals("/")){
            return num1 / num2;
        }
        else if (operator.equals("*")){
            return num1 * num2;
        }
        else if (operator.equals("-")){
            return num1 - num2;
        }
        else if (operator.equals("+")){
            return num1 + num2;
        }
        return 0;
    }
    // เมธอดสำหรับคำนวณผลลัพธ์ของเครื่องคิดเลข โดยรับตัวเลขสองตัวและตัวดำเนินการเป็นพารามิเตอร์ และคืนค่าผลลัพธ์ตามตัวดำเนินการที่เลือก

}
