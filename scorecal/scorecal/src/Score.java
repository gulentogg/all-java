public class Score {
    private double hw , mt , fs;

    public Score(){}

    public Score(double hw , double mt , double fs){

    }

    public void setFs(double fs) {
        this.fs = fs;
    }

    public void setHw(double hw) {
        this.hw = hw;
    }

    public void setMt(double mt) {
        this.mt = mt;
    }

    public double getFs() {
        return fs;
    }

    public double getHw() {
        return hw;
    }

    public double getMt() {
        return mt;
    }
    
    public String toString() {
        return hw + " " + mt + " " + fs;
    }
}
