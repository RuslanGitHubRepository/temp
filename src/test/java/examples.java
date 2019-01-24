import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Model{
    private Scanner scaner;
    private Matcher matcher;
    private Pattern pattern;
    Model(){
        scaner= new Scanner(System.in);
        pattern= Pattern.compile("\\.*\\s[А-Яа-я]{1,}\\-[0-9]{1,}\\s\\.*");
    }
    public String[] request(){
        System.out.println("insert your name");
        String text = scaner.nextLine();
        matcher = pattern.matcher(text);
        String[] srts = new String[1];
        boolean status = matcher.matches();
        System.out.println(matcher.groupCount());
        srts[0] = matcher.group();
        return status == true? srts:new String[0];
    }
}
class View{
    public void print(String text){
        System.out.println(text);
    }
}
class Controller{
    private Model model = new Model();
    private View view = new View();
    public boolean start(){
        String[] text = model.request();
        if(text[0].equals("fault")){
            view.print("Error");
            return true;
        }
        view.print(text[0]);
        if(text.equals("none")) return true;
        else return false;
    }
}
class Main{
    private static Controller controller = new Controller();
    public static void main(String[] args){
        while(controller.start() != true){}
    }
}

