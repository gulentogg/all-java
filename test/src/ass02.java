
import javax.swing.JOptionPane;

public class ass02 {
    public static void main(String[] args) {
        new ass02().calculate();
    }

    public String input(String text){
        return JOptionPane.showInputDialog(null,"Enter " + text + " time :","Input",JOptionPane.QUESTION_MESSAGE).trim();
    }

    public void message(String start , String end , String result){
        JOptionPane.showMessageDialog(null,"Start Time : " + start +"\n" + "End Time : " + end + "\n" + "Time used : " + result,"Message",JOptionPane.INFORMATION_MESSAGE);
    }

    public void warning(){
        JOptionPane.showMessageDialog(null, "Invalid format.","warning",JOptionPane.WARNING_MESSAGE);
    }

    public void calculate(){
        String start , end;
        int intstart = 0 , intend = 0;
        start = input("start");
        if (checkvalue(start)){
            intstart = str_to_second(start);
            end = input("end");
            if (checkvalue(end) && intstart != -1){
                intend = str_to_second(end);
                if (intend != -1){
                    int result = intend - intstart;
                    String text = second_to_str(result);
                    message(start,end,text);
                }else
                    warning();
            }else
                warning();   
        }else
            warning();
    }

    public String second_to_str(int value){
        int hour , minute , second;
        second = value % 60;
        value /= 60;
        minute = value % 60;
        value /= 60;
        hour = value;
        return hour + "Hours " + minute + " minutes " + second + "seconds.";
    }

    public int str_to_second(String value){
        int hour , minute , second;
        String temp = value;
        int pos = temp.indexOf(":");
        hour = Integer.parseInt(temp.substring(0,pos));
        minute = Integer.parseInt(temp.substring(pos + 1,temp.indexOf(":",pos + 1)));
        pos = temp.lastIndexOf(":");
        second = Integer.parseInt(temp.substring(pos + 1));
        System.out.println(hour + " p " + minute + " p " + second);
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60)
            return -1;
        else{
            hour *= 60;
            hour += minute;
            hour *= 60;
            hour += second;
            return hour;
        }
    }

    public boolean checkvalue(String value){
        String temp = value;
        if (temp.length() < 8 || temp.length() > 8){
            return false;
        }
        else{
            char ch ;
            int count = 0;
            for (int i = 0; i <= 7 ; i ++ ){
                ch = temp.charAt(i);
                if (ch == ':')
                    count++;
            }
            if (count < 2 || count > 2){
                return false;
            }
            else{
                int f = temp.indexOf(":");
                int b = temp.lastIndexOf(":");
                if (f != 2 || b != 5)
                    return false;
                else{
                    char nd ;
                    for (int i = 0; i <= 7 ; i ++ ){
                        nd = temp.charAt(i);
                        if ((nd <= '0' && nd >= '9') && (i != 2 || i != 5))
                            return false;
                    }
                    return true;
                }
            }
        }
    }
}
