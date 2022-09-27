package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.move.MoveStrategy;
import racing.rule.move.RandomMove;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSetTest {

    GameSet gameSet;
    MoveStrategy randomMove = new RandomMove();

    @BeforeEach
    void settings() {
        gameSet = new GameSet.GameSetBuilder(3, 5, randomMove).build();
    }

    @Test
    @DisplayName("게임 설정 - 규칙 설정 확인")
    void checkRuleSet() {
        assertThat(gameSet.getMoveStrategy()).isEqualTo(randomMove);
    }

    @Test
    @DisplayName("게임 설정 - 자동차 수 및 이동 수 확인")
    void checkNumberOfCarAndMovements() {
        gameSet = new GameSet.GameSetBuilder().build();
        // 기본 값
        assertThat(gameSet.getNumberOfCars()).isEqualTo(1);
        assertThat(gameSet.getNumberOfMove()).isEqualTo(1);

        gameSet = new GameSet.GameSetBuilder(3, 5, randomMove).build();
        // 설정 값
        assertThat(gameSet.getNumberOfCars()).isEqualTo(3);
        assertThat(gameSet.getNumberOfMove()).isEqualTo(5);
    }

    @Test
    @DisplayName("게임 설정 - 자동차, 이동 수 음수 입력 확인")
    void checkNegativeNumber() {
        assertThatThrownBy(() -> new GameSet.GameSetBuilder(-1, -2, randomMove).build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 설정 - 규칙 설정 에러 발생")
    void createConstructorException() {
        assertThatThrownBy(() -> new GameSet.GameSetBuilder(-1, -2, null).build())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
