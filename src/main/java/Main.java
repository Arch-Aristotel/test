public class Main {
    public static void main(String[] args) {

        dell_simbyl e = (x) ->{
            String tmp[] = x.split("a");
            x=null;
            for (String a : tmp){
                if(x!=null) x=x+a;
                    else x=a;
            }
            return x;
        };

        System.out.println(e.cleare_line("lonag liave ias goaod"));
    }
}
interface dell_simbyl{
    String cleare_line(String clear);
}
