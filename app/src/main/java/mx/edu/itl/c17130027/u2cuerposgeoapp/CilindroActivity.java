/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                   Activity que muestra los datos del Cilindro.
:*
:*  Archivo     : PrismaTriangActivity.java
:*  Autor       : Guadalupe Nury Galván García     17130027
:*  Fecha       : 24/oct/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Este Activity, contiene los cálculos necesarios para las áreas, volumen y
                  perímetro del cilindro y muestra los resultados en un AlertDialog.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  26/oct/2020 Nury Galván       Documentar código y agregar reglas de calidad.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130027.u2cuerposgeoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
//--------------------------------------------------------------------------------------------------

public class CilindroActivity extends AppCompatActivity {

    private EditText edtRadio;
    private EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        //Obtener las referencias a los campos del peso y la estatura
        edtRadio = findViewById ( R.id.edtRadio);
        edtAltura = findViewById ( R.id.edtAltura);
    }
//--------------------------------------------------------------------------------------------------

    public void btnCalClick (View v){
        float radio, altura;
        //Validamos si se pude convertir el radio a un valor numérico
        try {
            radio = Float.parseFloat(edtRadio.getText().toString());
        }catch ( NumberFormatException ex ) {
            Toast.makeText( this, "Debe capturar un valor numérico para el radio", Toast.LENGTH_SHORT)
                    .show();
            edtRadio.requestFocus ();
            return;
        }


        //Validamos si se pude convertir la altura a un valor numérico
        try {
            altura = Float.parseFloat(edtAltura.getText().toString());
        }catch (NumberFormatException ex){
            Toast.makeText( this, "Debe capturar un valor numérico para la altura", Toast.LENGTH_SHORT)
                    .show();
            edtAltura.requestFocus ();
            return;
        }
//--------------------------------------------------------------------------------------------------

        //formateamos el resultado con tres decimales
        DecimalFormat decimalFormat = new DecimalFormat ( "#####.###" );

        //Realizamos el calculo para el cilindro
        double aBase = Math.PI * Math.pow ( Double.parseDouble ( edtRadio.getText ().toString () ), 2 );
        String aBaseFormat =  decimalFormat.format ( aBase );

        double pBase = 2 * Math.PI * Double.parseDouble ( edtRadio.getText ().toString () );
        String pBaseFormat = decimalFormat.format( pBase );

        double aLat = pBase * Double.parseDouble ( edtAltura.getText ().toString () );
        String aLatFormat = decimalFormat.format ( aLat );

        double aTotal = 2 * aBase + aLat;
        String aTotalFormat = decimalFormat.format ( aTotal );

        double vol = aBase * Double.parseDouble ( edtAltura.getText ().toString () );
        String volFormat = decimalFormat.format ( vol );
//--------------------------------------------------------------------------------------------------
        //Creamos el AlertDialog para mostrar los resultados del cilindro
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Resultados" )
                .setMessage ("Area de la base: " + aBaseFormat + "\n"
                        + "Perimetro de la base: " + pBaseFormat + "\n"
                        + "Area lateral: " + aLatFormat + "\n"
                        + "Area total: " +  aTotalFormat + "\n"
                        + "Volumen: " + volFormat )
                .setPositiveButton ( "Aceptar", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick ( DialogInterface dialogInterface, int i ) {
                        dialogInterface.dismiss();
                    }
                }).create ().show ();



    }
}
//--------------------------------------------------------------------------------------------------