
In Kotlin:

class MinimumHop {

    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 3, 6, 3, 2, 3, 6, 8, 9, 5)
        val n = arr.size
        System.out.print(
            "Minimum number of jumps to reach end is "
                    + minHop(arr, 0, n - 1)
        )
    }

    fun minHop(array: IntArray, l: Int, h: Int): Int {
        if (h == l)
            return 0
        if (array[l] == 0)
            return Int.MAX_VALUE

        var min = Int.MAX_VALUE
        var i = l + 1
        while (i <= h
            && i <= l + array.get(l)
        ) {
            val jumps: Int = minHop(array, i, h)
            if (jumps != Int.MAX_VALUE && jumps + 1 < min) min = jumps + 1
            i++
        }
        return min
    }
}

In Java:

import java.util.*; 
import java.io.*; 

class Demo { 

	static int minHopps(int arr[], int l, int h) 
	{ 
		// Base case: when source 
		// and destination are same 
		if (h == l) 
			return 0; 

		// When nothing is reachable 
		// from the given source 
		if (arr[l] == 0) 
			return Integer.MAX_VALUE; 

		// Traverse through all the points 
		// reachable from arr[l]. Recursively 
		// get the minimum number of jumps 
		// needed to reach arr[h] from these 
		// reachable points. 
		int min = Integer.MAX_VALUE; 
		for (int i = l + 1; i <= h 
							&& i <= l + arr[l]; 
			i++) { 
			int jumps = minHopps(arr, i, h); 
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) 
				min = jumps + 1; 
		} 
		return min; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; 
		int n = arr.length; 
		System.out.print("Minimum number of jumps to reach end is "
						+ minHopps(arr, 0, n - 1)); 
	} 
} 

NOte:


Complexity Analysis:

Time complexity: O(n^n).

There are maximum n possible ways to move from a element. So maximum number of steps can be N^N so the upperbound of time complexity is O(n^n)

Auxiliary Space: O(1).

There is no space required (if recursive stack space is ignored).

Note: If the execution is traced for this method, it can be seen that there will be overlapping subproblems. 

For example, minHopps(3, 9) will be called two times as arr[3] is reachable from arr[1] and arr[2]. 
So this problem has both properties of Dynamic Programming.

We can also solve this problem by dynamic programming.In that case the complixity will be Time Complexity: O(n^2).






