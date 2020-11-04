package com.company;

import java.util.HashMap;

public class State {
    /* Due to the way Maine and Nebraska assign their electoral votes,
    each district in ME and NE should be its own state with one elector, plus the states themselves should be
    states with two electors, for a total of five votes across NE and its three districts and four votes
    across ME and its two districts.
    With DC as a state, this makes a total of 56 states.
    PR; Guam do not have electoral votes.
     */
    String fullName;
    String abbreviation;
    static HashMap<String, State> statesByAbbreviation;
    int electorVotes;
    static HashMap<String, State> swingStatesByAbbreviation;
    int category;
    //For category, 1=swing, 2=Dem very safe, 3 =Dem safe, 4=Rep very safe, 5=Rep safe; an Enum could also be used
    int probCategory;
    /*For prob category, 1 = Rep extremely likely, 2 = Rep very likely, 3 = Rep clearly favored, 4 = Rep favored,
    5 = Rep slightly favored, 6 = toss-up, 7 = Dem slightly favored, 8 = Dem favored, 9 = Dem clearly favored,
    10 = Dem very likely, 11 = Dem extremely likely
     */


    public State (String abbrev) {
        this.abbreviation = abbrev;
        statesByAbbreviation.put(abbrev, this);
    }

    public State (String abbrev, int eVotes) {
        this.abbreviation = abbrev;
        this.electorVotes = eVotes;
        statesByAbbreviation.put(abbrev, this);
    }

    public State (String abbrev, int eVotes, int cat) {
        this.abbreviation = abbrev;
        this.electorVotes = eVotes;
        this.category = cat;
        statesByAbbreviation.put(abbrev, this);
        if (cat == 1) {
            swingStatesByAbbreviation.put(abbrev, this);
        }
    }

    public static State getStateByAbbreviation(String s) {
        return statesByAbbreviation.get(s);
    }

    void setElectorVotes (int eVotes) {
        this.electorVotes = eVotes;
    }

    void setCategory (int cat) {
        this.category = cat;
    }

    void setCategoryAndPut(int cat) {
        this.category = cat;
        if (cat == 1) {
            statesByAbbreviation.put(this.abbreviation, this);
        }
    }


}
