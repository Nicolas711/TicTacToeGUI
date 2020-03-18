import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {


    int a = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Stage window = primaryStage;
        window.setTitle("TicTacToe");

        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        gridPane.setPadding(new Insets(15));

        Button ButtonList[] = new Button[9];
        int ID = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                Button button = new Button();
                button.setMinSize(50, 50);
                button.setMaxSize(50, 50);
                button.setId(Integer.toString(ID));


                ButtonList[ID] = button;

                gridPane.add(button, i, j);
                ID++;


                button.setOnAction((ActionEvent event) -> buttonEvent(button, ButtonList, root));


            }
        }


        root.setTop(getMenu());
        root.setCenter(gridPane);


        Scene scene = new Scene(root, 300, 300);
        window.setScene(scene);
        window.show();


    }

    private MenuBar getMenu() {

        MenuBar menuBar = new MenuBar();
        Menu gameMenu = new Menu("Game");
        MenuItem newGame = new MenuItem("New Game");
        MenuItem exitGame = new MenuItem("Exit Game");

        newGame.setOnAction((ActionEvent event) -> newGameClicked());
        exitGame.setOnAction((ActionEvent event) -> exitGameGameClicked());

        gameMenu.getItems().addAll(newGame, exitGame);
        menuBar.getMenus().add(gameMenu);

        return menuBar;
    }

    private void newGameClicked() {

        System.out.println("New Game clicked");
        // reset buttons and so on. Code to be placed here...
    }

    private void exitGameGameClicked() {

        System.out.println("Exit Game clicked");
        // Exit Game Action to be placed here...
    }

    public void buttonEvent(Button button, Button ButtonList[], BorderPane root) {
        String Spieler = "";


        if (a % 2 == 0) {
            Spieler = "X";
        } else {
            Spieler = "O";
        }

        a++;


        button.setText(Spieler);
        button.setDisable(true);

        Label ergebnis = new Label();
        if (gewonnen(ButtonList) == 0) {
            for (int i = 0; i < 9; i++) {

                ButtonList[i].setDisable(true);
            }

            ergebnis.setText("Gewonnen!");

        }
        if (gewonnen(ButtonList) == 1) {
            for (int i = 0; i < 9; i++) {

                ButtonList[i].setDisable(true);
            }

            ergebnis.setText("Unendschieden!");

        }
        root.setBottom(ergebnis);


    }

    public int gewonnen(Button buttonList[]) {


        if (buttonList[0].getText().equals("X") && buttonList[1].getText().equals("X") && buttonList[2].getText().equals("X") ||
                buttonList[3].getText().equals("X") && buttonList[4].getText().equals("X") && buttonList[5].getText().equals("X") ||
                buttonList[6].getText().equals("X") && buttonList[7].getText().equals("X") && buttonList[8].getText().equals("X") ||

                buttonList[0].getText().equals("X") && buttonList[3].getText().equals("X") && buttonList[6].getText().equals("X") ||
                buttonList[1].getText().equals("X") && buttonList[4].getText().equals("X") && buttonList[7].getText().equals("X") ||
                buttonList[2].getText().equals("X") && buttonList[5].getText().equals("X") && buttonList[8].getText().equals("X") ||

                buttonList[0].getText().equals("X") && buttonList[4].getText().equals("X") && buttonList[8].getText().equals("X") ||
                buttonList[2].getText().equals("X") && buttonList[4].getText().equals("X") && buttonList[6].getText().equals("X")) {
            return 0;
        } else if (buttonList[0].getText().equals("O") && buttonList[1].getText().equals("O") && buttonList[2].getText().equals("O") ||
                buttonList[3].getText().equals("O") && buttonList[4].getText().equals("O") && buttonList[5].getText().equals("O") ||
                buttonList[6].getText().equals("O") && buttonList[7].getText().equals("O") && buttonList[8].getText().equals("O") ||

                buttonList[0].getText().equals("O") && buttonList[3].getText().equals("O") && buttonList[6].getText().equals("O") ||
                buttonList[1].getText().equals("O") && buttonList[4].getText().equals("O") && buttonList[7].getText().equals("O") ||
                buttonList[2].getText().equals("O") && buttonList[5].getText().equals("O") && buttonList[8].getText().equals("O") ||

                buttonList[0].getText().equals("O") && buttonList[4].getText().equals("O") && buttonList[8].getText().equals("O") ||
                buttonList[2].getText().equals("O") && buttonList[4].getText().equals("O") && buttonList[6].getText().equals("O")) {
            return 0;
        } else if (buttonList[0].getText().equals("O") || buttonList[0].getText().equals("X") &&
                (buttonList[1].getText().equals("O") || buttonList[1].getText().equals("X")) &&
                (buttonList[2].getText().equals("O") || buttonList[2].getText().equals("X")) &&
                (buttonList[3].getText().equals("O") || buttonList[3].getText().equals("X")) &&
                (buttonList[4].getText().equals("O") || buttonList[4].getText().equals("X")) &&
                (buttonList[5].getText().equals("O") || buttonList[5].getText().equals("X")) &&
                (buttonList[6].getText().equals("O") || buttonList[6].getText().equals("X")) &&
                (buttonList[7].getText().equals("O") || buttonList[7].getText().equals("X")) &&
                (buttonList[8].getText().equals("O") || buttonList[8].getText().equals("X"))) {

            return 1;
        }


        return 2;
    }
}
