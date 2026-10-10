import java.util.Scanner;

public class Assign03_StudentID_01{
    Scanner input = new Scanner (System.in);
    long num = 0L;

    //ประกาศตัวแปรสำหรับรับค่าจากผู้ใช้และเก็บสถานะการทำงานของโปรแกรม
    
    public void start(){
        String menu = "::   Main Menu   ::\n";
        for (int i = 0; i < 18; i++) 
            menu += "=";
        menu += """
                \nA. Get Integer Number
                B. Summation of Digit
                C. Count Digit
                D. Exit
                Enter Choice : """;
        String choice;
        while (true) {
            System.out.print("\n" + menu);
            input = new Scanner(System.in);
            choice = input.nextLine();
            if (choice.length() == 1 && !choice.isEmpty()) {
                if(choice.equals("A") || choice.equals("a"))
                    num = getIntegerNumber(num);
                else if(choice.equals("B") || choice.equals("b")){
                    System.out.println("\nYour enter number : " + num);
                    System.out.println("Summation of Digit: " + summationOfDigit(num));
                }
                else if(choice.equals("C") || choice.equals("c")){
                    System.out.println("\nYour enter number : " + num);
                    System.out.println("Count Digit: " + countDigit(num));
                }
                else if(choice.equals("D") || choice.equals("d"))
                    break;
                else
                    System.out.println("\nInvalid choice. Please try again.");
            }
            else
                System.out.println("\nInvalid choice. Please try again.");
        }
        System.out.println("Exit Program.");
        input.close();
    }

    // method start : รับค่าตัวเลือกเมนูจากผู้ใช้และเรียกใช้ฟังก์ชันที่เหมาะสมตามตัวเลือกนั้น

    public long getIntegerNumber(long num){
        System.out.print("\nEnter an integer number: ");
        num = input.nextLong();
        return num;
    }

    // method getIntegerNumber : รับค่าตัวเลขจำนวนเต็มจากผู้ใช้และส่งค่ากลับ

    public int summationOfDigit(long num){
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // method summationOfDigit : คำนวณผลรวมของแต่ละหลักในตัวเลขที่รับมาและส่งค่ากลับ

    public int countDigit(long num){
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
    
    // method countDigit : นับจำนวนหลักในตัวเลขที่รับมาและส่งค่ากลับ

    public static void main(String[] args) {
        new Assign03_StudentID_01().start();
    }

    // main method : สร้างอินสแตนซ์ของคลาสและเรียกใช้เมธอด start เพื่อเริ่มโปรแกรม
}