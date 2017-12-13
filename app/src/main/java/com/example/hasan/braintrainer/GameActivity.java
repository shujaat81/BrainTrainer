package com.example.hasan.braintrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private TextView operation;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Random random;
    private TextView score;
    private TextView checker;
    private TextView totalScore;
    private TextView timer;
    private Button playAgain;
    int a ;
    int b;
    int arrayValuesRandom;
    int initialScore=0;


    public void playAgainM(){

        timer();
        reload();
        playAgain.setVisibility(View.INVISIBLE);
        totalScore.setText("0");
        score.setText("0/0");
    }

    public void timer (){

        new CountDownTimer(30000,1000){


            @Override
            public void onTick(long l) {

                int time = (int) l/1000;
                timer.setText(Integer.toString(time)+ "s");
            }

            @Override
            public void onFinish() {

                totalScore.setVisibility(View.VISIBLE);
                totalScore.setText("Your Total Score is "+ initialScore);
                playAgain.setVisibility(View.VISIBLE);

            }
        }.start();
    }
    public void calculate(View view){

        if (view.getTag().toString().equals(Integer.toString(arrayValuesRandom))){

            checker.setText("Correct!");
            checker.setVisibility(View.VISIBLE);
            initialScore++;
            score.setText(Integer.toString(initialScore));
            reload();
        }else{

            checker.setText("Incorrect");
            checker.setVisibility(View.VISIBLE);
            reload();
        }
    }

    public void reload (){

        ArrayList<Integer> arrayValues = new ArrayList<Integer>();
        random = new Random();


        a= random.nextInt(20);
        b= random.nextInt(20);

        operation.setText(Integer.toString(a) +"+ "+ Integer.toString(b));

        arrayValuesRandom = random.nextInt(4);
        for (int i=0; i<4; i++){

            if (i==arrayValuesRandom){
                arrayValues.add(a+b);
            }else {

                int inCorrectValues = random.nextInt(41);
                while (inCorrectValues==a+b){
                    inCorrectValues = random.nextInt(41);
                }

                arrayValues.add(inCorrectValues);
            }
        }

        button1.setText(Integer.toString(arrayValues.get(0)));
        button2.setText(Integer.toString(arrayValues.get(1)));
        button3.setText(Integer.toString(arrayValues.get(2)));
        button4.setText(Integer.toString(arrayValues.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        operation = (TextView)findViewById(R.id.operationID);
        checker =(TextView)findViewById(R.id.checkerID);
        score = (TextView)findViewById(R.id.scoreID);
        timer =(TextView)findViewById(R.id.timeID);
        totalScore=(TextView)findViewById(R.id.totalScoreID);
        button1 = (Button)findViewById(R.id.button1ID);
        button2 = (Button)findViewById(R.id.button2ID);
        button3 = (Button)findViewById(R.id.button3ID);
        button4 = (Button)findViewById(R.id.button4ID);
        playAgain=(Button)findViewById(R.id.playAgainID);



        timer();
        reload();

    }
}
