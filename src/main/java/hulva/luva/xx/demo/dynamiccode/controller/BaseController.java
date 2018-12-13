package hulva.luva.xx.demo.dynamiccode.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hulva Luva.H
 * @date 2018年12月7日
 * @description
 *
 */
public class BaseController {
  public Map<String, Object> SUCCESS() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", true);
    return map;
  }

  public Map<String, Object> SUCCESS(Object data) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", true);
    map.put("data", data);
    return map;
  }

  public Map<String, Object> SUCCESS(Object data, String message) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", true);
    map.put("data", data);
    map.put("message", message);
    return map;
  }

  public Map<String, Object> FAIL(String message) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", false);
    map.put("message", message);
    return map;
  }

  public Map<String, Object> FAIL(String message, Throwable e) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", false);
    map.put("message", message);
    map.put("error", e);
    return map;
  }
}
