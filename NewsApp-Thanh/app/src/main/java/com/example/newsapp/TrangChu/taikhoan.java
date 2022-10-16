package com.example.newsapp.TrangChu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.newsapp.GiaVang.giavang;
import com.example.newsapp.LichVanNien.lichvannien;
import com.example.newsapp.R;
import com.example.newsapp.XoSo.xoso;

public class taikhoan extends Fragment {
    private ImageView IMG_caidat_anhdaidien, IMG_caidat_chedo, IMG_caidat_dangxuat;
    private ImageButton       IMG_caidat_thoitiet, IMG_caidat_xoso, IMG_caidat_giavang,
            IMG_caidat_lichviet;
    private TextView TXT_caidat_tecmmguoidung, TXT_caidat_tienich, TXT_caidat_thoitiet, TXT_caidat_xoso, TXT_caidat_giavang,
            TXT_caidat_lichviet, TXT_caidat_nangcao, TXT_caidat_chedo, txt_caidat_dangxuat;
    private Switch SW_sang_toi;
    private SaveState saveState;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taikhoan, container, false);

        //Ánh xạ
        IMG_caidat_anhdaidien =view.findViewById(R.id.img_caidat_anhdaidien);
        IMG_caidat_thoitiet =view.findViewById(R.id.img_caidat_thoitiet);
        IMG_caidat_xoso =view.findViewById(R.id.img_caidat_xoso);
        IMG_caidat_giavang =view.findViewById(R.id.img_caidat_giavang);
        IMG_caidat_lichviet =view.findViewById(R.id.img_caidat_lichviet);
        IMG_caidat_chedo =view.findViewById(R.id.img_caidat_chedo);
        IMG_caidat_dangxuat =view.findViewById(R.id.img_caidat_dangxuat);
        //
        TXT_caidat_tecmmguoidung = view.findViewById(R.id.txt_caidat_tecmmguoidung);
        TXT_caidat_tienich = view.findViewById(R.id.txt_caidat_tienich);
        TXT_caidat_thoitiet = view.findViewById(R.id.txt_caidat_thoitiet);
        TXT_caidat_xoso = view.findViewById(R.id.txt_caidat_xoso);
        TXT_caidat_giavang = view.findViewById(R.id.txt_caidat_giavang);
        TXT_caidat_lichviet = view.findViewById(R.id.txt_caidat_lichviet);
        TXT_caidat_nangcao = view.findViewById(R.id.txt_caidat_nangcao);
        TXT_caidat_chedo = view.findViewById(R.id.txt_caidat_chedo);
        txt_caidat_dangxuat = view.findViewById(R.id.txt_caidat_dangxuat);
        //
        SW_sang_toi = view.findViewById(R.id.sw_taikhoan_sangtoi);
        // chuyển màn hình giá vàng
        IMG_caidat_giavang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentgiavang = new Intent(getActivity(), giavang.class);
                startActivity(intentgiavang);
            }
        });
        // chuyển qua màn hình xổ số
        IMG_caidat_xoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentxoso = new Intent(getActivity(), xoso.class);
                startActivity(intentxoso);
            }
        });
        // chuyển qua màn hình lịch việt
        IMG_caidat_lichviet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlichviet = new Intent(getActivity(), lichvannien.class);
                startActivity(intentlichviet);
            }
        });
        //
        DarkMode();
        //  xử lý switch
            if(saveState.getState()==true)
                 SW_sang_toi.setChecked(true);
            SW_sang_toi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        saveState.setState(true);
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                    else {
                            saveState.setState(false);
                              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                }
            });
        return view;
    }
    public taikhoan() {

    }

    public static taikhoan newInstance() {
        taikhoan fragment = new taikhoan();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void DarkMode() {

        saveState = new SaveState(getActivity());
        if (saveState.getState() == true)  {
              AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else  {
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }
}