import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import command.Save;
import model.EightBitPixel;
import model.ImageModel;
import model.ImageStore;
import model.PPMModel;
import model.Pixel;

/**
 * Test to save the image.
 */
public class SaveTest {

  /**
   * Test to save the image.
   */
  @Test
  public void TestSave() {
    String filePath = "/Users/kyle/IdeaProjects/ImageProcessingSetUp/test/";
    String fileName = "imagealterations/Koala.ppm";
    Save saving = new Save("/Users/kyle/IdeaProjects/ImageProcessingSetUp/test/",
            "Koala1.ppm");
    ImageStore store = new ImageStore();
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel model = new PPMModel(2,2,8,pix);
    store.put("fake",model);
    saving.process(store, null);

  }
}
