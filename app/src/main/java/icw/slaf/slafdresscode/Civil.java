package icw.slaf.slafdresscode;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Isuru on 12/8/2017.
 */
public class Civil extends ListActivity {
    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

    /**
     * The collection of all samples in the app. This gets instantiated in {@link
     * #onCreate(Bundle)} because the {@link Sample} constructor needs access to {@link
     * android.content.res.Resources}.
     */
    private static Sample[] mSamples;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the list of samples.
        mSamples = new Sample[]{
                new Sample(R.string.title_bar, icw.slaf.slafdresscode.cbar.class),
                new Sample(R.string.title_elect, icw.slaf.slafdresscode.celect.class),
                new Sample(R.string.title_maleatt, icw.slaf.slafdresscode.cmatten.class),
                new Sample(R.string.title_cook, icw.slaf.slafdresscode.ccook.class),
                new Sample(R.string.title_waiter, icw.slaf.slafdresscode.cwaiter.class),
                new Sample(R.string.title_peon, icw.slaf.slafdresscode.cpeon.class),
                new Sample(R.string.title_sanit, icw.slaf.slafdresscode.csanit.class),
                new Sample(R.string.title_sign, csign.class),
                new Sample(R.string.title_spray, icw.slaf.slafdresscode.cspray.class),
                new Sample(R.string.title_watch, icw.slaf.slafdresscode.cwatcher.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mSamples));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(Civil.this, mSamples[position].activityClass));
    }
}
