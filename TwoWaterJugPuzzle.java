import java.util.*;



class TwoWaterJugPuzzle{

    public static void Iterative(int maxA, int maxB, int target) {  // the  parameters are the max capacity of both jars, and the target volumr of one of the jar
        // Initializing the jugs A and B with 0 liters of water
        int jugA = 0;
        int jugB = 0;
        
        // Iterating until the target amount is reached or there is no more water to pour
        while (jugA != target && jugB != target) {
            if (jugA == 0) {
                // Fill jug A if it is empty
                jugA = maxA;
            } 
            else if (jugB == maxB) {
                // Empty jug B if it is full
                jugB = 0;
            } 
            else {
                // Pour water from jug A to jug B until jug B is full or jug A is empty
                int amount = Math.min(jugA, maxB - jugB);
                jugA -= amount;
                jugB += amount;
            }
        }
        
        // Check if target amount is reached
        if(jugA == target || jugB == target){
            System.out.println("One of the jar has been successfuly filled with "+ target +" litres of water using the iterative method");
        }

    }

    public static boolean Recursive(int currentA, int currentB, int target, int maxA, int maxB, boolean[][] visited) { // the boolean array 'visited' is used to keep track of previously visited states, in order to avoid infinite recursion
        if (currentA == target || currentB == target) {
            return true;
        }
        if (visited[currentA][currentB]) {
            return false;
        }
        visited[currentA][currentB] = true;
    
        // Case 1: Pour from jug A to jug B
        if (currentA > 0 && currentB < maxB) {
            if (Recursive(currentA - Math.min(currentA, maxB - currentB), currentB + Math.min(currentA, maxB - currentB), target, maxA, maxB, visited)) {
                return true;
            }
        }
    
        // Case 2: Pour from jug B to jug A
        if (currentB > 0 && currentA < maxA) {
            if (Recursive(currentA + Math.min(currentB, maxA - currentA), currentB - Math.min(currentB, maxA - currentA), target, maxA, maxB, visited)) {
                return true;
            }
        }
    
        // Case 3: Empty jug A
        if (currentA > 0 && Recursive(0, currentB, target, maxA, maxB, visited)) {
            return true;
        }
    
         // Case 4: Empty jug B
         if (currentB > 0 && Recursive(currentA , 0 , target ,maxA,maxB , visited)){
             return true;
         }
    
         // Case 5: Fill jug A
         if(currentA <maxA && Recursive(maxA,currentB,target,maxA,maxB , visited)){
             return true;
         }
    
         // Case 6: Fill jug B
         if(currentB <maxB && Recursive(currentA,maxB,target,maxA,maxB , visited)){
             return true;
         }
    
        return false;
    }


  
    public static void main(String [] args) {
        Iterative(3,4,2); //running the iterative approach
        int maxA = 3;
        int maxB = 4;
        int target = 2;
        boolean[][] visited = new boolean[maxA+1][maxB+1];
        for (int i = 0; i <= maxA; i++) {                   // The for loop in the given code initializes the boolean 2D array visited with false values. The loop iterates over each element in the array, setting each element to false. 
                                                            // The loop variable i corresponds to the amount of water in jug A, and the loop variable j corresponds to the amount of water in jug B.  
            for (int j = 0; j <= maxB; j++) {
                visited[i][j] = false;
            }
        }
        if(Recursive(0, 0, target, maxA, maxB, visited) == true){ //running the recursive approach
            System.out.println("One of the jar has been successfuly filled with "+ target +" litres of water using the recursive method"); // checks the recursive approach

        }
       
    }
    
}
    

