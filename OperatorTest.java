import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.EightBitPixel;
import model.Operations;
import model.Operator;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Testing all of the operations.
 */
public class OperatorTest {
  Pixel[][] pix;
  Pixel[][] pix1;
  Pixel[][] pix2;
  Pixel[][] pix3;
  Pixel[][] pix4;
  Pixel[][] pix5;
  Operations op;
  Operations op1;
  Operations op2;
  Operations op3;
  Operations op4;
  Operations op5;

  /**
   * Setting up the variables for the test.
   */
  @Before
  public void setUp() {
    pix = new Pixel[2][2];
    pix[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op = new Operator(pix);
    pix1 = new Pixel[2][2];
    pix1[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix1[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix1[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix1[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op1 = new Operator(pix1);
    pix2 = new Pixel[2][2];
    pix2[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix2[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix2[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix2[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op2 = new Operator(pix2);
    pix3 = new Pixel[2][2];
    pix3[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix3[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix3[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix3[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op3 = new Operator(pix3);
    pix4 = new Pixel[2][2];
    pix4[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix4[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix4[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix4[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op4 = new Operator(pix4);
    pix5 = new Pixel[2][2];
    pix5[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 3)));
    pix5[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 1, 1)));
    pix5[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 1, 4)));
    pix5[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 4, 3)));
    op5 = new Operator(pix5);
  }

  /**
   * Test the operations.
   */
  @Test
  public void updatelumagreyscale() {
    Pixel[][] luma = new Pixel[2][2];
    luma[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    luma[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 3, 3)));
    luma[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    luma[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    String lumaString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        lumaString += (luma[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString6 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString6 += (op.update(Operations.OperationType.luma, 0, "")[k][l]
                .getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(lumaString, mockString6);
  }


  /**
   * Test the components of greyscale.
   */
  @Test
  public void testcomponent() {
    //red
    Pixel[][] red = new Pixel[2][2];
    red[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    red[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 8, 8)));
    red[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 2, 2)));
    red[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 5, 5)));
    String redString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        redString += (red[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString1 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString1 += (op.update(Operations.OperationType.luma, 0, "red")
                [k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }

    assertEquals(redString, mockString1);
  }

  /**
   * Test the green component.
   */
  @Test
  public void testGreen() {
      //the green string
    Pixel[][] green = new Pixel[2][2];
    green[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    green[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    green[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    green[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    String greenString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        greenString += (green[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString2 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString2 += (op1.update(Operations.OperationType.greyScale, 0, "green")[k][l].getColor().stream()
                  .map(n -> String.valueOf(n))
                  .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(greenString, mockString2);
  }

  /**
   * Test the blue component.
   */
  @Test
  public void testBlue() {
    //blue
    Pixel[][] blue = new Pixel[2][2];
    blue[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 3, 3)));
    blue[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    blue[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    blue[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 3, 3)));
    String blueString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        blueString += (blue[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString3 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString3 += (op2.update(Operations.OperationType.greyScale, 0,
                "blue")[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(blueString, mockString3);
  }

  /**
   * Test the max value of the image.
   */
  @Test
  public void testMaxVal() {
    Pixel[][] max = new Pixel[2][2];
    max[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 3, 3)));
    max[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(8, 8, 8)));
    max[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    max[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(5, 5, 5)));
    String maxString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        maxString += (max[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString4 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString4 += (op3.update(Operations.OperationType.greyScale, 0,
                "max")[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(maxString, mockString4);
  }

  /**
   * Test the intensity of an image.
   */
  @Test
  public void TestIntensity() {
    Pixel[][] intensity = new Pixel[2][2];
    intensity[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    intensity[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 3, 3)));
    intensity[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 2, 2)));
    intensity[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    String intensityString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        intensityString += (intensity[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    String mockString5 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString5 += (op4.update(Operations.OperationType.greyScale, 0,
                "intensity")[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(intensityString, mockString5);
  }

  /**
   * Test the luma of the image.
   */
  @Test
  public void testLuma() {
    Pixel[][] luma = new Pixel[2][2];
    luma[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    luma[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 2, 2)));
    luma[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(1, 1, 1)));
    luma[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(4, 4, 4)));
    String lumaString = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        lumaString += (luma[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    Pixel[][] a = (op5.update(Operations.OperationType.greyScale, 0, "luma"));
    String mockString6 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString6 += (a[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(lumaString, mockString6);
  }

  /**
   * Test to brighten the image.
   */
  @Test
  public void testbright() {
    //brightening
    Pixel[][] brighten = new Pixel[2][2];
    brighten[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(2, 2, 4)));
    brighten[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(9, 2, 2)));
    brighten[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(3, 2, 5)));
    brighten[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(6, 5, 4)));
    String brightening = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        brightening += (brighten[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    Pixel[][] a = (op.update(Operations.OperationType.brighter, 1, ""));
    String mockString = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mockString += a[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")"));
      }
    }
    assertEquals(brightening, mockString);


    //brightening to a level higher than the maximum value of RGB
    Pixel[][] brighten1 = new Pixel[2][2];
    brighten1[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(255, 255, 255)));
    brighten1[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(255, 255, 255)));
    brighten1[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(255, 255, 255)));
    brighten1[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(255, 255, 255)));
    String brightening1 = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        brightening1 += (brighten1[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    Pixel[][] b = (op.update(Operations.OperationType.brighter, 255, ""));
    String mock1String = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mock1String += (b[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(brightening1, mock1String);

    //darkening
    Pixel[][] brighten2 = new Pixel[2][2];
    brighten2[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(254, 254, 254)));
    brighten2[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(254, 254, 254)));
    brighten2[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(254, 254, 254)));
    brighten2[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(254, 254, 254)));
    String brightening2 = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        brightening2 += (brighten2[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }

    Pixel[][] c = (op.update(Operations.OperationType.brighter, -1, ""));
    String mock1String1 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mock1String1 += (c[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    assertEquals(brightening2, mock1String1);

    //darken past the minimum value for RGB, ensures does not go past 0.
    Pixel[][] brighten3 = new Pixel[2][2];
    brighten3[0][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(0, 0, 0)));
    brighten3[0][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(0, 0, 0)));
    brighten3[1][0] = new EightBitPixel(new ArrayList<>(Arrays.asList(0, 0, 0)));
    brighten3[1][1] = new EightBitPixel(new ArrayList<>(Arrays.asList(0, 0, 0)));
    String brightening3 = "";
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        brightening3 += (brighten3[i][j].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }
    Pixel[][] d = (op.update(Operations.OperationType.brighter, -255, ""));
    String mock1String2 = "";
    for (int k = 0; k < 2; k++) {
      for (int l = 0; l < 2; l++) {
        mock1String2 += (d[k][l].getColor().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "(", ")")));
      }
    }

    assertEquals(brightening3, mock1String2);
  }

  /**
   * Test for if the pixels are null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullPixels() {
    new Operator(null);
  }


  /**
   * Test for providing invalid arguments in the greyscale.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGreyScaleInvalid() {
    op.update(Operations.OperationType.greyScale, 0, "23");
  }


  /**
   * Test p an providing valid arguments.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGreyScaleInvalid1() {
    op.update(Operations.OperationType.greyScale, 0, "adwdasfdgs");
  }

  /**
   * Test putting an invalid argument (String with characters) in the method greyScale.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGreyScaleInvalid2() {
    op.update(Operations.OperationType.greyScale, 0, "/.?@");
  }



}
