/**
 * Created by David on 9/27/2015.
 */

import java.util.*;
import java.io.*;

public class FieldSolver
{
    public static void main(String args[])
    {
        try {
            File fin = new File("field.txt");
            Scanner f = new Scanner(fin);

            String character;
            int row, col = -1;

            String nums = f.nextLine();
            String[] snums = nums.split(" ");
            row = Integer.parseInt(snums[0]);
            col = Integer.parseInt(snums[1]);

            System.out.println(row + " " + col);
            String[][] field = new String[row][col];
            f.useDelimiter("");
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col-1; j++)
                {
                    character = f.next();
                    field[i][j] = character;
                    System.out.print(field[i][j]);
                }
                f.nextLine();
                System.out.println();
            }

            System.out.println();

            solve(field, row, col);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve(String[][] field, int row, int col)
    {
        int mcount=0;
        for(int i = 0; i < row; i++)
        {
            for (int j = 0; j < col-1; j++)
            {
                if(field[i][j].equals("*"))
                {
                    System.out.print(field[i][j]);
                }
                else
                {
                    if(i != 0 && j != 0 && i < row-1 && j < col-1)
                    {
                        if(field[i][j-1].equals("*")) //left
                            mcount++;
                        if(field[i][j+1] != null && field[i][j+1].equals("*")) //right
                            mcount++;
                        if(field[i+1][j].equals("*")) //down
                            mcount++;
                        if(field[i-1][j].equals("*")) //up
                            mcount++;
                        if(field[i+1][j-1].equals("*")) // up left
                            mcount++;
                        if(field[i][j+1] != null && field[i+1][j+1].equals("*")) // up right
                            mcount++;
                        if(field[i-1][j-1].equals("*")) // down left
                            mcount++;
                        if(field[i][j+1] != null && field[i-1][j+1].equals("*")) // down right
                            mcount++;
                    }

                    System.out.print(mcount);
                    mcount = 0;
                }
            }
            System.out.println();
        }
    }

}
