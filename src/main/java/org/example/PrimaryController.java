package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

import static org.example.App.scene;

public class PrimaryController {


    //btn+nº -> game buttons, btnStart start the game button
    @FXML private Button btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22, btnStart;

    //theme -> change to night mode and back
    @FXML private MenuItem theme;

    //pvp -> select player versus player mode, pve -> select player versus computed mode, eve -> select computer versus computer mode
    @FXML private RadioButton pvp, pve, eve;

    //shows announcements
    @FXML private Label text;

    int player = 1;
    boolean playing = false;
    int grid[][] = new int[3][3];



    @FXML
    private void changeTheme() throws IOException {

            String mode;
            scene.getStylesheets().clear();
            if(theme.getText().equals("Change theme to dark")) {
                scene.getStylesheets().add("night.css");
                mode = "Change theme to light";
            }else {
                scene.getStylesheets().clear();
                mode = "Change theme to dark";
            }
            theme.setText(mode);

    }

    @FXML
    private void click(ActionEvent event) throws IOException {

        Button btn = (Button) event.getSource();
        int[] place = {0,0};

        if(playing == true) {

            place = getingCoord(btn.getId());

            if (grid[place[0]][place[1]] == 0) {

                grid[place[0]][place[1]] = player;

                text.setText("");

                if (player == 1) {

                    btn.setText("X");

                } else if (player == 2) {

                    btn.setText("O");

                }

                changeTurn();

            } else {
                text.setText("Already taken!");
            }

        }

    }

    private void resetGameButtons(){

        btn00.setText("");btn01.setText("");btn02.setText("");
        btn10.setText("");btn11.setText("");btn12.setText("");
        btn20.setText("");btn21.setText("");btn22.setText("");

    }

    private int[] getingCoord(String btnName){

        int[] coord = {0,0};

        if (btnName.equals("btn00")){
            coord[0]=0;
            coord[1]=0;
        } else if (btnName.equals("btn01")){
            coord[0]=0;
            coord[1]=1;
        } else if (btnName.equals("btn02")){
            coord[0]=0;
            coord[1]=2;
        } else if (btnName.equals("btn10")){
            coord[0]=1;
            coord[1]=0;
        } else if (btnName.equals("btn11")){
            coord[0]=1;
            coord[1]=1;
        } else if (btnName.equals("btn12")){
            coord[0]=1;
            coord[1]=2;
        } else if (btnName.equals("btn20")){
            coord[0]=2;
            coord[1]=0;
        } else if (btnName.equals("btn21")){
            coord[0]=2;
            coord[1]=1;
        } else if (btnName.equals("btn22")){
            coord[0]=2;
            coord[1]=2;
        }

        return coord;

    }

    private void changeTurn(){

        if (player == 1){
            player = 2;
        } else if (player == 2){
            player = 1;
        }

    }

    private int announceWinner(int[][] grid) {
        int winner = 0;

        if (grid [0][0] != 0 && grid [0][1] == grid [0][0] && grid [0][2] == grid [0][0]){

        } else if(grid [1][0] != 0 && grid [1][1] == grid [1][0] && grid [1][2] == grid [1][0]){

        }else if(grid [2][0] != 0 && grid [2][1] == grid [2][0] && grid [2][2] == grid [2][0]){

        }else if(grid [0][0] != 0 && grid [1][0] == grid [0][0] && grid [2][0] == grid [0][0]){

        }else if(grid [0][1] != 0 && grid [1][1] == grid [0][0] && grid [2][1] == grid [0][1]){

        }else if(grid [0][2] != 0 && grid [1][2] == grid [0][2] && grid [2][2] == grid [0][2]){

        }else if(grid [0][0] != 0 && grid [1][1] == grid [0][0] && grid [2][2] == grid [0][0]){

        }else if(grid [0][2] != 0 && grid [1][1] == grid [0][2] && grid [2][0] == grid [0][2]){

        }
        return winner;
    }

    @FXML
    private void selectPvP() throws IOException {

    }

    @FXML
    private void selectPvE() throws IOException {

    }

    @FXML
    private void selectEvE() throws IOException {

    }

    @FXML
    private void clickStart() throws IOException {
        resetGameButtons();
        playing = true;
    }

}
