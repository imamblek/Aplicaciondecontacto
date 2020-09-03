package com.imamblek.aplicaciondecontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

//----------------------------------------------------------DATE PICKER 1
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    //----------------------------------------------------------DATE PICKER 1
    String date1;
    public static final String DATE_DIALOG = "datePicker1";
    static TextView txtDate;
    private static int mYear;
    private static int mMonth;
    private static int mDay;
    //----------------------------------------------------------DATE PICKER 1
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // set default date

        //Date Time FROM BEFORE
//            String date =  txt_date1.getText().toString().trim();
//            String[] data = date.split("/", 3);
//            int year = Integer.parseInt(data[0]);
//            int month = Integer.parseInt(data[1])-1;    //Because January is 0
//            int day = Integer.parseInt(data[2]);

        //Date Time NOW
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(),R.style.DatePicker, this, year, month, day);
    }
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // get selected date
        mYear = year;
        mMonth = month;
        mDay = day;
        // show selected date to date button
        txtDate.setText(new StringBuilder()
                .append(mYear).append("/")
                .append(mMonth + 1).append("/")
                .append(mDay).append(" "));
    }
}
//----------------------------------------------------------DATE PICKER 1