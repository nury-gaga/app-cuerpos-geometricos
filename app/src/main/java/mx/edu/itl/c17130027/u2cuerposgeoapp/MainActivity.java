/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*            App que muestra los cálculos de las prismas y el cilindro.
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Guadalupe Nury Galván García     17130027
:*  Fecha       : 24/oct/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Este Main Activity, contiene los botones de las 2 prismas, el cilindro y
                   Acerca de y los redirecciona a sus Activitys correspondientes.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  26/oct/2020 Nury Galván       Documentar código y agregar reglas de calidad.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130027.u2cuerposgeoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//--------------------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//--------------------------------------------------------------------------------------------------
//Mostramos el Activity del Cilindro
    public void btnCilindroClick ( View v){
        Intent intent = new Intent( this, CilindroActivity.class);
        startActivity( intent );
    }
//--------------------------------------------------------------------------------------------------
//Mostramos el Activity del prisma Triangulo rectangulo
    public void btnPrismaTriangClick ( View v){
        Intent intent = new Intent( this, PrismaTriangActivity.class);
        startActivity( intent );
    }
//--------------------------------------------------------------------------------------------------
//Mostramos el Activity del prisma Rectangular
    public void btnPrismaRectClick ( View v){
        Intent intent = new Intent( this, PrismaRectActivity.class);
        startActivity( intent );
    }
//--------------------------------------------------------------------------------------------------
    //Mostramos el AcercaDeActivity
    public void btnAcercaDeClick ( View v){
        Intent intent = new Intent( this, AcercaDeActivity.class);
        startActivity( intent );
    }
}
//--------------------------------------------------------------------------------------------------