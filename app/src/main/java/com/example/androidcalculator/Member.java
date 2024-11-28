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
        if(this.number==null){
            this.number=number;
            return;
        }
        this.number+=number;
    }
    public void openInsideExpression(){
        insideExpression=new Expression();
    }
    public double calculateResult(){
        double result=Double.parseDouble(number);
        if(scientistExpression!=null){
            double insideResult=0;
            if(insideExpression!=null) {
                insideResult = insideExpression.calculateResult();
            }
            switch (scientistExpression){
                case "sin(":
                    result*=Math.sin(insideResult);
                    break;
                case "cos(":
                    result*=Math.cos(insideResult);
                    break;
                case "log(":
                    result*=Math.log(insideResult);
                    break;
                case "√(":
                    result*=Math.sqrt(insideResult);
                    break;
                case "(":
                    result*=insideResult;

            }
        }

        return result;
    }

    @Override
    public String toString(){
        String result=new String(operand);
        result+=number==null? "":number;
        result+=scientistExpression==null?"":scientistExpression;
        result+=insideExpression==null ? "":insideExpression.toString();

        return result;
    }
}
