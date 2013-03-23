package com.github.zxddxp.LC;

public class ThreeSumCloest {

	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int result = Integer.MAX_VALUE;
		int sum = Integer.MIN_VALUE;

		//step 1, sort the array
		quickSort(num, 0, num.length-1);

		for (int i = 0; i < num.length-2; i++) {
			int start = i+1;
			int end = num.length-1;

			while (end > start) {
				while (end > (start+1)) {
					//step 2, move end
					if (num[i]+num[start]+num[end] > target 
							&&  num[i]+num[start]+num[end-1] > target) {
						end--;
					}
					else {
						break;
					}
				}
				int tempResult = Math.abs(num[i]+num[start]+num[end] - target);
				if (tempResult < result) {
					result = tempResult;
					sum = num[i]+num[start]+num[end];
				}
				if (end > (start+1)) {
					tempResult = Math.abs(num[i]+num[start]+num[end-1] - target);
					if (tempResult < result) {
						result = tempResult;
						sum = num[i]+num[start]+num[end-1];
					}
				}
				start++;
			}
		}

		return sum;

	}
	
	public void quickSort(int[] num, int start, int end) {
		if (num == null || (start >= end)) {
			return;
		}

		else {
			int pivot = num[end];
			int hole = end;
			int my_start = start;
			int my_end = hole - 1;
			while (true) {
				//forward round
				while(my_start < hole && num[my_start] <= pivot) {
					my_start++;
				}
				if (my_start == hole) {//done
					num[hole] = pivot;
					break;
				}
				else {
					num[hole] = num[my_start];
					my_end = hole - 1;
					hole = my_start;
				}
				//backward round
				while(my_end > hole && num[my_end] > pivot) {
					my_end --;
				}
				if (my_end == hole) {//done}
					num[hole] = pivot;
					break;
				}
				else {
					num[hole] = num[my_end];
					my_start = hole + 1;
					hole = my_end;
				}
			}
			
			quickSort(num, start, hole-1);
			quickSort(num, hole + 1, end);
		}
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
}