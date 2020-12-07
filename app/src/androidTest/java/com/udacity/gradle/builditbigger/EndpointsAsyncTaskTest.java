package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Pair;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest{


    @Test
    public void testAsyncTestReturnString(){
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        EndpointsAsyncTask endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    assertTrue(result.length() > 0);
                }
            }

        }.execute(new Pair<Context, String>(appContext, "Manfred"));

    }


}
