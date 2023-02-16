import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception{

        String a="qwejksdfdsfv 1234qwels very meny words6543qwels";
        String b = a.substring(a.indexOf("1234qwels")+9, a.indexOf("6543qwels"));


        String name = null;
        String nameParser_start = "Полное имя</span><div class=\"userValue\" data-attr=\"\"><span>";
        String nameParser_end = "</span></div></div><div class=\"userField\">";

        String Department = null;
        String DepartmentParse_start = "userDepartmentContainer\" title=\"";
        String DepartmentParse_end = "\"><a href=\"https://newportal.mts.ru/Pages/Org.aspx?openID";

        String Mobile_number = null;
        String Mobile_numberParse_start = "<div class=\"userMobileNumberContainer\"><span>";
        String Mobile_numberParse_end = "</span><div class=\"userSmsButton\" data-phone=";

        String Data_number = null;
        String Data_numberParsr_start = "Рабочий телефон</span><div class=\"userValue usernumberFont\" data-attr=\"\">";
        String Data_numberParsr_end ="</div></div><div class=\"userField userManagerField\"><span class=\"userLabel\">";

        String Login = null;
        String Login_parser_start ="Логин</span><div class=\"userValue\" data-attr=\"\"><span>";
        String Login_parser_end ="</span></div></div><div class=\"userField userAddressField\">";

        String addres = null;
        String addres_Parsrs_tart ="Адрес</span><div class=\"userValue\" data-attr=\"\"><span>";
        String addres_Parsrs_end = "</span></div></div><div class=\"userField userRegionTimeZoneField\">";

        String mail=null;
        String mail_parser_start = "class=\"userMailContainer\"><a href=\"mailto:";
        String mail_parser_end = "<div class=\"userEmailButton\"></div></a><a class=\"chatWithSkype-piwik";




        URL url = new URL("file:///D:/java/terex2.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

        try {

            Login=line.substring(line.indexOf(Login_parser_start)+Login_parser_start.length(), line.indexOf(Login_parser_end));
            name=line.substring(line.indexOf(nameParser_start)+nameParser_start.length(), line.indexOf(nameParser_end));
            Data_number=line.substring(line.indexOf(Data_numberParsr_start)+Data_numberParsr_start.length(), line.indexOf(Data_numberParsr_end));
            Mobile_number=line.substring(line.indexOf(Mobile_numberParse_start)+Mobile_numberParse_start.length(),line.indexOf(Mobile_numberParse_end));
            Department=line.substring(line.indexOf(DepartmentParse_start)+DepartmentParse_start.length(), line.indexOf(DepartmentParse_end));
            addres=line.substring(line.indexOf(addres_Parsrs_tart)+addres_Parsrs_tart.length(), line.indexOf(addres_Parsrs_end));
            mail=line.substring(line.indexOf(mail_parser_start)+mail_parser_start.length(), line.indexOf(mail_parser_end));

        }
        catch (Exception e) {
        }



        }
        System.out.println(Login+" "+name+" "+Data_number+" "+Mobile_number+" "+Department+" "+addres+" "+mail);





    }
}
