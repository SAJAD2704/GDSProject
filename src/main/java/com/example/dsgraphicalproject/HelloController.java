package com.example.dsgraphicalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController
{
    @FXML
    private void Phase1Button() throws IOException
    {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose Main Folder");
        File file = directoryChooser.showDialog(null);
        try
        {
            Phase1.folderExtract(file);
        } catch (IOException exception)
        {
            Parent root = FXMLLoader.load(getClass().getResource("error-page.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    private void Phase2Button()
    {

    }
    @FXML
    private void Phase3Button()
    {

    }
    @FXML
    private void Phase4Button()
    {

    }
    @FXML
    private void ExtractCompressedFile() throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Main Compressed File");
        File file = fileChooser.showOpenDialog(null);
        try
        {
            Phase1.extractHereZip(file.getPath());
        } catch (IOException exception)
        {
            Parent root = FXMLLoader.load(getClass().getResource("error-page.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }
}