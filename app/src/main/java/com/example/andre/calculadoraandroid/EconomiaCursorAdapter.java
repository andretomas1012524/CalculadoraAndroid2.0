package com.example.andre.calculadoraandroid;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Andre on 13-06-2018.
 */

public class EconomiaCursorAdapter extends RecyclerView.Adapter<EconomiaCursorAdapter.EconomiaViewHolder> {
    private Context context;
    private Cursor cursor=null;
    private View.OnClickListener viewHolderClickListener = null;
    private int lastEconomiaClicked = -1;

    public void refreshData(Cursor cursor){
        if(this.cursor!=cursor){
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    public EconomiaCursorAdapter(Context context) {
        this.context = context;
    }

    public void setViewHolderClickListener(View.OnClickListener viewHolderClickListener) {
        this.viewHolderClickListener = viewHolderClickListener;
    }
    public int getLastEconomiaClicked() {
        return lastEconomiaClicked;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public EconomiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.precos,parent,false);

        return new EconomiaViewHolder(item);


    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(EconomiaViewHolder holder, int position) {
        cursor.moveToPosition(position);

        Funcoes funcoes = DbTabelaFuncoes.getCurrentFuncoes(cursor);

        holder.setFuncao(funcoes);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (cursor==null){
            return 0;
        }
        return cursor.getCount();
    }

    public class EconomiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewNome;
        private TextView textViewpreco;
        private int economiaID;

        public EconomiaViewHolder(View itemView) {
            super(itemView);

            textViewNome=(TextView)itemView.findViewById(R.id.textViewNome);
            textViewpreco=(TextView)itemView.findViewById(R.id.textViewPreco);

            itemView.setOnClickListener(this);
        }

        public void setFuncao(Funcoes funcoes) {
            textViewNome.setText(funcoes.getNome());
            textViewpreco.setText(String.format("%.2f",funcoes.getValor() + "€"));

            economiaID=funcoes.getId();
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION) {
                return;
            }
            if (viewHolderClickListener != null) {
                lastEconomiaClicked = economiaID;
                viewHolderClickListener.onClick(view);
            }
        }
    }
}
