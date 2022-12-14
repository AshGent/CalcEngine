package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

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
