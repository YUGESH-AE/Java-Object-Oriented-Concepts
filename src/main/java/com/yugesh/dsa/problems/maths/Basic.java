package com.yugesh.dsa.problems.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basic {
    static void main() {
        System.out.println(countNoOfDigits(0));
        System.out.println(reverseOfNumbers(1340000));
        System.out.println(isArmStrong(371));
        System.out.println(printDivisor(36));
        System.out.println(isPrime(13));
        System.out.println(GCD(20, 40));
    }

    public static int countNoOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int reverseOfNumbers(int n) {
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem != 0) {
                rev = (rev * 10) + rem;
            }
            n = n / 10;
        }
        return rev;
    }

    public static boolean isArmStrong(int n) {
        int original = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + (rem * rem * rem);
            n = n / 10;
        }
        if (sum == original) return true;
        else return false;
    }

    public static List<Integer> printDivisor(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                int num = n / i;
                if (num != i) {
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) {
                    count++;
                }
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    public static int GCD(int n1, int n2) {
        int max = Integer.MIN_VALUE;
        int n = Math.min(n1, n2);
        for (int i = 1; i <= n; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
