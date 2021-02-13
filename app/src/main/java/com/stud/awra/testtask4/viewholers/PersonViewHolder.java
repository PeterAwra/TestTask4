package com.stud.awra.testtask4.viewholers;

import androidx.recyclerview.widget.RecyclerView;
import com.stud.awra.testtask4.databinding.ItemPersonBinding;
import com.stud.awra.testtask4.interfaces.OnClickPersonListener;
import com.stud.awra.testtask4.model.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder {
  private final ItemPersonBinding binding;

  public PersonViewHolder(ItemPersonBinding binding, OnClickPersonListener personalListener) {
    super(binding.getRoot());
    this.binding = binding;
    binding.getRoot().setOnClickListener(v -> personalListener.onClick(binding.getPerson()));
  }

  public void bind(Person person) {
    binding.setPerson(person);
  }
}
