package com.example.yan.exemplo03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rvPessoas;
    public static List<String> pessoas = new ArrayList<String>(){{
        add("Item 0");
        add("Item 1");
        add("Item 2");
        add("Item 3");
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPessoas = findViewById(R.id.rvPessoas);
        rvPessoas.setLayoutManager(new LinearLayoutManager(this));
        final PessoaAdapter adapter = new PessoaAdapter(pessoas);
        adapter.setOnPessoaClickListener(new PessoaAdapter.OnPessoaClickListener() {
            @Override
            public void onPessoaClick(View view, int position) {
                Toast.makeText(MainActivity.this,
                        pessoas.get(position),
                        Toast.LENGTH_SHORT).show();
                pessoas.add("item "+pessoas.size());
                pessoas.set(position, pessoas.get(position)+"*");
                adapter.notifyItemChanged(pessoas.size()-1);
                adapter.notifyItemChanged(position);
            }
        });
        rvPessoas.setAdapter(adapter);



    }
}
