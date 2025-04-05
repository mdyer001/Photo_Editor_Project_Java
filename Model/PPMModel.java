package Model;
/**
 * Class that extends the Abstract Image Model class.
 * Class represents a PPM model.
 */
public class PPMModel extends AbstractImageModel {

  /**
   * Constructor to take in the structure of an image and the operation to be used.
   * @param height height of the image.
   * @param width represents the width of the image.
   * @param maxValue the maxValue of the image.
   * @param pixels represents all pixels in the image.
   */
  public PPMModel(int height, int width, int maxValue, Pixel[][] pixels) {
    super(height, width, maxValue, pixels);
  }

  /**
   * Returns the model being initiated.
   * @param height the height of the image.
   * @param width the width of the image.
   * @param maxValue the maxValue of the image.
   * @param pixels the pixels in the image.
   * @return new image model.
   */
  @Override
  protected ImageModel returnModel(int height, int width, int maxValue, Pixel[][] pixels) {
    return new PPMModel(height, width, maxValue, pixels);
  }


}

