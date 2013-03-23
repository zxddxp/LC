package com.github.zxddxp.LC;

public class MaxArea {

	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int result = 0;
		if (height == null || height.length < 2) {
			return result;
		}

		int maxV = height[0];
		int mid = 0;
		//first, find the peak, which is "inside" the final bucket
		for (int i = 1; i < height.length; i++)	{
			if (height[i] > maxV) {
				maxV = height[i];
				mid = i;
			}
		}

		int i = 0;
		int j = height.length-1;
		int leftMax = height[i];
		int rightMax = height[j];
		result = (Math.min(leftMax, rightMax)*(j-i));
		while (i < j) {
			if (i == mid || leftMax > rightMax) {
				j--;
			}
			else if (j == mid || leftMax <= rightMax) {
				i++;
			}

			if (height[i] > leftMax) {
				leftMax = height[i];
				int tempResult = (Math.min(leftMax, rightMax)*(j-i));
				result = Math.max(result, tempResult);
			}

			if (height[j] > rightMax) {
				rightMax = height[j];
				int tempResult = (Math.min(leftMax, rightMax)*(j-i));
				result = Math.max(result, tempResult);					
			}
		}

		return result;
	}

}
