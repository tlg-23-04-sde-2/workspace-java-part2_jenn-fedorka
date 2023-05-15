package com.duckrace;

import java.util.List;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer10 = new DuckRacer(10, "Kevin");
        System.out.println(racer10);

        racer10.win(Reward.DEBIT_CARD);
        racer10.win(Reward.PRIZES);
        racer10.win(Reward.PRIZES);
        System.out.println(racer10);

        //Cheat by getting the rewards list and calling add() need to make immutable
        List<Reward> rewardsList = racer10.getRewards();
//        rewardsList.add(Reward.DEBIT_CARD);

        //show just the rewards
        System.out.println(rewardsList);

        //make it win again
        racer10.win(Reward.PRIZES);

        //print new list
        System.out.println(racer10);

    }
}