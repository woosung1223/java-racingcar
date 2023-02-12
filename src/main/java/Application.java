import controller.RacingController;
import view.input.InputView;
import view.output.ConsoleView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new RacingController(new InputView(scanner), new ConsoleView()).start();
    }
}
