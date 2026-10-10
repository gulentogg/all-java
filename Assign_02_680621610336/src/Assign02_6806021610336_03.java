/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign02_6806021610336_03.java
 */ 
import java.util.Scanner;

public class Assign02_6806021610336_03 {
    public static boolean prime(int number) {
        if (number < 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // method prime คือการตรวจสอบว่าตัวเลขที่รับเข้ามาเป็นจำนวนเฉพาะหรือไม่
    
    public void inputnumber(){
        Scanner scanner = new Scanner(System.in);
        int num;
        while(true){ 
            System.out.print("Enter positive number (0-exit) : ");
            num = scanner.nextInt();
            if (num > 0) {
                if (prime(num)) {
                    System.out.println(num + " is a prime number.");
                } 
                else {
                    System.out.println(num + " is not a prime number.");
                }
            }
            else if (num == 0) {
                System.out.println("Exit Program.");
                break;
            } 
            else {
                System.out.println("Invalid input. Please enter a positive number or 0 to exit.");
            }
        }
        scanner.close();
    }

    // method inputnumber คือการรับค่าตัวเลขจากผู้ใช้ และเรียกใช้ method prime เพื่อตรวจสอบตัวเลขที่รับเข้ามา

    public static void main(String[] args) {
        Assign02_6806021610336_03 obj = new Assign02_6806021610336_03();
        obj.inputnumber();
    }
    // main method จะทำการสร้าง object และเรียกใช้ method inputnumber เพื่อเริ่มโปรแกรม
}
