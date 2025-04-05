package Model;

/**
 * Abstract image model that implements the ImageModel interface.
 */
public abstract class AbstractImageModel implements ImageModel {
  private int width;
  private int height;
  private final int maxValue;
  private Pixel[][] pixels;

  /**
   * Constructor for abstract image model.
   * @param height the height of the image.
   * @param width the width of the image.
   * @param maxValue the maxvalue of the image.
   * @param pixels the pixels of the image.
   */
  public AbstractImageModel(int height, int width, int maxValue, Pixel[][] pixels) {
    this.maxValue = maxValue;
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException("Invalid image dimensions");
    }
    this.height = height;
    this.width = width;
    if (pixels == null || pixels.length > height || pixels.length < height
            || pixels[0].length > width || pixels[0].length < width) {
      throw new IllegalArgumentException("Invalid amount of pixels");
    }
    this.pixels = pixels;
  }

  /**
   * Method to get the width.
   * @return the width.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Method to get the height.
   * @return the height.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Method to get the pixels of the image.
   * @return the pixels of the image.
   */
  @Override
  public Pixel[][] getPixels() {
    Pixel[][] pixelCopy = this.pixels;
    return pixelCopy;
  }

  /**
   * Method to clone the file.
   * @return the cloned model.
   */
  @Override
  public ImageModel clone() {
    ImageModel copy;
    Pixel[][] pixelCopy = new Pixel[this.height][this.width];

    copy = returnModel(this.height, this.width, this.maxValue, this.getPixels());
    return copy;
  }

  /**
   * Method to return the model.
   * @param height the height of the image.
   * @param width the width of the image.
   * @param maxValue the max value of the image.
   * @param pixels the pixels of the image.
   * @return the model.
   */
  protected abstract ImageModel returnModel(int height, int width, int maxValue, Pixel[][] pixels);

  /**
   * Updates the image model.
   * @param type the command types.
   * @param change the change as an integer.
   * @param direction the change as indicated by a string.
   */
  @Override
  public void getUpdated(Operations.OperationType type, int change, String direction) {

  }
}
