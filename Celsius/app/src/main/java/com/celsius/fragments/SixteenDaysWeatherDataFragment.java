package com.celsius.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahrenheit.celsius.activities.R;
import com.celsius.dbhelper.CurrentWeatherQueryResponce;
import com.celsius.dbhelper.DatabaseHelper;
import com.celsius.dbhelper.FiveDaysWeatherQueryResponce;
import com.celsius.dbhelper.SixTeenDaysWeatherQueryResponce;
import com.celsius.interfaces.DBHelperListenerInterface;
import com.celsius.utils.Tools;

import java.util.ArrayList;

/**
 * Created by dennisshar on 27/08/2017.
 */

public class SixteenDaysWeatherDataFragment extends Fragment {


    private DBHelperListenerInterface mCallback;
    private ArrayList<SixTeenDaysWeatherQueryResponce> sixTeenDaysWeatherList;


    private TextView day_one_date;
    private ImageView day_one_wheather_indicator_icon;
    private TextView day_one_min_max_temp;

    private TextView day_two_date;
    private ImageView day_two_wheather_indicator_icon;
    private TextView day_two_min_max_temp;

    private TextView day_three_date;
    private ImageView day_three_wheather_indicator_icon;
    private TextView day_three_min_max_temp;

    private TextView day_four_date;
    private ImageView day_four_wheather_indicator_icon;
    private TextView day_four_min_max_temp;

    private TextView day_five_date;
    private ImageView day_five_wheather_indicator_icon;
    private TextView day_five_min_max_temp;

    private TextView day_six_date;
    private ImageView day_six_wheather_indicator_icon;
    private TextView day_six_min_max_temp;

    private TextView day_seven_date;
    private ImageView day_seven_wheather_indicator_icon;
    private TextView day_seven_min_max_temp;

    private TextView day_eight_date;
    private ImageView day_eight_wheather_indicator_icon;
    private TextView day_eight_min_max_temp;

    private TextView day_nine_date;
    private ImageView day_nine_wheather_indicator_icon;
    private TextView day_nine_min_max_temp;

    private TextView day_ten_date;
    private ImageView day_ten_wheather_indicator_icon;
    private TextView day_ten_min_max_temp;

    private TextView day_eleven_date;
    private ImageView day_eleven_wheather_indicator_icon;
    private TextView day_eleven_min_max_temp;

    private TextView day_twelve_date;
    private ImageView day_twelve_wheather_indicator_icon;
    private TextView day_twelve_min_max_temp;

    private TextView day_thirteen_date;
    private ImageView day_thirteen_wheather_indicator_icon;
    private TextView day_thirteen_min_max_temp;

    private TextView day_fourteen_date;
    private ImageView day_fourteen_wheather_indicator_icon;
    private TextView day_fourteen_min_max_temp;

    private TextView day_fifthteen_date;
    private ImageView day_fifthteen_wheather_indicator_icon;
    private TextView day_fifthteen_min_max_temp;

