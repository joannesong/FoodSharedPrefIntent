package nyc.c4q.foodsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static nyc.c4q.foodsp.MainActivity.SHARED_PREFS_KEY;

public class Guess extends AppCompatActivity {
    private EditText guessEdit;
    private Button check;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        guessEdit = (EditText) findViewById(R.id.friendEdit);
        check = (Button) findViewById(R.id.check);
        preferences = (SharedPreferences) getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preferences.contains(guessEdit.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "nice", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
