public class Gradecal extends Score{

    private String id;
    private double total = 0.0;

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    

    public Gradecal ( String id, double hw , double mt , double fs){
        setId(id);
        setHw(hw);
        setMt(mt);
        setFs(fs);
        setTotal(calculateTotal(getHw(), getMt(), getFs()));

    }

    public double calculateTotal(double hw , double mt , double fs){
        hw = (hw*30) / 100;
        mt = (mt*30) / 100;
        fs = (fs*40) / 100;

        return hw + mt + fs;
    }

    public String tograde(){
        if (total >= 80) return "A";
        else if (total >= 75) return "B+";
        else if (total >= 70) return "B";
        else if (total >= 65) return "C+";
        else if (total >= 60) return "C";
        else if (total >= 55) return "D+";
        else if (total >= 50) return "D";
        else return "F";
    }

    public String toString() {
        return getId() + " " + super.toString() + " " + getTotal() + " " + tograde();
    }

}
