package Chapter5;

import java.util.Scanner;

/*
You are interested in keeping track of the team members and
competition information for your school’s annual entries in computer science programming competitions.
Each team consists of exactly four team members. Every year your team competes in two competitions.
As an initial start for your database, create a class named Team that has the following instance variables:
Note that there is a much better way to represent the team members and competitions using arrays;
this is covered in a subsequent chapter.
The class should also have a method that outputs all the names of all team members and
the competition information to the console.
*/
public class Question4
{
}

class Competition
{

    private String competitionName, winningTeam, secondPlace;

    private int year;

    public Competition(String competitionName, String winningTeam, String secondPlace, int year)
    {
        this.competitionName = competitionName;
        this.winningTeam = winningTeam;
        this.secondPlace = secondPlace;
        this.year = year;
    }

    public Competition()
    {
        this.competitionName = null;
        this.winningTeam = null;
        this.secondPlace =  null;
        this.year = 0000;
    }

    public Competition(Competition competition)
    {
        this.competitionName = competition.getCompetitionName();
        this.winningTeam = competition.getWinningTeam();
        this.secondPlace = competition.getSecondPlace();
        this.year = competition.getYear();
    }

    public String getCompetitionName()
    {
        return competitionName;
    }

    public void setCompetitionName(String competitionName)
    {
        this.competitionName = competitionName;
    }

    public String getWinningTeam()
    {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam)
    {
        this.winningTeam = winningTeam;
    }

    public String getSecondPlace()
    {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace)
    {
        this.secondPlace = secondPlace;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String toString()
    {
        return String.format("%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n",
                "Competition Name :", getCompetitionName(),
                "Year :", getYear(),
                "Winning Team ",getWinningTeam(),
                "Second Place :", getSecondPlace());
    }
}

class Team
{
    private String teamName;
    private Object teamMembers[];
    private Object competitions[];

    public Team(String teamName, Object[] teamMembers, Object[] competitions)
    {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
        this.competitions = competitions;
    }

    public Team()
    {
        this.teamName = null;
        this.teamMembers = null;
        this.competitions = null;
    }

    public Team(Team team)
    {
        this.teamName = team.getTeamName();
        this.teamMembers = new Object[team.teamMembers.length];
        System.arraycopy(team.getTeamMembers(), 0, this.teamMembers,
                0, team.getTeamMembers().length);
        this.competitions = new Object[team.teamMembers.length];
        System.arraycopy(team.getCompetitions(), 0, this.competitions,
                0, team.getCompetitions().length);
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public Object[] getTeamMembers()
    {
        return teamMembers;
    }

    public void setTeamMembers(Object[] teamMembers)
    {
        this.teamMembers = teamMembers;
    }

    public Object[] getCompetitions()
    {
        return competitions;
    }

    public void setCompetitions(Object[] competitions)
    {
        this.competitions = competitions;
    }

    public String toString()
    {
        int x =0;
        String teammembers = "";
        for (Object teamMember : teamMembers)
        {
            teammembers += teamMember +"    ";
            x++;
            if (x%2 ==0)
            {
                teammembers += "\n";
            }
        }
        String competitiondata = "\n";
        competitiondata += competitions[0].toString()+"\n"+competitions[1].toString();
        return getTeamName()+"\n"+teammembers +competitiondata;
    }
}

class TeamCompetitionsDemo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");

        //team 1 using default constructor
        Team team1 = new Team();
        team1.setTeamName("Team 6");
        Object[] teammembers = new Object[]{"Micah", "Jose",
                "Person3", "Vanessa"};
        team1.setTeamMembers(teammembers);
        Competition competition1 = new Competition();

        competition1.setCompetitionName("Computer Science Competition ");
        competition1.setWinningTeam("Team 1");
        competition1.setSecondPlace("Team 6");
        competition1.setYear(2011);
        Competition competition2 = new Competition();
        competition2.setCompetitionName("Computer Science Competition 2");
        competition2.setWinningTeam("Team 6");
        competition2.setSecondPlace("Team 2");
        competition2.setYear(2014);
        Object[] competitions = new Object[]{competition1, competition2};
        team1.setCompetitions(competitions);
        System.out.println(team1);

        //team 2 using constructor
        Object[] team2members = new Object[]{"Aaron", "Jonny",
                "Hippie", "Tron"};
        Competition team2Competition = new Competition("Ruby Competition ","Team 7","Team 2",1957);
        Competition team2Competition2 = new Competition("PHP Competition ","Team 11", "Team 12",1965);
        Object[] team2Competitions = new Object[]{team2Competition,
                team2Competition2};
        Team team2 = new Team("Team Two", team2members, team2Competitions);
        System.out.println(team2);

        //CopyConstructor used to create similar team object and competition
        //Slight Details changed in team 3 do not effect team 1
        Team team3 = new Team(team1);
        Object[] team3Members = new Object[]{"Micah", "Jose",
                "Rafael", "Vanessa"};
        team3.setTeamMembers(team3Members);
        Competition team3Competition = new Competition(competition1);
        team3Competition.setYear(2020);
        Competition team3Competition2 = new Competition(competition2);
        team3Competition2.setCompetitionName("Data Analysis Competition");
        team3Competition2.setYear(2027);
        Object[] team3Competitions = new Object[]{team3Competition, team3Competition2};
        team3.setCompetitions(team3Competitions);
        System.out.println(team3);

    }

}

