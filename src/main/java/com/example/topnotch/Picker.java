package com.example.topnotch;

import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.shrikanthravi.collapsiblecalendarview.data.Day;

import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.Calendar;

import static android.widget.Toast.*;


public class Picker extends AppCompatActivity {
    Button btnOnPick;
    Button btnShowDate;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_up);
        btnOnPick = findViewById(R.id.pickBtn);
        btnShowDate = findViewById(R.id.showDate);





        final CollapsibleCalendar collapsibleCalendar = findViewById(R.id.calendarView);
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDayChanged() {
                Day day =collapsibleCalendar.getSelectedDay();
                Log.i(getClass().getName(), "Selected Day: "
                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());
                date = day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay();

                btnShowDate.setText(date);

            }

            @Override
            public void onClickListener() {

            }

            @Override
            public void onDaySelect() {

            }




            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });


    }


    public void setTime(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog;
        timePickerDialog= new TimePickerDialog(Picker.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btnOnPick.setText(hourOfDay+":"+minute);

            }
        },hour,min,false);
        timePickerDialog.show();



    }
}

