/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name :  Assign02_6806021610336_02.java
 */ 

public class Assign02_6806021610336_02 {
    public static void main(String[] args) {
        new Assign02_6806021610336_02().inputnumber();
    }

    //method main จะทำการสร้าง object และเรียกใช้ method inputnumber เพื่อเริ่มโปรแกรม

    public String count_even_odd_zero(long number) {
        String result = "";
        int evenCount = 0, oddCount = 0, zeroCount = 0;
        long numberCopy = number;
        for (;numberCopy != 0;) {
            int digit = (int)(numberCopy % 10);
            numberCopy = numberCopy / 10;
            if (digit == 0) {
                zeroCount++;
            } else if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        result += "Even number : " + evenCount + "\n";
        result += "Odd number : " + oddCount + "\n";
        result += "Zero number : " + zeroCount + "\n";
        return result;
    }

    //method count_even_odd_zero คือการนับจำนวนหลักที่เป็นเลขคู่ เลขคี่ และเลขศูนย์ในตัวเลขที่รับเข้ามา

    public void inputnumber() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long num;
        while (true) {
            System.out.print("Enter integer number (0-exit) : ");
            num = scanner.nextLong();
            if (num > 0) {
                System.out.println(count_even_odd_zero(num));
            } else if (num == 0) {
                System.out.println("Exit Program");
                break;
            } else {
                System.out.println("Invalid input. Please enter a positive integer or 0 to exit.");
            }
        }
        scanner.close();
    }

    //method inputnumber คือการรับค่าตัวเลขจากผู้ใช้ และเรียกใช้ method count_even_odd_zero เพื่อตรวจสอบตัวเลขที่รับเข้ามา
}
