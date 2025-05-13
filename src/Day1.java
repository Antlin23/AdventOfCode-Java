import java.util.*;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

public class Day1 {
    public void Run(String puzzleInput){
        //Make the list two separate lists and check the lowest number, after the lowest number is taken we remove it from the string

        int result = 0;

        var inputWithShortenedSpaces = puzzleInput.replaceAll(" {3}", " ");

        var splittedString = inputWithShortenedSpaces.split("\n");

        //Left list
        List<Integer> leftList = new ArrayList<>();

        //Right list
        List<Integer> rightList= new ArrayList<>();

        for (String s : splittedString) {
            //adds first number to the first list
            var firstNumber = s.split(" ")[0];
            leftList.add(parseInt(firstNumber));

            //adds the second number to the second list
            var secondNumber = s.split(" ")[1];
            rightList.add(parseInt(secondNumber));
        }

        //sorts in the right order
        Collections.sort(leftList);

        Collections.sort(rightList);

        //checks for lowest number, saves it and removes it from the list
        for (int i = 0; i < splittedString.length; i++){
            //calculates the distance between the two numbers
            var distance = leftList.getFirst() - rightList.getFirst();

            //removes the used numbers
            leftList.removeFirst();
            rightList.removeFirst();

            result = result + Math.abs(distance);
        }

        System.out.println("Result: " + result);
    }
}
