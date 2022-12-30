package pixformer.view.javafx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import pixformer.view.Graphics;
import pixformer.view.Renderer;

import java.util.Objects;

/**
 * Renders the background of a JavaFX scene.
 */
public abstract class JavaFXBackgroundRenderer implements Renderer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        Canvas canvas = Objects.requireNonNull(g.getCanvas());
        this.drawBackground(g, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * Draws the background.
     * @param graphics JavaFX native graphics context
     * @param width canvas width
     * @param height canvas height
     */
    abstract void drawBackground(final GraphicsContext graphics, final double width, final double height);
}
