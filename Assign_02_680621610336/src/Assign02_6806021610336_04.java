/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign02_6806021610336_04.java
 */ 

import java.text.DecimalFormat;
import java.util.Scanner;


public class Assign02_6806021610336_04 {

    public static void main(String[] args) {
        new Assign02_6806021610336_04().input_inc();
    }

    // main method จะทำการสร้าง object และเรียกใช้ method input_inc เพื่อเริ่มโปรแกรม

    public static float returnrate(double inc) {
        if (inc <= 150000)
            return 0.0f;
        else if (inc <= 300000)
            return 2.5f;
        else if (inc <= 500000)
            return 4.0f;
        else if (inc <= 800000)
           return 5.5f;
        else if (inc <= 1000000)
            return 7.5f;
        else 
            return 10.0f;
    }

    // method returnrate คือการคำนวณอัตราภาษีตามช่วงรายได้ที่รับเข้ามา

    public static double caltax(double inc, float rate) {
        return (inc * rate) / 100;
    }

    // method caltax คือการคำนวณภาษีที่ต้องจ่ายตามรายได้และอัตราภาษีที่รับเข้ามา  

    public void input_inc() {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        DecimalFormat ratedf = new DecimalFormat("#.#");
        while (true) {
            System.out.print("Enter your income( -1 to exit) : ");
            double income = scanner.nextDouble();
            if (income >= 0) {
                float rate = returnrate(income);
                double tax = caltax(income, rate);
                System.out.print("Net Income : " + df.format(income) + "\n");
                System.out.print("Tax Rate(%) : " + ratedf.format(rate) + "%\n");
                System.out.println("Amount Tax : " + df.format(tax) + "\n");
            } else if (income == -1) {
                System.out.println("Exit Program.");
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid income or -1 to exit.");
            }
        }
        scanner.close();
    }

    // method input_inc คือการรับค่ารายได้จากผู้ใช้ และเรียกใช้ method returnrate และ caltax เพื่อตรวจสอบรายได้และคำนวณภาษีที่ต้องจ่าย
}