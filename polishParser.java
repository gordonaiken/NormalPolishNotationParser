import java.util.*;
/**
 * A short program that solves equations entered in NPN (Normal Polish Notation).
 * Final version completed 13.01.2018
 *
 * @author (Gordon Aiken)
 * @version (13.01.18)
 */
public class polishParser
{
    /**
     * Constructor for objects of class polishParser
     */
    public polishParser()
    {
    }

    /**
     * Main method, this will run run from the shell terminal.
     * 
     * Pipe equations into this program in the unix shell as follows:
     * 
     * user$ javac polishParser.java
     * user$ echo + x - 10 7 4 5 | java polishParser
     *
     * @param  y  String[] args
     * @return    void, no return statement
     */
    public static void main(String[] args)
    {
        // Scanner s receives input from the command line
        Scanner s= new Scanner(System.in);

        // Temporary array to move the system.in elements to a more flexible collection type
        ArrayList<String> polishList = new ArrayList<>();

        while (s.hasNext()){
            polishList.add(s.next());
        }

        while (polishList.size() >= 2){
            // Split elements into operators and operands(values)
            for (int i = polishList.size()-1 ; i>=0 ; i--){
                if (polishList.get(i).equals("+")) {
                    int res = Integer.parseInt(polishList.get(i+1)) + Integer.parseInt(polishList.get(i+2));
                    polishList.remove(i + 2);
                    polishList.remove(i + 1);
                    polishList.add(i+1, Integer.toString(res));
                    polishList.remove(i);
                }
                else if (polishList.get(i).equals("-")){
                    int res = Integer.parseInt(polishList.get(i+1)) - Integer.parseInt(polishList.get(i+2));
                    polishList.remove(i + 2);
                    polishList.remove(i + 1);
                    polishList.add(i+1, Integer.toString(res));
                    polishList.remove(i);
                } 
                else if (polishList.get(i).equals("x")){
                    int res = Integer.parseInt(polishList.get(i+1)) * Integer.parseInt(polishList.get(i+2));
                    polishList.remove(i + 2);
                    polishList.remove(i + 1);
                    polishList.add(i+1, Integer.toString(res));
                    polishList.remove(i);
                }

            }
        }

        int solution = Integer.parseInt(polishList.get(0));
        System.out.println(solution);
    }
}
