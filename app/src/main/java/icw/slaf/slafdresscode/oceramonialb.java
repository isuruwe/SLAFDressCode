package icw.slaf.slafdresscode;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Isuru on 12/10/2017.
 */
public class oceramonialb extends ListActivity {
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
        // getActionBar().setDisplayHomeAsUpEnabled(true);
        // Instantiate the list of samples.
        mSamples = new Sample[]{
                new Sample(R.string.title_sqrbelow, icw.slaf.slafdresscode.cbsqrbelow.class),
                new Sample(R.string.title_wngcdr, icw.slaf.slafdresscode.cbwgcdr.class),
                new Sample(R.string.title_grpcpt, icw.slaf.slafdresscode.cbgpcapt.class),
                new Sample(R.string.title_acdre, icw.slaf.slafdresscode.cbacdr.class),
                new Sample(R.string.title_avm, cbavm.class),
                new Sample(R.string.title_coa, icw.slaf.slafdresscode.cbcoa.class),
        };

        setListAdapter(new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mSamples));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(oceramonialb.this, mSamples[position].activityClass));
    }
}
