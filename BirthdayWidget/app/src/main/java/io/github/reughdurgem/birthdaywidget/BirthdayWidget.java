package io.github.reughdurgem.birthdaywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class BirthdayWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        // Grab strings from configurator
        CharSequence widgetText = BirthdayWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.birthday_widget);
        views.setTextViewText(R.id.name, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }

        String date = ("4/29/2018");
        String daysCounter = ("9 Days Remaining");

        final int N = appWidgetIds.length;
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Grab strings from configurator
            CharSequence widgetText = BirthdayWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
            CharSequence widgetText_Date = BirthdayWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
            // Construct the RemoteViews object
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.birthday_widget);
            views.setTextViewText(R.id.date, date);
            views.setTextViewText(R.id.day_counter, daysCounter);
            views.setTextViewText(R.id.name, widgetText);
            //views.setTextViewText(R.id.date, widgetText_Date);

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
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            BirthdayWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
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

/*package io.github.reughdurgem.birthdaywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class BirthdayWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        String date = ("1/1/2000");
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            int awId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.birthday_widget);
            views.setTextViewText(R.id.date, date);
            appWidgetManager.updateAppWidget(awId, views);
        }
    }
}*/