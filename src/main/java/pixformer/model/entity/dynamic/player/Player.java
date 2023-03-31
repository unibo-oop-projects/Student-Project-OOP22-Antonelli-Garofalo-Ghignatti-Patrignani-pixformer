package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.PowerUp;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.Powerupable;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.entity.player.PlayerGraphicsComponent;

import java.util.Optional;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity, Powerupable {
    static final double WIDTH = 1.0;
    static final double HEIGHT = 1.0;

    // This playerIndex
    private final int playerIndex;

    // State variable to check if player is sprinting
    private boolean isSprinting;

    // Current powerup
    private PowerUp powerup = new PowerUp();

    // Player components
    private PlayerGraphicsComponent graphicsComponent;
    private final PlayerPhysicsComponent physicsComponent;
    private final PlayerCollisionComponent collisionComponent;
    private PlayerInputComponent inputComponent;

    /**
     * 
     * @param x      X position of the player.
     * @param y      Y position of the player.
     * @param width  Width of the base player.
     * @param height Height of the base player.
     * @param playerIndex Index of this player istance.
     */
    public Player(final double x, final double y, final double width, final double height, final int playerIndex) {
        super(x, y, width, height);

        this.playerIndex = playerIndex;

        graphicsComponent = new PlayerGraphicsComponent(this);
        physicsComponent = new PlayerPhysicsComponent(this);
        collisionComponent = new PlayerCollisionComponent(this);
        inputComponent = new PlayerInputComponent(this);

        powerup = new PowerUp();
    }

    /**
     * @param x X position of the player.
     * @param y Y position of the player.
     */
    public Player(final double x, final double y) {
        this(x, y, WIDTH, HEIGHT, 0);
    }

    /**
     * Return this entity player index.
     * @return playerIndex
     */
    public int getIndex() {
        return playerIndex;
    }

    /**
     * Set the new inputComponent.
     * @param newInputComponent new Player's inputComponent.
     */
    public void setInputComponent(final PlayerInputComponent newInputComponent) {
        inputComponent = newInputComponent;
    }

    /**
     * Set the new graphicsComponent.
     * @param newGraphicsComponent new Player's graphicsComponent.
     */
    public void setGraphicsComponent(final PlayerGraphicsComponent newGraphicsComponent) {
        this.graphicsComponent = newGraphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

    /**
     * Return current physics component.
     * @return player's physics component.
     */
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(physicsComponent);
    }

    /**
     * Set the new Powerup for the player.
     * @param powerupBehaviour the new powerup.
     */
    public void setPowerup(final PowerupBehaviour powerupBehaviour) {

        if (powerup.getBehaviour().isPresent()) {
            if (powerup.getBehaviour().get().getPriority() == powerupBehaviour.getPriority()) {
                powerup = new PowerUp(powerupBehaviour, powerup.getPrevious().get());
            } else if (powerup.getBehaviour().get().getPriority() > powerupBehaviour.getPriority()) {
                powerup = new PowerUp(powerupBehaviour, powerup);
            }
        } else {
            powerup = new PowerUp(powerupBehaviour, powerup);
        }
    }

     /**
     * @return True if is sprinting.
     */
    public boolean isSprinting() {
        return isSprinting;
    }

    /**
     * @return true if the player is touching ground otherwise false.
     */
    public boolean isOnGround() {
        return collisionComponent.isOnGround();
    }

    /**
     * Define what happens when Player get damaged.
     */
    public void damaged() {
        if (powerup.getBehaviour().isEmpty()) {
            kill();
        } else {
            powerup = powerup.getPrevious().get();
        }
    }

    /**
     * Define what happens on Player death.
     */
    private void kill() {
        getWorld().get().queueEntityDrop(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PowerupBehaviour> getPowerupBehaviour() {
        return powerup.getBehaviour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PowerUp getPowerup() {
        return powerup;
    }
}
