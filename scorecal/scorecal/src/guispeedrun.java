import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guispeedrun implements ActionListener{

    public static void main(String[] args) {
        new guispeedrun();
    }

    String title = "Grade App Std ID : 6806021610336";
    String[] labeltext = { "Enter ID : ", "Enter Homework Score : ", "Enter Midterm Score : ", "Enter Final Score : " };
    String[] buttontext = { "Calculate", "cancel" };
    String[] radiotext = { "Open All", "Open Grade", "Open ID" };

    JFrame window;
    JPanel panel;
    JButton[] btn = new JButton[buttontext.length];
    JLabel[] label = new JLabel[labeltext.length];
    JTextField[] textFields = new JTextField[labeltext.length];
    JTextArea textArea;
    JScrollPane sc;
    Container c;
    JRadioButton[] radioButtons = new JRadioButton[radiotext.length];
    JComboBox [] comboBox;

    public guispeedrun() {
        window = new JFrame(title);
        window.setSize(500, 500);
        window.setLocation(200, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = window.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        c.add(createInputPanel(labeltext.length));
        c.add(createbtn(buttontext.length));
        c.add(createRadiobutton(radiotext.length));
        c.add(createComboBox(new String[] {"ID", "Grade", "Total"}));
        c.add(createArea());
        window.setVisible(true);
    }

    public JPanel createInputPanel(int HowMuchLabelYouWant) {
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.red, 1));
        panel.setPreferredSize(new Dimension(400, 130));
        panel.setLayout(new FlowLayout());
        for (int i = 0; i < HowMuchLabelYouWant; i++) {
            label[i] = new JLabel(labeltext[i]);
            label[i].setPreferredSize(new Dimension(150, 25));
            textFields[i] = new JTextField();
            textFields[i].setPreferredSize(new Dimension(200, 20));
            panel.add(label[i]);
            panel.add(textFields[i]);
        }
        return panel;
    }

    public JPanel createbtn(int HowMuchButtonYouWant) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(400, 40));
        panel.setBorder(new LineBorder(Color.red, 1));
        for (int i = 0; i < HowMuchButtonYouWant; i++) {
            btn[i] = new JButton(buttontext[i]);
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
        return panel;
    }

    public JPanel createArea() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 10, 0));
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setBorder(new LineBorder(Color.red, 1));
        textArea = new JTextArea();
        sc = new JScrollPane(textArea);
        panel.add(sc);
        return panel;
    }

    public JPanel createRadiobutton(int HowMuchRadioButtonYouWant) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(400, 40));
        panel.setBorder(new LineBorder(Color.red, 1));
        for (int i = 0; i < HowMuchRadioButtonYouWant; i++) {
            radioButtons[i] = new JRadioButton(radiotext[i]);
            radioButtons[i].addActionListener(this);
            panel.add(radioButtons[i]);
        }
        return panel;
    }

    public JPanel createComboBox(String[] items) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(400, 40));
        panel.setBorder(new LineBorder(Color.red, 1));
        comboBox = new JComboBox[2];
        for (int i = 0; i < items.length; i++) {
            comboBox[i] = new JComboBox(items);
            comboBox[i].setPreferredSize(new Dimension(100, 20));
            comboBox[i].setVisible(false);
            panel.add(comboBox[i]);
        }
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (radioButtons[0].isSelected()) {
            for (int i = 0; i < comboBox.length; i++) {
                comboBox[i].setVisible(true);
            }
        } else if (radioButtons[1].isSelected()) {
            comboBox[0].setVisible(false);
            comboBox[2].setVisible(false);
            comboBox[1].setVisible(true);
        }
        else if (radioButtons[2].isSelected()) {
            comboBox[0].setVisible(true);
            comboBox[1].setVisible(false);
            comboBox[2].setVisible(false);
        }
    }
}
