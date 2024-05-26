package plugin.enemydownApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plugin.enemydownApp.DuplicateConfigException;
import plugin.enemydownApp.mapper.data.GameConfig;
import plugin.enemydownApp.mapper.data.SpawnEnemy;
import plugin.enemydownApp.service.ConfigService;


@RestController
public class ConfigController {

  private final ConfigService service;

  public ConfigController(ConfigService service) {
    this.service = service;
  }

  @RequestMapping(value = "/configList", method = RequestMethod.GET)
  public List<GameConfig> configList(){
    return service.searchConfigList();
  }
  @RequestMapping(value = "/config", method = RequestMethod.GET)
  public GameConfig config(@RequestParam String difficulty){
    return service.searchConfig(difficulty);
  }
  @RequestMapping(value = "/spawnEnemyList", method = RequestMethod.GET)
  public List<SpawnEnemy> spawnEnemyList(@RequestParam String difficulty){
    return service.searchSpawnEnemyList(difficulty);
  }

  @PostMapping(value = "/config")
  public ResponseEntity<GameConfig> registerConfig(@RequestBody GameConfig config) throws Exception{
    GameConfig registerConfig = service.registerConfig(config);
    return new ResponseEntity<>(registerConfig, HttpStatus.OK);
  }
  @PostMapping(value = "/updateEnemyScore")
  public ResponseEntity<List<SpawnEnemy>> updateEnemyScore(@RequestBody SpawnEnemy enemy) {
    List<SpawnEnemy> updateSpawnEnemyList = service.updateEnemyScore(enemy);
    return new ResponseEntity<>(updateSpawnEnemyList, HttpStatus.OK);
  }

  @ExceptionHandler(value = DuplicateConfigException.class)
  public ResponseEntity<Map<String, String>> handleDuplicateConfig(
      DuplicateConfigException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
        "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI());
    return new ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}