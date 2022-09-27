package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.move.RandomMove;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRoundTest {

    @Test
    @DisplayName("경주 및 경주 결과 출력 검증")
    void racingAndRoundResult() {
        List<Car> cars = Arrays.asList(new Car(), new Car());

        GameRound gameRound = new GameRound();
        gameRound.racing(cars, new RandomMove());

        assertThat(gameRound.getRoundResults()).isNotEmpty();
    }
}
