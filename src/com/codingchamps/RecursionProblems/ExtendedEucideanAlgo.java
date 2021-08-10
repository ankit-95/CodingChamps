package com.codingchamps.RecursionProblems;

/*Extended Euclidean Algorithm:
        Extended Euclidean algorithm also finds integer coefficients x and y such that:

        ax + by = gcd(a, b)
        Examples:

        Input: a = 30, b = 20
        Output: gcd = 10
        x = 1, y = -1
        (Note that 30*1 + 20*(-1) = 10)

        Input: a = 35, b = 15
        Output: gcd = 5
        x = 1, y = -2
        (Note that 35*1 + 15*(-2) = 5)
        The extended Euclidean algorithm updates results of gcd(a, b) using the results calculated by recursive call gcd(b%a, a).
        Let values of x and y calculated by the recursive call be x1 and y1. x and y are updated using the below expressions.
        x = y1 - ⌊b/a⌋ * x1
        y = x1
 As seen above, x and y are results for inputs a and b,
        a.x + b.y = gcd                      ----(1)

        And x1 and y1 are results for inputs b%a and a
        (b%a).x1 + a.y1 = gcd

        When we put b%a = (b - (⌊b/a⌋).a) in above,
        we get following. Note that ⌊b/a⌋ is floor(b/a)

        (b - (⌊b/a⌋).a).x1 + a.y1  = gcd

        Above equation can also be written as below
        b.x1 + a.(y1 - (⌊b/a⌋).x1) = gcd      ---(2)

        After comparing coefficients of 'a' and 'b' in (1) and
        (2), we get following
        x = y1 - ⌊b/a⌋ * x1
        y = x1*/
public class ExtendedEucideanAlgo {
    static public int  extendedEuclideanAlgo(int a, int b,int x,int y){
        if(a==0){
            x = 0;
            y=1;
            return b;
        }
        int x1=1,y1=1;
        int gcd =  extendedEuclideanAlgo(b%a,a,x1,y1);
        x = y1 - (b/a) * x1;
        y = x1;
        return gcd;
    }
}
