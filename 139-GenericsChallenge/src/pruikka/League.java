package petrihannonen;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;

    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean add(T team) {
        if (this.league.contains(team)) {
            return false;
        }
        this.league.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
