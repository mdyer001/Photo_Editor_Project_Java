package Model;
import java.util.LinkedList;
import java.util.List;

/**
 * class to represent the model with a 2D array of pixels.
 */
public class EightBitPixel extends AbstractPixel {

  /**
   * A constructor taking in the structure of the pixel (its list of RGB values).
   * @param rgb represent the list of RGB values.
   */
  public EightBitPixel(List<Integer> rgb) {
    super(rgb);
  }

  /**
   * Copy the pixel.
   * @return a copy of the pixel.
   */
  @Override
  public Pixel copy() {
    List<Integer> rgbReal = new LinkedList<>();
    for (int i = 0; i < super.getColor().size(); i++) {
      rgbReal.add(super.getColor().get(i));
    }
    Pixel copy;
    copy = (Pixel) new EightBitPixel(rgbReal);
    return copy;
  }
}