    private TextView day_sixteen_date;
    private ImageView day_sixteen_wheather_indicator_icon;
    private TextView day_sixteen_min_max_temp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_sixteen_days_weather_data, parent, false);

        day_one_date = (TextView) view.findViewById(R.id.day_one_date);
        day_one_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_one_wheather_indicator_icon);
        day_one_min_max_temp = (TextView) view.findViewById(R.id.day_one_min_max_temp);

        day_two_date = (TextView) view.findViewById(R.id.day_two_date);
        day_two_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_two_wheather_indicator_icon);
        day_two_min_max_temp = (TextView) view.findViewById(R.id.day_two_min_max_temp);

        day_three_date = (TextView) view.findViewById(R.id.day_three_date);
        day_three_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_three_wheather_indicator_icon);
        day_three_min_max_temp = (TextView) view.findViewById(R.id.day_three_min_max_temp);

        day_four_date = (TextView) view.findViewById(R.id.day_four_date);
        day_four_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_four_wheather_indicator_icon);
        day_four_min_max_temp = (TextView) view.findViewById(R.id.day_four_min_max_temp);

        day_five_date = (TextView) view.findViewById(R.id.day_five_date);
        day_five_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_five_wheather_indicator_icon);
        day_five_min_max_temp = (TextView) view.findViewById(R.id.day_five_min_max_temp);

        day_six_date = (TextView) view.findViewById(R.id.day_six_date);
        day_six_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_six_wheather_indicator_icon);
        day_six_min_max_temp = (TextView) view.findViewById(R.id.day_six_min_max_temp);

        day_seven_date = (TextView) view.findViewById(R.id.day_seven_date);
        day_seven_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_seven_wheather_indicator_icon);
        day_seven_min_max_temp = (TextView) view.findViewById(R.id.day_seven_min_max_temp);

        day_eight_date = (TextView) view.findViewById(R.id.day_eight_date);
        day_eight_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_eight_wheather_indicator_icon);
        day_eight_min_max_temp = (TextView) view.findViewById(R.id.day_eight_min_max_temp);

        day_nine_date = (TextView) view.findViewById(R.id.day_nine_date);
        day_nine_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_nine_wheather_indicator_icon);
        day_nine_min_max_temp = (TextView) view.findViewById(R.id.day_nine_min_max_temp);

        day_ten_date = (TextView) view.findViewById(R.id.day_ten_date);
        day_ten_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_ten_wheather_indicator_icon);
        day_ten_min_max_temp = (TextView) view.findViewById(R.id.day_ten_min_max_temp);

        day_eleven_date = (TextView) view.findViewById(R.id.day_eleven_date);
        day_eleven_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_eleven_wheather_indicator_icon);
        day_eleven_min_max_temp = (TextView) view.findViewById(R.id.day_eleven_min_max_temp);

        day_twelve_date = (TextView) view.findViewById(R.id.day_twelve_date);
        day_twelve_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_twelve_wheather_indicator_icon);
        day_twelve_min_max_temp = (TextView) view.findViewById(R.id.day_twelve_min_max_temp);

        day_thirteen_date = (TextView) view.findViewById(R.id.day_thirteen_date);
        day_thirteen_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_thirteen_wheather_indicator_icon);
        day_thirteen_min_max_temp = (TextView) view.findViewById(R.id.day_thirteen_min_max_temp);

        day_fourteen_date = (TextView) view.findViewById(R.id.day_fourteen_date);
        day_fourteen_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_fourteen_wheather_indicator_icon);
        day_fourteen_min_max_temp = (TextView) view.findViewById(R.id.day_fourteen_min_max_temp);

        day_fifthteen_date = (TextView) view.findViewById(R.id.day_fifthteen_date);
        day_fifthteen_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_fifthteen_wheather_indicator_icon);
        day_fifthteen_min_max_temp = (TextView) view.findViewById(R.id.day_fifthteen_min_max_temp);

        day_sixteen_date = (TextView) view.findViewById(R.id.day_sixteen_date);
        day_sixteen_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_sixteen_wheather_indicator_icon);
        day_sixteen_min_max_temp = (TextView) view.findViewById(R.id.day_sixteen_min_max_temp);

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBHelperListenerInterface) activity;

        sixTeenDaysWeatherList = new ArrayList<>();
        sixTeenDaysWeatherList = mCallback.getDBhelper().getSixTeenDaysWeather();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(0).getDt())!=null && sixTeenDaysWeatherList.get(0).getIcon()!=null && sixTeenDaysWeatherList.get(0).getMax()!=null && sixTeenDaysWeatherList.get(0).getMin().toUpperCase()!=null) {
            day_one_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(0).getDt()));
            day_one_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(0).getIcon())));
            day_one_min_max_temp.setText(sixTeenDaysWeatherList.get(0).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(0).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(1).getDt())!=null && sixTeenDaysWeatherList.get(1).getIcon()!=null && sixTeenDaysWeatherList.get(1).getMax()!=null && sixTeenDaysWeatherList.get(1).getMin().toUpperCase()!=null) {
            day_two_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(1).getDt()));
            day_two_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(1).getIcon())));
            day_two_min_max_temp.setText(sixTeenDaysWeatherList.get(1).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(1).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(2).getDt())!=null && sixTeenDaysWeatherList.get(2).getIcon()!=null && sixTeenDaysWeatherList.get(2).getMax()!=null && sixTeenDaysWeatherList.get(2).getMin().toUpperCase()!=null) {
            day_three_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(2).getDt()));
            day_three_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(2).getIcon())));
            day_three_min_max_temp.setText(sixTeenDaysWeatherList.get(2).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(2).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(3).getDt())!=null && sixTeenDaysWeatherList.get(3).getIcon()!=null && sixTeenDaysWeatherList.get(3).getMax()!=null && sixTeenDaysWeatherList.get(3).getMin().toUpperCase()!=null) {
            day_four_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(3).getDt()));
            day_four_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(3).getIcon())));
            day_four_min_max_temp.setText(sixTeenDaysWeatherList.get(3).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(3).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(4).getDt())!=null && sixTeenDaysWeatherList.get(4).getIcon()!=null && sixTeenDaysWeatherList.get(4).getMax()!=null && sixTeenDaysWeatherList.get(4).getMin().toUpperCase()!=null) {
            day_five_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(4).getDt()));
            day_five_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(4).getIcon())));
            day_five_min_max_temp.setText(sixTeenDaysWeatherList.get(4).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(4).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(5).getDt())!=null && sixTeenDaysWeatherList.get(5).getIcon()!=null && sixTeenDaysWeatherList.get(5).getMax()!=null && sixTeenDaysWeatherList.get(5).getMin().toUpperCase()!=null) {
            day_six_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(5).getDt()));
            day_six_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(5).getIcon())));
            day_six_min_max_temp.setText(sixTeenDaysWeatherList.get(5).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(5).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(6).getDt())!=null && sixTeenDaysWeatherList.get(6).getIcon()!=null && sixTeenDaysWeatherList.get(6).getMax()!=null && sixTeenDaysWeatherList.get(6).getMin().toUpperCase()!=null) {
            day_seven_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(6).getDt()));
            day_seven_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(6).getIcon())));
            day_seven_min_max_temp.setText(sixTeenDaysWeatherList.get(6).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(6).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(7).getDt())!=null && sixTeenDaysWeatherList.get(7).getIcon()!=null && sixTeenDaysWeatherList.get(7).getMax()!=null && sixTeenDaysWeatherList.get(7).getMin().toUpperCase()!=null) {
            day_eight_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(7).getDt()));
            day_eight_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(7).getIcon())));
            day_eight_min_max_temp.setText(sixTeenDaysWeatherList.get(7).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(7).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(8).getDt())!=null && sixTeenDaysWeatherList.get(8).getIcon()!=null && sixTeenDaysWeatherList.get(8).getMax()!=null && sixTeenDaysWeatherList.get(8).getMin().toUpperCase()!=null) {
            day_nine_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(8).getDt()));
            day_nine_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(8).getIcon())));
            day_nine_min_max_temp.setText(sixTeenDaysWeatherList.get(8).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(8).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(9).getDt())!=null && sixTeenDaysWeatherList.get(9).getIcon()!=null && sixTeenDaysWeatherList.get(9).getMax()!=null && sixTeenDaysWeatherList.get(9).getMin().toUpperCase()!=null) {
            day_ten_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(9).getDt()));
            day_ten_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(9).getIcon())));
            day_ten_min_max_temp.setText(sixTeenDaysWeatherList.get(9).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(9).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(10).getDt())!=null && sixTeenDaysWeatherList.get(10).getIcon()!=null && sixTeenDaysWeatherList.get(10).getMax()!=null && sixTeenDaysWeatherList.get(10).getMin().toUpperCase()!=null) {
            day_eleven_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(10).getDt()));
            day_eleven_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(10).getIcon())));
            day_eleven_min_max_temp.setText(sixTeenDaysWeatherList.get(10).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(10).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(11).getDt())!=null && sixTeenDaysWeatherList.get(11).getIcon()!=null && sixTeenDaysWeatherList.get(11).getMax()!=null && sixTeenDaysWeatherList.get(11).getMin().toUpperCase()!=null) {
            day_twelve_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(11).getDt()));
            day_twelve_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(11).getIcon())));
            day_twelve_min_max_temp.setText(sixTeenDaysWeatherList.get(11).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(11).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(12).getDt())!=null && sixTeenDaysWeatherList.get(12).getIcon()!=null && sixTeenDaysWeatherList.get(12).getMax()!=null && sixTeenDaysWeatherList.get(12).getMin().toUpperCase()!=null) {
            day_thirteen_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(12).getDt()));
            day_thirteen_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(12).getIcon())));
            day_thirteen_min_max_temp.setText(sixTeenDaysWeatherList.get(12).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(12).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(13).getDt())!=null && sixTeenDaysWeatherList.get(13).getIcon()!=null && sixTeenDaysWeatherList.get(13).getMax()!=null && sixTeenDaysWeatherList.get(13).getMin().toUpperCase()!=null) {
            day_fourteen_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(13).getDt()));
            day_fourteen_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(13).getIcon())));
            day_fourteen_min_max_temp.setText(sixTeenDaysWeatherList.get(13).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(13).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(14).getDt())!=null && sixTeenDaysWeatherList.get(14).getIcon()!=null && sixTeenDaysWeatherList.get(14).getMax()!=null && sixTeenDaysWeatherList.get(14).getMin().toUpperCase()!=null) {
            day_fifthteen_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(14).getDt()));
            day_fifthteen_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(14).getIcon())));
            day_fifthteen_min_max_temp.setText(sixTeenDaysWeatherList.get(14).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(14).getMin().toUpperCase() + "\u2103");
        }

        if(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(15).getDt())!=null && sixTeenDaysWeatherList.get(15).getIcon()!=null && sixTeenDaysWeatherList.get(15).getMax()!=null && sixTeenDaysWeatherList.get(15).getMin().toUpperCase()!=null) {
            day_sixteen_date.setText(Tools.dateFromTimeStamp(sixTeenDaysWeatherList.get(15).getDt()));
            day_sixteen_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(), sixTeenDaysWeatherList.get(15).getIcon())));
            day_sixteen_min_max_temp.setText(sixTeenDaysWeatherList.get(15).getMax() + "\u2103" + " / " + sixTeenDaysWeatherList.get(15).getMin().toUpperCase() + "\u2103");
        }


        //day_three_wheather_indicator_icon.setImageDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),fiveDaysWeatherList.get(2).getDescription()));
    }
}
