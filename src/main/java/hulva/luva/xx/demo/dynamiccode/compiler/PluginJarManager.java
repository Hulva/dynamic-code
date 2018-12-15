package hulva.luva.xx.demo.dynamiccode.compiler;

import java.io.File;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * @author Hulva Luva.H
 * @date 2018年12月14日
 * @description
 *
 */
@Component
public class PluginJarManager {

  public static final String PLUGIN_JAR_FOLDER = "plugin-jar";
  static {
    File thirdPartyJarDir = new File(PLUGIN_JAR_FOLDER);
    if (!thirdPartyJarDir.exists() || !thirdPartyJarDir.isDirectory()) {
      thirdPartyJarDir.mkdir();
    }
  }

  public Set<String> list(String pluginName) {

    return null;
  }

}
