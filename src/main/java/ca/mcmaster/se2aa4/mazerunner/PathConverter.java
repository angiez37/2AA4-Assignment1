package ca.mcmaster.se2aa4.mazerunner;

import java.util.StringTokenizer;
public class PathConverter {

    public static String Canonical(String path) {
        StringBuilder canonicalPath = new StringBuilder(); // Holds new canonical path format
        path = path.toUpperCase(); 
        path = path.replaceAll("\\s", "");
        int factLength = path.length();
        int num_inst = 0; // Will hold how many instructions we should convert. ex for 10F, it should write ten 'F'
        char inst = ' ';
        
        int i = 0;
        while (i < factLength) {
            // Read in current char in path
            char current = path.charAt(i);
            // If it is a number
            if (Character.isDigit(current)) {
                // Check to see if number is more than 1 digit
                String num = ""; 
                num += current;
                int j = i+1;
                while (j < factLength && Character.isDigit(path.charAt(j))) {
                    num+=path.charAt(j);
                    j++;
                }
                
                // Append current instruction num times
                if (j < factLength) {
                    num_inst = Integer.parseInt(num);
                    inst = path.charAt(j);
                    for (int k = 0; k < num_inst; k++) {
                        canonicalPath.append(inst);
                    }
                    i = j+1;     
                } else {
                    throw new IllegalArgumentException("Invalid path format: number at the end wthout instruction.");
                }
                
            } else {
                // Add the single instruction to can_path
                canonicalPath.append(current);
                i++;
            }
        }
        
        return canonicalPath.toString();
    }
}

