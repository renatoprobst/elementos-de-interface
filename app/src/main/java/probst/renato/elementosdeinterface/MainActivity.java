package probst.renato.elementosdeinterface;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private ImageView imageView;
    private ImageButton imageButton;
    private SeekBar seekBar;
    private RatingBar ratingBar;
    private CheckBox checkBox;
    private RadioButton radioButton;
    private Switch switch1;
    private ToggleButton toggleButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        switch1 = (Switch) findViewById(R.id.switch1);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        spinner = (Spinner) findViewById(R.id.spinner);


        setButtonBehavior();
        setTextViewBehavior();
        setEditTextBehavior();
        setImageViewBehavior();
        setImageButtonBehavior();
        setSeekBarBehavior();
        setRatingBarBehavior();
        setCheckBoxBehavior();
        setRadioButtonBehavior();
        setSwitchBehavior();
        setToggleButtonBehavior();
        setSpinnerBehavior();
    }

    private void setSpinnerBehavior() {
        final List<String> categories = new ArrayList<>();
        categories.add("Carros");
        categories.add("Motos");
        categories.add("Acessórios");

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories.get(position);
                Toast.makeText(MainActivity.this, "A categoria " + selectedCategory + " foi selecionada.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner.setSelection(2);

    }

    private void setToggleButtonBehavior() {
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "ToggleButton selecionada: " + (isChecked ? "Sim" : "Não"), Toast.LENGTH_LONG).show();
            }
        });

        //toggleButton.setChecked(true);
    }

    private void setSwitchBehavior() {
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Switch selecionada: " + (isChecked ? "Sim" : "Não"), Toast.LENGTH_LONG).show();
            }
        });
        //switch1.setChecked(true);
    }

    private void setRadioButtonBehavior() {
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "RadioButton selecionada: " + (isChecked ? "Sim" : "Não"), Toast.LENGTH_LONG).show();
            }
        });

        //radioButton.setChecked(true);
    }

    private void setCheckBoxBehavior() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Checkbox selecionada: " + (isChecked ? "Sim" : "Não"), Toast.LENGTH_LONG).show();
            }
        });

        //checkBox.setChecked(true);
    }

    private void setRatingBarBehavior() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Rating: " + rating, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setSeekBarBehavior() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Progresso: " + progress, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setImageButtonBehavior() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setImageResource(R.drawable.gt);
            }
        });
    }

    private void setImageViewBehavior() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.gt);
            }
        });
    }

    private void setTextViewBehavior() {
        textView.setText("Mudando texto da textView");
        textView.setTextColor(Color.parseColor("#C00000"));
    }

    private void setEditTextBehavior() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.getText().toString() != null && editText.getText().toString().length() > 10
                        && editText.getText().toString().length() < 15) {
                    Toast.makeText(MainActivity.this, editText.getText().toString() + "", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setButtonBehavior() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Botão apertado");
                button.setTextColor(Color.parseColor("#C00000"));
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "O botão foi segurado.", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
