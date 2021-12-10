package com.example.mypepper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.example.mypepper.actions.Outro;
import com.example.mypepper.actions.PepperAnimation;
import com.example.mypepper.database.UpdateUser;

import java.util.concurrent.ExecutionException;

public class PerformActivity extends RobotActivity implements RobotLifecycleCallbacks {

    private final static String TAG = PerformActivity.class.getName();
    public Button cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform_activity);
        QiSDK.register(this, this);

        cancel_button = (Button) findViewById(R.id.cancel_back_button);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exercise.cancel();
                    Intent backIntent = new Intent(PerformActivity.this, MainActivity.class);
                    startActivity(backIntent);
            }
        });
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {

        // TODO: drehen während übung?
        Bundle extrasActivity = getIntent().getExtras();
        if (extrasActivity== null){
            Log.d(TAG,"an error occured");
        } else {
            String performMethod = extrasActivity.getString("keyPerform");
            if (performMethod.equals("valueHardPerform")){
                int[] arrayHard = {10,7,6,1,4,9,8,2,5,12,0};
                int iteration = 2;

                Say intro1 = SayBuilder.with(qiContext)
                    .withText("\\rspd=80\\ klasse! schön euch zu sehen")
                    .build();
                intro1.run();

                Animation myGreating = AnimationBuilder.with(qiContext)
                        .withResources(R.raw.greating)
                        .build();

                Animate greating = AnimateBuilder.with(qiContext)
                        .withAnimation(myGreating)
                        .build();
                greating.run();

                Say intro2 = SayBuilder.with(qiContext)
                        .withText("\\rspd=80\\ dann lass uns ein paar schwere Übungen machen.")
                        .build();
                intro2.run();

                Exercise.doExercise(qiContext, arrayHard, iteration);

            }
            if (performMethod.equals("valueEasyPerform")){

                int[] arrayEasy = {10,7,6,5,11,3,12,0};
                int iteration=2;

                Say intro1 = SayBuilder.with(qiContext)
                        .withText("\\rspd=80\\ super! \\pau=200\\ schön dass ihr da seid.")
                        .build();
                intro1.run();

                Animation myGreating = AnimationBuilder.with(qiContext)
                        .withResources(R.raw.greating)
                        .build();

                Animate greating = AnimateBuilder.with(qiContext)
                        .withAnimation(myGreating)
                        .build();
                greating.run();

                Say intro2 = SayBuilder.with(qiContext)
                        .withText("\\rspd=80\\ heute machen wir ein paar leichte übungen.")
                        .build();
                intro2.run();
                Exercise.doExercise(qiContext, arrayEasy, iteration);
            }
            if (performMethod.equals("valueIndividual")){
                int iteration = UpdateUser.iter;
                int [] array = UpdateUser.array;
                String name = UpdateUser.userName;

                Say intro = SayBuilder.with(qiContext)
                        .withText("\\rspd=80\\ Hallo schön dass du mit mir ein paar Übungen machen möchtest.")
                        .build();
                intro.run();
                Exercise.doExercise(qiContext, array, iteration);
            }
        }
    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusLost() {

    }

    @Override
    public void onRobotFocusRefused(String reason) {

    }
}