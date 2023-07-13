public class BowlingGame {

    private int[] rolls;
    private int currentRoll;
    private int[] frameScores;
    private int currentFrame;

    public BowlingGame() {
        rolls = new int[21];
        currentRoll = 0;
        frameScores = new int[10];
        currentFrame = 0;
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
        calculateFrameScores();
    }

    public int[] score() {
        return frameScores;
    }

    private void calculateFrameScores() {
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                frameScores[frame] = 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                frameScores[frame] = 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                frameScores[frame] = sumOfPinsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
    }


    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int sumOfPinsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

}