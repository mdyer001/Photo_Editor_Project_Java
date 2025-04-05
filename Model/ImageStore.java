package Model;

import java.util.HashMap;
import java.util.Map;


/**
 * Class representing the Image Storage. Implements the image library.
 */
public class ImageStore implements ImageLibrary {

  private final Map<String, ImageModel> storage;

  /**
   * Constructor for Image storage.
   */
  public ImageStore() {
    this.storage = new HashMap<>();
  }

  /**
   * Method to put the file in the image sotrage.
   * @param key name of the image.
   * @param model the model of the image.
   */
  @Override
  public void put(String key, ImageModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Model is Null");
    }
    this.storage.put(key, model);
  }

  /**
   * Method to store what the file contains.
   * @param name the name of the image.
   * @return a copy of the file.
   */
  @Override
  public ImageModel contains(String name) {
    ImageModel copy;
    copy = (this.storage.getOrDefault(name, null));
    if (copy == null) {
      return null;
    }
    return copy.clone();
  }

  /**
   * Method to return the storage of the file.
   * @return the storage.
   */
  @Override
  public Map<String, ImageModel> returnStorage() {
    return this.storage;
  }
}
