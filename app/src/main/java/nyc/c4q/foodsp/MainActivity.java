package nyc.c4q.foodsp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    private EditText foods;
    private Button enter;
    private Button guess;
    private SharedPreferences list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foods = (EditText) findViewById(R.id.foods);
        enter = (Button) findViewById(R.id.enter);
        guess = (Button) findViewById(R.id.guess);

        list = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = list.edit();
                editor.putString(foods.getText().toString(), foods.getText().toString());
                editor.commit();
                foods.setText("");
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Guess.class);
                startActivity(intent);
            }
        });
    }
}























