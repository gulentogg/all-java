
/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign02_6806021610336_01.java
 */ 

import java.util.Scanner;

public class Assign02_6806021610336_01 {
    public static String isEven(int number) {
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    // method isEven คือการตรวจสอบว่าเลขที่รับเข้ามาเป็นเลขคู่หรือเลขคี่

    public String deldigit(int number) {
        String result = "";
        int count = 0, total = 0 , numberCopy = number;
        for (; numberCopy != 0; ) {
            int digit = numberCopy % 10;
            numberCopy = numberCopy / 10;
            result += digit + " is " + isEven(digit) + "\n";
            total += digit;
            count++;
        }
        if (count >= 5 || count <= 3)
            return ("Input error not in range, please input again?\n");
        result += "Total number : " + total + "\n";
        result += "Number " + number + " is " + isEven(number) + "\n";
        return result;
    }

    // metthod deldigit คือการลบหลักของตัวเลขทีละหลัก และตรวจสอบว่าแต่ละหลักเป็นเลขคู่หรือเลขคี่ พร้อมทั้งนับจำนวนหลักและหาผลรวมของตัวเลข

    public void inputnumber() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Enter integer number(4 digit, 0-exit) : ");
            num = scanner.nextInt();
            if (num > 0) {
                System.out.println(deldigit(num));
            } else if (num == 0) {
                System.out.println("Exit Program");
                break;
            } else {
                System.out.println("Invalid input. Enter integer number 4 digit, 0-exit");
            }
        }
        scanner.close();
    }

    // method inputnumber คือการรับค่าตัวเลขจากผู้ใช้ และเรียกใช้ method deldigit เพื่อตรวจสอบตัวเลขที่รับเข้ามา

    public static void main(String[] args) {
        new Assign02_6806021610336_01().inputnumber();
    }

    // main method จะทำการสร้าง object และเรียกใช้ method inputnumber เพื่อเริ่มโปรแกรม
}
