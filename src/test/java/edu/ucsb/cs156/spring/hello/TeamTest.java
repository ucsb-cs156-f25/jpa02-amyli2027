package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_same_object() {
        Team tp = team;
        assert(team.equals(tp));
    }

    @Test
    public void returns_different_class() {
        int tp = 1;
        assertEquals(false, team.equals(tp));
    }

    @Test
    public void returns_same_class_diff_obj() {
        Team tp = new Team("t");
        assertEquals(false, team.equals(tp));
    }

    @Test
    public void returns_same_class_same_obj() {
        Team tp = new Team("test-team");
        tp.setMembers(team.getMembers());
        assert(team.equals(tp));
    }

    @Test
    public void returns_different_members() {
        Team tp = new Team("test-team");
        tp.addMember("joe");
        assertEquals(false, team.equals(tp));
    }


    @Test
    public void hash_code_cheat() {
        Team t = new Team("t");
        int result = t.hashCode();
        int expectedResult = 117;
        assertEquals(expectedResult, result);
    }
    
/*
    @Test
    public void checkHash() {
        Team tp1 = new Team("test-team");
        tp1.addMember("bar");
        Team tp2 = new Team("test-team");
        tp2.addMember("bar");
        assertEquals(tp1.hashCode(), tp2.hashCode());
    }
    */

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
