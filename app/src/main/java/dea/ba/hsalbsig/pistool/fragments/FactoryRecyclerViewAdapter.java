package dea.ba.hsalbsig.pistool.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dea.ba.hsalbsig.pistool.R;
import dea.ba.hsalbsig.pistool.fragments.dummy.FactoryContent.FactoryItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FactoryItem} and makes a call to the

 * TODO: Replace the implementation with code for your data type.
 */
public class FactoryRecyclerViewAdapter extends RecyclerView.Adapter<FactoryRecyclerViewAdapter.ViewHolder> {

    private final List<FactoryItem> mValues;
    private final FactoryFragment.OnListFragmentInteractionListener mListener;

    public FactoryRecyclerViewAdapter(List<FactoryItem> items, FactoryFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_factory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public FactoryItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
