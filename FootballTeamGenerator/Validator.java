package FootballTeamGenerator;

import java.util.Map;

public class Validator {
    public static void ValidateStats(int value,String statsType){
        if (value<0 || value>100){
            throw new IllegalArgumentException(statsType+" should be between 0 and 100.");

        }
    }
    public static void validateName(String name){
        if ( name == null||name.trim().equals("")  ){
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
    public static void validatePlayer(int oldSize, int size, String name, String team){
        if (oldSize==size){
            throw new IllegalArgumentException("Player " + name + " is not in " + team + " team.");
        }
    }
    public static void validateTeamNameIsNotTaken(Map<String,Team> teams, String teamName){
        if (teams.containsKey(teamName)){
            throw new IllegalArgumentException("Team already exists");
        }
    }
    public static void validateTeamExists(Map<String,Team> teams, String teamName){
        if (!teams.containsKey(teamName)){
            throw new IllegalArgumentException("Team "+teamName+" does not exist.");
        }
    }

}
