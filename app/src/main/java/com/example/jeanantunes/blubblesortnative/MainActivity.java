package com.example.jeanantunes.blubblesortnative;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    long start = System.currentTimeMillis();
    private StringBuilder orderArray = new StringBuilder();
    private int size_array = 100000;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);

        int array[];
        array = geraVector(size_array);
        bubbleSort(array);

        for(int i = 0; i < size_array; i++){
            orderArray.append(array[i] + ",");
        }
        textView.setText(orderArray);
        long time = System.currentTimeMillis() - start;
        showToast(time);
        //Toast.makeText(getBaseContext(), ""+time/1000.0, Toast.LENGTH_LONG).show();
    }

    public void showToast(long time) {
        int duration = 40000;
        toast = Toast.makeText(this,""+time/1000.0, Toast.LENGTH_LONG);
        CountDownTimer countDownTimer;
        countDownTimer = new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        };
        toast.show();
        countDownTimer.start();

    }
    public int[] geraVector(int size) {
        int vector[] = new int[size];
        int j=0;
        for(int i = size; i > 0; i--){
            vector[j] = i;
            j++;
        }
        return vector;
    }
    public static void bubbleSort(int[] vetor) {
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }
}

