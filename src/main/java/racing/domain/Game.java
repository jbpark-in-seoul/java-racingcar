package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private final static int ZERO = 0;
    private final static int FIRST_ROUND = 1;
    private final GameSet gameSet;

    private List<Car> cars;
    GameResult gameResult = new GameResult();

    public Game(GameSet gameSet) {
        if (gameSet == null) {
            throw new IllegalArgumentException("입력된 게임 설정이 올바르지 않습니다.");
        }
        this.gameSet = gameSet;
        lineUp();
    }

    public void start() {
        for (int round = FIRST_ROUND; round <= gameSet.getNumberOfMove(); round++) {
            GameRound gameRound = new GameRound();
            gameRound.racing(cars, gameSet.getMoveStrategy());

            gameResult.addRound(gameRound);
        }
    }

    private void lineUp() {
        cars = IntStream.range(ZERO, gameSet.getNumberOfCars())
                .mapToObj(car -> new Car())
                .collect(Collectors.toList());
    }

    public GameSet getGameSet() {
        return gameSet;
    }

    public List<Car> getCars() {
        return cars;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
