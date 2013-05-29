package com.github.zxddxp.LC;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (height == null || height.length == 0) {
            return 0;
        }

        int[] aux = new int[height.length];

        return solve(height, 0, height.length - 1, aux);
    }

    public int solve(int[] height, int left, int right, int[] aux) {
        if (left > right) {
            return 0;
        } else if (left == right) {
            return height[left];
        } else {
            int mid = (left + right) / 2;

            int leftMax = solve(height, left, mid - 1, aux);
            int rightMax = solve(height, mid + 1, right, aux);
            int result = Math.max(leftMax, rightMax);
            result = Math.max(result, baseCase(height, mid, left, right, aux));
            return result;
        }
    }

    public int baseCase(int[] height, int mid, int left, int right, int[] aux) {

        //step 1, expand
        int currentMin = height[mid];
        aux[mid] = height[mid];
        for (int i = mid - 1; i >= left; i--) {
            if (height[i] < currentMin) {
                currentMin = height[i];
            }
            aux[i] = currentMin;
        }
        currentMin = height[mid];
        for (int i = mid + 1; i <= right; i++) {
            if (height[i] < currentMin) {
                currentMin = height[i];
            }
            aux[i] = currentMin;
        }

        //step 2, shrink
        int size = right - left + 1;
        int maxSoFar = height[mid];
        while (!(left == mid && right == mid)) {
            if (left == mid) {
                maxSoFar = Math.max(maxSoFar, aux[right] * size);
                right--;
            } else if (right == mid) {
                maxSoFar = Math.max(maxSoFar, aux[left] * size);
                left++;
            } else if (aux[left] <= aux[right]) {
                maxSoFar = Math.max(maxSoFar, aux[left] * size);
                left++;
            } else {
                maxSoFar = Math.max(maxSoFar, aux[right] * size);
                right--;
            }
            size--;
        }

        return maxSoFar;
    }

}
