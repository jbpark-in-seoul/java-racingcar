package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car();

    @Test
    @DisplayName("자동차 검증 - 출발지 확인")
    void checkStartingPoint() {
        assertThat(car.getForwardCount()).isEqualTo(1);
    }
}
