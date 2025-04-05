package Command;


import java.util.List;

import Model.ImageLibrary;

/**
 * This is the interface for the commands. The commands will implement the Command interface.
 */
public interface Command {

  /**
   * This is the method used to execute the command in the model.
   * @param library the library storing the models.
   * @throws IllegalArgumentException when the command fails.
   */
  void process(ImageLibrary library, List<String> stringCommands) throws IllegalArgumentException;
}
