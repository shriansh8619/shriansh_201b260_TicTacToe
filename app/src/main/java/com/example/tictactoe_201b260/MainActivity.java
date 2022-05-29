package com.example.tictactoe_201b260;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView3;
//    Button button;
//    TextView textView;
//    GridLayout gridLayout;

    // 0: cross, 1: ring
    int activePlay = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2 , 2, 2};
    int[][] positions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {3, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}};
    boolean gameActive = true;

    public void tap(View view) {

        textView3 = findViewById(R.id.textView3);

        textView3.setVisibility(View.INVISIBLE);

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlay;

            if (activePlay == 0) {
                counter.setImageResource(R.drawable.coolcross);
                activePlay = 1;
            } else {
                counter.setImageResource(R.drawable.coolring);
                activePlay = 0;
            }

            for (int[] position : positions) {
                if (gameState[position[0]] == gameState[position[1]] && gameState[position[1]] == gameState[position[2]] && gameState[position[0]] != 2) {

                    String winner = " ";

                    gameActive = false;
                    if (activePlay == 1) {
                        winner = "Team Cross";
                    } else {
                        winner = "Team Circle";
                    }

                    Button button = (Button) findViewById(R.id.button);
                    // button = findViewById(R.id.button);
                    TextView textView = (TextView) findViewById(R.id.textView);
                    // textView = findViewById(R.id.textView);

                    textView.setText(String.format("%s Win!", winner));

                    button.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void again(View view)
    {
        Button button = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        // GridLayout gridLayout = (GridLayout) findViewById(R.id.gridOut);
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);

        textView3.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);


        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        Arrays.fill(gameState, 2);
        activePlay = 0;
        gameActive = true;
    }
    }
}