package Command;

import Model.ImageModel;

/**
 * This interface loads the model from the input path provided.
 */
public interface Loader {

  /**
   * Allows the Loader to load the path's file and return it as ImageModel.
   * @return ImageModel that represents the input image.
   * @throws IllegalStateException if loading fails.
   */
  ImageModel load() throws IllegalStateException;
}
