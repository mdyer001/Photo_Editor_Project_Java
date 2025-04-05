import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.EightBitPixel;
import model.ImageLibrary;
import model.ImageModel;
import model.ImageStore;
import model.PPMModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Test Image Sotrage class.
 */
public class StoreTest {

  /**
   * Test put to ensure it puts inside the image database.
   */
  @Test
  public void testPut() {
    ImageLibrary storage = new ImageStore();
    Pixel[][] p = new Pixel[2][2];
    p[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    p[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    p[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    p[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel test = new PPMModel(2, 2, 255, p);
    storage.put("name", test);
    assertEquals(storage.contains("name").getHeight(), 2);
    assertEquals(storage.contains("name").getWidth(), 2);
    String testS = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        testS += (p[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String inLib = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        inLib += (storage.contains("name").getPixels()[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(inLib, testS);
  }


  /**
   * Test contains to see if it contains the image.
   */
  @Test
  public void testContain() {
    ImageLibrary storage = new ImageStore();
    Pixel[][] p = new Pixel[2][2];
    p[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    p[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    p[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    p[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel test = new PPMModel(2, 2, 255, p);
    storage.put("name", test);
    assertEquals(storage.contains("name").getHeight(), 2);
    assertEquals(storage.contains("name").getWidth(), 2);
    String testS = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        testS += (p[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String inLib = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        inLib += (storage.contains("name").getPixels()[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(inLib, testS);
  }

  /**
   * Test null model.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    ImageLibrary lib = new ImageStore();
    lib.put("", null);
  }
}
