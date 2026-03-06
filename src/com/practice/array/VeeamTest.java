import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class VeeamTest {

    // Main method to start the process
    public String rebuildMessage(String[] parts) {
        // We need a helper method to handle the recursive search.
        // The helper needs to manage state: current path, and remaining parts.
        
        for (String startPart : parts) {
            // Check if the part starts with 'A'
            if (startPart.charAt(0) == 'A') {
                Set<String> used = new HashSet<>();
                used.add(startPart);
                
                // Start the recursive search with the first valid part
                String result = findPath(startPart, used, List.of(parts));
                if (result != null) {
                    return result;
                }
            }
        }
        return null; // Or throw an exception if no solution is found
    }

    // Helper recursive method
    private String findPath(String currentMessage, Set<String> usedParts, List<String> allPartsList) {
        
        // Base Case: Check for success
        if (usedParts.size() == allPartsList.size()) {
            // Check if the final character is 'Z'
            if (currentMessage.charAt(currentMessage.length() - 1) == 'Z') {
                return currentMessage; // Found the complete message
            }
            return null; // All parts used, but didn't end with 'Z'
        }

        char requiredNextStartChar = currentMessage.charAt(currentMessage.length() - 1);

        // Recursive Step: Look for the next valid part
        for (String nextPart : allPartsList) {
            if (!usedParts.contains(nextPart) && nextPart.charAt(0) == requiredNextStartChar) {
                
                // Mark as used for this path
                usedParts.add(nextPart);
                
                // Combine the message, ensuring overlap is handled (append from the 2nd char)
                String newMessage = currentMessage + nextPart.substring(1); 
                
                // Recurse
                String result = findPath(newMessage, usedParts, allPartsList);
                
                if (result != null) {
                    return result; // Pass successful result back up the chain
                }
                
                // Backtrack: If the recursion failed, unmark the part
                usedParts.remove(nextPart);
            }
        }

        return null; // No valid next part found from this state
    }


    /**
        We have:
	•	A 2D grid int[][] grid
	•	Each cell represents a square on the ground
	•	The value in the cell = number of leaves

We have:
	•	A 2D grid int[][] grid
	•	Each cell represents a square on the ground
	•	The value in the cell = number of leaves
    **/

public class LeafSimulation {

    public static int[][] moveLeaves(int[][] grid, char direction) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] newGrid = new int[rows][cols];

        int dr = 0, dc = 0;

        switch(direction) {
            case 'N': dr = -1; break;
            case 'S': dr = 1; break;
            case 'E': dc = 1; break;
            case 'W': dc = -1; break;
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {

                int leaves = grid[r][c];
                int newR = r + dr;
                int newC = c + dc;

                if(newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                    newGrid[newR][newC] += leaves;
                }
                // else leaves are blown away
            }
        }

        return newGrid;
    }
}



}
