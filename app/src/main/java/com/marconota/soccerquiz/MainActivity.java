package com.marconota.soccerquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method to calculate quiz score
    public int calculateScore() {
        int quizScore = 0;
        //Provides values for QUESTION 1(radio button)
        int question1 = 0;
        RadioButton italyRadioButton = (RadioButton) findViewById(R.id.italy);
        boolean italyRadioButtonIsChecked = italyRadioButton.isChecked();
        RadioButton spainRadioButton = (RadioButton) findViewById(R.id.spain);
        boolean spainRadioButtonIsChecked = spainRadioButton.isChecked();
        RadioButton usaRadioButton = (RadioButton) findViewById(R.id.usa);
        boolean usaRadioButtonIsChecked = usaRadioButton.isChecked();

        // Check which radio button was clicked
        if (italyRadioButtonIsChecked) {
            question1 = 1;
        } else if (spainRadioButtonIsChecked) {
            question1 = 0;
        } else if (usaRadioButtonIsChecked) {
            question1 = 0;
        }

        //Provides values for QUESTION2 (edit text)

        EditText editTextPlayerQuestion2 = (EditText) findViewById(R.id.question2_edittext);
        String question2TextValue = editTextPlayerQuestion2.getText().toString();
        question2TextValue = question2TextValue.trim();
        int question2 = 0;
        if (question2TextValue.equalsIgnoreCase("Messi")) {
            question2 = 1;
        } else {
            question2 = 0;
        }

        //Provides values for QUESTION3 (radio button)
        int question3 = 0;
        RadioButton oneRadioButton = (RadioButton) findViewById(R.id.one);
        boolean oneRadioButtonIsChecked = oneRadioButton.isChecked();
        RadioButton twoRadioButton = (RadioButton) findViewById(R.id.two);
        boolean twoRadioButtonIsChecked = twoRadioButton.isChecked();
        RadioButton threeRadioButton = (RadioButton) findViewById(R.id.three);
        boolean threeRadioButtonIsChecked = threeRadioButton.isChecked();

        // Checks which radio button was clicked
        if (oneRadioButtonIsChecked) {
            question3 = 1;
        } else if (twoRadioButtonIsChecked) {
            question3 = 0;
        } else if (threeRadioButtonIsChecked) {
            question3 = 0;
        }

        //Provides values for QUESTION 4 (checkbox)

        int question4 = 0;
        CheckBox robertocarlos_checkbox = (CheckBox) findViewById(R.id.robertocarlos);
        boolean robertocarlosValue = robertocarlos_checkbox.isChecked();
        CheckBox ronaldinho_checkbox = (CheckBox) findViewById(R.id.ronaldinho);
        boolean ronaldinhoValue = ronaldinho_checkbox.isChecked();
        CheckBox kaka_checkbox = (CheckBox) findViewById(R.id.kaka);
        boolean kakaValue = kaka_checkbox.isChecked();
        if (robertocarlosValue && !ronaldinhoValue == false && !kakaValue == false) {
            question4 = 1;
        } else {
            question4 = 0;
        }

        //Provides values for QUESTION 5 (radio button)
        int question5 = 0;
        RadioButton brazilRadioButton = (RadioButton) findViewById(R.id.brazil);
        boolean brazilRadioButtonIsChecked = brazilRadioButton.isChecked();
        RadioButton englandRadioButton = (RadioButton) findViewById(R.id.england);
        boolean englandRadioButtonIsChecked = englandRadioButton.isChecked();
        RadioButton portugalRadioButton = (RadioButton) findViewById(R.id.portugal);
        boolean portugalRadioButtonIsChecked = portugalRadioButton.isChecked();

        // Checks which radio button was clicked
        if (brazilRadioButtonIsChecked) {
            question5 = 0;
        } else if (englandRadioButtonIsChecked) {
            question5 = 0;
        } else if (portugalRadioButtonIsChecked) {
            question5 = 1;
        }

        // Calculates quiz score
        quizScore = question1 + question2 + question3 + question4 + question5;
        return quizScore;
    }

    //Method to display a toast message with score and ability message, when submit button is clicked
    public void displayScore(View view) {
        String abilityMessage = "";
        int acceptedRepliesFinalValue = calculateScore();
        if (acceptedRepliesFinalValue == 0) {
            abilityMessage = getString(R.string.improve_knowledge_toast);
        } else if (acceptedRepliesFinalValue <= 2) {
            abilityMessage = getString(R.string.something_knowledge_toast);
        } else if (acceptedRepliesFinalValue <= 4) {
            abilityMessage = getString(R.string.pretty_good_knowledge_toast);
        } else if (acceptedRepliesFinalValue <= 5) {
            abilityMessage = getString(R.string.expert_knowledge_toast);
        }
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.accepted_replies_toast) + acceptedRepliesFinalValue + getString(R.string.of_5_toast);
        text = text + "\n" + abilityMessage;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}


