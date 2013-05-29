package com.github.zxddxp.LC;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s == null || s.length() == 0) {
            return true;
        }
        else {
            int left = 0;
            int right = s.length()-1;
            int leftIdx = 0;
            int rightIdx = 0;
            while (left < right) {
                while (left < right) {
                    char c = s.charAt(left);
                    if (! ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                        left++;
                    }
                    else {
                        if (c >= 'A' && c <= 'Z') {
                            leftIdx = (int) (c - 'A');
                        }
                        else if (c >= 'a' && c <= 'z') {
                            leftIdx = (int) (c - 'a');
                        }
                        else {
                            leftIdx = (int) (c - '0') + 100;
                        }
                        break;
                    }
                }
                while (left < right) {
                    char c = s.charAt(right);
                    if (! ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                        right--;
                    }
                    else {
                        if (c >= 'A' && c <= 'Z') {
                            rightIdx = (int) (c - 'A');
                        }
                        else if (c >= 'a' && c <= 'z') {
                            rightIdx = (int) (c - 'a');
                        }
                        else {
                            rightIdx = (int) (c - '0') + 100;
                        }
                        break;
                    }
                }
                if (left < right) {
                    if (leftIdx != rightIdx) {
                        return false;
                    }
                }
                left ++;
                right --;
            }

            return true;
        }

    }

}
