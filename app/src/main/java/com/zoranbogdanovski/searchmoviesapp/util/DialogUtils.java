package com.zoranbogdanovski.searchmoviesapp.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Utility class for creating dialogs.
 */
public final class DialogUtils {

    private DialogUtils() {
    }

    /**
     * Shows choose one from N dialog.
     *
     * @param context         the context
     * @param title           the title
     * @param items           the items
     * @param checkedItem     the position of the initially checked item
     * @param onClickListener listener on item click
     */
    public static void showChooseOneDialog(final Context context,
                                           final String title,
                                           final String[] items,
                                           int checkedItem,
                                           DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(items, checkedItem, onClickListener);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Shows dialog with given message.
     *
     * @param context  the context
     * @param message  the message
     * @param listener the listener for the 'OK' button, if the listener is intentionally
     *                 set to <code>null</code>, then the {@link DialogUtils#cancelListener}
     *                 will be set.
     */
    public static void showMessageDialog(final Context context, String message,
                                         DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setMessage(message);

        DialogInterface.OnClickListener clickListener = listener;
        if (clickListener == null) {
            clickListener = cancelListener;
        }
        builder.setPositiveButton("OK", clickListener);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private static DialogInterface.OnClickListener cancelListener = new DialogInterface
            .OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };
}
