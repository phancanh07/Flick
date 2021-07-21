package com.example.fickhd.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fickhd.R;
import com.example.fickhd.adapter.ThemeAdapter;
import com.example.fickhd.model.Theme;
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView gridView;
    private List<Theme> themeList;
    private ThemeAdapter themeAdapter;
    private ProgressBar progressBar;
    private GoogleProgressBar googleProgressBar;


    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        getImageView(view);
        getData();
        return view;
    }

    private void getData() {
        themeList = new ArrayList<>();
        themeList.add(new Theme("https://1.bp.blogspot.com/-a-GO0cVmnuE/XcWkLlMcWrI/AAAAAAAATMY/3QfOrHzXeYoRS7qMAzVCa8BrHAwnmCncQCLcBGAsYHQ/s1600/hinh-anh-hot-girl-xinh-han-quoc-wap102-com%2B%25281%2529.jpg", "Beautiful Girl 002 4K"));
        themeList.add(new Theme("https://gaixinh69.net/wp-content/uploads/2019/10/cropped-Girl-mini-P1-gaixinh69.net-045-1024x576.jpg", "Beautiful Girl 004 4K"));
        themeList.add(new Theme("https://fsb.zobj.net/crop.php?r=m4W77IFixy3HOt-gm7ZX47CRDeM9VEzIJtgOh4QQBnEp5kER3Ek5LaWpsavqoaetWwFVNg8b5l1U-sYJnArsSrdByaLoMAhpRnGDEPSMHkyiH0YpqWX740wXMG_MV00bA6axqorLcoP3qKCz", "SPACE 4K"));
        themeList.add(new Theme("https://images2.minutemediacdn.com/image/upload/c_crop,h_1689,w_3000,x_0,y_404/f_auto,q_auto,w_1100/v1563809078/shape/mentalfloss/28865-gettyimages-500694766.jpg", "Animal 4K"));
        themeAdapter = new ThemeAdapter(themeList, getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        gridView.setLayoutManager(manager);
        gridView.setHasFixedSize(false);
        gridView.setAdapter(themeAdapter);
        progressBar.setVisibility(View.GONE);
    }

    private void getImageView(View view) {
        int[] color = {
                R.color.red, R.color.yeallow, R.color.tim, R.color.xanhcay
        };
        progressBar = view.findViewById(R.id.favorite_progessbar);
        gridView = view.findViewById(R.id.recleview);
        progressBar.setIndeterminateDrawable(new ChromeFloatingCirclesDrawable.Builder(getContext())
                .build());

    }

}