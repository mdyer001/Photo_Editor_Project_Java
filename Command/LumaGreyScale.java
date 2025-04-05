package Command;

import java.util.List;

import Model.ImageLibrary;
import Model.ImageModel;
import Model.Operations;

/**
 * Class for Luma, and Greyscale operations.
 */
public class LumaGreyScale implements Command {

  private final String fileNameIn;
  private final String fileNameOut;


  /**
   * Constructor for the operations.
   * @param fileNameIn name of in file.
   * @param fileNameOut
   */
  public LumaGreyScale(String fileNameIn, String fileNameOut) {
    this.fileNameIn = fileNameIn;
    this.fileNameOut = fileNameOut;
  }


  /**
   * Method to process the operation type.
   * @param library the library storing the models.
   * @param stringCommands commands.
   * @throws IllegalArgumentException if null.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalArgumentException {
    try {
      if (stringCommands.contains(fileNameOut)) {
        System.out.println("File names cannot be the same");
        throw new IllegalArgumentException();
      }
      ImageModel model = library.contains(fileNameIn);

      if (model == null) {
        throw new IllegalArgumentException("Cannot find image to luma");
      }
      model.getUpdated(Operations.OperationType.greyScale, 0, "");
      library.put(this.fileNameOut, model);
      System.out.println(fileNameIn + "has been greyscaled" + fileNameOut);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Cannot find image to luma");
    }
  }
}
