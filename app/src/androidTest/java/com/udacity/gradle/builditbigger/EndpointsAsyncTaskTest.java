package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Pair;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest{


    @Test
    public void testAsyncTestReturnString() throws Exception{
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // track the AsyncTask is done with a CountDownLatch
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] mResult = new String[1];

        EndpointsAsyncTask endpointsAsyncTask = (EndpointsAsyncTask) new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                countDownLatch.countDown();
                mResult[0] = result;
            }

        };

        endpointsAsyncTask.execute(new Pair<Context, String>(appContext, "Manfred"));
        countDownLatch.await(60, TimeUnit.SECONDS);
        assertNotNull(mResult[0]);
        assertNotEquals("", mResult[0]);
    }


}
