import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{

        //List<String> list2 = new ArrayList<>();
        String name = null;
        String Start = "<script id=\"dynamicJSONLD\" type=\"application/ld+json\">{\"@context\":\"https://schema.org\",\"@type\":\"Person\",\"alternateName\":";
        String Stop = "\"}}</script>";

        System.setProperty("javax.net.ssl.trustStore","clientTrustStore.key");

        System.setProperty("javax.net.ssl.trustStorePassword","qwerty");



        Scanner cin_file_logs = new Scanner(System.in);

        //Get_Logins st1 = new Get_Logins();
        System.out.println("Input path to file whith UserName");
        //*************************************

            Path pt = Paths.get(cin_file_logs.nextLine());
            System.out.println(pt.getFileName());
            List<String> list = Files.readAllLines(pt);
            if (list==null) System.out.println("Do not load");
            else System.out.println("File is load");

        //*************************************
        //st1.get_name(cin_file_logs.nextLine());



        System.out.println("Input path to file to safe");
        Scanner cin_file_safe = new Scanner(System.in);
        String PathX = cin_file_safe.nextLine();




        for(String url_name : list) {

            System.out.println("https://newportal.mts.ru/my/Person.aspx?accountname=MGTS\\"+url_name);
            URL url = new URL("https://newportal.mts.ru/my/Person.aspx?accountname=MGTS\\"+url_name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    System.out.println("Dont cathc");
                    break;
                }
                try {
                    name = line.substring(line.indexOf(Start) + Start.length(), line.indexOf(Stop));

                    name = name+"\n";
                    Path pt2 = Paths.get(PathX);
                    try {
                        byte[] strToBytes = name.getBytes();
                        Files.write(pt2, strToBytes, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                } catch (Exception e) {
                }
            }
        }
    }
}
