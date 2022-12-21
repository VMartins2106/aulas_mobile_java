package etec.com.br.victor.barradenavegacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import etec.com.br.victor.barradenavegacao.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        replaceFragment(new FirstFragment());

            binding.barraDeNavegacao.setOnItemSelectedListener(item -> {

                switch (item.getItemId()){

                    case R.id.firstFragment:
                        replaceFragment(new FirstFragment());
                        break;

                    case R.id.secondFragment:
                        replaceFragment(new SecondFragment());
                        break;

                    case R.id.thirdFragment:
                        replaceFragment(new ThirdFragment());
                        break;

                }

                return true;
            });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tela, fragment);
        fragmentTransaction.commit();

    }
}