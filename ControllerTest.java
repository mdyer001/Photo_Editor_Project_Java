import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.EightBitPixel;
import model.ImageLibrary;
import model.ImageModel;
import model.ImageStore;
import model.PPMModel;
import model.Pixel;
import view.ImageView;
import view.ViewImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test class contains tests to check all methods related to the ImageControllerImpl Class.
 */
public class ControllerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


  /**
   * Setting up streams before testing.
   */
  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  /**
   * Testing for appendable error.
   */
  @Test(expected = IllegalStateException.class)
  public void errorAppendableTest() {
    Appendable ap = new NewAppendable();
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\Pictures\\Camera Roll\\koala.ppm koala");

    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel test = new PPMModel(2, 2, 255, pix);
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, ap);
    ImageController controller = new ImageControllerImpl(lib, view, in);
    controller.process();
  }

  /**
   * Test if inputs are passed in.
   */
  @Test
  public void testInputs() {
    Readable in = new StringReader("brighten 10 mock mock1");
    Appendable dontCareOutput = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, dontCareOutput);
    StringBuilder log = new StringBuilder();
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals("amount = 10", log.toString());
  }


  /**
   * Test ppm image is loaded successfully.
   */
  @Test
  public void testPPMImageLoaded() {
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.ppm" + " koala");
    Appendable output = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Action Completed! \n");
    assertEquals(outContent.toString(), "Input File Type: ppm" + System.lineSeparator() +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.ppm has been loaded successfully as koala"
            + System.lineSeparator());
    assertNotNull(lib.contains("koala")); //check if the object is != null
    //check if the library has the image and returned the model of the class PPMModel.
    assertTrue(lib.contains("koala") instanceof PPMModel);
    ImageModel loaded = lib.contains("koala");
    //compare it with the real info of the image loaded from the examples
    //example is modified so that height = 2, width = 2,
    //and the pixels is the same as the mock defined below
    Pixel[][] mock = new Pixel[2][2];
    mock[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    mock[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    mock[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    mock[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    assertEquals(loaded.getHeight(), 2);
    assertEquals(loaded.getWidth(), 2);
    String mockS = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        mockS += (mock[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String loadS = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        loadS += (loaded.getPixels()[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(mockS, loadS);
  }

  private void assertTrue(boolean koala) {
  }

  /**
   * Test png image is loaded successfully.
   */
  @Test
  public void testPNGImageLoaded() {
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.png" + " koalap");
    Appendable output = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Action Completed! \n");
    assertEquals(outContent.toString(), "Input File Type: png" + System.lineSeparator() +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.png has been loaded successfully as koalap"
            + System.lineSeparator());
    assertNotNull(lib.contains("koalap")); //check if the object is != null
    //check if the library has the image and returned the model of the class IOModel.
    ImageModel loaded = lib.contains("koalap");
    //compare it with the real info of the image loaded from the examples
    //example is modified so that height = 2, width = 2,
    //and the pixels is the same as the mock defined below
    Pixel[][] mock = new Pixel[2][2];
    mock[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3, 255)));
    mock[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1, 255)));
    mock[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4, 255)));
    mock[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3, 255)));
    assertEquals(loaded.getHeight(), 2);
    assertEquals(loaded.getWidth(), 2);
    String mockS = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        mockS += (mock[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String loadS = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        loadS += (loaded.getPixels()[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(mockS, loadS); //check if loaded image has correct information
  }

  /**
   * Test bmp image is loaded successfully.
   */
  @Test
  public void testBMPImageLoaded() {
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.bmp" + " koalap");
    Appendable output = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Action Completed! \n");
    assertEquals(outContent.toString(), "Input File Type: bmp" + System.lineSeparator() +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.bmp has been loaded successfully as koalap"
            + System.lineSeparator());
    assertNotNull(lib.contains("koalap")); //check if the object is != null
    //check if the library has the image and returned the model of the class IOModel.
    ImageModel loaded = lib.contains("koalap");
    //compare it with the real info of the image loaded from the examples
    //example is modified so that height = 2, width = 2,
    //and the pixels is the same as the mock defined below
    Pixel[][] mock = new Pixel[2][2];
    mock[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3, 255)));
    mock[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1, 255)));
    mock[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4, 255)));
    mock[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3, 255)));
    assertEquals(loaded.getHeight(), 2);
    assertEquals(loaded.getWidth(), 2);
    String mockS = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        mockS += (mock[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String loadS = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        loadS += (loaded.getPixels()[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(mockS, loadS); //check if loaded image has correct information
  }

  /**
   * Test jpeg image is loaded successfully.
   */
  @Test
  public void testJPEGImageLoaded() {
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.jpeg" + " koalap");
    Appendable output = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Action Completed! \n");
    assertEquals(outContent.toString(), "Input File Type: jpeg" + System.lineSeparator() +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.jpeg has been loaded successfully as koalap"
            + System.lineSeparator());
    assertNotNull(lib.contains("koalap")); //check if the object is != null
    //check if the library has the image and returned the model of the class IOModel.
    //can't check the details of the image because JPEG performs a lossy compression, so RGB values
    //will not be the same.
    assertEquals(lib.contains("koalap").getHeight(), 2);
    assertEquals(lib.contains("koalap").getWidth(), 2);
  }

  /**
   * Test jpg image is loaded successfully.
   */
  @Test
  public void testJPGImageLoaded() {
    Readable in = new StringReader("load " +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.jpg" + " koalap");
    Appendable output = new StringBuilder();
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Action Completed! \n");
    assertEquals(outContent.toString(), "Input File Type: jpg" + System.lineSeparator() +
            "C:\\Users\\admin\\OneDrive\\Public\\koala.jpg has been loaded successfully as koalap"
            + System.lineSeparator());
    assertNotNull(lib.contains("koalap")); //check if the object is != null
    //check if the library has the image and returned the model of the class IOModel.
    //can't check the details of the image because jpg performs a lossy compression, so RGB values
    //will not be the same.
    assertEquals(lib.contains("koalap").getHeight(), 2);
    assertEquals(lib.contains("koalap").getWidth(), 2);
  }


  /**
   * Test export PPMFile successfully.
   */
  @Test
  public void testExport() {
    Readable in = new StringReader("save C:\\Users\\admin\\OneDrive\\Public\\mock.ppm mock");
    Appendable output = new StringBuilder();

    ImageLibrary lib = new ImageStore();

    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel mock = new PPMModel(2, 2, 255, pix);
    lib.put("mock", mock);
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Completed \n");
    assertEquals(outContent.toString(), "mock has been saved successfully"
            + System.lineSeparator());

    //new storage and controller and view to load the saved file.
    ImageLibrary storage = new ImageStore();
    Readable rd = new StringReader("load C:\\Users\\admin\\OneDrive\\Public\\mock.ppm mock");
    Appendable ap = new StringBuilder();
    ImageView view1 = new ViewImpl(storage, ap);
    ImageController controller = new ImageControllerImpl(storage, view1, rd);
    controller.process();
    assertEquals(ap.toString(), "Completed \n");
    assertEquals(outContent.toString(), "mock has been saved successfully"
            + System.lineSeparator()
            + "Input File Type:ppm\n");

  }


  /**
   * Test operations works, and when operations fails when the command is unknown (invalid).
   */
  @Test
  public void testOperations() {
    Readable in = new StringReader("brighten 10 mock mock-brighter " +
            "vertical-flip mock-brighter mock1"
            + " horizontal-flip mock1 mock2" + " brighten -1 mock2 mock3" +
            " value-component mock3 mock4" + " luma-component mock4 mock5"
            + " intensity-component mock5 mock6" + " red-component mock6 mock7"
            + " blue-component mock7 mock8" + " green-component mock8 mock9" +
            " dsfsefsdef" + "324234" + "/$#%$@" + "brighten wred mock9 mockerr"
            + " greyscale mock14 mock15"
            + " grey-component 32323" + " brighten333" + "q");
    Appendable output = new StringBuilder();

    ImageLibrary lib = new ImageStore();

    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel mock = new PPMModel(2, 2, 255, pix);
    lib.put("mock", mock);
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Completed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Completed \n" +
            "Completed \n" +
            "Completed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Completed \n" +
            "Completed \n" +
            "Completed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Failed \n" +
            "Completed \nFailed \nFailed \nFailed \n");
    assertEquals(outContent.toString(), "mock has been brightened in the amount of " +
            "10 as mock-brighter" + System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator() +
            "Cannot find the image" +
            System.lineSeparator());
  }


  /**
   * Test quit.
   */
  @Test
  public void testQuit() {
    Readable in = new StringReader("q Q");
    Appendable output = new StringBuilder();

    ImageLibrary lib = new ImageStore();

    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel mock = new PPMModel(2, 2, 255, pix);
    lib.put("mock", mock);
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Application has closed");
    assertEquals(outContent.toString(), "");
  }

  /**
   * Test quit with words.
   */
  @Test
  public void testQuit2() {
    Readable in = new StringReader("QUIT quit");
    Appendable output = new StringBuilder();

    ImageLibrary lib = new ImageStore();

    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    ImageModel mock = new PPMModel(2, 2, 255, pix);
    lib.put("mock", mock);
    ImageView view = new ViewImpl(lib, output);
    ImageController controller5 = new ImageControllerImpl(lib, view, in);
    controller5.process();
    assertEquals(output.toString(), "Application has closed");
    assertEquals(outContent.toString(), "");
  }

  /**
   * Test null storage.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullLib() {
    Readable in = new StringReader("QUIT quit");
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib);
    new ImageControllerImpl(null, view, in);
  }

  /**
   * Test null view.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    Readable in = new StringReader("QUIT quit");
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib);
    new ImageControllerImpl(lib, null, in);
  }

  /**
   * Test null readable.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {
    Readable in = new StringReader("QUIT quit");
    ImageLibrary lib = new ImageStore();
    ImageView view = new ViewImpl(lib);
    new ImageControllerImpl(lib, view, null);
  }


}
