https://www.codingninjas.com/studio/problems/the-celebrity-problem_982769?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
class Solution {
	public static int findCelebrity(int n) {
		Stack<Integer> s = new Stack<Integer>();
		for( int i = 0; i < n; i++)
		{
			s.add(i);
		}

		while( s.size()>1)
		{
			int a = s.pop();
			int b = s.pop();

			if( Runner.knows(a,b))
			{
				// a is not a celebrity 
				s.push(b);
			}
			else
			{
				if(Runner.knows(b,a))
				{
					// b is not a celebrity
					s.push(a);
				}
			}
		}
		if(s.size() == 0)
		{
			return -1;
		}
		int get  = s.pop();
		for( int i = 0; i< n ; i++)
		{
			if( i != get)
			{
				if(Runner.knows(i,get) == false || Runner.knows(get,i) == true)
				{
					return -1;
				}
			}
		}
		return get;
 
    }

}
