package Command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import Model.ImageLibrary;
import Model.ImageModel;
import View.ViewImpl;

public class Save implements Command {
  private final String savingPath;
  private final String fileNameIn;

  /**
   * Constructor for Save takes in image name and returns image file.
   * @param savingPath The output.
   * @param fileNameIn The input.
   */
  public Save(String savingPath, String fileNameIn) {
    this.savingPath = savingPath;
    this.fileNameIn = fileNameIn;
  }

  /**
   * Used to execute the save command and save the given image.
   * @param library The library storing models.
   * @throws IllegalArgumentException When the command fails.
   */
  @Override
  public void process(ImageLibrary library, List<String> stringCommands)
          throws IllegalArgumentException {
    try {
      ImageModel model = library.contains(fileNameIn);
      if (model == null) {
        throw new IllegalArgumentException("Cannot find image to save");
      }
      try {
        int end = this.savingPath.lastIndexOf(".");
        String fileType = savingPath.substring(end + 1);
        String[] typesSupported = ImageIO.getReaderFormatNames();
        boolean isSupported = false;
        for (int i = 0; i < typesSupported.length; i++) {
          if (fileType.equalsIgnoreCase(typesSupported[i]) ||
                  fileType.equalsIgnoreCase("ppm")) {
            isSupported = true;
          }
        }

        try {
          if (!isSupported) {
            throw new IllegalStateException();
          }
        } catch (IllegalStateException e) {
          System.out.println("Save file type is not supported!");
        }

        if (fileType.equalsIgnoreCase("ppm")) {
          File out = new File(this.savingPath);
          FileOutputStream imageOut = new FileOutputStream(out);
          imageOut.write(new ViewImpl(library).toString(this.fileNameIn).getBytes());
          imageOut.flush();
          imageOut.close();
          System.out.println(fileNameIn + " has been saved successfully");
        }

      } catch (IllegalArgumentException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
}



