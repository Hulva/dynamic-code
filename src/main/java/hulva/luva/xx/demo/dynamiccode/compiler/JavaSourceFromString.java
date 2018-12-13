package hulva.luva.xx.demo.dynamiccode.compiler;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Hulva Luva.H
 * @date 2018年12月13日
 * @description
 *
 */
public class JavaSourceFromString extends SimpleJavaFileObject {
  /**
   * The source code of this "file".
   */
  private final String code;

  /**
   * Constructs a new JavaSourceFromString.
   *
   * @param name the name of the compilation unit represented by this file object
   * @param code the source code for the compilation unit represented by this file object
   */
  JavaSourceFromString(@NotNull String name, String code) {
    super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
    this.code = code;
  }

  @Override
  public CharSequence getCharContent(boolean ignoreEncodingErrors) {
    return code;
  }
}
