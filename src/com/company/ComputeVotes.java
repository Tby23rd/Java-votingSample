package com.company;

import java.util.Scanner;

public class ComputeVotes {

    private int totalVotesA;
    private int totalVotesB;
    private int numberOfStudents;
    private int votingPopulation;
    private int percentageVotesA;
    private int percentageVotesB;

    public int getPercentageVotesB() {
        return percentageVotesB;
    }

    public void setPercentageVotesB(int percentageVotesB) {
        this.percentageVotesB = percentageVotesB;
    }

    public int getPercentageVotesA() {
        return percentageVotesA;
    }

    public void setPercentageVotesA(int percentageVotesA) {
        this.percentageVotesA = percentageVotesA;
    }

    public int getTotalVotesA() {
        return totalVotesA;
    }

    public void setTotalVotesA(int totalVotesA) {
        this.totalVotesA = totalVotesA;
    }

    public int getTotalVotesB() {
        return totalVotesB;
    }

    public void setTotalVotesB(int totalVotesB) {
        this.totalVotesB = totalVotesB;
    }

    public int getVotingPopulation() {
        return votingPopulation;
    }

    public void setVotingPopulation(int votingPopulation) {
        this.votingPopulation = votingPopulation;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    public void AcceptData(){
        Scanner hey = new Scanner(System.in);

        boolean invalidStudentsA = false;
        
        while(!invalidStudentsA){
            System.out.println("Enter the number of votes for candidates A");
            String input = hey.next();
            try{
                totalVotesA = Integer.parseInt(input);
                invalidStudentsA= true;
            }catch (NumberFormatException e){
                System.out.println("You did not enter a valid number");
            }
        }

        boolean invalidStudents = false;

        while(!invalidStudents){
            System.out.println("Enter the number of votes for candidates B");            String input = hey.next();
            try{
                totalVotesB = Integer.parseInt(input);
                invalidStudents= true;
            }catch (NumberFormatException e){
                System.out.println("You did not enter a valid number");
            }
        }

        boolean invalidVoters = false;

        while(!invalidVoters){
            System.out.println("Enter the number of students who did not participate");
            String input = hey.next();
            try{
                numberOfStudents = Integer.parseInt(input);
                invalidVoters= true;
            }catch (NumberFormatException e){
                System.out.println("You did not enter a valid number");
            }

        }

    }

    public void calculatePercentage() {
        votingPopulation = numberOfStudents + totalVotesA + totalVotesB;
        System.out.println("The total voting population is " + votingPopulation);
        System.out.println("");
       percentageVotesA = totalVotesA *100/votingPopulation;
        percentageVotesB = totalVotesB *100 /votingPopulation;
        System.out.println("The percentage votes for candidate A is "+ percentageVotesA );
        System.out.println("");
        System.out.println("The percentage votes for candidate B is "+ percentageVotesB );
        System.out.println("");
        if(totalVotesA > totalVotesB){
            System.out.println("Congratulations candidate A you got the biggest vote" );
            System.out.println("");
        }else  if(totalVotesA < totalVotesB){
            System.out.println("Congratulations candidate B you got the biggest vote" );
            System.out.println("");
        }else {
            System.out.println("It was a tie");
        }

    }
    public void ComputeVotes(){

        if(totalVotesA > totalVotesB){
            System.out.println("Congratulations candidate A you won" );
            System.out.println("");
        }else  if(totalVotesA < totalVotesB){
            System.out.println("Congratulations candidate B you won" );
            System.out.println("");
        }else {
            System.out.println("It was a tie");
        }

    }

}
