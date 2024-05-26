package plugin.enemydownApp.mapper.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpawnEnemy {

  private int id;
  private String difficulty;
  private String enemy_Name;
  private int score;
}