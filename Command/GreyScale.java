package Command;

import java.util.List;

import Model.ImageLibrary;
import Model.ImageModel;
import Model.Operations;

/**
 * Class for the Greyscale operation.
 */
public class GreyScale implements Command {
  private final String name;
  private final String nameOutput;
  private final String way;

  /**
   * Constructor for Greyscale.
   * @param name of file.
   * @param nameOutput name of output file.
   * @param way if the way is r,g,b.
   */
  public GreyScale(String name, String nameOutput, String way) {
    this.name = name;
    this.nameOutput = nameOutput;
    this.way = way;

  }


  /**
   * Method to process the operation.
   * @param library the library storing the models.
   * @param stringCommands commands.
   * @throws IllegalArgumentException if null.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalArgumentException {
    try {
      if (stringCommands.contains(nameOutput)) {
        throw new IllegalArgumentException("names cannot be the same");
      }
      ImageModel model = library.contains(name);
      if (!model.equals("")) {
        try {
          model = library.contains(name);
        }
        catch (NullPointerException e) {
          throw new IllegalArgumentException("cannot find the image to greyscale");
        }
      }
      if (model == null) {
        throw new IllegalArgumentException("Cannot find the image to greyscale");
      }
      model.getUpdated(Operations.OperationType.greyScale, 0, way);
      library.put(this.nameOutput, model);
      System.out.println(name + "has been changed as " + way + "component" + nameOutput);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Cannot find image to greyscale");
    }
  }



}
