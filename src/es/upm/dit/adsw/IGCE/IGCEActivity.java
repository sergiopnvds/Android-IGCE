

package es.upm.dit.adsw.IGCE;

import es.upm.dit.adsw.IGCE.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class IGCEActivity extends Activity {
	
	private EditText et1,et2,et3,et4;
	private TextView tv1,tv2,tv3;
	private RadioButton rb1,rb2;
	private DatePicker dp;
	private int year;
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1=(EditText)findViewById(R.id.cuadroAltura);
    	et2=(EditText)findViewById(R.id.cuadroPeso);
    	tv1=(TextView)findViewById(R.id.muestraMASA);
    	tv2=(TextView)findViewById(R.id.muestraSalud);
    	tv3=(TextView)findViewById(R.id.muestraIGMC);
    	rb1=(RadioButton)findViewById(R.id.hombre);
    	rb2=(RadioButton)findViewById(R.id.mujer);
    	dp= (DatePicker) findViewById(R.id.fecha);
    	
    	
    }
    public void muestraIMC(View v){
    	double altura=0;
    	double peso=0;
    	try{
    	String n1=et1.getText().toString();
    	altura=Double.parseDouble(n1);
    	}
    	catch(Exception e){
    		Toast toast=Toast.makeText( this,"Campo erroneo",Toast.LENGTH_SHORT);
    		toast.show();
    	}
    	
    	try{
    	String n2=et2.getText().toString();
    	peso=Double.parseDouble(n2);
    	}
    	catch(Exception e){
    		Toast toast=Toast.makeText( this,"Campo erroneo",Toast.LENGTH_SHORT);
    		toast.show();
		}
    	Log.e("imc", "comienza el calculo del imc:");
    	double imc;
    	imc=10000*(peso)/(altura*altura);
    	int numero = (int)(imc * 100); 
    	imc = numero/100.0;
    	String s1=Double.toString(imc);
    	tv1.setText(s1);
    	
    	Log.e("la icm es", s1);
    	if (imc<18.5){ 
    		if (imc<16) tv2.setText("Infrapeso con Delgadez severa");
    			else	if (imc>16 && imc<17) tv2.setText("Infrapeso con Delgadez moderada");
    			else 	if (imc>17 && imc<18.5) tv2.setText("Infrapeso con Delgadez no muy pronunciada");
    	}
    	else{if(imc<24.99 && imc>18.5) tv2.setText("Normal");
    			
    		else if (imc>25 && imc<29.99) tv2.setText("Sobrepeso con estado de Preobeso");
    			
    			else if (imc>30.0){
    			
    				if (imc<34.99 && imc>30.0) tv2.setText("Obeso tipo I");
    				else if (imc<39.99 && imc>35) tv2.setText("Obeso tipo II");
    				else if (imc>40) tv2.setText("Obeso tipo III");
    			    	
    			}
    			
    	}	
    	
    }
    public void muestraIGCE(View v){

    	double igce;
    	double imc;
    	double altura=0;
    	double peso=0;
    	
    	try{
    		String n1=et1.getText().toString();
    		altura=Double.parseDouble(n1);
    	}	
    	catch(Exception e){
    			Toast toast=Toast.makeText( this,"Campo erroneo",Toast.LENGTH_SHORT);
    			toast.show();
    	}
    	
    	try{
    		String n2=et2.getText().toString();
    		peso=Double.parseDouble(n2);
    	}
    	catch(Exception e){
    		Toast toast=Toast.makeText( this,"Campo erroneo",Toast.LENGTH_SHORT);
    		toast.show();
		}
    	  	
    	imc=10000*(peso)/(altura*altura);
    	int numero = (int)(imc * 100); 
    	imc = numero/100.0;
    	String s1=Double.toString(imc);
    	tv1.setText(s1);
    	
    	int ano = dp.getYear();
    	int edad = 2012-ano;
    	if (ano>2012){
    		Toast toast=Toast.makeText( getApplicationContext(),"Edad erronea",Toast.LENGTH_SHORT);
    		toast.show();	
    	}
    	
    	if (edad<17){
    		if(rb1.isChecked()==true){
    			int dato=1;
    			igce=(1.51*imc)-(0.7*edad)-(3.6*dato)+1.4;
    			int datillo = (int)(igce * 100); 
    			igce = datillo/100.0;
    			String s2=Double.toString(igce);
    			tv3.setText(s2);
    		}
    		if(rb2.isChecked()==true){
    			int dato=0;
    			igce=(1.51*imc)-(0.7*edad)-(3.6*dato)+1.4;
    			int datillo = (int)(igce * 100); 
    			igce = datillo/100.0;
    			String s3=Double.toString(igce);
    			tv3.setText(s3);
    		}
    	}
    	else{
    		if(rb1.isChecked()==true){
    			int dato=1;
    			igce=(1.20*imc)+(0.23*edad)-(10.8*dato)-5.4;
        		int datillo = (int)(igce * 100); 
            	igce = datillo/100.0;
            	String s4=Double.toString(igce);
            	tv3.setText(s4);
    		}
    		if(rb2.isChecked()==true){
    			int dato=0;
    			igce=(1.20*imc)+(0.23*edad)-(10.8*dato)-5.4;
    			int datillo = (int)(igce * 100); 
    			igce = datillo/100.0;
    			String s5=Double.toString(igce);
    			tv3.setText(s5);
    		}
    	}
    }
}
