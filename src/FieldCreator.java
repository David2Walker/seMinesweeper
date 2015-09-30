/**
 * Created by David on 9/27/2015.
 */

import java.io.*;
import java.util.*;

public class FieldCreator
{
    public static void main(String args[]) throws FileNotFoundException
    {
        int min = 0;
        int max = 100;
        int num = -1;
        try
        {
            File out = new File("field.txt");
            FileWriter fw = new FileWriter(out);
            PrintWriter pw = new PrintWriter(fw);


            Random r = new Random();

            pw.println(max + " " + max);

            for(int i = 0; i < max; i++)
            {
                for(int j = 0; j < max; j++)
                {
                    num = r.nextInt(max);
                    if(num > 85)
                    {
                        pw.print("*");
                        //System.out.print("*");
                    }
                    else
                    {
                        pw.print(".");
                        //System.out.print(".");
                    }
                }
                pw.println();
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
