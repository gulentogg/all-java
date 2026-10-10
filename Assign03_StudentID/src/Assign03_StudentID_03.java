
import javax.swing.JOptionPane;

public class Assign03_StudentID_03 {
    public static void main(String[] args) {
        new Assign03_StudentID_03().input();
    }

    // main method : สร้างอินสแตนซ์ของคลาสและเรียกใช้เมธอด input เพื่อเริ่มโปรแกรม

    public void input(){
        String text = JOptionPane.showInputDialog(null,"Enter text : ","Input",JOptionPane.QUESTION_MESSAGE).trim();
        calculate(text);
    }

    // method input : รับค่าข้อความจากผู้ใช้ผ่านกล่องโต้ตอบ

    public boolean check (String value){
        return !value.isEmpty();
    }

    // method check : ตรวจสอบว่าข้อความที่รับมาว่างเปล่าหรือไม่

    public void calculate(String value){
        if (check(value)){
            int U = 0, L = 0, N = 0, S = 0;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if (ch >= 'A' && ch <= 'Z') U++;
                else if (ch >= 'a' && ch <= 'z') L++;
                else if (ch >= '0' && ch <= '9') N++;
                else S++;
            }
            String message = " TEXT : " + value;
            message += "\n Text length : " + value.length();
            message += "\n Upper Text : " + U;
            message += "\n Lower Text : " + L;
            message += "\n Number : " + N;
            message += "\n Other Symbol : " + S;
            display(message);
        }else
            errormessage();
    }

    // method calculate : คำนวณจำนวนตัวอักษรพิมพ์ใหญ่ ตัวอักษรพิมพ์เล็ก ตัวเลข และสัญลักษณ์พิเศษในข้อความที่รับมา แล้วแสดงผลลัพธ์ หรือแสดงข้อความผิดพลาดหากไม่มีการป้อนข้อความ

    public void errormessage(){
        JOptionPane.showMessageDialog(null, "No Input Text!","Error",JOptionPane.ERROR_MESSAGE);
    }

    // method errormessage : แสดงกล่องข้อความแจ้งข้อผิดพลาดเมื่อไม่มีการป้อนข้อความ

    public void display(String message){
        JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
    }

    // method display : แสดงผลลัพธ์การคำนวณผ่านกล่องข้อความ
}
