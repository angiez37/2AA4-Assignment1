package ca.mcmaster.se2aa4.mazerunner;
public class PathConverter {

    public PathConverter() {}
    
    public String Canonical(String path) {
        StringBuilder canonical_path = new StringBuilder(); // Holds new canonical path format
        path = path.toUpperCase(); 
        path = path.replaceAll("\\s", "");
        int fact_length = path.length();
        int num_inst = 0; // Will hold how many instructions we should convert. ex for 10F, it should write ten 'F'
        char inst = ' ';
        
        int i = 0;
        while (i < fact_length) {
            // Read in current char in path
            char current = path.charAt(i);
            // If it is a number
            if (Character.isDigit(current)) {
                // Check to see if number is more than 1 digit
                String num = ""; 
                num += current;
                int j = i+1;
                while (Character.isDigit(path.charAt(j))) {
                    num+=path.charAt(j);
                    j++;
                }
                
                // Append current instruction num times
                num_inst = Integer.parseInt(num);
                inst = path.charAt(j);
                for (int k = 0; k < num_inst; k++) {
                    canonical_path.append(inst);
                }

                i = j+1;
            } else {
                // Add the single instruction to can_path
                canonical_path.append(current);
                i++;
            }
        }
        
        return canonical_path.toString();
    }
}

