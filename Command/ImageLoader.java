package Command;

import Model.ImageModel;

/**
 * Abstract class that aides in loading different image files.
 */
public abstract class ImageLoader implements Loader{

  protected String in;

  /**
   * Constructor for the abstract class that takes in a string for the file's path.
   * @param in the input file path.
   * @throws IllegalArgumentException When input is null.
   */
  public ImageLoader(String in) throws IllegalArgumentException {
    if (in == null) {
      System.out.println("Cannot find the path input");
      throw new IllegalArgumentException();
    }
    this.in = in;
  }

  /**
   * This is an abstract method that ensure the loader to load the file's path and return to,
   * the ImageModel.
   * @return the ImageModel that represents the input file.
   * @throws IllegalStateException when loading fails.
   */
  public abstract ImageModel load() throws IllegalStateException;
}

