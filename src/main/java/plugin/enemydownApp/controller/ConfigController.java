package plugin.enemydownApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plugin.enemydownApp.mapper.data.GameConfig;
import plugin.enemydownApp.service.ConfigService;

@RestController
public class ConfigController {

  @Autowired
  private ConfigService service;

  public ConfigController(ConfigService service) {
    this.service = service;
  }
  @RequestMapping(value = "/configList",method = RequestMethod.GET)
public List<GameConfig> configList(){
    return service.searchConfig();
}
}
