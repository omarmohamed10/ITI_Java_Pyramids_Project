package pyramidsproject;

import java.util.List;

/**
 *
 * @author omar
 */
public class Pyramidsproject {

 
    public static void main(String[] args) {
        
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("pyramids.csv");
        for(Pyramid p:pyramids){
            System.out.println(p);
        }
        
        
    }
    
}
