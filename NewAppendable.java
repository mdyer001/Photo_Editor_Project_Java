import java.io.IOException;


/**
 * This class made to test the Appendable.
 * (throw IOException instead of IllegalArgumentException)
 */
public class NewAppendable implements Appendable {

  /**
   * Appends the character sequence to this {@code Appendable}
   */
  @Override
  public NewAppendable append(CharSequence csq) throws IOException {
    throw new IOException("Cannot write!");
  }

  /**
   * Appends the specified character sequence to this
   * {@code Appendable}.
   */
  @Override
  public NewAppendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Cannot write!");
  }

  /**
   * Appends the specified character to this {@code Appendable}.
   */
  @Override
  public NewAppendable append(char c) throws IOException {
    throw new IOException("Cannot write!");
  }
}

