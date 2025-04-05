package Model;


/**
 * interface for receiving the different operation commands toward the pixels.
 */
public interface Operations {

  /**
   * The different types of operations that will be used.
   */
  enum OperationType {
    greyScale, luma, brighter, intensity
  }

  /**
   * Updating pixels by the operation given.
   * @param type the type of operation.
   * @param change changes that may be needed as an integer.
   * @param direction the string that may be needed.
   * @return
   */
  Pixel[][] update(OperationType type, int change, String direction);

}
