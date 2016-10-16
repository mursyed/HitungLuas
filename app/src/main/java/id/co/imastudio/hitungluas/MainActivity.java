package id.co.imastudio.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;
    private String panjang, lebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi");

        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtLebar.setError(null);
                edtPanjang.setError(null);
                txtLuas.setText("");

                getValueOfField();

                char[] arrayPanjang = panjang.toCharArray();
                char[] arrayLebar = lebar.toCharArray();

                if (panjang == "" || panjang == ".") {
                    edtPanjang.setError("This field for length");
                    edtPanjang.requestFocus();
                } else if (lebar == "" || lebar == ".") {
                    edtLebar.setError("This field for width");
                    edtLebar.requestFocus();
                } else {
                    if (arrayPanjang[0] == '.') {
                        edtPanjang.setError("This field can't start with dot");
                        edtPanjang.requestFocus();
                    } else if (arrayLebar[0] == '.') {
                        edtLebar.setError("This field can't start with dot");
                        edtLebar.requestFocus();
                    } else {
                        double p = Double.parseDouble(panjang);
                        double l = Double.parseDouble(lebar);
                        if (p == 0.0) {
                            edtPanjang.setError("This field required not zero");
                            edtPanjang.requestFocus();
                        } else if (l == 0.0) {
                            edtLebar.setError("This field required not zero");
                            edtLebar.requestFocus();
                        } else {
                            double luas = p * l;
                            txtLuas.setText("Luas : " + luas);
                        }
                    }
                }
            }
        });

    }

    public void getValueOfField() {
        panjang = edtPanjang.getText().toString().trim();
        lebar = edtLebar.getText().toString().trim();
    }
}
