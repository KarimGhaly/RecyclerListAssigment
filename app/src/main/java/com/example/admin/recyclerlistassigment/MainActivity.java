package com.example.admin.recyclerlistassigment;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    private Button btn;
    private RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.BTNDATABASE);
        Database database = new Database(this);
        if (database.getAnimalsList().size() <= 0) {
            btn.setEnabled(true);
        } else {
            btn.setEnabled(false);
        }

        RecyclerView rview = (RecyclerView) findViewById(R.id.RecycleViewid);
        rvAdapter = new RVAdapter(database.getAnimalsList());
        rview.setAdapter(rvAdapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rview.setLayoutManager(layoutManager);
        rview.setItemAnimator(itemAnimator);

        ItemTouchHelper.Callback callback = new Swiper(rvAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rview);

    }

    public void SetupDatabase(View view) {
        Database database = new Database(this);
        if (database.InsertAnimals(getAnimals())) {
            Toast.makeText(this, "Animals Added Successfully to the Database", Toast.LENGTH_LONG).show();
            btn.setEnabled(false);
            rvAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
        }


    }

    private ArrayList<Animals> getAnimals() {
        ArrayList<Animals> animalsList = new ArrayList<>();
        Animals Lion = new Animals("Lion", "Mammals", 12, 420, R.drawable.lino);
        Animals Tiger = new Animals("Tiger", "Mammals", 20, 670, R.drawable.tiger);
        Animals Cheetah = new Animals("Cheetah", "Mammals", 11, 100, R.drawable.cheetah);
        Animals Panda = new Animals("Panda", "Mammals", 20, 220, R.drawable.panda);
        Animals Elephant = new Animals("Elephant", "Mammals", 55, 13000, R.drawable.elephant);
        animalsList.add(Lion);
        animalsList.add(Tiger);
        animalsList.add(Cheetah);
        animalsList.add(Panda);
        animalsList.add(Elephant);

        Animals Chicken = new Animals("Chicken", "Birds", 6, 2, R.drawable.chicken);
        Animals Eagle = new Animals("Eagle", "Birds", 20, 15, R.drawable.eagle);
        Animals Parrot = new Animals("Parrot", "Birds", 50, 3, R.drawable.parrot);
        Animals Toucan = new Animals("Toucan", "Birds", 20, 1, R.drawable.toucan);
        Animals Duck = new Animals("Duck", "Birds", 8, 3, R.drawable.duck);
        animalsList.add(Chicken);
        animalsList.add(Eagle);
        animalsList.add(Parrot);
        animalsList.add(Toucan);
        animalsList.add(Duck);

        Animals Anchovy = new Animals("Anchovy", "Fish", 1, 1, R.drawable.anchovy);
        Animals Albacore = new Animals("Albacore", "Fish", 10, 2, R.drawable.albacore);
        Animals Mackerel = new Animals("Mackerel", "Fish", 5, 3, R.drawable.mackerel);
        Animals Bonito = new Animals("Bonito", "Fish", 3, 2, R.drawable.bonito);
        Animals Sardine = new Animals("Sardine", "Fish", 1, 1, R.drawable.sardine);
        animalsList.add(Anchovy);
        animalsList.add(Albacore);
        animalsList.add(Mackerel);
        animalsList.add(Bonito);
        animalsList.add(Sardine);

        Animals Alligator = new Animals("Alligator", "Reptiles", 40, 500, R.drawable.alligator);
        Animals Snake = new Animals("Snake", "Reptiles", 9, 350, R.drawable.snake);
        Animals Turtle = new Animals("Tutle", "Reptiles", 60, 50, R.drawable.turtle);
        Animals lguana = new Animals("Green Lguana", "Reptiles", 20, 4, R.drawable.lguana);
        Animals leopard = new Animals("Leopard", "Reptiles", 15, 10, R.drawable.leopard);
        animalsList.add(Alligator);
        animalsList.add(Snake);
        animalsList.add(Turtle);
        animalsList.add(lguana);
        animalsList.add(leopard);

        return animalsList;
    }
}
