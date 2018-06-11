package com.example.alice.proyectoaldito2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Conectar extends AppCompatActivity {

    Button btnOn, btnOff, btnDisc, btnList;
    BluetoothAdapter bluetoothAdapter;
    ListView list;

    private static final int REQUEST_ENABLE = 0;
    private static final int REQUEST_DISCOVERABLE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectar);

        btnOn = (Button) findViewById(R.id.btnOn);
        btnOff = (Button) findViewById(R.id.btnOff);
        btnDisc = (Button) findViewById(R.id.btnDisc);
        btnList = (Button) findViewById(R.id.btnListar);
        list = (ListView) findViewById(R.id.lvListar);
        //Lo que hacemos en esta variable es obtener el bluetooth de nuestro teléfono
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if(bluetoothAdapter == null){
            Toast.makeText(this, "No tienes bluetooth man", Toast.LENGTH_SHORT).show();
            //Termina la aplicación
            finish();
        }

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE);
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            //Apagamos el bluetooth
            public void onClick(View v) {
                bluetoothAdapter.disable();
            }
        });


        //Al iniciar Discoverty, lo que estamos haciendo es comenzar a detectar los dispositivos que están a nuestro alrededor.
        btnDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Buscamos los disitivos
                if(!bluetoothAdapter.isDiscovering()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVERABLE);

                }

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vamos a crear un arrayList de todos los dispositivos que existen.
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                ArrayList<String> devices = new ArrayList<>();

                for(BluetoothDevice bt : pairedDevices){
                    devices.add(bt.getName());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(Conectar.this, android.R.layout.simple_list_item_1, devices);
                list.setAdapter(arrayAdapter);
            }
        });


    }
}
