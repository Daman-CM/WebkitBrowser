package example.webkitbrowser;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import java.net.URL;

public class Controller implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;

    @Override
    public void initialize(URL a1, java.util.ResourceBundle a2) {
        engine = webView.getEngine();
        String homePage = "www.google.com";
        textField.setText(homePage);
        loadPage();
    }

    public void loadPage() {
        engine.load("https://" + textField.getText());
    }

    public void refreshPage() {
        engine.reload();
    }

    public void zoomIn() {
        webView.setZoom(webView.getZoom() + 0.1);
    }
    public void zoomOut() {
        webView.setZoom(webView.getZoom() - 0.1);
    }

    public void backPage() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forwardPage() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void bookmarkYoutube() {
        String homePage = "www.youtube.com";
        textField.setText(homePage);
        loadPage();
    }
}
