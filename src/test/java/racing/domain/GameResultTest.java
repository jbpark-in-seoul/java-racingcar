package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("게임 결과 등록 및 조회")
    void addGameRound() {
        GameResult gameResult = new GameResult();
        GameRound gameRound = new GameRound();

        gameResult.addRound(gameRound);

        assertThat(gameResult.getGameRoundList()).contains(gameRound);
    }
}
