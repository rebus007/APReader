package james.apreader.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import james.apreader.R;
import james.apreader.Supplier;
import james.apreader.adapters.ListAdapter;
import james.apreader.data.WallData;

public class FavFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fav, container, false);
        RecyclerView recycler = (RecyclerView) v.findViewById(R.id.recycler);

        ArrayList<WallData> walls = ((Supplier) getContext().getApplicationContext()).getFavoriteWallpapers();

        recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        ListAdapter adapter = new ListAdapter(getActivity(), walls);
        adapter.setLayoutMode(ListAdapter.LAYOUT_MODE_COMPLEX);
        recycler.setAdapter(adapter);

        if (walls.size() < 1) v.findViewById(R.id.empty).setVisibility(View.VISIBLE);

        return v;
    }
}
