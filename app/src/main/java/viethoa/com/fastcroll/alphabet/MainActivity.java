package viethoa.com.fastcroll.alphabet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.viethoa.RecyclerViewFastScroller;
import com.viethoa.models.AlphabetItem;

import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.fast_scroller)
    RecyclerViewFastScroller fastScroller;

    private ArrayList<BaiHat> mDataArray = new ArrayList<BaiHat>();
    private List<AlphabetItem> mAlphabetItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initialiseData();
        initialiseUI();
    }

    protected void initialiseData() {
        //Recycler view data
        mDataArray.add(new BaiHat("50232","Anh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("52011","Binh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("2212","Cnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("2124","Dnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("1245","Enh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("1242","Fnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("121","Fnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Fnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("0100","Gnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Hnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Inh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Jnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Knh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("2212","Lnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("2124","Mnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("1245","Mnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("1242","Mnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("121","Nnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Onh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("0100","Onh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Onh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Pnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Qnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));
        mDataArray.add(new BaiHat("50232","Xnh Khong Muon Bat Cong","c","d","e","f","i",false,R.drawable.addfav));

        //Alphabet fast scroller data
        mAlphabetItems = new ArrayList<>();
        List<String> strAlphabets = new ArrayList<>();
        for (int i = 0; i < mDataArray.size(); i++) {
            String name = mDataArray.get(i).getTenBh();
            if (name == null || name.trim().isEmpty())
                continue;

            String word = name.substring(0, 1);
            if (!strAlphabets.contains(word)) {
                strAlphabets.add(word);
                mAlphabetItems.add(new AlphabetItem(i, word, false));
            }
        }
    }

    protected void initialiseUI() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(mDataArray));

        fastScroller.setRecyclerView(mRecyclerView);
        fastScroller.setUpAlphabet(mAlphabetItems);
    }
}
