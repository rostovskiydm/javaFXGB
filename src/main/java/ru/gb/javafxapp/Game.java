package ru.gb.javafxapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {

    public static class BullsAndCowsCount {
        private final int bulls;
        private final int cows;

        public BullsAndCowsCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }

    }

    private final int[] guessNum;

    public Game() {
        guessNum = generateNumber();
        System.out.println(Arrays.toString(guessNum));
    }

    public String getGuessNum() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < guessNum.length; i++) {
            stringBuilder.append(guessNum[i]);
        }
        return stringBuilder.toString();
    }

    public BullsAndCowsCount calculateBullsAndCows(String playerNum) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guessNum.length; i++) {
            if (guessNum[i] == playerNum.charAt(i) - '0') {
                bulls++;
            } else if (playerNum.contains(String.valueOf(guessNum[i]))) {
                cows++;
            }
        }
        return new BullsAndCowsCount(bulls, cows);
    }

    private int[] generateNumber() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);
        return new int[]{numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)};
    }


}
