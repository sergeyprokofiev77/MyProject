// Deployed on Git: https://github.com/sergeyprokofiev77/MyProject.git
// Version 2. Added method public static String calc(String input)

package arabian;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Calculator {
    public static void main(String[] args) throws Exception {
        // arithmetic action like: 5+1, 9-2 etc
        // also Roman VI+I, V-I etc
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input math action (for example: 6+1, 10/2, VI-I, II*III): ");
        String inputLine = scanner.nextLine(); //input line
        //System.out.println(inputLine);       //just to check
        String resultLine = calc(inputLine);   //calculate input line
        System.out.println(resultLine);        //output of result as String line
    }

    public static String calc(String input) throws Exception {
        Converter converter = new Converter();
        String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8", "9" }; //possible actions
        String[] actions = {"+", "-", "/", "*"}; //possible actions
        String[] regexActions = {"\\+", "-", "/", "\\*"}; //regular form using

        // check action
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if(input.contains(actions[i])){
                actionIndex = i; //if was action, actionIndex>=0
                break;
            }
        }
        //if no action closing program
        if(actionIndex == -1){
            throw new Exception("Incorrect input, no math sign in your input");
        }
        // split input line by regexActions sign
        // "1+4" -> {"1", "4"}
        String[] data = input.split(regexActions[actionIndex]);
        if (data.length != 2) {
            throw new Exception("Incorrect input, only 2 parameters possible");
        }
        // taking off spaces from input line
        if (data[0].contains(" ")) data[0] = data[0].replace(" ", "");
        if (data[1].contains(" ")) data[1] = data[1].replace(" ", "");

        // a + b = result
        int a,b; int result = -1;
        String resultString; //for output as String format

        //check if a,b are Arabian digits
        if(data[0].matches("(?i)1|2|3|4|5|6|7|8|9|10")&&data[1].matches("(?i)1|2|3|4|5|6|7|8|9|10")){
            a = Integer.parseInt(data[0]); // convert String to int
            b = Integer.parseInt(data[1]); // convert String to int
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = a / b;
                    } else {
                        throw new Exception("Div to null not possible");
                    }
                    break;
                default:
                    throw new Exception("Something going wrong in my program");
            }
            resultString = String.valueOf(result);
            //System.out.println(resultString);
            return resultString;
        }

        //
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            //System.out.println(converter.RomanDigit(data[0]));
            a = converter.RomanDigit(data[0]); // convert String to int
            b = converter.RomanDigit(data[1]); // convert String to int

            // execute arithmetic action
            switch (actions[actionIndex]){
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0){
                        result = a / b;
                    } else {
                        throw new Exception("Div to null not possible");
                    }
                    break;
                default:
                    throw new Exception("Something going wrong in my program");
            }
            String resultRoman = "";
            if (result>=10){
                Integer decPart = result/10;
                if (decPart==10){resultRoman += "C";}
                if (decPart==9){resultRoman += "XC";}
                if (decPart==8){resultRoman += "LXXX";}
                if (decPart==7){resultRoman += "LXX";}
                if (decPart==6){resultRoman += "LX";}
                if (decPart==5){resultRoman += "L";}
                if (decPart==4){resultRoman += "XL";}
                if (decPart==3){resultRoman += "XXX";}
                if (decPart==2){resultRoman += "XX";}
                if (decPart==1){resultRoman += "X";}

                Integer digitPart = result%10;
                if (digitPart==9){resultRoman += "IX";}
                if (digitPart==8){resultRoman += "VII";}
                if (digitPart==7){resultRoman += "VII";}
                if (digitPart==6){resultRoman += "VI";}
                if (digitPart==5){resultRoman += "V";}
                if (digitPart==4){resultRoman += "IV";}
                if (digitPart==3){resultRoman += "III";}
                if (digitPart==2){resultRoman += "II";}
                if (digitPart==1){resultRoman += "I";}

                //System.out.println(resultRoman);//Roman result only >0

            }else if(result>0 & result<=9){
                if (result==9){resultRoman += "IX";}
                if (result==8){resultRoman += "VIII";}
                if (result==7){resultRoman += "VII";}
                if (result==6){resultRoman += "VI";}
                if (result==5){resultRoman += "V";}
                if (result==4){resultRoman += "IV";}
                if (result==3){resultRoman += "III";}
                if (result==2){resultRoman += "II";}
                if (result==1){resultRoman += "I";}
            }
            else{
                throw new Exception("Operating Roman digits only positive result possible");
            }

            // result output. Roman result only >0
            resultString = resultRoman;
            //System.out.println(resultString);
            return resultString;

        }else{
            throw new Exception("One format shall be used. Both digits Roman or both Arabic. Roman in array[I,X]");
        }


    }
}
