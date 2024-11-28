package com.example.androidcalculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<Member> members=new ArrayList<>();
    private int currMemberId =-1;
    private boolean isOpen=true;
    public Expression() {
    }

    public Expression(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    public void addNumber(String number){
        if(currMemberId >-1) {
            Member currMember =members.get(currMemberId);
            if (currMember.getInsideExpression() != null) {
                if (currMember.getInsideExpression().isOpen()) {
                    currMember.getInsideExpression().addNumber(number);
                }
            }
            else{
                members.get(currMemberId).addNumber(number);
            }
        }
        else{
            this.addMember(new Member("+",null,number,null));
        }
    }
    public void addOperand(String operand){
        Member member =new Member();
        member.setOperand(operand);
        this.addMember(member);
    }
    public void addMember(Member member){
        if(currMemberId >-1) {
            if (members.get(currMemberId).getInsideExpression() != null) {
                if (members.get(currMemberId).getInsideExpression().isOpen()) {
                    members.get(currMemberId).getInsideExpression().addMember(member);
                    return;
                }
            }

        }
        members.add(member);
        currMemberId++;

    }
    public void openExpression(){
        if(currMemberId >-1) {
            if (members.get(currMemberId).getInsideExpression() != null) {
                if (members.get(currMemberId).getInsideExpression().isOpen()) {
                    members.get(currMemberId).getInsideExpression().openExpression();
                }
            }
            else{
                if(members.get(currMemberId).getNumber()==null){
                    members.get(currMemberId).setNumber("1");
                }
                members.get(currMemberId).openInsideExpression();
            }
        }
        else{
            members.add(new Member(null,null,"1",null));
            currMemberId++;
            members.get(currMemberId).openInsideExpression();
        }

    }
    public void openExpression(String scientistExpression){

        if(currMemberId >-1) {
            if (members.get(currMemberId).getInsideExpression() != null) {
                if (members.get(currMemberId).getInsideExpression().isOpen()) {
                    members.get(currMemberId).getInsideExpression().openExpression(scientistExpression);
                }
            }
            else{
                if(members.get(currMemberId).getNumber()==null){
                    members.get(currMemberId).setNumber("1");
                }
                members.get(currMemberId).setScientistExpression(scientistExpression);
                members.get(currMemberId).openInsideExpression();
            }
        }
        else{
            members.add(new Member(null,scientistExpression,null,null));
            currMemberId++;
            members.get(currMemberId).addNumber("1");
            members.get(currMemberId).openInsideExpression();
        }
    }
    public void closeExpression(){
        if(currMemberId >-1) {
            if (members.get(currMemberId).getInsideExpression() != null) {
                if (members.get(currMemberId).getInsideExpression().isOpen()) {
                    members.get(currMemberId).getInsideExpression().closeExpression();
                    return;
                }

            }
        }
        isOpen=false;

    }
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
    public double calculateResult(){
        double result=0;
        List<Member> copyMembers=getCopyOfMembers();
        List<Member> results=new ArrayList<>();
        for(int i=0; i<copyMembers.size();i++){
            if(i==copyMembers.size()-1){
                Member currMember =copyMembers.get(i);
                Double number= currMember.calculateResult();
                currMember.setNumber(number.toString());
                currMember.setScientistExpression(null);
                currMember.setInsideExpression(null);
                results.add(currMember);
                break;
            }
            Member nextMember =copyMembers.get(i+1);
            if("*".equals(copyMembers.get(i+1).getOperand())){
                Member currMember =copyMembers.get(i);
                Double number= currMember.calculateResult()* nextMember.calculateResult();
                nextMember.setNumber(number.toString());
            }
            else if("/".equals(copyMembers.get(i+1).getOperand())) {
                Member currMember = copyMembers.get(i);
                Double number = currMember.calculateResult() / nextMember.calculateResult();
                nextMember.setNumber(number.toString());
            }
            else if("+".equals(copyMembers.get(i+1).getOperand()) || "-".equals(copyMembers.get(i+1).getOperand())){
                results.add(copyMembers.get(i));
            }

        }
        for(int i=results.size()-1; i>0;i--) {
            Member currMember = results.get(i);
            if ("+".equals(copyMembers.get(i).getOperand())) {
                Member prevMember = results.get(i - 1);
                Double number = prevMember.calculateResult() + currMember.calculateResult();
                prevMember.setNumber(number.toString());
            } else if ("-".equals(copyMembers.get(i).getOperand())) {
                Member prevMember = results.get(i - 1);
                Double number = prevMember.calculateResult() - currMember.calculateResult();
                prevMember.setNumber(number.toString());
            }
        }
        if("-".equals(results.get(0).getOperand())){
            return Double.parseDouble(results.get(0).getNumber())*-1;
        }
        return Double.parseDouble(results.get(0).getNumber());

    }
    public List<Member> getCopyOfMembers(){
        List<Member> result=new ArrayList<>();
        for(int i=0; i<members.size();i++){
            Member currMember=members.get(i);
            Member member=new Member(currMember.getOperand(),currMember.getScientistExpression(),currMember.getNumber(),currMember.getInsideExpression());
            result.add(member);
        }
        return result;
    }
    @Override
    public String toString(){
        String result="";
        for(int i=0; i<members.size();i++){
            result+=members.get(i).toString();
            if(i==0) {
                result=result.substring(1);
            }
        }
        if(!isOpen){
            result+=")";
        }
        return result;
    }
}
