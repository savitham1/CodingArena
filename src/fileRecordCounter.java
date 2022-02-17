import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileRecordCounter {

  public static void main(String [] args) throws IOException
  {
    // int counter=0;String str;
    String fileName = "input/edges.csv";

    String line = null;

    BufferedReader bufferedReader =
            new BufferedReader(new FileReader(fileName));

    int recordCount = 0;
    try {
      //print first 5 lines or all if file has less than 5 lines
      while(((line = bufferedReader.readLine()) != null) ) {
        recordCount++;
      }
    }
    finally {
      bufferedReader.close();
    }
    System.out.println(recordCount);
  }
}
