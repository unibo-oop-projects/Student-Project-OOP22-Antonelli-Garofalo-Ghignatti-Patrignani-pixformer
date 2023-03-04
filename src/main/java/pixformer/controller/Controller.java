package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;
import pixformer.view.ViewImpl;

/**
 * The controller that acts as a bridge between model and view.
 */
public interface Controller {

    /**
     * @return current game mechanics settings
     */
    GameSettings getSettings();

    /**
     * @return the handler for playable levels
     */
    LevelManager getLevelManager();

    /**
     * @return the handler for game loop cycles
     */
    GameLoopManager getGameLoopManager();

    /**
     * @param view view to output to
     * @return a new game loop instance
     */
    GameLoop createGameLoop(ViewImpl view); // TODO change to View

    /**
     * @return the current amount of players
     */
    int getPlayersAmount();

    /**
     * Sets a new amount of players.
     * @param playersAmount new amount of players
     * @implNote changes don't affect a game that is already running
     */
    void setPlayersAmount(int playersAmount);
}
