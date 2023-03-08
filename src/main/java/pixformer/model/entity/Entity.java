package pixformer.model.entity;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

import java.util.Optional;

/**
 * In-Game entity.
 */
public interface Entity {

    /**
     * @return X coordinate
     */
    double getX();

    /**
     * Set the X coordinate.
     * 
     * @param x coordinate
     */
    void setX(double x);

    /**
     * @return Y coordinate
     */
    double getY();

    /**
     * Set the Y coordinate.
     * 
     * @param y coordinate
     */
    void setY(double y);

    /**
     * Set the velocity of the entity.
     * 
     * @param velocity new vector
     */
    void setVelocity(Vector2D velocity);

    /**
     * @return the width of the entity
     */
    double getWidth();

    /**
     * @return the height of the entity
     */
    double getHeight();

    /**
     * @return the velocity vector
     */
    Vector2D getVelocity();

    /**
     * @return the bounding box of the entity
     */
    BoundingBox getBoundingBox();

    /**
     * @return the physics component of the entity
     */
    PhysicsComponent getPhysicsComponent();

    /**
     * @return the input component of the entity
     */
    default Optional<InputComponent> getInputComponent() {
        return Optional.empty();
    }

    /**
     * @return the collision component of the entity
     */
    default Optional<CollisionComponent> getCollisionComponent() {
        return Optional.empty();
    }

    /**
     * Called when this entity is added onto a game world.
     * 
     * @param world game world the entity spawned on
     */
    default void onSpawn(World world) {

    }
}
