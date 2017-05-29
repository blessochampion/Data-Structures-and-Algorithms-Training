/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big4prep;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 *
 * @author azeez
 */
public class ReverseInteger {
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        if (abs(x) < 10 && x != Integer.MIN_VALUE) {
            return x;
        }
        boolean s = x < 0;
        boolean t = x % 10 == 0;

        int result = 0;

        int x1 = abs(x);
        int x2 = x1;

        while (x1 > 0) {
            result = (result * 10) + (x1 % 10);
            x1 /= 10;
        }

        int left = 0;
        try {
            left = (result) / ((int) (pow(10, (int) Math.log10(result))));
        } catch (ArithmeticException e) {
            return 0;
        }

        int right = x2 % 10;

        if (t) {
            left *= 0;
        }
        if (left != right) {
            return 0;
        }

        return s ? result * -1 : result;

    }
}
