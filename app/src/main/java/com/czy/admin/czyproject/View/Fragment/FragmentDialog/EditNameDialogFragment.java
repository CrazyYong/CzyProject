package com.czy.admin.czyproject.View.Fragment.FragmentDialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.czy.admin.czyproject.R;

/**
 * Created by czy on 2017/6/7.
 */

public class EditNameDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_edit_dialog, container);
        return view;
    }


    public void showEditDialog(View view)
    {
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }
}
