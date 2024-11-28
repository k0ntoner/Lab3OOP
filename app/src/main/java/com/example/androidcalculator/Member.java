package com.example.androidcalculator;

public class Member {
    private String operand;
    private String scientistExpression;

    private String number;

    private Expression insideExpression;

    public Member() {
    }

    public Member(String operand, String scientistExpression, String number, Expression insideExpression) {
        this.operand = operand;
        this.scientistExpression = scientistExpression;
        this.number = number;
        this.insideExpression = insideExpression;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getScientistExpression() {
        return scientistExpression;
    }

    public void setScientistExpression(String scientistExpression) {
        this.scientistExpression = scientistExpression;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public Expression getInsideExpression() {
        return insideExpression;
    }
    public void setInsideExpression(Expression insideExpression) {
        this.insideExpression = insideExpression;
    }
    public void addNumber(String number){
        if(this.operand==null){
            this.operand="+";
        }
        this.number+=number;
    }
    public void openInsideExpression(){
        insideExpression=new Expression();
    }
    @Override
    public String toString(){
        String result=new String(operand+number);
        for(Member member:members){
            result+=insideExpression.toString();
        }
        return result;
    }
}
