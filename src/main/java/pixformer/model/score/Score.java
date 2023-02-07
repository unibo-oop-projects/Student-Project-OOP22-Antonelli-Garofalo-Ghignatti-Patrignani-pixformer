package pixformer.model.score;

/**
 * Score class to manage the in-game score of the user.
 */
public interface Score {

    /**
     * @return the score of the user
     */
    int getScore();

    /**
     * Method to update the score adding a new value.
     * @param points points to add
     */
    void updateScore(int points);
}
