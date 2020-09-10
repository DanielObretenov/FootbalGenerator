package FootballTeamGenerator;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File file = new File("FootballTeamGenerator\\example.txt");

        Map<String,Team> teams = new LinkedHashMap<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String input = bf.readLine();

            while (!input.equals("END")) {
                String[] commands = input.split(";");
                String command = commands[0];
                String teamName = commands[1];

                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        Validator.validateTeamNameIsNotTaken(teams, teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        Validator.validateTeamExists(teams, teamName);
                        String playerName = commands[2];
                        int endurance = Integer.parseInt(commands[3]);
                        int spring = Integer.parseInt(commands[4]);
                        int dribble = Integer.parseInt(commands[5]);
                        int passing = Integer.parseInt(commands[6]);
                        int shooting = Integer.parseInt(commands[7]);
                        teams.get(teamName).addPlayer(new Player(playerName, endurance, spring, dribble, passing, shooting));
                        break;
                    case "Remove":
                        playerName = commands[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        Validator.validateTeamExists(teams, teamName);
                        long averageRating = Math.round(teams.get(teamName).getRating());
                        System.out.println(teamName + " - " + averageRating);
                        break;
                }
                input = bf.readLine();
            }
        }
        catch (IllegalArgumentException | IOException ignored){
                System.out.println(ignored.getMessage());
            }

        }
    }



