import java.util.*;
/**
 * Write a description of class ACSLString here.
 * 
 * @author Vaed Prasad
 */
public class AscendingStrings
{   
    public static void main (String[] args) {
        System.out.print("\f");
        Scanner input;
        for(int i = 0; i < 5; i++){
            System.out.println("Enter line " + (i+1) + " ");
            input = new Scanner(System.in);
            String in = input.nextLine();
            convert(in, 0, -1);
            System.out.println("");//31415926538
        }
    }

    public static void convert(String str, int parity, int num) {
        int odd_counter = 1;
        int even_counter = 1;
        while(parity == 0) {
            if (odd_counter > str.length())
                break;
            if(Integer.parseInt(str.substring(0,odd_counter)) > num) {
                num = Integer.parseInt(str.substring(0,odd_counter));
                System.out.print(num + " ");
                convert(str.substring(odd_counter), 1, num); 
                break;
            }
            odd_counter++;
        }
        while(parity == 1) {
            if (even_counter > str.length())
                break;
            int value = reverse(Integer.parseInt(str.substring(str.length()-even_counter)));
            if(value > num) {
                num = value;
                System.out.print(num + " ");
                convert(str.substring(0,str.length() - even_counter), 0, num);
                break;
            }
            even_counter++;
        }
    }

    public static int reverse (int n) {
        int reverse = 0;
        while(n != 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }
}