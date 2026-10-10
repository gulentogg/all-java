import java.io.*;
import java.util.ArrayList;

public class FileManager {
    
    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    // ==========================================
    // ฟังก์ชันใหม่: แก้ไขข้อมูลเฉพาะบรรทัดที่ต้องการ
    // ==========================================
    public void editSpecificData(String keyword, String newText) {
        // สร้าง List เพื่อมาเก็บข้อมูลชั่วคราวใน RAM
        ArrayList<String> fileContent = new ArrayList<>();
        boolean isFound = false;

        // ขั้นตอนที่ 1: อ่านข้อมูลเก่าทั้งหมดขึ้นมา
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filename));
            String line;
            while ((line = reader.readLine()) != null) {
                // ขั้นตอนที่ 2: ค้นหาคำที่ต้องการแก้ไข
                if (line.contains(keyword)) {
                    // ถ้าเจอบรรทัดที่มีคำคีย์เวิร์ด ให้เอาข้อความใหม่ (newText) ใส่เข้าไปแทน
                    fileContent.add(newText);
                    isFound = true;
                } else {
                    // ถ้าไม่ใช่บรรทัดที่หา ก็เก็บข้อความเดิมไว้เหมือนเดิม
                    fileContent.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ ไม่สามารถอ่านไฟล์ได้");
            e.printStackTrace();
            return; // ออกจากฟังก์ชันถ้าอ่านไฟล์ไม่ได้
        }

        // ขั้นตอนที่ 3: เขียนทับไฟล์เดิม (ถ้ามีการค้นเจอและแก้ไข)
        if (isFound) {
            try {
                // สังเกตว่าเราไม่ใส่ 'true' (Append) แล้ว เพื่อให้มันเคลียร์ไฟล์แล้วเขียนใหม่ทั้งหมด
                FileWriter writer = new FileWriter(this.filename); 
                for (String textLine : fileContent) {
                    writer.write(textLine + "\n");
                }
                writer.close();
                System.out.println("✅ แก้ไขข้อมูลสำเร็จเรียบร้อย!");
            } catch (IOException e) {
                System.out.println("❌ ไม่สามารถบันทึกไฟล์ได้");
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ ไม่พบคำว่า '" + keyword + "' ในไฟล์ (ไม่มีการเปลี่ยนแปลง)");
        }
    }

    // ==========================================
    // ส่วนทดสอบการทำงาน
    // ==========================================
    public static void main(String[] args) {
        FileManager studentFile = new FileManager("scorecal\\std.txt");

        // สมมติว่าในไฟล์มีข้อมูล "รหัส 68060216: สมชาย เชียงพงพันธ์" อยู่ก่อนแล้ว
        // เราต้องการเปลี่ยนชื่อ สมชาย เป็น "สมเกียรติ ยอดเยี่ยม" โดยค้นหาจากรหัสนักศึกษา
        
        System.out.println("--- สั่งแก้ไขข้อมูลเฉพาะจุด ---");
        
        // ส่งคีย์เวิร์ด "68060216" ไปค้นหา ถ้าเจอให้เปลี่ยนทั้งบรรทัดเป็นข้อความใหม่
        studentFile.editSpecificData("68060216", "รหัส 68060216: สมเกียรติ ยอดเยี่ยม (อัปเดตแล้ว)");
        
        // ลองทดสอบหาคำที่ไม่มีในไฟล์ดู
        studentFile.editSpecificData("99999999", "รหัสนี้ไม่มีอยู่จริง");
    }
}