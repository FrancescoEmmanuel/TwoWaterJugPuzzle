# TwoWaterJugPuzzle :beer: :beer:
 This repo contains my implementation and analysis of the Two Water Jug Puzzle by using both iteration and recursion in Java.
 You can find and download my implementation code from this repo.
<br>
## The puzzle :jigsaw:
 Implement the following problems by using both iteration and recursion. Also analyse the performance of both approaches.<br>

You have given two empty jugs A and B in which the volume of liquid that can be poured is not marked. But Jug A can hold a maximum amount of 03 Liters and Jar B can hold a maximum amount of 04 Liters. There’s an unlimited amount of water resources and also a place to discharge water. The aim is to have 02 Liters of water from one of the jugs.
## Analysis :detective:
### :one: Iterative approach
The time complexity of the iterative approach is O(ab), where 'a' is the first jug's maximum capacity (3 in this case) and 'b' is the second jug's maximum capacity (4 in this case). This is due to the fact that, in the worst case scenario, it might be necessary to try all of the jugs' possible states (a x b states) before we get the solution and we are using nested loops to iterate through all possible states . Furthermore, as every potential state of the jars are stored in the queue, the space complexity is also O(ab).
'''
 
        
      public static void Iterative(int maxA, int maxB, int target) {  // the  parameters are the max capacity of both jars, and the target volume of one of the jar
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
'''
### :two: Recursive approach
Now for the recursive approach, the time complexity is also O(ab) as all the possible states of the jugs might be explored (just like the iterative approach). Each recursive call generates two new states, so the number of recursive calls is proportional to the number of states, therefore, the time complexity can be expressed as O(ab). This approach has a space complexity of O(a+b) since there can be up to a + b recursive calls on the call stack at once and each recursive call generates a new set of variables to represent the state of the jugs.
'''
    
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
'''

 ### :white_check_mark: Verdict
So in conclusion, the iterative and recursive approaches are comparable in terms of their time complexity at O(ab). However, the need to create new variables on each recursive call, results in a higher space complexity for the recursive technique. Hence, the iterative approach might be recommended if memory utilization is a problem and it may also be faster as it does not have the overhead of function calls and recursive stack frames. But the recursive approach might be favored if code clarity is a priority as it is usually simpler to read and comprehend.
