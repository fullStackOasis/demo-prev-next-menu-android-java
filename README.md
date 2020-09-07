# Demos the app bar menu

Simple demo of a Prev/Next menu in the app bar.

Clicking "Prev" in the app bar takes you to the earlier image. Clicking on "Next" takes you to the following one.

![Demo of menu in Android app bar with Java](https://github.com/fullStackOasis/demo-prev-next-menu-android-java/raw/master/demo-prev-next-menu-bar.gif)

Note that when switching from `Activity` to `AppCompatActivity`, you have to switch from calling `invalidateOptionsMenu` to calling `supportInvalidateOptionsMenu` to tell Android to redraw the menu. In this case, that is done to disable menu items when there are no more next or previous images to show.
