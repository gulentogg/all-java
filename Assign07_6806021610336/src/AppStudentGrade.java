/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign06_6806021610336.java
 */ 

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class AppStudentGrade extends Student implements ActionListener {

    JFrame window;
    JScrollPane scrollPane;
    JTextArea textArea;
    Container c;
    JPanel panel , subpanel;
    JButton [] btn;
    JTextField [] TextField;
    JLabel [] label;
    int ButtonCount = 2;
    Font font = new Font("Tahoma", Font.BOLD, 20);
    Color fontColor = Color.BLUE;
    String filename = "Assign07_6806021610336/Student.txt";
    String [] text = {"Enter ID   :  ", "Enter Name   :  ", "Enter Surname   :  ", "Enter Score   :  "};
    // ประกาศตัวแปรและกำหนดค่าเริ่มต้น

    public AppStudentGrade(){
        btn = new JButton[ButtonCount];
        window = new JFrame("Application Student { By ID: 6806021610336 }");
        window.setLocation(200, 200);
        window.setSize(750, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = window.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        CreateEnterField();
        CreateShowField();
        window.setVisible(true);
    }
    // สร้างหน้าต่างและกำหนดค่าต่าง ๆ รวมถึงเรียกใช้เมธอดในการสร้างส่วนต่าง ๆ ของหน้าต่าง

    public void CreateEnterField(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(550, 200));
        panel.setBorder(new LineBorder(Color.RED,1));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(CreateInputField(text));
        panel.add(CreateBtn("Save  Data", 0));
        c.add(panel);
    }
    // สร้างส่วนของหน้าต่างสำหรับกรอกข้อมูลนักเรียนและปุ่มบันทึกข้อมูล

    public void CreateShowField(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,420));
        panel.setBorder(new LineBorder(Color.BLACK,1));
        subpanel = new JPanel();
        subpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
        subpanel.setPreferredSize(new Dimension(500, 50));
        label[0] = new JLabel("Data from  File  :  ");
        label[0].setFont(font);
        subpanel.add(label[0]);
        subpanel.add(CreateBtn("Read  File",1));
        textArea = new JTextArea(13, 30);
        scrollPane = new JScrollPane(textArea);
        textArea.setFont(font);
        textArea.setForeground(fontColor);
        textArea.setEditable(false);
        panel.add(subpanel);
        panel.add(scrollPane);
        c.add(panel);
    }
    // สร้างส่วนของหน้าต่างสำหรับแสดงข้อมูลที่อ่านจากไฟล์และปุ่มสำหรับอ่านข้อมูลจากไฟล์

    public JButton CreateBtn(String btnname , int action){
        btn[action] = new JButton(btnname);
        btn[action].setFont(font);
        btn[action].setPreferredSize(new Dimension(200, 40));
        btn[action].addActionListener(this);
        return btn[action];
    }
    // สร้างปุ่มและกำหนดค่าต่าง ๆ รวมถึงเพิ่ม ActionListener ให้กับปุ่ม

    public JPanel CreateInputField(String [] Text){
        subpanel = new JPanel();
        subpanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        subpanel.setPreferredSize(new Dimension(500, 140));
        TextField = new JTextField[Text.length];
        label = new JLabel[Text.length];
        for (int i = 0 ; i < Text.length ; i++){
            label[i] = new JLabel(Text[i]);
            label[i].setFont(font);
            TextField[i] = new JTextField(12);
            TextField[i].setFont(font);
            TextField[i].addActionListener(this);
            subpanel.add(label[i]);
            subpanel.add(TextField[i]);
        }
        return subpanel;
    }
    // สร้างส่วนของหน้าต่างสำหรับกรอกข้อมูลนักเรียน โดยมีการสร้าง JLabel และ JTextField ตามจำนวนที่กำหนดในอาร์เรย์ Text

    public void save(){
        try{
            FileWriter out = new FileWriter(filename, true);
            BufferedWriter write = new BufferedWriter(out);
            write.write("Data Student : " + super.toString() + "\n");
            write.close();
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Error saving data.","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    // เมธอดสำหรับบันทึกข้อมูลนักเรียนลงในไฟล์ โดยใช้ FileWriter และ BufferedWriter เพื่อเขียนข้อมูลลงในไฟล์

    public void read(){
        try{
            FileReader in = new FileReader(filename);
            BufferedReader read = new BufferedReader(in);
            String Line;
            while((Line = read.readLine()) != null){
                textArea.append(Line + "\n");
            }
            read.close();
            in.close();
            JOptionPane.showMessageDialog(window, "Read Data Already.","Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, "Error reading data.","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    // เมธอดสำหรับอ่านข้อมูลจากไฟล์ โดยใช้ FileReader และ BufferedReader เพื่ออ่านข้อมูลจากไฟล์และแสดงใน JTextArea

    public boolean checkvalue(){
        for (int i = 0 ; i < TextField.length ; i ++){
            if (TextField[i].getText().isEmpty()) return false;
        }
        for (char ch : TextField[0].getText().toCharArray()){
            if (!Character.isDigit(ch)) return false;
        }
        for (char ch : TextField[1].getText().toCharArray()){
            if (!Character.isLetter(ch)) return false;
        }
        for (char ch : TextField[2].getText().toCharArray()){
            if (!Character.isLetter(ch)) return false;
        }
        for (char ch : TextField[3].getText().toCharArray()){
            if (!Character.isDigit(ch)) return false;
            else if (Integer.parseInt(TextField[3].getText()) < 0 || Integer.parseInt(TextField[3].getText()) > 100) return false;
        }
        return true;
    }
    // เมธอดสำหรับตรวจสอบความถูกต้องของข้อมูลที่กรอกใน JTextField โดยตรวจสอบว่าไม่เป็นค่าว่างและมีรูปแบบที่ถูกต้องตามที่กำหนด

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0] && checkvalue()) {
            super.setId(TextField[0].getText());
            super.setName(TextField[1].getText());
            super.setSurname(TextField[2].getText());
            super.setScore(Integer.parseInt(TextField[3].getText()));
            save();
            JOptionPane.showMessageDialog(null, "Save Already.","Message", JOptionPane.INFORMATION_MESSAGE);
            for (int i = 0 ; i < TextField.length ; i++){
                TextField[i].setText("");
            }
        }
        else if (e.getSource() == btn[1]) {
            textArea.setText("");
            read();
        }
        else JOptionPane.showMessageDialog(null, "Please Enter this format : \nID : Only Number \nName : Only Letter \nSurname : Only Letter \nScore : Only Number (0-100)","Error Message", JOptionPane.ERROR_MESSAGE);
    }
    // เมธอดสำหรับจัดการกับเหตุการณ์ที่เกิดขึ้นเมื่อมีการคลิกปุ่ม โดยตรวจสอบว่าปุ่มที่ถูกคลิกคือปุ่มบันทึกข้อมูลหรือปุ่มอ่านข้อมูล และดำเนินการตามนั้น
}