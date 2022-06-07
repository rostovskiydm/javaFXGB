package ru.gb.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class Controller {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField userAnswer;
    private Game game;
    private int step;

    public Controller() {
        this.game = new Game();
    }

    public void clickCheckButton(ActionEvent actionEvent) {
        String answer = userAnswer.getText();
        if (answer.isBlank()) {
            return;
        }
        Game.BullsAndCowsCount count = game.calculateBullsAndCows(answer);
        String text = String.format("%d. Введено число %s, количество быков %d, количество коров %d", ++step, answer, count.getBulls(), count.getCows());
        historyArea.appendText(text + "\n");
        userAnswer.clear();
        userAnswer.requestFocus();

        if (count.getBulls() == 4) {
            if (ifWantToPlayAgain()) {
                clickNewGame();
            } else {
                System.exit(0);
            }

        }
    }

    private boolean ifWantToPlayAgain() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Поздравляем, вы выиграли! \n" + "Загаданное число " + game.getGuessNum() + ".\n\n" + "Желаете сыграть еще?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Поздравляем!");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;

    }

    public void clickNewGame() {
        step = 0;
        historyArea.clear();
        this.game = new Game();
    }

    public void clickExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
