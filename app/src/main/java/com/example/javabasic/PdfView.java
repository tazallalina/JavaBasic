package com.example.javabasic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

public class PdfView extends AppCompatActivity {
    PDFView pdfView;
    int file;
    public static String pdfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        pdfView = (PDFView) findViewById(R.id.showPdf);

        if (getIntent() != null) {
            pdfView.fromAsset(pdfName)
                    .password(null).defaultPage(0)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .onDraw(new OnDrawListener() {
                        @Override
                        public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                        }
                    }).onDrawAll(new OnDrawListener() {
                @Override
                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                }
            }).onPageError(new OnPageErrorListener() {
                @Override
                public void onPageError(int page, Throwable t) {
                    Toast.makeText(PdfView.this, "Error while open page" + page, Toast.LENGTH_SHORT).show();
                }
            }).onPageChange(new OnPageChangeListener() {
                @Override
                public void onPageChanged(int page, int pageCount) {
                    file++;
                }
            }).onTap(new OnTapListener() {
                @Override
                public boolean onTap(MotionEvent e) {
                    return true;
                }
            }).onRender(new OnRenderListener() {
                @Override
                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                    pdfView.fitToWidth();
                }
            }).enableAnnotationRendering(true)
                    .invalidPageColor(Color.WHITE)
                    .load();
        }

    }

}
