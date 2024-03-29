package com.notedapp.noted;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.io.File;
import java.util.List;

public class NotesDiffCallback extends DiffUtil.Callback {

    private List<File> oldList;
    private List<File> newList;

    public NotesDiffCallback(List<File> oldList, List<File> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).lastModified() < (System.currentTimeMillis() - 5000);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

}