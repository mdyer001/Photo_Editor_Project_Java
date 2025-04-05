import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import model.EightBitPixel;
import model.ImageLibrary;
import model.ImageModel;
import model.ImageStore;
import model.PPMModel;
import model.Pixel;
import view.ImageView;
import view.ViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * Test to ensure the image view is working properly.
 */
public class ImageViewTest {

  /**
   * Test the to string of the Image.
   */
  @Test
  public void ToStringTest() {
    Pixel[][] pixel = new Pixel[2][2];
    pixel[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1,1,3)));
    pixel[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(0,1,1)));
    pixel[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2,1,4)));
    pixel[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(5,4,3)));
    ImageModel mockModel = new PPMModel(2,2,255,pixel);
    ImageLibrary store = new ImageStore();
    store.put("mock", mockModel);
    ImageView view = new ViewImpl(store);
    System.out.println(mockModel.toString());
    assertEquals(view.toString("mock"), "P3\n" + " 2 2 \n" + "255\n" +
            "1 1 3 8 1 1" + System.lineSeparator() + "2 1 4 5 4 3" + System.lineSeparator());
  }

  /**
   * Test storage/library null for constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullLibConstructor() {
    Appendable ap = new StringBuilder();
    new ViewImpl(null, ap);
  }

  /**
   * Test appendable null for constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAPConstructor() {
    ImageLibrary storage = new ImageStore();
    new ViewImpl(storage, null);
  }

}
