package id.co.imastudio.doahariananak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import id.co.imastudio.mengenalprofesi.R;

public class MenuActivity extends AppCompatActivity {

    GridView gridMenu;
    int[] listMenu = {
            R.drawable.menu001,
            R.drawable.menu002,
            R.drawable.menu003,
            R.drawable.menu004,
            R.drawable.menu005,
            R.drawable.menu006,
            R.drawable.menu007,
            R.drawable.menu008,
            R.drawable.menu009,
            R.drawable.menu010
    };

    String[] listu = {
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",

    };
    private ImageView ivback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridMenu = (GridView) findViewById(R.id.gridView);
        MenuAdapter adapter = new id.co.imastudio.doahariananak.MenuAdapter(MenuActivity.this, listMenu, listu );
        gridMenu.setAdapter(adapter);
        gridMenu.setNumColumns(5);

        gridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pindah = new Intent(MenuActivity.this, PlayActivity.class);
                pindah.putExtra("posisi", position);
                startActivity(pindah);
                finish();
            }
        });

        ivback = (ImageView) findViewById(R.id.iv_back);
        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
