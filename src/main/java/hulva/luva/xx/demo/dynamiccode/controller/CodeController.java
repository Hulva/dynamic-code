package hulva.luva.xx.demo.dynamiccode.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hulva Luva.H
 * @date 2018年12月13日
 * @description
 *
 */
@RequestMapping("/codesource")
@RestController
public class CodeController extends BaseController {

  @GetMapping("/view")
  public Map<String, Object> viewSourceCode(@RequestParam String id) {

    return null;
  }

  @PostMapping("upload")
  public Map<String, Object> uploadSourceCode(@RequestBody String sourceCode) {

    return null;
  }
}
