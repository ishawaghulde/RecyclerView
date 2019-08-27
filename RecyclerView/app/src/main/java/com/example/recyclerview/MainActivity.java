package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Card> cardList;
    Typeface myFont;

    RecyclerView recyclerView;

//    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
//            navigate();
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myFont = Typeface.createFromAsset(this.getAssets(), "font/Unicorns are Awesome - TTF.ttf");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardList = new ArrayList<>();

        cardList.add(
                new Card(
                        "Athletics",
                        R.drawable.athletics));

        cardList.add(
                new Card(
                        "Badminton(Mixed)",
                        R.drawable.badminton));

        cardList.add(
                new Card(
                        "Basketball(Boys)",
                        R.drawable.basketball));
        cardList.add(
                new Card(
                        "Basketball(Girls)",
                        R.drawable.basketball));
        cardList.add(
                new Card(
                        "Carrom",
                        R.drawable.carrom));
        cardList.add(
                new Card(
                        "Chess",
                        R.drawable.chess));
        cardList.add(
                new Card(
                        "Cricket(Boys)",
                        R.drawable.cricket));
        cardList.add(
                new Card(
                        "Cricket(Girls)",
                        R.drawable.cricket));
        cardList.add(
                new Card(
                        "Football(Boys)",
                        R.drawable.football));
        cardList.add(
                new Card(
                        "Handball(Boys)",
                        R.drawable.handball));
        cardList.add(
                new Card(
                        "Handball(Girls)",
                        R.drawable.handball));
        cardList.add(
                new Card(
                        "Hockey(Boys)",
                        R.drawable.hockey));
        cardList.add(
                new Card(
                        "Kabaddi",
                        R.drawable.hockey));
        cardList.add(
                new Card(
                        "Kho Kho(Boys)",
                        R.drawable.hockey));
        cardList.add(
                new Card(
                        "Kho Kho(Girls))",
                        R.drawable.hockey));
        cardList.add(
                new Card(
                        "Marathon",
                        R.drawable.marathon));
        cardList.add(
                new Card(
                        "Powerlifting",
                        R.drawable.powerlifting));
        cardList.add(
                new Card(
                        "Swimming",
                        R.drawable.swimming));
        cardList.add(
                new Card(
                        "Table Tennis(Mixed)",
                        R.drawable.table_tennis));
        cardList.add(
                new Card(
                        "Tennis(Boys)",
                        R.drawable.tennis));

        cardList.add(
                new Card(
                        "Throwball",
                        R.drawable.tennis));
        cardList.add(
                new Card(
                        "Volleyball(Boys)",
                        R.drawable.volleyball));
        cardList.add(
                new Card(
                        "Volleyball(Girls)",
                        R.drawable.volleyball));
        cardList.add(
                new Card(
                        "SportsQuiz",
                        R.drawable.search));



        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, cardList, myFont);
//        adapter.setItemClickListener(onItemClickListener);


        recyclerView.setAdapter(adapter);

    }

    public void navigate(View view){

        Intent intent = new Intent(MainActivity.this, FixturesActivity.class);
        startActivity(intent);
        startActivity(intent);
    }
}
