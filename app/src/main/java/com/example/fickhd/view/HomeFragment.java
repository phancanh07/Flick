package com.example.fickhd.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.fickhd.R;
import com.example.fickhd.adapter.ImageApdapter;
import com.example.fickhd.interfaces.IfPhoto;
import com.example.fickhd.interfaces.SendList;
import com.example.fickhd.model.Photo;
import com.example.fickhd.model.PhotoBg;
import com.example.fickhd.presenters.ApiRetrofit;
import com.example.fickhd.view.activity.ImageDowloadActivity;
import com.google.gson.Gson;
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements SendList {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ImageApdapter imageApdapter;
    private List<Photo> photoList = new ArrayList<>();
    List<Photo> photoListTest;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int page = 1;
    int maxpage = 2;
    boolean isLoading = false;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        getImageView();

        return view;
    }


    private void initUI(View view) {
        recyclerView = view.findViewById(R.id.recyleViewHome);
        progressBar = view.findViewById(R.id.google_progress);
        progressBar.setIndeterminateDrawable(new ChromeFloatingCirclesDrawable.Builder(getContext())
                .build());

    }

    private void getImageView() {
        IfPhoto ifPhoto = ApiRetrofit.getClient().create(IfPhoto.class);
        ifPhoto.getDataDetai().enqueue(new Callback<PhotoBg>() {
            @Override
            public void onResponse(Call<PhotoBg> call, Response<PhotoBg> response) {
                if (response.isSuccessful()) {
                    photoList.addAll(response.body().getPhotos().getPhoto());
                    imageApdapter = new ImageApdapter(photoList, getContext(), HomeFragment.this::listImage);
                    StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
                    manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setHasFixedSize(true);
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<PhotoBg> call, Throwable t) {
                Log.e("ERROLCALL:", t.getMessage());
            }
        });

    }

    public void showToast() {
        Toast toast = new Toast(getContext());
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast, (ViewGroup) getActivity().findViewById(R.id.viewToat));
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void listImage(List<Photo> photos, int positon) {
        Gson gson = new Gson();
        String json = gson.toJson(photos);
        Log.d("json", json);
        if (photos.get(positon).getUrlL() != null) {
            Intent intent = new Intent(getContext(), ImageDowloadActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("KEY_JSON", json);
            bundle.putInt("KEY_ID", positon);
            intent.putExtras(bundle);
            startActivity(intent);
            showToast();
//            startActivity(new Intent(getContext(), ImageDowloadActivity.class).putExtra("KEY_DATA", photos.get(positon).getUrlL()));
        } else {
            startActivity(new Intent(getContext(), ImageDowloadActivity.class).putExtra("KEY_DATA", photos.get(positon).getUrlM()));
            showToast();
        }
    }

    private void setAdapter() {
        recyclerView.setAdapter(imageApdapter);
        progressBar.setVisibility(View.INVISIBLE);
        imageApdapter.notifyDataSetChanged();
    }
}