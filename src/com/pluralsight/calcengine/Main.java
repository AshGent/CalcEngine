package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            performCalculations();
        } else if(args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if(args.length == 3)
            handleCommandLine(args);
        else System.out.println("Please provide an operation code and 2 numeric values");
    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("Result = " + equation.getResult());
        }
        System.out.println("Average result = " + MathEquation.getAverageResult());

        useOverloads();

    }

    static void useOverloads() {
        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overload result with ints: " + equationOverload.getResult());

    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathEquation equation = new MathEquation();
        equation.setOpCode(opCodeFromString(parts[0]));
        equation.setLeftVal(valueFromWord(parts[1]));
        equation.setRightVal(valueFromWord(parts[2]));
        equation.execute();
        displayResult(equation.getOpCode(), equation.getLeftVal(), equation.getRightVal(), equation.getRightVal());
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        System.out.println(output);
    }

    private static void handleCommandLine(String[] args) {
        MathEquation equation = new MathEquation();
        equation.setOpCode(args[0].charAt(0));
        equation.setLeftVal(Double.parseDouble(args[1]));
        equation.setRightVal(Double.parseDouble(args[2]));
        equation.execute();
        displayResult(equation.getOpCode(), equation.getLeftVal(), equation.getRightVal(), equation.getResult());
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'd', 'm'};
        char[] symbols = {'+', '-', '/', '*'};
        char symbol = ' ';
        for(int i = 0; i < opCodes.length; i++){
            if(opCode == opCodes[i]){
                symbol  = symbols[i];
                break;
            }
        }
        return symbol;
    }
}
