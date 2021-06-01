package pyramidsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omar
 */
public class PyramidCSVDAO {
    
public ArrayList <Pyramid> pyramids;    

public PyramidCSVDAO(){
    pyramids = new ArrayList<Pyramid>();
}
    
public List<Pyramid> readPyramidsFromCSV(String fileName){
    
    try {
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(",");
       // List <String> headers = new ArrayList<String>();
        String [] headers = new String [100];
        String [] attributes = new String [100];
        
        if(sc.hasNextLine()){
            
           headers = sc.nextLine().split(",");
        }
        while(sc.hasNextLine()){
            
            attributes = sc.nextLine().split(",");
              for(int i = 0; i < attributes.length; i++){
                if(attributes[i].isEmpty()){
                    attributes[i] = null;
                  }
              }
            Pyramid new_pyrmaid = createPyramid(attributes);
            pyramids.add(new_pyrmaid);
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
    return pyramids;
}

private static Pyramid createPyramid(String [] info){
    String pharaho = info[0];
    String modern_name = info[2];
    String site = info[4];
    String height_str = info[7];
    
    double height;
    
      if(height_str == null){height = Double.NaN;}
      else{height = Double.parseDouble(height_str);}
    
    return new Pyramid(pharaho,modern_name,site,height);
}



}
