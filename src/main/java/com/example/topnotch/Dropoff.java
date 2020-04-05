package com.example.topnotch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.Calendar;

public class Dropoff extends AppCompatActivity {

    Button btnOnDrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropoff);

        btnOnDrop = findViewById(R.id.dropBtn);

        final CollapsibleCalendar collapsibleCalendar = findViewById(R.id.calendarView);
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDayChanged() {

            }

            @Override
            public void onClickListener() {

            }

            @Override
            public void onDaySelect() {
                Day day =collapsibleCalendar.getSelectedDay();
                Log.i(getClass().getName(), "Selected Day: "
                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());
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
        timePickerDialog= new TimePickerDialog(Dropoff.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btnOnDrop.setText(hourOfDay+minute);

            }
        },hour,min,false);
        timePickerDialog.show();

    }
}
