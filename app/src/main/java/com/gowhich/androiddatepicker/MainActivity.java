package com.gowhich.androiddatepicker;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener,TimePicker.OnTimeChangedListener {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) this.findViewById(R.id.datePicker);
        timePicker = (TimePicker) this.findViewById(R.id.timePicker);
        textView = (TextView) this.findViewById(R.id.textView);

        datePicker.init(2013, 8, 20, this);//初始化时间

        timePicker.setIs24HourView(true);//24小时制
        timePicker.setOnTimeChangedListener(this);//注册监听事件
    }

    @Override
    public void onDateChanged(DatePicker view, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(), timePicker.getCurrentHour(),timePicker.getCurrentMinute());
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        textView.setText(format.format(calendar.getTime()));
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        Toast.makeText(MainActivity.this, "hourOfDay:" + i + " minute:" + i1, Toast.LENGTH_SHORT).show();
    }
}
