package plugin.enemydownApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plugin.enemydownApp.mapper.GameConfigMapper;
import plugin.enemydownApp.mapper.data.GameConfig;

@Service
public class ConfigService {


  private final GameConfigMapper mapper;

  public ConfigService(GameConfigMapper mapper) {
    this.mapper = mapper;
  }

  public List<GameConfig> searchConfig(){
    return mapper.selectGameConfigList();
  }

}
