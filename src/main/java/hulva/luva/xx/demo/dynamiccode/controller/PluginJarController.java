package hulva.luva.xx.demo.dynamiccode.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hulva.luva.xx.demo.dynamiccode.compiler.PluginJarManager;

/**
 * @author Hulva Luva.H
 * @date 2018年12月14日
 * @description
 *
 */
@RequestMapping("/plugin-jar")
@RestController
public class PluginJarController extends BaseController {
  @Autowired
  PluginJarManager pluginJarManager;

  @GetMapping("/query")
  public Map<String, Object> list(@RequestParam String pluginName) {
    return SUCCESS(pluginJarManager.list(pluginName));
  }
}
