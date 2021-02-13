package com.stud.awra.testtask4.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.stud.awra.testtask4.databinding.ItemPersonBinding;
import com.stud.awra.testtask4.interfaces.OnClickPersonListener;
import com.stud.awra.testtask4.model.Person;
import com.stud.awra.testtask4.viewholers.PersonViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PersonalAdapter extends RecyclerView.Adapter<PersonViewHolder> {
  private final List<Person> items = new ArrayList<>();
  private final OnClickPersonListener personClickListener;

  public PersonalAdapter(OnClickPersonListener personClickListener) {
    this.personClickListener = personClickListener;
  }

  public void setItems(List<Person> _items) {
    items.clear();
    items.addAll(_items);
    notifyDataSetChanged();
  }

  @NonNull @Override
  public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new PersonViewHolder(
        ItemPersonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false),
        personClickListener);
  }

  @Override public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
    holder.bind(items.get(position));
  }

  @Override public int getItemCount() {
    return items.size();
  }
}