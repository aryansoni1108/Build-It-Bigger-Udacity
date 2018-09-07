package androidTest;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.TimeUnit;


/**
 * Created by Aryan Soni on 9/7/2018.
 */

public class AsyncTaskTest extends AndroidTestCase {

    public void testNonEmptyJokeReceived() {
        try {
            EndpointsAsyncTask task = new EndpointsAsyncTask();
            task.execute();
            String joke = task.get(30, TimeUnit.SECONDS);

            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            fail("Operation timed out");
        }

    }
}