package mpe.mirroir;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Recto extends Activity {
	
	final String c_str_TextInv ="INVERSE";
	EditText v_str_TextInv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recto);
		
		//recupere boutton et text editable
		v_str_TextInv = (EditText)findViewById(R.id.TextRecto);
		final Button bt_Verso = (Button)findViewById(R.id.Verso);
		
		//recupere le lancement de l activite par l autre
		Intent v_itt_FromVerso = getIntent();
		
		if(v_itt_FromVerso!=null){
			String v_str_Temp;
			
			//on recupere le parametre (dont le nom est dans c_str_TextInv) renvoyer
			v_str_Temp = v_itt_FromVerso.getStringExtra(c_str_TextInv);
			if(v_str_Temp!=null){
				
			   //inversion du text
			   StringBuilder v_sbd_Temp = new StringBuilder(v_str_Temp);
			   v_str_Temp = v_sbd_Temp.reverse().toString();
			   
			   //affichage du text
			   v_str_TextInv.setText(v_str_Temp);
			}
		}
				
		
		bt_Verso.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//creer element pour passer a une autre activite
				Intent itt = new Intent(Recto.this,Verso.class);
				//passe le text en parametre
				itt.putExtra(c_str_TextInv,v_str_TextInv.getText().toString());
				//lance l autre activite
				startActivity(itt);
				
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recto, menu);
		return true;
	}

	
	

}
