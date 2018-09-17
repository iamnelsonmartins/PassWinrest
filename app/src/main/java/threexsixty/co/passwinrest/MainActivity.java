package threexsixty.co.passwinrest;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public void btnClick(View view) {

        EditText dataValue = findViewById(R.id.dataInput);
        String dataValueString = dataValue.getText().toString();
        EditText horaValue = findViewById(R.id.horaInput);
        String horaValueString = horaValue.getText().toString();
        EditText seqValue = findViewById(R.id.seqInput);
        String seqValueString = seqValue.getText().toString();

        if (dataValue.length() < 1) {
            Toast.makeText(this, "Verifique a Data", Toast.LENGTH_LONG).show();
        } else if (horaValueString.length() < 1) {
            Toast.makeText(this, "Verifique a Hora", Toast.LENGTH_LONG).show();
        } else if (seqValueString.length() < 1) {
            Toast.makeText(this, "Verifique a sequencia", Toast.LENGTH_LONG).show();
        } else {
            final String sumValues = dataValueString + horaValueString + seqValueString;
            if (sumValues.length() < 19) {
                Toast.makeText(this, "Verifique os valores", Toast.LENGTH_LONG).show();
            } else {
                final char[] pw = sumValues.toCharArray();

                RadioButton rbs = findViewById(R.id.rbs);
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                mBuilder.setView(dialogView);
                final AlertDialog dialog = mBuilder.create();
                TextView dialogMsg = dialogView.findViewById(R.id.dialogMsg);
                Button closeDiag = dialogView.findViewById(R.id.dialogClose);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();

                closeDiag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                if (rbs.isChecked()) {
                    dialogMsg.setText(pw[0] + "" +
                            pw[12] + "" +
                            pw[14] + "" +
                            pw[1] + "" +
                            pw[13] + "" +
                            pw[18] + "" +
                            pw[15]);
                } else {
                    dialogMsg.setText(pw[0] + "" +
                            pw[12] + "" +
                            pw[14] + "" +
                            pw[1] + "" +
                            pw[13] + "" +
                            pw[18]);
                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
