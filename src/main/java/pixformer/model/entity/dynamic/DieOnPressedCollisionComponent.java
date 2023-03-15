package pixformer.model.entity.dynamic;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.collision.SimpleCollisionReactor;
import pixformer.model.entity.dynamic.player.Player;

public final class DieOnPressedCollisionComponent extends CollisionComponent {

    private final CollisionReactor reactor;

    protected DieOnPressedCollisionComponent(final MutableEntity entity, final Consumer<Entity> die) {
        super(entity);
        reactor = new SimpleCollisionReactor(Map.of(
            Player.class::isInstance, new SideCheckerConsumer(CollisionSide.TOP, () -> die.accept(entity))
        ));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        reactor.react(collisions);
    }
    
}
