package Model;
import java.util.Collections;
import java.util.List;

/**
 * class that represents the abstract implementation of the Pixel interface.
 * This class contains methods for the pixel operations.
 */
public abstract class AbstractPixel implements Pixel {
  private List<Integer> rgb;


  /**
   * A constructor that takes in the structure of the pixel (the list of RGB values).
   * @param rgb the list of RGB values.
   */
  public AbstractPixel(List<Integer> rgb) {
    if (rgb == null) {
      throw new IllegalArgumentException("Null RGB values");
    }
    else if (rgb.size() > 4 || rgb.size() < 3) {
      throw new IllegalArgumentException("There should be 3 numbers for red, green, and blue");

    }
    this.rgb = rgb;
  }

  @Override
  public int intensity() {
    return (this.rgb.get(0) + this.rgb.get(1) + this.rgb.get(2)) / 3;
  }

  /**
   * Gets the rgb representation of the pixel.
   * @return rgb representation.
   */
  @Override
  public List<Integer> getColor() {
    return this.rgb;
  }

  /**
   * Get the max value of the three components of the pixel.
   * @return the max value of the three components.
   */
  @Override
  public int maxVal() {
    return Collections.max(this.rgb);
  }

  /**
   * Gets the level of brightness of pixels.
   * @return the luma of the pixel.
   */
  @Override
  public int luma() {
    return (int) Math.round(0.2126 * (this.rgb.get(0))
            + 0.7152 * (this.rgb.get(1) + 0.0722 * (this.rgb.get(2))));
  }

  /**
   * change all the rgb values to the luma value, the intensity, value of the RGB,
   * the red component, blue, or green.
   * @param type the type of the pixel.
   */
  @Override
  public void setRGB(String type) {
    int value = 0;
    if (type.equals("luma")) {
      value = this.luma();
    } else if (type.equals("intensity")) {
      value = this.intensity();
    }
    for (int i = 0; i < 3; i++) {
      switch (type) {
        case "luma":
          this.rgb.set(i, value);
          break;
        case "intensity":
          this.rgb.set(i, value);
        case "max":
          this.rgb.set(i, this.maxVal());
          break;
        case "red":
          int red = this.rgb.get(0);
          this.rgb.set(i, red);
        case "green":
          int green = this.rgb.get(1);
          this.rgb.set(i, green);
          break;
        case "blue":
          int blue = this.rgb.get(2);
          this.rgb.set(i, blue);
          break;
        default:
          throw new IllegalArgumentException("Invalid argument");
      }
    }
  }

  /**
   * Copy and return the pixel.
   * @return the copy of the pixel.
   */
  @Override
  public abstract Pixel copy();
}

