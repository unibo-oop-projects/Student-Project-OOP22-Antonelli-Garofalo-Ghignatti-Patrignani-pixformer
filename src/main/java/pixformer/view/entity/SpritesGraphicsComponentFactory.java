package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentFactory;
import pixformer.view.engine.Color;
import pixformer.view.entity.enemies.GoombaGraphicsComponent;
import pixformer.view.entity.powerup.FireFlowerGraphicsComponent;
import pixformer.view.entity.statics.*;

/**
 * A factory of graphics component represented by sprite images.
 */
public class SpritesGraphicsComponentFactory implements GraphicsComponentFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent tileBlock(final Entity entity) {
        return new BlockGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent grassBlock(final Entity entity) {
        return new GrassGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent brickBlock(Entity entity) {
        return new BrickGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent surpriseBlock(final Entity entity) {
        return new SurpriseGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent coin(final Entity entity) {
        return new CoinGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent pole(final Entity entity) {
        return new PoleGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent goomba(final Entity entity) {
        return new GoombaGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent fireFlower(final Entity entity) {
        return new FireFlowerGraphicsComponent(entity);
    }

    @Override
    public GraphicsComponent walkingKoopa(final Entity entity) {
        return new RectangleGraphicsComponent(entity, new Color(0, 1, 0));
    }
}
