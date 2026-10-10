/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Student.java
 */ 
public class Student extends Person{
    private String id;
    private int score = 0;
    // ตัวแปรสำหรับเก็บรหัสนักเรียนและคะแนนของนักเรียน โดย score เริ่มต้นที่ 0

    public Student(){}
    // คอนสตรัคเตอร์เริ่มต้นที่ไม่มีพารามิเตอร์

    public Student(String id, String name, String surname, int score){
        super(name, surname);
        setId(id);
        setScore(score);
    }
    // คอนสตรัคเตอร์ที่รับพารามิเตอร์สำหรับกำหนดค่า id, name, surname และ score โดยใช้ super() เพื่อเรียกคอนสตรัคเตอร์ของคลาส Person และใช้เมธอด setId และ setScore เพื่อกำหนดค่าให้กับตัวแปร

    public String getId() {
        return id;
    }
    // เมธอดสำหรับรับค่าของตัวแปร id

    public void setId(String id) {
        this.id = id;
    }
    // เมธอดสำหรับกำหนดค่าของตัวแปร id

    public int getScore() {
        return score;
    }
    // เมธอดสำหรับรับค่าของตัวแปร score

    public void setScore(int score) {
        this.score = score;
    }
    // เมธอดสำหรับกำหนดค่าของตัวแปร score

    public String toGrade(){
        if (getScore() >= 80) {
            return "A";
        } else if (getScore() >= 75) {
            return "B+";
        } else if (getScore() >= 70) {
            return "B";
        } else if (getScore() >= 65) {
            return "C+";
        } else if (getScore() >= 60) {
            return "C";
        } else if (getScore() >= 55) {
            return "D+";
        } else if (getScore() >= 50) {
            return "D";
        }else {
            return "F";
        }
    }
    // เมธอดสำหรับแปลงคะแนนเป็นเกรด โดยใช้เงื่อนไข if-else เพื่อตรวจสอบช่วงคะแนนและคืนค่าเกรดที่ตรงกับช่วงคะแนนนั้น ๆ

    public String toString() {
        return getId() + "; " + super.toString() + "; " + getScore() + "; " + toGrade();
    }
    // เมธอดสำหรับแสดงข้อมูลของนักเรียนในรูปแบบ "id; name; surname; score; grade" โดยใช้ super.toString() เพื่อเรียกเมธอด toString() ของคลาส Person เพื่อแสดงชื่อและนามสกุล

}
