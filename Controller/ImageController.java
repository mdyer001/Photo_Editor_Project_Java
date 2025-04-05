package Controller;

/**
 * Interface for the controller of the Image processing program.
 * Connects the models and the view classes.
 */
public interface ImageController {

  /**
   * Execution method of the controller.
   * @throws IllegalStateException when the input creates an error.
   */
  void process() throws IllegalStateException;
}
