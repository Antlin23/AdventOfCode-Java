import java.util.*;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

public class Day1 {
    public void Run(String puzzleInput){
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
        PartOne(leftList, rightList, splittedString);

        PartTwo(leftList, rightList);
    }

    //Check the lowest number, after the lowest number is taken we remove it from the string
    public void PartOne(List<Integer> leftList, List<Integer> rightList, String[] splittedString){
        // Make copies so we don't modify the original lists
        List<Integer> sortedLeft = new ArrayList<>(leftList);
        List<Integer> sortedRight = new ArrayList<>(rightList);

        var result = 0;

        //sorts in the right order
        Collections.sort(sortedLeft);
        Collections.sort(sortedRight);

        //checks for lowest number, saves it and removes it from the list
        for (int i = 0; i < splittedString.length; i++){
            int distance = Math.abs(sortedLeft.get(i) - sortedRight.get(i));
            result += distance;
        }

        System.out.println("Result part one: " + result);
        //Part 1 answer: 2756096
    }

    public void PartTwo(List<Integer> leftList, List<Integer> rightList){
        var partTwoResult = 0;
        for (Integer integer : leftList) {
            for (Integer value : rightList) {
                if (Objects.equals(integer, value)) {
                    partTwoResult += integer;
                }
            }
        }
        System.out.println("Result part two: " + partTwoResult);
        //Part 2 answer: 23117829
    }
}