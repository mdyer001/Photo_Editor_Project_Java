package Command;

import java.util.List;

import Model.ImageLibrary;
import Model.ImageModel;
import Model.Operations;

/**
 * Class to brighten an image.
 */
public class Brighten implements Command {
  private final int brightness;
  private final String fileNameIn;
  private String fileNameOut;

  /**
   * Constructor for brightening an image.
   * @param brightness the level of brightness.
   * @param fileNameIn the file name going in.
   * @param fileNameOut the file name out.
   */
  public Brighten(int brightness, String fileNameIn, String fileNameOut) {
    this.brightness = brightness;
    this.fileNameIn = fileNameIn;
    this.fileNameOut = fileNameOut;
  }

  /**
   * The method to process the operation.
   * @param library the library storing the models.
   * @param stringCommands commands.
   * @throws IllegalArgumentException if null.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalArgumentException {
    try {
      if (stringCommands.contains(fileNameOut)) {
        throw new IllegalArgumentException("Name cannot be the same as command");
      }
      ImageModel model = library.contains(fileNameIn);
      if (model == null) {
        throw new IllegalArgumentException("Cannot access image to brighten");
      }
      model.getUpdated(Operations.OperationType.brighter, brightness, null);
      library.put(this.fileNameOut, model);
      System.out.println(fileNameIn + " has been brightened in the amount of " + this.brightness +
              " as " + fileNameOut);
    }
    catch (IllegalArgumentException e) {
      System.out.println(" Cannot find the image to brighten");
    }
  }

}
