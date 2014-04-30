package mpe.mirroir;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Verso extends Activity {
	//nom de parametre echanger entre les vue
	final String c_str_TextInv ="INVERSE";
	EditText v_str_RemplirText;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verso);
		
		//recupere boutton et text editable
		final Button bt_Recto = (Button)findViewById(R.id.Recto);
		v_str_RemplirText = (EditText)findViewById(R.id.TextVerso);
		
		//recupere element du changement d activite
		Intent v_itt_FromRecto = getIntent();
		
		if(v_itt_FromRecto!=null){
			
			String v_str_Temp;
			
			//recuper la valeur du parametre
			v_str_Temp = v_itt_FromRecto.getStringExtra(c_str_TextInv).toString();
			
			//inverse la chaine de caractere
			StringBuilder lettersBuff = new StringBuilder(v_str_Temp);
			v_str_Temp = lettersBuff.reverse().toString();
			
			//et l affiche
			v_str_RemplirText.setText(v_str_Temp);
		}
		
		bt_Recto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//creer element pour lancer l autre activite
				Intent itt = new Intent(Verso.this, Recto.class);
				//lui pass un parametre
				itt.putExtra(c_str_TextInv, v_str_RemplirText.getText().toString());
				//demarre l autre activite
				startActivity(itt);
				
			}
		});
		
	}

}
