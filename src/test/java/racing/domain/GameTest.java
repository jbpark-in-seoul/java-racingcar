package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.move.RandomMove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 검증")
    void createConstructorWithSettings() {
        GameSet gameSet = new GameSet.GameSetBuilder(3, 5, new RandomMove()).build();
        Game game = new Game(gameSet);

        assertThat(game.getGameSet()).isEqualTo(gameSet);
        assertThat(game.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 예외 발생")
    void createConstructorWithSettingException() {
        assertThatThrownBy(() -> new Game(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
