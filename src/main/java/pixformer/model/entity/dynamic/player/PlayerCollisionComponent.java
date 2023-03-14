package pixformer.model.entity.dynamic.player;

import java.util.Set;

import javafx.geometry.Side;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends CollisionComponent {
    private Player player;

    /**
     * 
     * @param player Player entity whose collisions will be managed.
     */
    protected PlayerCollisionComponent(final Player player) {
        super(player);
        this.player = player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        if (player.isOnGround()) {
            player.resetJumping();
        }

        for (var x : collisions) {
            if(x.entity().getClass().equals(Goomba.class) || x.entity().getClass().equals(Koopa.class)) {
                if(x.side() == CollisionSide.LEFT || x.side() == CollisionSide.RIGHT) {
                    this.player.getDamage();
                }
            }
        }

    }

}
