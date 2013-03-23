package com.github.zxddxp.LC;

import java.util.ArrayList;

public class GetRowPascal {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		rowIndex++;
		ArrayList<Integer> result = new ArrayList<Integer>(rowIndex);
		if (rowIndex == 0) {
			return result;
		}
		result.add(1);
		int currentRow = 1;
		while ( --rowIndex > 0 ) {
			currentRow++;
			int temp2 = 1;
			int temp1;
			for (int j = 1; j < currentRow-1; j++) {
				temp1 = temp2;
				temp2 = result.get(j);
				result.set(j, temp1+temp2);
			}
			result.add(1);
		}

		return result;
	}

}
