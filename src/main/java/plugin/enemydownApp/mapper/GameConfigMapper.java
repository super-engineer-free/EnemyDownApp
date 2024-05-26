package plugin.enemydownApp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.enemydownApp.mapper.data.GameConfig;
import plugin.enemydownApp.mapper.data.PlayerScore;

@Mapper
public interface GameConfigMapper {

  @Select("select * from game_config")
  List<GameConfig> selectGameConfigList();
}
