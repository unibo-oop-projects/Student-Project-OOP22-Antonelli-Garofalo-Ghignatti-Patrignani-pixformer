package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentFactory;
import pixformer.view.engine.GameScene;

/**
 * A graphics component factory that does not actually draw any content.
 */
public final class NullGraphicsComponentFactory implements GraphicsComponentFactory {

    /**
     * A shared graphics component whose update method does nothing.
     */
    private static final GraphicsComponent NULL_COMPONENT = new GraphicsComponent(null) {
        /**
         * {@inheritDoc}
         */
        @Override
        public void update(final GameScene scene) {

        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent tileBlock(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent grassBlock(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent brickBlock(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent surpriseBlock(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent coin(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent pole(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent goomba(final Entity entity) {
        return NULL_COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent fireFlower(final Entity entity) {
        return NULL_COMPONENT;
    }
}
