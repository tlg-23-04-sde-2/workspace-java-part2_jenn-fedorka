package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    //Statics
    private static final String dataFilePath = "data/board.dat";
    private static final String studentIdFilePath = "conf/student-ids.csv";

    //if data.dat exists, read the board object from file, otherwise create new and return it
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board)in.readObject();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            board = new Board();
        }

        return board;
    }

    //Instance Variables
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();


    //constructor= this one is privete, to prevent outside instantiation
    private Board() {

    }

    //updates the baord (racerMap) by making a duckracer win
    //this could mean fetching an exsiting duckracer from racermap
    //or we might need to create a new duckracer and put it in the map
    //need to make it win

    public void update(int id, Reward reward){
        DuckRacer racer = null;

        if (racerMap.containsKey(id)){
            racer = racerMap.get(id);
        }
        else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
        save();
    }


    //for testing purposes
    void dumpStudentIdeaMap(){
        System.out.println(studentIdMap);
    }

    public void show() {
        //if racerMap is empty print "no results to show"

        if (racerMap.isEmpty()) {
            System.out.println();
            System.out.println("There are no results to show.");
            System.out.println();
        }
        else {
            Collection<DuckRacer> racers = racerMap.values();

            System.out.println("Duck Race Results");
            System.out.println("==============\n");

            System.out.println("id      name    wins     rewards");
            System.out.println("--      -----   -----    --------");

//see formatted output for fixed column width
            for(DuckRacer racer: racers) {
                System.out.printf("%s    %s     %s     %s\n", racer.getId(),
                        racer.getName(), racer.getWins(), racer.getRewards());
            }
        }
    }

    //saves this board object to binary file "data/board.dat"
    private void save() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))){
            out.writeObject(this); //write "me" a board object to the binary file
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        //read all lines from conf/student-ids.csv
        try {
            List<String> lines = Files.readAllLines(Path.of(studentIdFilePath));
            //for each line in the files. split into tokens. convert tokens as necessary and put each pair in idMap
            for (String line : lines){
                String[] tokens = line.split(","); //returns an array of string
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }




}