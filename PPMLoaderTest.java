import org.junit.Test;

import command.PPMLoader;
import model.ImageModel;

/**
 * Test the loacing of the ppm.
 */
public class PPMLoaderTest {

  /**
   * test the PPM is loaded correctly.
   * @param args
   */
  @Test
  public static void main(String[] args) {
    ImageModel testModal = null;
    PPMLoader loader = null;
    loader = new PPMLoader(args[0]);
    testModal = loader.load();
  }
}
