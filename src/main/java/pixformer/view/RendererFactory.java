package pixformer.view;

/**
 * A provider of scene components.
 */
public interface RendererFactory {

    /**
     * @param text text to display
     * @param color text color
     * @param family font family
     * @param size font size
     * @return a new text renderer
     * @see TextBuilder
     */
    PositionableRenderer newText(final String text, final Color color, final String family, final double size);

    /**
     * @param text text to display
     * @return a new text renderer
     */
    PositionableRenderer newText(final String text);

    /**
     * @param color background color
     * @return a new solid background renderer
     */
    Renderer newSolidBackground(final Color color);

    // Renderer newImage(Image image);
    // TODO needs wrapping or sprite enum
}
