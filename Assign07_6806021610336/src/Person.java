/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Person.java
 */ 

public class Person {
    private String name;
    private String surname;
    // ตัวแปรสำหรับเก็บชื่อและนามสกุลของบุคคล

    public Person(){}
    // คอนสตรัคเตอร์เริ่มต้นที่ไม่มีพารามิเตอร์

    public Person(String name , String surname){
        setName(name);
        setSurname(surname);
    }
    // คอนสตรัคเตอร์ที่รับพารามิเตอร์สำหรับกำหนดค่า name และ surname โดยใช้เมธอด setName และ setSurname เพื่อกำหนดค่าให้กับตัวแปร

    public String getName() {
        return name;
    }
    // เมธอดสำหรับรับค่าของตัวแปร name

    public void setName(String name) {
        this.name = name;
    }
    // เมธอดสำหรับกำหนดค่าของตัวแปร name

    public String getSurname() {
        return surname;
    }
    // เมธอดสำหรับรับค่าของตัวแปร surname

    public void setSurname(String surname) {
        this.surname = surname;
    }
    // เมธอดสำหรับกำหนดค่าของตัวแปร surname

    public String toString() {
        return name + "; " + surname;
    }
    // เมธอดสำหรับแสดงข้อมูลของบุคคลในรูปแบบ "name; surname"

}

