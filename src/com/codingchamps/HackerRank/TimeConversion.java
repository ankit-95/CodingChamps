package com.codingchamps.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        int h1 = (int)s.charAt(1) - '0';
        int h2 = (int)s.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10);
        String result="";
        //"AM"
        if (s.charAt(8) == 'A')
        {
            if (hh == 12)
            {
                result+="00";
                for (int i = 2; i <= 7; i++)
                    result+=s.charAt(i);
            }
            else
            {
                for (int i = 0; i <= 7; i++)
                    result+=s.charAt(i);
            }
        }

        //"PM"
        else
        {
            if (hh == 12)
            {
                result+="12";
                for (int i = 2; i <= 7; i++)
                    result+=s.charAt(i);
            }
            else
            {
                hh = hh + 12;
                result+=hh;
                for (int i = 2; i <= 7; i++)
                    result+=s.charAt(i);
            }
        }
        return result;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {

        String s = "07:05:45PM";
        String result = Result.timeConversion(s);
        System.out.printf(result);
    }
}