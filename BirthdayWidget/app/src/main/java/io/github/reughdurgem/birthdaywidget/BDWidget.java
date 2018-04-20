package io.github.reughdurgem.birthdaywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of App Widget functionality.
 */
public class BDWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        // Grab strings from configurator
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bdwidget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        final int N = appWidgetIds.length;
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Set RemoteViews for XML layout
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bdwidget);

            // Create an Intent to launch Google.com
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.buy_button, pendingIntent);

            // Manager updates all widgets
            appWidgetManager.updateAppWidget(appWidgetIds[i], views);
        }

        /*
        // EXAMPLE CODE TO OPEN AN ACTIVITY WITH A BUTTON ON WIDGET
        // I G N O R E
        // Create an Intent to launch MainActivity
        Intent intent = new Intent(context, MainActivity.class);
        // Pending Intent for Context Activity
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Get layout for Widget and attach onClickListener
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bdwidget);
        views.setOnClickPendingIntent(R.id.buy_button, pendingIntent);
        // AppWidgetManager performs update on current widget
        appWidgetManager.updateAppWidget(appWidgetIds, views);
        */
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}