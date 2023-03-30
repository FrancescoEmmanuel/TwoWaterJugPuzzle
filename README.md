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
### :two: Recursive approach
Now for the recursive approach, the time complexity is also O(ab) as all the possible states of the jugs might be explored (just like the iterative approach). Each recursive call generates two new states, so the number of recursive calls is proportional to the number of states, therefore, the time complexity can be expressed as O(ab). This approach has a space complexity of O(a+b) since there can be up to a + b recursive calls on the call stack at once and each recursive call generates a new set of variables to represent the state of the jugs.
 ### :white_check_mark: Verdict
So in conclusion, the iterative and recursive approaches are comparable in terms of their time complexity at O(ab). However, the need to create new variables on each recursive call, results in a higher space complexity for the recursive technique. Hence, the iterative approach might be recommended if memory utilization is a problem and it may also be faster as it does not have the overhead of function calls and recursive stack frames. But the recursive approach might be favored if code clarity is a priority as it is usually simpler to read and comprehend.
