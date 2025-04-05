package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

import Command.Command;
import Command.Load;
import Command.Brighten;
import Command.LumaGreyScale;
import Command.GreyScale;
import Command.Save;
import Model.ImageLibrary;
import View.ImageView;

/**
 * Class for the image controller.
 */
public class ImageControllerImpl implements ImageController {

  private final ImageLibrary library;
  private final ImageView view;
  private final Readable in;

  /**
   * The constructor for the image controller.
   * @param library the library for the image.
   * @param view the view of the image.
   * @param in the readable in.
   */
  public ImageControllerImpl(ImageLibrary library, ImageView view, Readable in) {
    if (library == null || view == null || in == null) {
      throw new IllegalArgumentException("Null input.");
    }
    this.library = library;
    this.view = view;
    this.in = in;
  }

  /**
   * Method of the process of the operation chosen.
   * @throws IllegalStateException if error.
   */
  @Override
  public void process() throws IllegalStateException {
    List<String> stringCommands = new ArrayList<>(Arrays.asList("load", "brighten", "save",
            "red-component", "green-component", "blue-component", "luma-component",
            "intensity-component", "value-component", "greyscale"));
    try {
      Scanner scan = new Scanner(this.in);
      Stack<Command> commands = new Stack<>();
      Map<String, Function<Scanner, Command>> knownCommands = new HashMap<>();
      knownCommands.put("load", (Scanner s) -> {
        return new Load(s.next(), s.next());
      });
      knownCommands.put("brighten", (Scanner s) -> {
        return new Brighten(s.nextInt(), s.next(), s.next());
      });
      knownCommands.put("save", (Scanner s) -> {
        return new Save(s.next(), s.next());
      });
      knownCommands.put("red-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "red")
                : new GreyScale(model, s.next(), "red");
      });
      knownCommands.put("green-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "green")
                : new GreyScale(model, s.next(), "green");
      });
      knownCommands.put("blue-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "blue")
                : new GreyScale(model, s.next(), "blue");
      });
      knownCommands.put("luma-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "luma")
                : new GreyScale(model, s.next(), "luma");
      });
      knownCommands.put("intensity-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "intensity")
                : new GreyScale(model, s.next(), "intensity");
      });
      knownCommands.put("value-component", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new GreyScale(model, next, "max")
                : new GreyScale(model, s.next(), "max");
      });
      knownCommands.put("greyscale", (Scanner s) -> {
        String model = s.next();
        String next = s.next();
        return (this.library.contains(next) == null) ? new LumaGreyScale(model, "red")
                : new GreyScale(model, s.next(), "red");
      });

      while (scan.hasNext()) {
        Command c;
        String in = scan.next();
        if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
          this.view.renderMessage("Application has closed");
          return;
        }
        try {
          Function<Scanner, Command> cmd = knownCommands.getOrDefault(in, null);
          if (cmd == null) {
            this.view.renderMessage("Failed to load command\n");
          }
          else {
            c = cmd.apply(scan);
            commands.add(c);
            c.process(library, stringCommands);
            this.view.renderMessage("Completed " + stringCommands.toString() + "\n");
          }
        }
        catch (Exception e){
          this.view.renderMessage("Failed \n");
        }
      }

    } catch (IOException e) {
      throw new IllegalStateException("The appendable failed");
    }
  }
}
