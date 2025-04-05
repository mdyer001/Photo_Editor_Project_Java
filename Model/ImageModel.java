package Model;

public interface ImageModel {

  /**
   * Method to pass the operation type and the arguments being passed.
   * @param type the command types.
   * @param change the change as an integer.
   * @param direction the change as indicated by a string.
   */
  void getUpdated(Operations.OperationType type, int change, String direction);

  /**
   * Gets the width of the image.
   * @return the width of the image.
   */
  int getWidth();

  /**
   * Gets the height of the image.
   * @return the height of the image.
   */
  int getHeight();

  /**
   * Gets the pixels of the image.
   * @return the pixels of the image.
   */
  Pixel[][] getPixels();

  /**
   * Copies the Image and the outputs as a copy.
   * @return a copy of the image.
   */
  ImageModel clone();

}
