package com.example.mypepper.actions;

import android.content.Intent;

import com.aldebaran.qi.Future;
import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.example.mypepper.R;

public class Outro{

    public static Future<Void> doOutro(QiContext qiContext) {

        Say sayHallo = SayBuilder.with(qiContext)
                .withText("\\rspd=80\\das habt ihr toll gemacht \\pau=500\\ ich hoffe wir sehen uns bald wieder ") // set text to say
                .build();
        sayHallo.run();

        Animation myGreating = AnimationBuilder.with(qiContext)
                .withResources(R.raw.outro)
                .build();

        return AnimateBuilder.with(qiContext)
                .withAnimation(myGreating)
                .build()
                .async().run();
    }
}
