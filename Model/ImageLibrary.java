package Model;

import java.util.Map;


/**
 * Image interface is the operations provided by the image storage class.
 */
public interface ImageLibrary {

  /**
   * Method to put the image in the Hashmap and store the image.
   * @param key name of the image.
   * @param model the model of the image.
   */
  void put(String key, ImageModel model);

  /**
   * Checks if storage has the given image and allows the sotrage to return the model.
   * @param name the name of the image.
   * @return the stored model.
   */
  ImageModel contains(String name);

  /**
   * provides the storage.
   * @return the storage.
   */
  Map<String, ImageModel> returnStorage();
}
