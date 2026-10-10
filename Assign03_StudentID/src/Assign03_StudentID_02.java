import javax.swing.JOptionPane;

public class Assign03_StudentID_02 {
    
    public static void main(String[] args) {
        new Assign03_StudentID_02().input();
    }

    // main method : สร้างอินสแตนซ์ของคลาสและเรียกใช้เมธอด input เพื่อเริ่มโปรแกรม

    public void input(){
        String strstart = JOptionPane.showInputDialog(null,"Enter start time : ","Input",JOptionPane.QUESTION_MESSAGE).trim();
        int start = str_to_second(strstart);
        if (start == -1 ) 
            JOptionPane.showMessageDialog(null, "Invalid Time Format","Error",JOptionPane.ERROR_MESSAGE);
        else {
            String strend = JOptionPane.showInputDialog(null,"Enter end time : ","Input",JOptionPane.QUESTION_MESSAGE).trim();
            int end = str_to_second(strend);
                if (end == -1 ) 
                    JOptionPane.showMessageDialog(null, "Invalid Time Format","Error",JOptionPane.ERROR_MESSAGE);
                else {
                    // if (end < start)
                    //     end += 24 * 3600;  //ทำให้เมื่อค่าหลังน้อยกว่าจะสามารถคำนวนได้จากassignไม่ได้ให้ทำแต่แค่เขียนไว้พอเปนความรู้ สามารถลบได้ก่อนส่งงาน
                    int total = Math.abs(end - start);
                    display(total , strstart, strend);
                }
            }
    }

    // method input : รับค่าจากผู้ใช้และตรวจสอบความถูกต้องของรูปแบบเวลา

    public int str_to_second(String value){
        if (checkvalue(value)) {
            int index ;
            index = value.indexOf(":");
            int hour = Integer.parseInt(value.substring(0, index));
            int minute = Integer.parseInt(value.substring(index + 1,value.indexOf(":",index + 1)));
            index = value.lastIndexOf(":");
            int second = Integer.parseInt(value.substring(index + 1));
            if (hour >=0 && hour < 24 && minute >=0 && minute < 60 && second >=0 && second < 60) 
                return (hour * 3600) + (minute * 60) + second;
            else
                return -1;
        }
        else
            return -1;
    }

    // method str_to_second : แปลงสตริงรูปแบบเวลาเป็นวินาทีและส่งค่ากลับ เมื่อรูปแบบถูกต้อง หรือส่งค่ากลับ -1 เมื่อรูปแบบไม่ถูกต้อง

    public boolean checkvalue(String value){
        int index ;
        String temp = value;
        for(int count = 0; temp.length() > 0;) {
            index = temp.indexOf(":");
            if (value.isEmpty() || value.length() < 8 || value.length() > 8)
                break;
            else if (index >= 0){
                temp = temp.substring( index + 1);
                count++;
            }
            else if (count > 2 || count < 2) 
                break;
            else
                return true;
        }
        return false;
    }

    // method checkvalue : ตรวจสอบรูปแบบของสตริงเวลาและส่งค่ากลับเป็นจริงหรือเท็จ

    public void display(int totalSecond , String start, String end){
        int hour = totalSecond / 3600;
        int minute = (totalSecond % 3600) / 60;
        int second = totalSecond % 60;
        String time = "Start Time : " + start + "\nEnd Time : " + end + "\n"
                    + "Time used : " 
                    + String.format("%02d Hours %02d Minutes %02d Seconds", hour, minute, second);
        JOptionPane.showMessageDialog(null,time, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // method display : แสดงผลลัพธ์เวลาที่ใช้ระหว่างเวลาเริ่มต้นและเวลาสิ้นสุดในรูปแบบชั่วโมง นาที และวินาที
}