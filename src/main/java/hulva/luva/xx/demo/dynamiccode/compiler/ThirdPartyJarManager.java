package hulva.luva.xx.demo.dynamiccode.compiler;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hulva Luva.H
 * @date 2018年12月14日
 * @description
 *
 */
@Component
public class ThirdPartyJarManager {
  private final RestTemplate restTemplate;

  public static final String THIRD_PARTY_JAR_FOLDER = "third-party-jar";
  static {
    File thirdPartyJarDir = new File(THIRD_PARTY_JAR_FOLDER);
    if (!thirdPartyJarDir.exists() || !thirdPartyJarDir.isDirectory()) {
      thirdPartyJarDir.mkdir();
    }
  }

  public ThirdPartyJarManager(RestTemplate restTemplate) {
    super();
    this.restTemplate = restTemplate;
  }


  // TODO query third-party jar from mvnrepository
  // http://central.maven.org/maven2/org/hamcrest/hamcrest-library/2.1-rc4/hamcrest-library-2.1-rc4.jar
  public String query(String keyword) {
//    MvnRepositoryApi api = MvnRepositoryApi.create();
//    Page<ArtifactEntry> page = api.search("reactor-core");
    return null;
  }
}
