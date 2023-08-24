735. Asteroid Collision


  import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stk = new ArrayDeque<>(); // stk = stack 
        
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || asteroids[i] > 0) {
                stk.push(asteroids[i]);
            } else {
                while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(asteroids[i])) {
                    stk.pop();
                }

                if (!stk.isEmpty() && stk.peek() == Math.abs(asteroids[i])) {
                    stk.pop();
                } else {
                    if (stk.isEmpty() || stk.peek() < 0) {
                        stk.push(asteroids[i]);
                    }
                } 
            }
        }
        
        int[] ans = new int[stk.size()];
        int size = stk.size();
        while (!stk.isEmpty()) {
            ans[--size] = stk.pop();
        }
        
        return ans;
    }
}



/* 

Intuition:
The intuition is to use the stack to keep track of the right-moving asteroids encountered so far. When a left-moving asteroid is encountered, we use the stack to simulate collisions and determine which asteroids survive.

Explanation:
1. Positive Asteroids (Right-moving):
* If the current asteroid is positive (right-moving) or the stack is empty, we directly push the asteroid onto the stack. Since right-moving asteroids will never collide with any previously encountered asteroids, we can safely add them to the stack.
2. Negative Asteroids (Left-moving):
* If the current asteroid is negative (left-moving), it may collide with previously encountered right-moving asteroids. In this case, we enter a while loop to simulate the collisions.
* While the stack is not empty and the top of the stack is positive (right-moving) and has a smaller absolute value than the absolute value of the current left-moving asteroid, we keep popping elements from the stack. This is to simulate the collision of the asteroids, where the larger asteroid survives, and the smaller one gets destroyed.
* If the while loop ends and the stack is not empty, we need to check if the current asteroid and the top of the stack have the same absolute value. If they do, it means they will mutually destroy each other, and we can simply pop the element from the stack without pushing the current asteroid.
4. Non-Collisions:
* If the while loop and collision checks do not apply (i.e., the stack is empty or the top of the stack is negative), it means the current left-moving asteroid will not collide with any remaining right-moving asteroids in the stack. In this case, we can safely push the current asteroid onto the stack.
4. Final Result:
* After processing all the asteroids, the remaining elements in the stack represent the final state of asteroids after all collisions have been simulated. We create a new 
* vector "ans" of the same size as the stack and store the elements of the stack into "ans" in reverse order (since we are popping elements from the stack).
The vector "ans" now contains the state of asteroids after all collisions. 


*/
