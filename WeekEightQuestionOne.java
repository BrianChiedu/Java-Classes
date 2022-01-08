class WeekEightQuestionOne {

    public static void main(String[] args) {

        char[][] charArray = {
                {'G', 'B', 'A', 'C', 'A', 'B'},
                {'K', 'D', 'X', 'F', 'O', 'B'},
                {'Z', 'H', 'S', 'A', 'D', 'C'}
        };

        char character1 = 'B';
        char character2 = 'H';

        displayArray(charArray);

        int replacements = replacementmethod(charArray, character1, character2);

        displayArray(charArray);

        System.out.println("Number of replaced letters are " + replacements);
    }

    /**
     * Replaces elements in a 2D array
     * Replaces occurences of variable 1 with variable 2
     *
     * @param charArray
     * @param character1
     * @param character2
     * @return
     */
    public static int replacementmethod(char[][] charArray, char character1, char character2) {
        int replacedAmount = 0;

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {

                if (charArray[i][j] == character1) {
                    charArray[i][j] = character2;

                    replacedAmount++;
                }
            }
        }

        return replacedAmount;
    }

    /**
     * Prints an array passed in
     *
     * @param charArray
     */
    public static void displayArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        System.out.println("---------------------------------");
    }
}




