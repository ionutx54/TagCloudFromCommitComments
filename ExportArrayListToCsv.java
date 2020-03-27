import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportArrayListToCsv {
    ArrayList<String> arrayList = new ArrayList<String>();

    public ExportArrayListToCsv(ArrayList<String> arrayList){
        this.arrayList = arrayList;
    }

    public void ExportMethod(){
        File csvFile = new File("G:\\Projects\\Python\\CloudTagGenerator\\csv.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));){
            for(String item :arrayList){
                csvWriter.println(item + ",");
            }
        } catch (IOException e) {
            //Handle exception
            e.printStackTrace();
        }
    }
}
