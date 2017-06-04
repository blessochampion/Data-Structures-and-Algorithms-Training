/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big4prep;

import java.util.Scanner;

/**
 *
 * @author azeez
 */
public class MultiplyTwoNumbers {

    public static void main(String[] args) {
        
        String a = "77777777777777777777777777777777777733333333333333333333777777777777733333333333335777777777777777777777777777773333333333333333333377777777777777777777777777777777777777777333333333333333333337777777777777777777777777777777777777777733333333333333333333777773333337777777777777777777777777777777777777777733333333333333333333777773333337777777777777777777777777777777777777777733333333333333333333777773333337777777777777777777777777777777777777777733333333333333333333777773337777733333377777777777777777777777777777777777777777333333333333333333337777733377777333333777777777777777777777777777777777777777773333333333333333333377777333777773333337777777777777777777777777777777777777777733333333333333333333777773333337777777777777777777777777777777777777777733333333333333333333777773337777733333377777777777777777777777777777777777777777333333333333333333337777733377777333777773333337777777777777777777777777777777777777777733333333333333333333777773337777733333377777777777777777777777777777777777777777333333333333333333337777733377777333333777777777777777777777777777777777777777773333333333333333333377777998653";
        String b = "7777777777777777777777777777777777773333333333333333333377777777777777777777777777777777777333333333337777733377777333333777777777777777777777777777777777777777773333333333333333333377777777777333333333333333333337777777777777777777777777777777777777777733333333333333333333777777777777777777777777777777777777777777777777733333333333333333333777773333337777777777777777777777777777777777777777777777777333333333333333333337777733333377777777777777777777777777777777777777777333333333333333377777777333377777333333777777777777777777777777777777777777777773333333333333333333377777777777777777777777777";
        MultiplyTwoNumbers mult = new MultiplyTwoNumbers();
        int[] f = convert(a);

        int[] s = convert(b);
        String[] result = mult.multiply(f, s);
        String[] mresult = arrange(result);
        printArr(result);
        String sum = "0";
        for (int k = 0; k < mresult.length; k++) {

            sum = add(sum, mresult[k]);
        }
        System.out.println(sum);
    }

    public static String add(String a1, String b1) {
        int[] a = convert(a1);
        int[] b = convert(b1);
        int l = a.length - 1;
        int m = b.length - 1;
        int sum = 0;
        int carry = 0;
        int rem = 0;
        String temp = "";
        if (a.length > b.length) {
            while (m >= 0) {
                sum = a[l] + b[m] + carry;
                carry = sum / 10;
                rem = sum % 10;
                temp = rem + temp;
                m--;
                l--;
            }
            while (l >= 0) {
                sum = a[l] + carry;
                carry = sum / 10;
                rem = sum % 10;
                temp = rem + temp;
                l--;
            }
            if (carry > 0) {
                temp = carry + temp;
            }
        } else {
            while (l >= 0) {
                sum = a[l] + b[m] + carry;
                carry = sum / 10;
                rem = sum % 10;
                temp = rem + temp;
                m--;
                l--;
            }
            while (m >= 0) {
                sum = b[m] + carry;
                carry = sum / 10;
                rem = sum % 10;
                temp = rem + temp;
                m--;
            }
            if (carry > 0) {
                temp = carry + temp;
            }
        }
        return temp;

    }

    public static int[] convert(String a) {
        int[] temp = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            temp[i] = Character.digit(a.charAt(i), 10);

        }
//        printArr(temp);

        return temp;
    }
    
    public static void printArr(String[] a){
        
        for(String b : a){
         System.out.print(b +" ");
        }
       
    }

    public static String[] arrange(String[] result) {
        for (int i = 0; i < result.length; i++) {
            int j = 0;
            while (j < i) {
                result[i] = result[i] + "0";
                j++;
            }
        }
        return result;
    }

    public String[] multiply(int[] a, int[] b) {
        String[] temp = new String[b.length];
        for (int i = b.length - 1; i >= 0; i--) {

            int carry = 0;
            int result = 0;
            int rem = 0;
            temp[b.length - i - 1] = "";
            for (int j = a.length - 1; j >= 0; j--) {
                result = a[j] * b[i] + carry;
                carry = result / 10;
                rem = result % 10;
                temp[b.length - i - 1] = rem + temp[b.length - i - 1];
            }
            if (carry > 0) {
                temp[b.length - i - 1] = carry + temp[b.length - i - 1];
            }
        }
        return temp;
    }
}
