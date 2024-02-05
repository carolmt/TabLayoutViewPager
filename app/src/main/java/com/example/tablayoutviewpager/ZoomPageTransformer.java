package com.example.tablayoutviewpager;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

public class ZoomPageTransformer implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity, -1)
            // Esta página desaparece de la pantalla hacia la izquierda.
            view.setAlpha(0F);
        } else if (position <= 1) { // [-1, 1]

            // Modifica la transición deslizante encogiendo la página
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }
            // Devuelve la página a su tamaño normal
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            // Aparece la página con su tamaño normal
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1, +Infinity]
            // Esta página desaparece de la pantalla hacia la derecha.
            view.setAlpha(0F);
        }
    }

}
