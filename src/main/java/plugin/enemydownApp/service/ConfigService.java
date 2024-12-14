package plugin.enemydownApp.service;


import java.util.List;
import org.springframework.stereotype.Service;
import plugin.enemydownApp.DuplicateConfigException;
import plugin.enemydownApp.mapper.GameConfigMapper;
import plugin.enemydownApp.mapper.data.GameConfig;
import plugin.enemydownApp.mapper.data.SpawnEnemy;

@Service
public class ConfigService {


  private final GameConfigMapper mapper;


  public ConfigService(GameConfigMapper mapper) {
    this.mapper = mapper;
  }

  public List<GameConfig> searchConfigList() {
    return mapper.selectConfigList();
  }

  public GameConfig searchConfig(String difficulty) {
    return mapper.selectConfig(difficulty);
  }

  public List<SpawnEnemy> searchSpawnEnemyList(String difficulty) {
    return mapper.selectSpawnEnemyList(difficulty);
  }

  public GameConfig registerConfig(GameConfig config) throws Exception {
    if (searchConfig(config.getDifficulty()) != null){
      throw new DuplicateConfigException("Duplicate Config Error!");
    }
    mapper.insertConfig(config);
    return mapper.selectConfig(config.getDifficulty());
  }

  public List<SpawnEnemy> updateEnemyScore(SpawnEnemy enemy) {
    mapper.updateEnemyScore(enemy);
    return mapper.selectSpawnEnemyList(enemy.getDifficulty());
  }
}