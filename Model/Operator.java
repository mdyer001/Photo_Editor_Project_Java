package Model;

/**
 * This class works to implement the operator.
 */
public class Operator implements Operations {
  private Pixel[][] pixels;

  /**
   * the constructor for the Operator that takes the image pixels and the masked image pixels.
   * @param pixels The Image 2D pixels.
   */
  public Operator(Pixel[][] pixels) {
    if (pixels == null) {
      throw new IllegalArgumentException();
    }
    this.pixels = pixels;
  }

  /**
   * Method for updating the pixels by the operation types.
   * @param type the type of operation.
   * @param change changes that may be needed as an integer.
   * @param way the string that may be needed.
   * @return
   */
  @Override
  public Pixel[][] update(OperationType type, int change, String way) {
    switch (type) {
      case greyScale:
        this.greyScale(way);
        break;
      case brighter:
        this.brighter(change);
        break;
      case luma:
        this.greyScale(way);
        break;
      case intensity:
        this.greyScale(way);

    }
    return this.pixels;
  }

  /**
   * Ensures the min value and max of the rgb do not go out of range.
   * @param pixels the 2D image pixels.
   * @return the Pixel list after the range of the rgb values are correct.
   */
  protected Pixel[][] ensureVal(Pixel[][] pixels) {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        for (int k = 0; k < pixels[i][j].getColor().size(); k++) {
          if (pixels[i][j].getColor().get(k) < 0) {
            pixels[i][j].getColor().set(k,0);
          }
          else if (this.pixels[i][j].getColor().get(k) > 255) {
            pixels[i][j].getColor().set(k, 255);
          }
        }
      }
    }
    return pixels;
  }

  /**
   * Converts image colors into greyscale.
   * @param ways different ways to turn the image greyscale through luma,
   *             intensity, value, red, green, or blue.
   */
  protected void greyScale(String ways) {
      for (int i = 0; i < this.pixels.length; i++) {
        for (int j = 0; j < this.pixels[i].length; j++) {
          this.pixels[i][j].setRGB(ways);
        }
      }
    ensureVal(this.pixels);
  }



  /**
   * Brightens or darkens the image with the amount that is inputted.
   * @param amount the amount given by the user.
   */
  protected void brighter(int amount) {
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j ++) {
        for (int k = 0; k < 3; k++) {
          this.pixels[i][j].getColor().set(k, this.pixels[i][j].getColor().get(k) + amount);
        }
      }
    }
    ensureVal(this.pixels);
  }
}

