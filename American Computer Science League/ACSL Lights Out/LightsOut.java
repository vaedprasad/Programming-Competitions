import java.util.*;
import java.io.*;
import java.math.BigInteger;
/**
 * Write a description of class ACSLString here.
 * 
 * @author Vaed Prasad
 */
public class LightsOut
{   
    public static void main (String[] args) {
        System.out.print("\f");
        Scanner input;
        String[] boards = new String[6];

        System.out.println("Enter line 1: ");
        input = new Scanner(System.in);
        String start = input.nextLine();
        boards[0] = start;

        for(int i = 1; i < 6; i++){
            System.out.println("Enter line " + (i+1) + ": ");
            input = new Scanner(System.in);
            String b = input.nextLine();
            boards[i] = b;

            convert(boards, i);
            System.out.println("");
        }
    }

    public static void convert(String[] boards, int index) {
        boolean[][] startBoard = new boolean [8][8];
        boolean[][] currentBoard = new boolean [8][8];
        String start = boards[index-1];
        String current = boards[index];
        
        
        for(int i = 0; i < 16; i += 4) {
            String str = start.substring(i,i+4);
            String first = str.substring(0,4);
            String second = str.substring(4,8);
            for(int j = 0; j < 8; j++) {
                if(first.substring(j,j+1) == 1) {
                    
                }
            }
        }

    }

    public static String hexToBin(String hex) {
        String preBin = new BigInteger(hex, 16).toString(2);
        Integer length = preBin.length();
        if (length < 16) {
            for (int i = 0; i < 16 - length; i++) {
                preBin = "0" + preBin;
            }
        }
        return preBin;
    }
}