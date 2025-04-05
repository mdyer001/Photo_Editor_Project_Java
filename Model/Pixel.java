package Model;

import java.util.List;

/**
 * Interface representing the operations offered by the pixel object.
 * One object of the model represents one pixel image.
 */
public interface Pixel {

  /**
   * Gets the rgb representation of the pixel.
   * @return the rgb representation of the pixel.
   */
  List<Integer> getColor();

  /**
   * Gets the max value of the three components of the pixel.
   * @return the max value.
   */
  int maxVal();

  /**
   * Gets the levels of brightness (luma) of the pixel.
   * @return the luma of the pixel.
   */
  int luma();

  /**
   * Changes all the rgb values of the pixel to luma value, max value of the rgb,
   * the red components, blue or green.
   * @param type the type of the pixel.
   */
  void setRGB(String type);

  /**
   * Get the average of the three components for the pixel.
   * @return the average of the three components the pixel.
   */
  int intensity();

  /**
   * Copies the pixel.
   * @return the copy of the pixel.
   */
  Pixel copy();
}

