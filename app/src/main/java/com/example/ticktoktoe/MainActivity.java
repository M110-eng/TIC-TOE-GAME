package com.example.ticktoktoe;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, clickedbtn;
    TextView headerText;
    int player_o = 0;
    int player_x = 1;
    int activePlayer = player_o;
    int[] filledpos = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headerText = (TextView) findViewById(R.id.header_Text);

        btn0 = (Button) findViewById(R.id.btn8);
        btn1 = (Button) findViewById(R.id.btn0);
        btn2 = (Button) findViewById(R.id.btn1);
        btn3 = (Button) findViewById(R.id.btn2);
        btn4 = (Button) findViewById(R.id.btn3);
        btn5 = (Button) findViewById(R.id.btn4);
        btn6 = (Button) findViewById(R.id.btn5);
        btn7 = (Button) findViewById(R.id.btn6);
        btn8 = (Button) findViewById(R.id.btn7);

btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);



        btn0.setOnClickListener(this);
        btn1.setOnClickListener(MainActivity.this);

        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);


    }


    public void onClick(View v) {
        /*if (!isGameActive)
            return;*/


        Button clickedbtn = (Button) findViewById(v.getId());
        int clickedTag = Integer.parseInt(v.getTag().toString());
        if (filledpos[clickedTag] != -1) {
            return;
        }
        filledpos[clickedTag] = activePlayer;
        if (activePlayer == player_o) {
            clickedbtn.setText("ohgf");
            activePlayer = player_x;
            headerText.setText("x turn");
            clickedbtn.setBackground(getDrawable(android.R.color.holo_blue_bright));

        } else {
            clickedbtn.setText("x");
            activePlayer = player_o;
            headerText.setText("o turn");
            clickedbtn.setBackground(getDrawable(android.R.color.holo_blue_light));
        }
        checkforwin();
    }

    private void checkforwin() {
        int[][] winningpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < 8; i++) {
            int val0 = winningpos[i][0];
            int val1 = winningpos[i][1];
            int val2 = winningpos[i][2];
            if (filledpos[val0] == filledpos[val1] && filledpos[val1] == filledpos[val2]) {
                if (filledpos[val0] != -1) {
                    isGameActive = false;
                    if (filledpos[val0] == player_o) {//headerText.setText("o is winner");
                        //showDialog("o is winner");
                        Toast.makeText(MainActivity.this, "well played", Toast.LENGTH_LONG).show();

                    }
                    else {    //headerText.setText("x is winner");
                        showDialog("x is winner");
                    }
                }

            }
        }
    }

    private void showDialog(String winnerText) {

        new AlertDialog.Builder(this)
                .setTitle(winnerText)
                .setPositiveButton("Restart game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame();
                    }
                }).show();

    }


    public void restartGame()
    {
        activePlayer=player_o;
        filledpos =new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
     // int[]  filledpos={-1,-1,-1,-1,-1,-1,-1,-1,-1};
        headerText.setText("0 turn");
        btn0.setText("ews");
        btn1.setText("");
        btn2.setText("");
        btn3 .setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn0.setBackground(getDrawable(android.R.color.darker_gray));
        btn1.setBackground(getDrawable(android.R.color.darker_gray));
        btn2.setBackground(getDrawable(android.R.color.darker_gray));
        btn3.setBackground(getDrawable(android.R.color.darker_gray));
        btn4.setBackground(getDrawable(android.R.color.darker_gray));
        btn5.setBackground(getDrawable(android.R.color.darker_gray));
        btn6.setBackground(getDrawable(android.R.color.darker_gray));
        btn7.setBackground(getDrawable(android.R.color.darker_gray));
        btn8.setBackground(getDrawable(android.R.color.darker_gray));
        isGameActive =true;






    }
}



