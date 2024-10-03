package org.example;

import java.io.Serializable;

public class CalculationRequest implements Serializable {
    static final long serialVersionUID = 42L;

    private int operand1;
    private int operand2;
    private String operator;

    public CalculationRequest(int operand1, String operator, int operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}