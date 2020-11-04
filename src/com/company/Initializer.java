package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Initializer {

    public static void initializeElection () {
        String[] swingStatesArray = new String[] {"PA", "FL", "WI", "MI",
                "AZ", "OH", "NC", "MN", "CO", "NV", "GA", "NH", "VA", "TX"};
        ArrayList<String> swingStates = new ArrayList<String> (Arrays.asList(swingStatesArray));
        int dSafe = 192;
        int rSafe = 131;
    }


    public static void initializeStates() {
        HashMap<String, Integer> stateVoteCount = new HashMap<String, Integer>();
    }

    public static void stateCSVReader() throws IOException {
        List<State> stateList = new ArrayList <>();
        String fileIn = "statesList.csv";
        String line = null;

        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.readLine(); //Skip headers
        while ((line = bufferedReader.readLine()) != null) {
            String[] stateDetails = line.split(",");
            String abbreviation = stateDetails[0];
            int votes = Integer.parseInt(stateDetails[1]);
            String electionCategory = stateDetails[2];
            int electionCat;
                if (electionCategory == "Swing") {electionCat = 1;}
                else if (electionCategory == "Biden Overwhelmingly Safe") {electionCat = 2;}
                else if (electionCategory == "Biden Safe") {electionCat = 3;}
                else if (electionCategory == "Trump Overwhelmingly Safe") {electionCat = 4;}
                else if (electionCategory == "Trump Safe") {electionCat = 5;}
                else {electionCat = 6;}
            String probabilityCategory = stateDetails[3];
            int reps = Integer.parseInt(stateDetails[4]);
            double repubProb = Double.parseDouble(stateDetails[5]);
            double swingProb = Double.parseDouble(stateDetails[6]);
            double repubShare = Double.parseDouble(stateDetails[7]);
            //stateList.add(new State());
        }
    }

}
