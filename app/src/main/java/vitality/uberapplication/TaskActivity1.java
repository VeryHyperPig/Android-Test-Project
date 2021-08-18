package vitality.uberapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TaskActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        EditText editText = findViewById(R.id.editText);
        TextView plusText = findViewById(R.id.plusText);
        Button plusButton = findViewById(R.id.plusButton);
        plusText.setMovementMethod(new ScrollingMovementMethod());

        plusButton.setOnClickListener(view -> {
            if (editText.getText().length() == 0) {
                editText.setHint("Вы не ввели текст!");
            } else {
                editText.setHint("Введите текст");
                plusText.append("- " + editText.getText().toString() + "\n");
                editText.setText(null);
            }

        });
    }
}