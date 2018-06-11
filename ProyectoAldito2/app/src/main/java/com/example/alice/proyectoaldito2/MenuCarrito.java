package com.example.alice.proyectoaldito2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuCarrito extends AppCompatActivity {
    Button btnConectar, btnAutomatico, btnManual, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carrito);
        btnAutomatico = (Button)findViewById(R.id.btnAutomatico);
        btnManual = (Button)findViewById(R.id.btnManual);
        btnConectar = (Button)findViewById(R.id.btnConectar);
        btnSalir = (Button)findViewById(R.id.btnSalir);


        btnAutomatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irConectar = new Intent(MenuCarrito.this, Automatico.class);
                startActivity(irConectar);
            }
        });

        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irConectar = new Intent(MenuCarrito.this, Manual.class);
                startActivity(irConectar);
            }
        });

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irConectar = new Intent(MenuCarrito.this, Conectar.class);
                startActivity(irConectar);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Has salido de la aplicación",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
