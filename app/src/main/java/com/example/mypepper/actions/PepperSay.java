package com.example.mypepper.actions;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.example.mypepper.actions.PepperAction;

import java.util.concurrent.ExecutionException;

public class PepperSay extends PepperAction {

    public static void doSay (QiContext qiContext, String arg) throws ExecutionException, InterruptedException {

        Say say = SayBuilder.with(qiContext)
                .withText(arg)
                .build();
        sayFuture(say.async().run());

    }
}
