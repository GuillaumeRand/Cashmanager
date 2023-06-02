package com.bill.cashmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bill.cashmanager.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GenerateQRCodeActivity extends AppCompatActivity {

    private TextView qrCodeTV;
    private ImageView qrCodeIV;
    private QRGEncoder qrgEncoder;
    private Bitmap bitmap;
    private String dataQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        qrCodeTV = findViewById(R.id.tv_GQRCode);

        getDataQRCode();

        String data = dataQRCode;

        qrCodeIV = findViewById(R.id.ivQRcode);

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int dimen = width<height ? width:height;
        dimen = dimen * 3/4;

        qrgEncoder = new QRGEncoder(data,null, QRGContents.Type.TEXT,dimen);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            qrCodeIV.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    private void getDataQRCode() {
        Intent intent = getIntent();
        dataQRCode = intent.getStringExtra("dataQRCode");
        qrCodeTV.setText(dataQRCode+"'s QR Code");
    }
}