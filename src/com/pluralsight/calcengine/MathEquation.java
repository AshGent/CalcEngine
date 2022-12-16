package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch (opCode) {
            case 'a' -> this.setResult(leftVal + rightVal);
            case 's' -> this.setResult(leftVal - rightVal);
            case 'm' -> this.setResult(leftVal * rightVal);
            case 'd' -> this.setResult(rightVal != 0 ? leftVal / rightVal : 0.0d);
            default -> this.setResult(0.0d);
        }
        numberOfCalculations++;
        sumOfResults += this.getResult();
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();

        result = (int)result;
    }

    public char symbolFromOpCode() {
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

    public String toString() {
        char symbol = symbolFromOpCode();
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
