package com.example.mypepper.actions;


import android.os.Bundle;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.builder.AnimateBuilder;
import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animation;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.example.mypepper.R;


public class GreatingAnimation {

    public static void beNice(QiContext qiContext){

        // Introduction
        Say sayHallo = SayBuilder.with(qiContext) // create the builder with context.
                .withText("\\rspd=80\\ Hallo Schön dass ihr da seid.") // set text to say
                .build(); // build the say
        sayHallo.run();

        Animation myGreating = AnimationBuilder.with(qiContext)
                .withResources(R.raw.greating)
                .build();

        Animate greating = AnimateBuilder.with(qiContext)
                .withAnimation(myGreating)
                .build();
        greating.run();

        Say intro1 = SayBuilder.with(qiContext)
                .withText("\\rspd=80\\ Habt ihr Lust euch etwas zu bewegen? setzt euch Aufrecht hin und wenn ihr bereit seid können wir beginnen"+
                        "\\rspd=80\\ jeder kann die übungen nach eigenem ermessen durchführen ich bin schließlich auch in meinen bewegungen eingeschränkt"+
                        "\\rspd=80\\jetzt könnt ihr euren schwierigkeitsgrad wählen.")
                .build();
        intro1.run();
    }


}
