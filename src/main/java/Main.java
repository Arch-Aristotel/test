import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{

        String name = null;
        String Start = "<script id=\"dynamicJSONLD\" type=\"application/ld+json\">{\"@context\":\"https://schema.org\",\"@type\":\"Person\",\"alternateName\":";
        String Stop = "\"}}</script>";



        Scanner cin_file_logs = new Scanner(System.in);

        Get_Logins st1 = new Get_Logins();
        System.out.println("Input path to file whith UserName");
        st1.get_name("D:\\Справочник МГТС\\List-OTUsever.txt");
        System.out.println("Input path to file to safe");
        Scanner cin_file_safe = new Scanner(System.in);
        String PathX = cin_file_safe.nextLine();




        for(String url_name : st1.list) {

            System.out.println("https://newportal.mts.ru/my/Person.aspx?accountname=MGTS\\"+url_name);
            URL url = new URL("https://newportal.mts.ru/my/Person.aspx?accountname=MGTS\\"+ url_name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                try {
                    name = line.substring(line.indexOf(Start) + Start.length(), line.indexOf(Stop));
                } catch (Exception e) {
                }
            }
            st1.rec_file("D:\\Справочник МГТС\\test.txt", name);
        }
    }
}
