package View;

import java.io.IOException;

/**
 * Interface to portray the model into a writable file. Send error outputs if applicable.
 */
public interface ImageView {

  /**
   * Creates a toString of the file name.
   * @param fileName name of file as a string.
   * @return the file as a toString.
   */
  String toString(String fileName);

  /**
   * Provides error messages or gives information to the user about the model.
   * @param message the message.
   * @throws IOException when fails.
   */
  void renderMessage(String message) throws IOException;

}
