package icw.slaf.slafdresscode;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * Created by Isuru on 12/11/2017.
 */
public class ewoavm  extends FragmentActivity {

    static final int NUM_ITEMS = 4;
    ImageFragmentPagerAdapter imageFragmentPagerAdapter;
    ViewPagerFixed viewPager;
    public static final String[] IMAGE_NAME = {"ewoavm1", "ewoavm2","ewoavm3","ewoavm4",  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        // getActionBar().setDisplayHomeAsUpEnabled(true);
        imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPagerFixed) findViewById(R.id.pager);
        viewPager.setAdapter(imageFragmentPagerAdapter);
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
    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        public ImageFragmentPagerAdapter(androidx.fragment.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            SwipeFragment fragment = new SwipeFragment();
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends androidx.fragment.app.Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.swipe_fragment, container, false);
            TouchImageView    ImageView = (TouchImageView) swipeView.findViewById(R.id.photo_view);


            //ImageView imageView = (ImageView) swipeView.findViewById(R.id.imageView);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            String imageFileName = IMAGE_NAME[position];
            int imgResId = getResources().getIdentifier(imageFileName, "drawable", "icw.slaf.slafdresscode");
            ImageView.setImageResource(imgResId);
            //imageView.setImageResource(imgResId);
            return swipeView;
        }

        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }
    }
}