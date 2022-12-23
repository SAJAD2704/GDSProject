package com.example.dsgraphicalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ErrorPageController
{
    @FXML
    private TextArea textArea;

    @FXML
    private Button ExitButton;
    @FXML
    private Button MainPageButton;

    @FXML
    private void ExitButton()
    {
        System.exit(0);
    }

    @FXML
    private void MainPageButton()
    {
        HelloApplication.launch();
    }
}
