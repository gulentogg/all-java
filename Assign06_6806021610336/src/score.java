/*ID   : 68-060216-1033-6
 *Name : Jirawish Thepthong
 *Room : 1 RA
 *File name : Assign06_6806021610336.java
 */ 

public class score {
    private double MidExam = 0.0;
    private double FinalExam = 0.0;
    private double Homework = 0.0;

    score() {
        this.MidExam = 0.0;
        this.FinalExam = 0.0;
        this.Homework = 0.0;

    }

    score(double m, double f, double h) {
        this.MidExam = m;
        this.FinalExam = f;
        this.Homework = h;
    }    

    public void SetMid(double m) {
        this.MidExam = m;
    }
    public void SetFinal(double f) {
        this.FinalExam = f;
    }
    public void SetHomework(double h) {
        this.Homework = h;
    }

    public double GetMid() {
        return MidExam;
    }
    public double GetFinal() {
        return FinalExam;
    }
    public double GetHomework() {
        return Homework;
    }

    public double toSum() {
        return Math.round(this.MidExam + this.FinalExam + this.Homework);
    }

    public String toGrade() {
        double sum = toSum();
        if (sum >= 80) {
            return "A";
        } else if (sum >= 70) {
            return "B";
        } else if (sum >= 60) {
            return "C";
        } else if (sum >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    
    public String toString() {
        return "MidExam: " + this.MidExam + ", FinalExam: " + this.FinalExam + ", Homework: " + this.Homework + ", Total Score: " + toSum() + ", Grade: " + toGrade();
    }
}
