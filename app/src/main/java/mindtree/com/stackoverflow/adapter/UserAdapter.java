package mindtree.com.stackoverflow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import mindtree.com.stackoverflow.R;
import mindtree.com.stackoverflow.restclient.responsemodel.UserDetail;

/**
 * Created by M1030452 on 3/28/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    interface AdapterListener {
        void loadMore();
    }

    private List<UserDetail> userDetails;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, reputation;
        private ImageView profileImage;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.text_name);
            reputation = view.findViewById(R.id.text_reputation);
            profileImage = view.findViewById(R.id.image_profile);
        }
    }

    public UserAdapter(Context context) {
        this.mContext = context;
    }

    public void updateAdapter(ArrayList<UserDetail> userDetailList) {
        this.userDetails = userDetailList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recycler_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserDetail userDetail = userDetails.get(position);
        holder.name.setText(userDetail.getDisplay_name());
        holder.reputation.setText("Reputation : " + userDetail.getReputation());
        Glide.with(mContext).load(userDetail.getProfile_image())
                .thumbnail(0.5f)
                .into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        if (userDetails != null)
            return userDetails.size();
        else
            return 0;
    }
}
