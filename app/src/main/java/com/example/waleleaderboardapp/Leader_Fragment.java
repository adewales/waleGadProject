package com.example.waleleaderboardapp;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Leader_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Leader_Fragment extends Fragment {
    View view;
    private ProgressBar mLoadingProgress;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Leader_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Leader_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Leader_Fragment newInstance(String param1, String param2) {
        Leader_Fragment fragment = new Leader_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private  RecyclerView rvLeader;
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
        view = inflater.inflate(R.layout.fragment_learner, container, false);

        mLoadingProgress = (ProgressBar) view.findViewById(R.id.pb_learner_loading);

        rvLeader = (RecyclerView) view.findViewById(R.id.rvLeader);

        LinearLayoutManager learnerLayoutManager = new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.VERTICAL, false);

        rvLeader.setLayoutManager(learnerLayoutManager);

        try {
            URL leaderUrl = ApiUti.buildUrl("hours");
            new LeaderQueryTask().execute(leaderUrl);
        }
        catch (Exception e) {
            Log.d("Error", e.getMessage());
        }

        ArrayList<Leader> leaders = ApiUti.getLearners("");
        //tvLearner.setText(result);
        //String resultString = "";

        LeaderAdapter adapter = new LeaderAdapter(leaders);
        rvLeader.setAdapter(adapter);

        return view;

    }
    public class LeaderQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchURL = urls[0];
            String result = null;
            try {
                result = ApiUti.getJson(searchURL);
            }
            catch (IOException e) {
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            //TextView tvLearner = (TextView) view.findViewById(R.id.tvLearner);
            TextView tvError = (TextView) view.findViewById(R.id.tv_learner_error);
            mLoadingProgress.setVisibility(View.INVISIBLE);

            if (result == null) {
                rvLeader.setVisibility(View.INVISIBLE);
                tvError.setVisibility(View.VISIBLE);
            } else {
                rvLeader.setVisibility(View.VISIBLE);
                tvError.setVisibility(View.INVISIBLE);
            }

            ArrayList<Leader> leaders = ApiUti.getLearners(result);
            //tvLearner.setText(result);
            String resultString = "";

            //tvLearner.setText(resultString);
            //tvLearner.setText(result);

            LeaderAdapter adapter = new LeaderAdapter(leaders);
            rvLeader.setAdapter(adapter);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingProgress.setVisibility(View.VISIBLE);
        }
    }
}