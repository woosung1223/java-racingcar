package controller;

import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.input.InputView;
import view.output.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            makeRacingGame(readCarNames());
            startRacingGame(readGameTry());
            makeRacingGameResult();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            start();
        }
    }

    private void makeRacingGame(List<String> carNames) {
        this.racingGame = new RacingGame(carNames, new RandomNumberGenerator());
    }

    private List<String> readCarNames() {
        try {
            return inputView.readCarName();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readCarNames();
        }
    }

    private void startRacingGame(int gameTry) {
        outputView.printGameResultMessage();
        for (int i = 0; i < gameTry; i++) {
            racingGame.start();
            outputView.printRacingStatus(racingGame.getCars());
        }
    }

    private int readGameTry() {
        try {
            return inputView.readGameTry();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return readGameTry();
        }
    }

    private void makeRacingGameResult() {
        outputView.printRacingStatus(racingGame.getCars());
        outputView.printRacingWinners(racingGame.getWinners());
    }
}
