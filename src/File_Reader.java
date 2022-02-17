import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class File_Reader
{
  public static void main(String [] args) throws IOException
  {
    // int counter=0;String str;
    String fileName = "input/edges.csv";
//    String fileName = "input/nodes.csv";

    String line = null;

    BufferedReader bufferedReader =
            new BufferedReader(new FileReader(fileName));
    Path edgeFile = Paths.get("input/sampleEdges.csv");
//    Path nodeFile = Paths.get("sampleNodes.csv");
    int i = 0;
    try {
      //print first 5 lines or all if file has less than 5 lines
      while(((line = bufferedReader.readLine()) != null) && i < 100) {
        Files.write(edgeFile, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
//        Files.write(nodeFile, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        System.out.println(line);
        i++;
      }
    }
    finally {
      bufferedReader.close();
    }
  }
}