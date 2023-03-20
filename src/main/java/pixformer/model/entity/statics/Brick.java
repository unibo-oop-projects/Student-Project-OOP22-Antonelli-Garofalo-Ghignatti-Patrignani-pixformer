package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.*;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

import java.util.Optional;
import java.util.Set;

/**
 * Brick block, common brick block which can be destroyed from the bottom.
 */
public class Brick extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private final GraphicsComponent graphicsComponent = new RectangleGraphicsComponent(this, new Color(0, 0, 1));

    /**
     * Constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Brick(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
<<<<<<< HEAD
        return Optional.of(new CollisionComponent(this) {

            /**
             * {@inheritDoc}
             */
            @Override
            public void update(final double dt, final Set<Collision> collisions) {
                for (var collision : collisions) {
                    if (collision.side() == CollisionSide.BOTTOM && getWorld().isPresent()) {
                        getWorld().get().dropEntity(this.getEntity());
                    }
                }
            }
        });
=======
        return Optional.of(new BrickCollisionComponent(this));
>>>>>>> 6177e99ef295c90ef87a1252fd938d821aab9271
    }
}
