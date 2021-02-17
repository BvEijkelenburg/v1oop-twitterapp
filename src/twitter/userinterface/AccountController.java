package twitter.userinterface;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import twitter.model.Tweet;
import twitter.model.TwitterAccount;

import java.util.ArrayList;
import java.util.Collections;

public class AccountController {
    @FXML private ListView tweetlist;
    @FXML private Label tweetsLabel;
    @FXML private Label volgersLabel;
    @FXML private Label vriendenLabel;

    private TwitterAccount account = TwitterAccount.getHuidigeUser();

    public void initialize() {
        tweetsLabel.setText("" + account.getTweets().size());
        vriendenLabel.setText("" + account.getVrienden().size());
        volgersLabel.setText("" + account.getVolgers().size());

        ArrayList<Label> labels = new ArrayList<>();
        for (Tweet tweet : account.getTweets()) {
            Label label = new Label(tweet.getBericht());
            label.setFont(new Font("Calibri", 18));
            label.setPadding(new Insets(10, 10, 10, 10));
            labels.add(label);
        }
        Collections.reverse(labels);

        tweetlist.setItems(FXCollections.observableArrayList(labels));
    }

    public void handleButtonToonVrienden(ActionEvent actionEvent) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vrienden.fxml"));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            initialize();
    }

    public void handleButtonTweetOpstellen(ActionEvent actionEvent) {
        String melding = "Deze functionaliteit is helaas nog niet in gebruik!";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, melding);
        alert.show();
    }
}
