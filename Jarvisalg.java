/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarivisalg;

import java.util.Arrays;
import java.util.Scanner;

public class Jarvisalg {
    public static Scanner ul = new Scanner(System.in);
    static class Point {
        int x;
        int y;
    }

    public static class Jarvis {

        public void ispisi(Point[] points, int[] next) {
            System.out.println("\ntacke : ");

            for (int i = 0; i < next.length; i++)
                if (next[i] != -1) {
                    System.out.println("( " + points[i].x + ", " + points[i].y + " )");
                }
        }
        private boolean orijentacija(Point p, Point q, Point r) {
            int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
            return !(val >= 0);
        }
        public void Jarvis(Point[] points) {
            if (points.length <= 2)
                return;
            int[] next = new int[points.length];
            Arrays.fill(next, -1);

            int lMax = 0;
            for (int i = 1; i < points.length; i++)
                if (points[i].x < points[lMax].x)
                    lMax = i;
            int m = lMax, n;
            do {
                n = (m + 1) % points.length;
                for (int i = 0; i < points.length; i++)
                    if (orijentacija(points[m], points[i], points[n]))
                        n = i;
                next[m] = n;
                m = n;
            } while (m != lMax);
            ispisi(points, next);
        }


        


    }


    public static void main(String[] args) {
        

    }
}

