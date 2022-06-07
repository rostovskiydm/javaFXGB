package ru.gb.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    private static final String EXIT_PHRASE = "Вы дейстивтельно хотите выйти?";
    private static final String CLEAR_PHRASE = "Вы дейстивтельно хотите очистить историю чата?";
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField userSpeech;

    public void clickSendButton(ActionEvent actionEvent) {
        String speech = userSpeech.getText();
        if (speech.isBlank()) {
            return;
        }
        chatArea.appendText(speech + "\n");
        userSpeech.clear();
        userSpeech.requestFocus();

    }

    private boolean ifWantToExitOrClear(String phrase) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                phrase,
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Предупреждение");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;

    }

    public void clickExit() {
        if (ifWantToExitOrClear(EXIT_PHRASE)){
            System.exit(0);
        }
    }

    public void clickClearChat() {
        if (ifWantToExitOrClear(CLEAR_PHRASE)){
            chatArea.clear();
        }
    }
}