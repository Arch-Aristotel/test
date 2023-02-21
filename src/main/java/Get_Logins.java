
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class Get_Logins {
    public List<String> list;

    public void get_name(String pathX){
        try {
            Path pt = Paths.get(pathX);
            list = Files.readAllLines(pt);
        }
        catch (Exception e){

    }

        }

        public void rec_file(String path_input, String name){
        name = name+"\n";
        Path pt = Paths.get(path_input);
            try {
                byte[] strToBytes = name.getBytes();
                Files.write(pt, strToBytes, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
