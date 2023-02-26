package org.example;

import java.util.Random;

public class Universe {

    private String[][] universe;

    private String[][] updatedUniverse;

    public Universe() {
        this.universe = new String[10][10];
        this.updatedUniverse = new String[10][10];
        populateUniverse();
    }

    public void runTheUniverse() {
        for (int i = 0; i < 100; i++) {
            this.updatedUniverse = this.universe.clone();
            for (int x = 0; x < universe.length; x++) {
                for (int y = 0; y < universe[x].length; y++) {
                    if (isCellAlive(x, y) && howManyNeighborsAreAlive(x, y) < 2 || isCellAlive(x, y) && howManyNeighborsAreAlive(x, y) > 3) {
                        this.updatedUniverse[x][y] = " ";
                    }
                    if (isCellAlive(x, y) && howManyNeighborsAreAlive(x, y) == 2 || isCellAlive(x, y) && howManyNeighborsAreAlive(x, y) == 3) {
                        this.updatedUniverse[x][y] = "x";
                    }
                    if (!isCellAlive(x, y) && howManyNeighborsAreAlive(x, y) == 3) {
                        this.updatedUniverse[x][y] = "x";
                    }
                }
            }
            this.universe = this.updatedUniverse.clone();
            printUniverse();
        }
    }

    private int howManyNeighborsAreAlive(int coordOne, int coordTwo) {
        int aliveNeighbors = 0;
        if (isNeighborAlive(coordOne - 1, coordTwo)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne, coordTwo - 1)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne + 1, coordTwo)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne, coordTwo + 1)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne - 1, coordTwo - 1)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne + 1, coordTwo + 1)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne - 1, coordTwo + 1)) {
            aliveNeighbors += 1;
        }
        if (isNeighborAlive(coordOne + 1, coordTwo - 1)) {
            aliveNeighbors += 1;
        }
        return aliveNeighbors;
    }

    private boolean isCellAlive(int coordOne, int coordTwo) {
        if (universe[coordOne][coordTwo].equals("x")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNeighborAlive(int coordOne, int coordTwo) {
        if (coordOne < 0 || coordOne > this.universe.length - 1 || coordTwo < 0 || coordTwo > this.universe.length - 1) {
            return false;
        }
        if (universe[coordOne][coordTwo].equals("x")) {
            return true;
        } else {
            return false;
        }
    }

    public void printUniverse() {
        for (int x = 0; x < universe.length; x++) {
            for (int y = 0; y < universe[x].length; y++) {
                System.out.print(this.universe[x][y]);
            }
            System.out.println();
        }
    }

    private void populateUniverse() {
        for (int x = 0; x < universe.length; x++) {
            for (int y = 0; y < universe[x].length; y++) {
                if (x == generateRandomInt() || y == generateRandomInt()) {
                    this.universe[x][y] = "x";
                } else {
                    this.universe[x][y] = " ";
                }
            }
        }
    }

    private int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(10 - 0 + 1) + 0;
    }
}
