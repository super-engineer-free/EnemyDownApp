package plugin.enemydownApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plugin.enemydownApp.mapper.PlayerScoreMapper;
import plugin.enemydownApp.mapper.data.GameConfig;
import plugin.enemydownApp.mapper.data.PlayerScore;

@Service
public class PlayerScoreService {

  private final PlayerScoreMapper mapper;


  public PlayerScoreService(PlayerScoreMapper mapper) {
    this.mapper = mapper;
  }

  public List<PlayerScore> searchPlayerScoreList() {
    return mapper.selectPlayerScoreList();
  }
}
