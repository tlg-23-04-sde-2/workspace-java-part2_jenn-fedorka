package com.duckrace.client;

import com.duckrace.controller.DuckRaceApp;

//gets the application going
class Main {

    public static void main(String[] args) {
        //instantiate controller
        DuckRaceApp app = new DuckRaceApp();
        app.execute();
    }
}