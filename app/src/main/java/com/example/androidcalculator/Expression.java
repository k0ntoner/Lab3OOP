package com.example.androidcalculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<Member> members=new ArrayList<>();
    private int currMember=-1;
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
        if(currMember>-1) {
            if (members.get(currMember).getInsideExpression() != null) {
                if (members.get(currMember).getInsideExpression().isOpen()) {
                    members.get(currMember).getInsideExpression().addNumber(number);
                }
            }
        }
        else{
            members.get(currMember).addNumber(number);
        }
    }
    public void addOperand(String operand){
        Member member =new Member();
        member.setOperand(operand);
        this.addMember(member);
    }
    public void addMember(Member member){
        if(currMember>-1) {
            if (members.get(currMember).getInsideExpression() != null) {
                if (members.get(currMember).getInsideExpression().isOpen()) {
                    members.get(currMember).getInsideExpression().addMember(member);
                }
            }
        }
        else{
            members.add(member);
            currMember++;
        }
    }
    public void openExpression(){
        if(currMember>-1) {
            if (members.get(currMember).getInsideExpression() != null) {
                if (members.get(currMember).getInsideExpression().isOpen()) {
                    members.get(currMember).getInsideExpression().openExpression();
                }
            }
            else{
                members.get(currMember).openInsideExpression();
            }
        }
    }
    public void closeExpression(){
        if(currMember>-1) {
            if (members.get(currMember).getInsideExpression() != null) {
                if (members.get(currMember).getInsideExpression().isOpen()) {
                    members.get(currMember).getInsideExpression().closeExpression();
                }
            }
        }
        else{
            isOpen=false;
        }
    }
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString(){
        String result="";
        for(Member member:members){
            result+=member.toString();
        }
        return result;
    }
}
