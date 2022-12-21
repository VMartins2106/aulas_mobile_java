package etec.com.br.victor.testecalendrio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.metrics.Event;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        selectedDate = LocalDate.now();
        setMonthView();
    }

    private void inicializarComponentes() {

        calendarRecyclerView = findViewById(R.id.calendarRecycleView);
        monthYearText = findViewById(R.id.mesAno);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView() {

        monthYearText.setText(monthYearFromDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonth(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> daysInMonth(LocalDate date) {

        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i<=42; i++){

            if(i <= dayOfWeek || i >= daysInMonth + dayOfWeek){

                daysInMonthArray.add("");

            }
            else{

                daysInMonthArray.add(String.valueOf(i - dayOfWeek));

            }

        }

        return daysInMonthArray;


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthYearFromDate(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void mesAnterior(View view) {

        selectedDate = selectedDate.minusMonths(1);
        setMonthView();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void mesProximo(View view) {

        selectedDate = selectedDate.plusMonths(1);
        setMonthView();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String dayText) {

        Log.e("ERRO", dayText);



        String msg = "Data selecionada " + dayText + " " + monthYearFromDate(selectedDate);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();


    }
}