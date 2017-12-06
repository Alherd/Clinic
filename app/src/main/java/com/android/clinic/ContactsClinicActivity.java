package com.android.clinic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactsClinicActivity extends AppCompatActivity {
TextView mail;
Button webSiteButtom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_clinic);
        mail = (TextView)findViewById(R.id.email);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.example.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("mailto:")); // only phone apps should handle this
//                intent.putExtra(Intent.EXTRA_SUBJECT,
//                        getString(R.string.app_name));
//         intent.putExtra(Intent.EXTRA_TEXT, a);
//
//                Intent i = new Intent(ContactsClinicActivity.this, DatabaseSpecialistsActivity.class);
//                startActivity(i);
            }
        });

        webSiteButtom = (Button)findViewById(R.id.official_site);
        webSiteButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsClinicActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
