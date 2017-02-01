package com.example.bilama_jlatexmath;


import maximsblog.blogspot.com.jlatexmath.core.Insets;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends Activity {

	private ImageView mImageView;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		mImageView = (ImageView)findViewById(R.id.logo);

		setformula();
    }//end_OnCreat
    
	private void setformula() {
		int w = getResources().getDisplayMetrics().widthPixels;
		int h = getResources().getDisplayMetrics().heightPixels;
		String latex = "\\text{hello world}";
		TeXFormula formula = new TeXFormula(latex);
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY)
				.setSize(14)
				.setWidth(TeXConstants.UNIT_PIXEL, 256f, TeXConstants.ALIGN_CENTER)
				.setIsMaxWidth(true).setInterLineSpacing(TeXConstants.UNIT_PIXEL, 20f)
				.build();

		Bitmap image = Bitmap.createBitmap(icon.getIconWidth(), icon.getIconHeight(),
				Config.ARGB_8888);

		Canvas g2 = new Canvas(image);
		g2.drawColor(Color.WHITE);

		Bitmap scaleimage = scaleBitmapAndKeepRation(image, h, w);

		mImageView.setImageBitmap(scaleimage);
	}
    
	public Bitmap scaleBitmapAndKeepRation(Bitmap targetBmp,
			int reqHeightInPixels, int reqWidthInPixels) {
		Bitmap bitmap = Bitmap.createBitmap(reqWidthInPixels,
				reqHeightInPixels, Config.ARGB_8888);
		Canvas g = new Canvas(bitmap);
		g.drawBitmap(targetBmp, 0, 0, null);
		targetBmp.recycle();
		return bitmap;
	}

}
