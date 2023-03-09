package pixformer.model.entity.dynamic;


public class WalkingKoopa extends Enemy implements Koopa {

    private static double WIDTH = 1;
    private static double HEIGHT = 2;
    
    public WalkingKoopa(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
