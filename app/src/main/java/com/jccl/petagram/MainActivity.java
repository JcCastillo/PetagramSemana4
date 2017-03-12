package com.jccl.petagram;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.adapter.PageAdapter;
import com.jccl.petagram.fragment.homeFragment;
import com.jccl.petagram.fragment.perfilFragment;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout =(TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setSupportActionBar(miActionBar);



        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        SetUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch  (item.getItemId()){
            case R.id.mFavoritos:
                irFavoritos();
                break;
            case R.id.mAcerca:
                irAcercaDe();
                break;
            case R.id.mContacto:
                irContacto();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new homeFragment());
        fragments.add(new perfilFragment());
        return fragments;
    }

    private void SetUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        Drawable drawable;
        Drawable wrapped;
        @ColorInt int color = getResources().getColor(R.color.colorBlanco);
         drawable = getResources().getDrawable(R.drawable.ic_action_name);
         wrapped = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapped, color);
        tabLayout.getTabAt(0).setIcon(wrapped);
        drawable = getResources().getDrawable(R.drawable.ic_perfil);
        wrapped = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapped, color);
        tabLayout.getTabAt(1).setIcon(wrapped);
    }



    public void irFavoritos(){
        Intent intent = new Intent(this,mascotas_favoritas.class);
        startActivity(intent);
    }

    public void irAcercaDe(){
        Intent intent = new Intent(this,acercade.class);
        startActivity(intent);
    }

    public void irContacto(){
        Intent intent = new Intent(this,contacto.class);
        startActivity(intent);
    }
}
