package material.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String navTitle[];
    private int navIcons[];

    private String m_name;
    private String m_account;
    private int m_profile;
    Context m_context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        int holderID;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView name;
        TextView account;
        Context context;

        public ViewHolder(View itemView, int viewType, Context c) {
            super(itemView);

            context = c;
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, "현재 Activity : " + getPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            if (viewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                holderID = 1;
            } else {
                name = (TextView) itemView.findViewById(R.id.name);
                account = (TextView) itemView.findViewById(R.id.account);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                holderID = 0;
            }
        }
    }

    public MyAdapter(String title[], int icon[], String name, String account, int profile, Context c) {
        navTitle = title;
        navIcons = icon;
        m_name = name;
        m_account = account;
        m_profile = profile;
        m_context = c;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
            ViewHolder vhItem = new ViewHolder(v, viewType, m_context);

            return vhItem;
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            ViewHolder vhHeader = new ViewHolder(v, viewType, m_context);

            return vhHeader;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        if (holder.holderID == 1) {
            holder.textView.setText(navTitle[position - 1]);
            holder.imageView.setImageResource(navIcons[position - 1]);
        } else {
            holder.profile.setImageResource(m_profile);
            holder.name.setText(m_name);
            holder.account.setText(m_account);
        }
    }

    @Override
    public int getItemCount() {
        return navTitle.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
