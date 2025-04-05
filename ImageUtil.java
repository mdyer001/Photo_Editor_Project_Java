import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import command.Save;
import model.EightBitPixel;
import model.ImageLibrary;
import model.ImageModel;
import model.ImageStore;
import model.Operations;
import model.Operator;
import model.PPMModel;
import model.Pixel;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method
 *  as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static void readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      System.out.println("File " + filename + " not found!");
      return;
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): "+ maxValue);
    Pixel[][] p = new Pixel[height][width];



    for (int i = 0;i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        List rgblist = new ArrayList<>();
        rgblist.add(r);
        rgblist.add(g);
        rgblist.add(b);
        p[i][j] = new EightBitPixel(rgblist);
      }
    }

    ImageModel test = new PPMModel(height, width, 255, p);
    ImageLibrary storage = new ImageStore();
    storage.put("Hello", test);
    Operator op = new Operator(p);
    op.update(Operations.OperationType.brighter, 100, "");
    op.update(Operations.OperationType.greyScale, 0, "red");
    Save s = new Save("/Users/kyle/IdeaProjects/ImageProcessingSetUp/src/" +
            "imagealterations/Koala.ppm", "Hello");
    s.process(storage, null);




  }

  /**
   *Main argument for running the image and changing it.
   * @param args
   */
  //demo main
  public static void main(String []args) {
    String filename;

    if (args.length > 0) {
      filename = args[0];

    }
    else {
      filename = "sample.ppm";
    }

    ImageUtil.readPPM(filename);
  }
}


