package csc310.dungeondivers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TobiasMessage extends AppCompatActivity {

    EditText editText;
    Button sendButton;
    TextView editableTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tobias_message);


        editText = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.SendButton);
        editableTextView = (TextView) findViewById(R.id.editableTextView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editableTextView.append(editText.getText().toString() + "\n");
                editText.setText("");
            }
        });


    }
}
