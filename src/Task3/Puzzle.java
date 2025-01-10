package Task3;

import java.util.HashSet;
import java.util.Set;

class Puzzle {
    private final char[][] puzzle;
    private final Set<String> wordSet; //A set of words that need to be found in the puzzle
    private final Set<String> prefixSet; //A set of prefixes of the words in wordSet to speed up the search
    private final int rows; //The number of rows and columns in the grid
    private final int cols;


    private final int[][] DIRECTIONS = { //an array representing the possible directions to move in the grid
            {0, 1},  // Right
            {1, 0},  // Down
            {1, 1},  // Diagonal Down-Right
            {1, -1}, // Diagonal Down-Left
            {0, -1}, // Left
            {-1, 0}, // Up
            {-1, -1},// Diagonal Up-Left
            {-1, 1}  // Diagonal Up-Right
    };

    public Puzzle(char[][] puzzle, String[] words) {
        this.puzzle = puzzle;
        this.rows = puzzle.length;
        this.cols = puzzle[0].length;

        this.wordSet = new HashSet<>();
        this.prefixSet = new HashSet<>();
        initializeWordAndPrefixSets(words);
    }

    private void initializeWordAndPrefixSets(String[] words) {
        for (String word : words) {
            wordSet.add(word);

            // Add all prefixes of the word to the prefix set
            for (int i = 1; i <= word.length(); i++) {
                prefixSet.add(word.substring(0, i));
            }
        }
    }

    public void solve() {
        System.out.println("Finding Word Puzzle:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                searchPosition(row, col);
            }
        }
    }

    private void searchPosition(int row, int col) {
        // Loop through all 8 possible directions
        for (int[] direction : DIRECTIONS) {
            StringBuilder wordBuilder = new StringBuilder(); // Start building a word
            int x = row, y = col; // Initialize current position to the starting cell (row, col)

            // Continue searching while the current position is within the grid boundaries
            while (x >= 0 && x < rows && y >= 0 && y < cols) {
                wordBuilder.append(puzzle[x][y]); // Add the character at the current position to the word
                String currentWord = wordBuilder.toString(); // Convert the current word to a string

                // If the current word is not a valid prefix, stop searching in this direction
                if (!prefixSet.contains(currentWord)) {
                    break;
                }

                // If the current word is a valid word, print it and stop searching further in this direction
                if (wordSet.contains(currentWord)) {
                    System.out.println("Found word: " + currentWord + " from (" + (row + 1) + ", " + (col + 1) +
                            ") to (" + (x + 1) + ", " + (y + 1) + ")");
                    break;
                }

                // Move to the next cell in the current direction
                x += direction[0];
                y += direction[1];
            }
        }
    }
}