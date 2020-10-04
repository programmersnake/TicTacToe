package com.kostin.miner.logicController;

import com.kostin.miner.Players.Player;
import com.kostin.miner.Players.PlayerComputer;
import com.kostin.miner.Players.PlayerUser;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MinerUI extends Application {

    private final Player[] players = new Player[2];
    private final Image[] winImgs = new Image[]{
            new Image( "javafxView/scr/imgs/win3.png" ),
            new Image( "javafxView/scr/imgs/win2.png" ),
            new Image( "javafxView/scr/imgs/win4.png" ),
            new Image( "javafxView/scr/imgs/win5.png" ),
            new Image( "javafxView/scr/imgs/win1.png" ),
            new Image( "javafxView/scr/imgs/win6.png" ),
            new Image( "javafxView/scr/imgs/win7.png" ),
            new Image( "javafxView/scr/imgs/win8.png" ),
            new Image( "javafxView/scr/imgs/the end.png" )
    };
    private boolean gameWithPC = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Pane;

    @FXML
    private AnchorPane startPane;

    @FXML
    private Button StartGameMainButton;

    @FXML
    private Button StartGameMainButton1;

    @FXML
    private Button startAgain;

    @FXML
    private AnchorPane gameAreaPane;

    @FXML
    private ImageView cell_1X1_ImageView;

    @FXML
    private ImageView cell_1X2_ImageView;

    @FXML
    private ImageView cell_1X3_ImageView;

    @FXML
    private ImageView cell_2X1_ImageView;

    @FXML
    private ImageView cell_2X2_ImageView;

    @FXML
    private ImageView cell_2X3_ImageView;

    @FXML
    private ImageView cell_3X1_ImageView;

    @FXML
    private ImageView cell_3X2_ImageView;

    @FXML
    private ImageView cell_3X3_ImageView;

    @FXML
    private ImageView theEndOrWinImg;

    private int hodNumber = 0;
    private boolean isStopGame = false;

    public static void main(String[] args) {
        launch( args );
    }

    void gameWithPC() {

    }

    void userHod(int x, int y) {
        System.out.println( "User hod x = " + x + " y = " + y );
        players[hodNumber].xod( (short) x, (short) y );
        isWin();
        if (hodNumber >= 1)
            hodNumber = 0;
        else
            hodNumber++;
    }

    private void isWin() {
        System.out.println( "void isWin() MinerUI.class" );
        if (players[hodNumber].isWin()) {
            int imgCode = players[hodNumber].getWinImgCode();
            theEndOrWinImg.setImage( winImgs[imgCode] );
            theEndOrWinImg.setVisible( true );
            isStopGame = true;
        }
    }

    @FXML
    void initialize() {

        StartGameMainButton.setOnAction( actionEvent -> {
            gameWithPC = false;
            isStopGame = false;
            theEndOrWinImg.setVisible( false );
            startPane.setVisible( false );
            gameAreaPane.setVisible( true );
            hodNumber = 0;

            players[0] = new PlayerUser();
            players[1] = new PlayerUser();


        } );

        StartGameMainButton1.setOnAction( actionEvent -> {
            gameWithPC = true;
            isStopGame = false;
            theEndOrWinImg.setVisible( false );
            startPane.setVisible( false );
            gameAreaPane.setVisible( true );
            hodNumber = 0;

            players[0] = new PlayerUser();
            players[1] = new PlayerComputer( players[0].getArea() );

        } );

        cell_1X1_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_1X1_ImageView.setDisable( true );
                userHod( 0, 0 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {
                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }

                userHod( 0, 0 );

                cell_1X1_ImageView.setDisable( true );
            }

        } );

        cell_1X2_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_1X2_ImageView.setDisable( true );
                userHod( 0, 1 );


                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 0, 1 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_1X2_ImageView.setDisable( true );
            }
        } );

        cell_1X3_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_1X3_ImageView.setDisable( true );
                userHod( 0, 2 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 0, 2 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_1X3_ImageView.setDisable( true );
            }
        } );

        cell_2X1_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                System.out.println( "Game With PCCc" );

                hodNumber = 0;
                System.out.println( "Х" );
                cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_2X1_ImageView.setDisable( true );
                userHod( 1, 0 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 1, 0 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_2X1_ImageView.setDisable( true );
            }
        } );

        cell_2X2_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_2X2_ImageView.setDisable( true );
                userHod( 1, 1 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 1, 1 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_2X2_ImageView.setDisable( true );
            }
        } );

        cell_2X3_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_2X3_ImageView.setDisable( true );
                userHod( 1, 2 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 1, 2 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_2X3_ImageView.setDisable( true );
            }
        } );

        cell_3X1_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_3X1_ImageView.setDisable( true );
                userHod( 2, 0 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 2, 0 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_3X1_ImageView.setDisable( true );
            }
        } );

        cell_3X2_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_3X2_ImageView.setDisable( true );
                userHod( 2, 1 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "PC hod y = " + pcHod[0] + " x = " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 2, 1 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_3X2_ImageView.setDisable( true );
            }
        } );

        cell_3X3_ImageView.setOnMouseClicked( mouseEvent -> {

            if (gameWithPC) {

                hodNumber = 0;
                System.out.println( "Х" );
                cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                cell_3X3_ImageView.setDisable( true );
                userHod( 2, 2 );

                if (!isStopGame) {
                    System.out.println( "О" );
                    short[] pcHod = players[1].xod( (short) -1, (short) -1 );
                    System.out.println( "x= " + pcHod[0] + " y= " + pcHod[1] );
                    switch (pcHod[0]) {
                        case 0: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_1X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 1: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_2X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            switch (pcHod[1]) {
                                case 0: {
                                    cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X1_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 1: {
                                    cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X2_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                                case 2: {
                                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                                    cell_3X3_ImageView.setDisable( true );
                                    isWin();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {

                if (hodNumber == 0) {
                    System.out.println( "Х" );
                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/X.png" ) );
                } else {
                    System.out.println( "О" );
                    cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/O.png" ) );
                }
                userHod( 2, 2 );

                if (players[hodNumber].isWin()) {
                    startAgain.setVisible( true );
                }

                cell_3X3_ImageView.setDisable( true );
            }
        } );

        startAgain.setOnAction( actionEvent -> {
            gameAreaPane.setVisible( false );
            startPane.setVisible( true );
            cell_1X1_ImageView.setDisable( false );
            cell_1X1_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_2X1_ImageView.setDisable( false );
            cell_2X1_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_3X1_ImageView.setDisable( false );
            cell_3X1_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_1X2_ImageView.setDisable( false );
            cell_1X2_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_2X2_ImageView.setDisable( false );
            cell_2X2_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_3X2_ImageView.setDisable( false );
            cell_3X2_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_1X3_ImageView.setDisable( false );
            cell_1X3_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_2X3_ImageView.setDisable( false );
            cell_2X3_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            cell_3X3_ImageView.setDisable( false );
            cell_3X3_ImageView.setImage( new Image( "javafxView/scr/imgs/empty.png" ) );
            hodNumber = 0;
        } );
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load( loader.getClassLoader().getResource( "javafxView/Miner.fxml" ) );
        stage.setTitle( "TicTacToe" );
        stage.setScene( new Scene( root ) );
        stage.setResizable( false );
        stage.setOnCloseRequest( windowEvent -> {
            stage.close();
            System.exit( 0 );
        } );
        stage.show();
    }
}
