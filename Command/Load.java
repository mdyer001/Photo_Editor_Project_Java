package Command;

import java.util.List;

import Model.ImageLibrary;


public class Load implements Command {
  private final String path;
  private final String fileName;

  /**
   * This is the constructor for the PPMLoader that takes in a string of the file path.
   *
   * @param path   The file path.
   * @param fileName the file name.
   */
  public Load(String path, String fileName) {
    this.path = path;
    this.fileName = fileName;
  }

  /**
   * This method is used to execute the load command in the model to load an image from a system
   * path and put into the library.
   *
   * @param library        The library that stores all models.
   * @param stringCommands The list of command's names.
   * @throws IllegalArgumentException When the command fails, it will occur.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalStateException {
    try {
      try {
        if (stringCommands.contains(fileName)) {
          throw new IllegalArgumentException("The name cannot be the command's name");
        }
        String fileType;
        int startPos = this.path.lastIndexOf(".");
        fileType = path.substring(startPos + 1);
        System.out.println("Input File Type: " + fileType);
        Loader image;
        if (fileType.equalsIgnoreCase("ppm")) {
          image = new PPMLoader(this.path);
        }

      } catch (IllegalArgumentException e) {
        System.out.println("The name cannot be the command's name");
      }
    } catch (IllegalStateException e) {
      System.out.println("Loading fails: Incorrect Path！");
    }
  }
}
