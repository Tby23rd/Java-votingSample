package com.company;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputeVoteTest {

    ComputeVotes obj = new ComputeVotes();
    @BeforeEach
    public void InitEach(){

        ByteArrayInputStream in = new ByteArrayInputStream
                ("15\n10\n5".getBytes());
        System.setIn(in);

    }

    @org.junit.jupiter.api.Test
    void acceptData() {

        obj.AcceptData();

        assertEquals(15, obj.getTotalVotesA());
        assertEquals(10, obj.getTotalVotesB());
        assertEquals(5, obj.getNumberOfStudents());


    }

    @org.junit.jupiter.api.Test
    void calculatePercentage(){

        obj.AcceptData();
        obj.calculatePercentage();
        assertEquals(30,obj.getVotingPopulation());
        assertEquals(50,obj.getPercentageVotesA());
        assertEquals(33,obj.getPercentageVotesB());

    }

    @org.junit.jupiter.api.Test
    void ComputeVotes(){

        obj.AcceptData();

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.ComputeVotes();
        assertEquals("Congratulations candidate A you won", captor.toString().trim());
        System.setOut(standardOut);

    }


    void TestException(){
        ByteArrayInputStream in = new ByteArrayInputStream("35\n23\n7".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        obj.AcceptData();
        assertTrue(new String(captor.toByteArray()).contains("You did not enter a valid Number"));

    }
    }
