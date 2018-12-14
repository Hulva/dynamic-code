package hulva.luva.xx.demo.dynamiccode.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hulva.luva.xx.demo.dynamiccode.compiler.ThirdPartyJarManager;

/**
 * @author Hulva Luva.H
 * @date 2018年12月14日
 * @description
 *
 */
@RequestMapping("/third-party-jar")
@RestController
public class ThirdPartyJarController extends BaseController {
  @Autowired
  ThirdPartyJarManager thirdPartyJarManager;

  @GetMapping("/query")
  public Map<String, Object> query(@RequestParam String query) {
    return SUCCESS(thirdPartyJarManager.query(query));
  }
}
