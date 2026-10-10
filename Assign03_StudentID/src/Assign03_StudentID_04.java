
import javax.swing.JOptionPane;

public class Assign03_StudentID_04 {
    Long num = 0L;
    // ตัวแปรเก็บค่าตัวเลขจำนวนเต็มที่ผู้ใช้ป้อน

    public static void main(String[] args) {
        Assign03_StudentID_04 obj = new Assign03_StudentID_04();
        obj.mainmenu();
    }

    // main method : สร้างอินสแตนซ์ของคลาสและเรียกใช้เมธอด mainmenu เพื่อเริ่มโปรแกรม

    public void mainmenu(){
        String menu = "::   Main Menu   ::\n";
        menu += "========================\n";
        menu += """
                    A. Get Integer Number
                    B. Summation of Digit
                    C. Print Reverse
                    D. Count Digit
                    E. Exit
                    Enter Choice : """;
        String choice;
        while(true){
            choice = input(menu);
            if ("A".equals(choice) || "a".equals(choice))
                num = getIntegerNumber();
            else if ("B".equals(choice) || "b".equals(choice)) 
                summationOfDigit(num);
            else if ("C".equals(choice) || "c".equals(choice))
                printReverse(num);
            else if ("D".equals(choice) || "d".equals(choice))
                countdigit(num);
            else if ("E".equals(choice) || "e".equals(choice)) {
                Information("Now,Exit Program...");
                break;
            }
            else
                Information("No this choice. Please Input again.");
        }
    }

    // method mainmenu : แสดงเมนูหลักและรับตัวเลือกจากผู้ใช้เพื่อเรียกใช้ฟังก์ชันที่เหมาะสม ตามตัวเลือกนั้น จนกว่าผู้ใช้จะเลือกออกจากโปรแกรม

    public long getIntegerNumber(){
        String value = input("Enter an integer number: ");
        if (check(value))
            return Long.parseLong(value);
        else {
            Information("Invalid Input!");
            return 0;
        }
    }

    // method getIntegerNumber : รับค่าตัวเลขจำนวนเต็มจากผู้ใช้ผ่านกล่องโต้ตอบ และตรวจสอบความถูกต้องของข้อมูลที่ป้อนเข้ามา ก่อนส่งค่ากลับ เป็นตัวเลขจำนวนเต็ม หรือแสดงข้อความผิดพลาดหากข้อมูลไม่ถูกต้อง

    public void summationOfDigit(long num){
        int sum = 0;
        Long temp = num;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        Information("Your enter number : " + num + "\nSummation of Digit: " + sum);
    }

    // method summationOfDigit : คำนวณผลรวมของแต่ละหลักในตัวเลขที่รับมา และแสดงผลลัพธ์ผ่านกล่องข้อความ

    public void printReverse(long num){
        String reverse = "";
        Long temp = num;
        while (temp != 0) {
            reverse += temp % 10;
            temp /= 10;
        }
        Information("Your enter number : " + num + "\nReverse Digit: " + reverse);
    }

    // method printReverse : พิมพ์ตัวเลขที่รับมาในลำดับย้อนกลับ และแสดงผลลัพธ์ผ่านกล่องข้อความ

    public void countdigit(long num){
        int count = 0;
        Long temp = num;
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        Information("Your enter number : " + num + "\nCount Digit: " + count);
    }

    // method countdigit : นับจำนวนหลักในตัวเลขที่รับมา และแสดงผลลัพธ์ผ่านกล่องข้อความ

    public String input( String message){
        return JOptionPane.showInputDialog(null,message,"Input",JOptionPane.QUESTION_MESSAGE).trim();
    }

    // method input : รับค่าข้อความจากผู้ใช้ผ่านกล่องโต้ตอบ และส่งค่ากลับเป็นสตริง

    public void Information(String message){
        JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
    }

    // method Information : แสดงข้อความผ่านกล่องข้อความ

    public boolean check(String value){
        for (int i = 0 ; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i)))
                return true;
            else if (!value.isEmpty())
                return true;
        }
        return false;
    }

    // method check : ตรวจสอบว่าข้อความที่รับมาประกอบด้วยตัวเลขจำนวนเต็มที่ถูกต้องหรือไม่ และส่งค่ากลับเป็นจริงหรือเท็จ
}