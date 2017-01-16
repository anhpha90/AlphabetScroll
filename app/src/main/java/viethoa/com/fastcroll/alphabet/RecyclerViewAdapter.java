package viethoa.com.fastcroll.alphabet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.viethoa.RecyclerViewFastScroller;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by VietHoa on 07/10/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
    implements RecyclerViewFastScroller.BubbleTextGetter {

    private ArrayList<BaiHat> mDataArray;

    public RecyclerViewAdapter(ArrayList<BaiHat> dataset) {
        mDataArray = dataset;
    }

    @Override
    public int getItemCount() {
        if (mDataArray == null)
            return 0;
        return mDataArray.size();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataArray.get(position).getTxtms());
        holder.bhName.setText(mDataArray.get(position).getTenBh());
        holder.lr.setText(mDataArray.get(position).getTxtLr());

        holder.imageButton.setImageResource(mDataArray.get(position).getImg());
    }

    @Override
    public String getTextToShowInBubble(int pos) {
        if (pos < 0 || pos >= mDataArray.size())
            return null;

        String name = mDataArray.get(pos).getTenBh();
        if (name == null || name.length() < 1)
            return null;

        return mDataArray.get(pos).getTenBh().substring(0, 1);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_alphabet)
        TextView mTextView;
        @Bind(R.id.bh)
        TextView bhName;
        @Bind(R.id.lr)
        TextView lr;
        @Bind(R.id.imageButton)
        ImageButton imageButton;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
