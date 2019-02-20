package com.example.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void setContentsOfTextView(int id, String newContents){
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }
    private String getInputOfTextField(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }
    private String getItemSelected(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    public void startGame(View view){
        String nameX = getInputOfTextField(R.id.inputNameX);
        String nameO = getInputOfTextField(R.id.inputNameO);
        String first = getItemSelected(R.id.spinnerFirst);

        game = new Game(nameX, nameO, first);

        setContentsOfTextView(R.id.labelOutcome, game.getGame());
    }
    public void play(View view){
        String row = getItemSelected(R.id.spinnerRow);
        String col = getItemSelected(R.id.spinnerColumn);

        game.setRC(row, col);

        setContentsOfTextView(R.id.labelOutcome, game.getPlay());
    }
}
