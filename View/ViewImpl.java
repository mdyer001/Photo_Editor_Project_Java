package View;

import java.io.IOException;

import Model.ImageLibrary;
import Model.ImageModel;
import Model.Pixel;

/**
 * Class for the view implementation implements ImageView.
 */
public class ViewImpl implements ImageView {

  private final ImageLibrary library;
  private final Appendable ap;

  /**
   * Constructor for the view impl class.
   * @param library the image library.
   * @param ap the appendable.
   */
  public ViewImpl(ImageLibrary library, Appendable ap) {
    if (library == null || ap == null) {
      throw new IllegalArgumentException("The model provided cannot be null");
    }
    this.library = library;
    this.ap = ap;
  }

  /**
   * The view Impl method.
   * @param library the image library.
   */
  public ViewImpl(ImageLibrary library) {
    this(library, System.out);
  }

  @Override
  public String toString(String fileName) {
    ImageModel model = library.contains(fileName);

    if (model == null) {
      throw new IllegalStateException();
    }
    Pixel[][] copys = model.getPixels();
    StringBuilder outModel;

    outModel = new StringBuilder("P3\n" + model.getWidth() + " " + model.getHeight() + " " +
            "\n" + "255\n");

    for (int i = 0; i < copys.length; i++) {
      StringBuilder line = new StringBuilder(" ");
      for (int k = 0; k < copys[i].length; k++) {
        for (int j = 0; j < 3; j++) {
          if (k == copys[i].length - 1 && j == 3 - 1) {
            line.append(copys[i][k].getColor().get(j));
          }
          else {
            line.append(copys[i][k].getColor().get(j) + " ");
          }
        }
      }
      outModel.append(line + System.lineSeparator());
    }
    return outModel.toString();
  }

  /**
   * The method to render the message of the file image.
   * @param message the message.
   * @throws IOException if null.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.ap.append(message);
  }
}
