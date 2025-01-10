package Task3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
                // Sample 2D word puzzle
                char[][] puzzle = {
                        {'t', 'h', 'i', 's'},
                        {'w', 'a', 't', 's'},
                        {'o', 'a', 'h', 'g'},
                        {'f', 'g', 'd', 't'}
                };

                // List of words to find
                String[] words = {"this", "two", "fat", "that"};

                // Solve the word puzzle
                Puzzle puzzleSolver = new Puzzle(puzzle, words);
                puzzleSolver.solve();
            }
        }

