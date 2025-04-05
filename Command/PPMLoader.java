package Command;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Model.EightBitPixel;
import Model.ImageModel;
import Model.PPMModel;
import Model.Pixel;

/**
 * Class to load PPM image loading.
 */
public class PPMLoader extends ImageLoader{

  /**
   * constructor for the PPM Loader that takes the file path as a string.
   * @param in the file path.
   */
  public PPMLoader(String in) {
    super(in);
  }

  /**
   * Allows the loader to load the path file and return it as an ImageModel.
   * @return returns the ImageModel.
   * @throws IllegalStateException loading failed.
   */
  @Override
  public ImageModel load() throws IllegalStateException {

    Scanner scanner = null;
    File file = new File(super.in);
    try {
      scanner = new Scanner(new FileInputStream(file));
    }
    catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    }

    StringBuilder builder = new StringBuilder();

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      try {
        if (s.charAt(0) != '#') {
          builder.append(s + System.lineSeparator());
        }
      }
      catch (Exception e) {
        throw new IllegalStateException();
      }
    }
    scanner = new Scanner(builder.toString());

    String token;

    token = scanner.next();

    if (!token.equals("P3")) {
      throw new IllegalStateException("Invalid PPM file");
    }
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    int maxValue = scanner.nextInt();
    Pixel[][] imageBoard = new Pixel[height][width];

    for (int i = 0; i < imageBoard.length; i++) {
      for (int j = 0; j < imageBoard.length; j++) {
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        if(r < 0 || r > 255 || g < 0 || g > 255|| g < 0 || g > 255) {
          System.out.println("Destructed file, try to input another");
          throw new IllegalStateException("Destructed file");
        }
        imageBoard[i][j] = new EightBitPixel(Arrays.asList(r,g,b));
      }
    }
    return new PPMModel(height, width, maxValue, imageBoard);
  }
}

