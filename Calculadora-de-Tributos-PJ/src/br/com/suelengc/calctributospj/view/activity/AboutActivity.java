package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.share.Email;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class AboutActivity extends SherlockActivity{
		    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setTitle("Sobre");
	        setContentView(R.layout.about);
	        
	        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
	        getSupportActionBar().setBackgroundDrawable(bg);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    }
	    
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			
			Log.d("SuelenGC", menu.toString());
			MenuInflater mi = new MenuInflater(getApplicationContext());
			mi.inflate(R.menu.menu, menu);
			
			//Ocultar menus desta tela
			menu.findItem(MyMenu.ABOUT).setVisible(false);
			menu.findItem(MyMenu.SETTINGS).setVisible(false);
			
			return true;
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			
			case MyMenu.HOME:
				finish();
				
			case MyMenu.EMAIL:
				new Email().sendEmail(this);
			
			default:
				return super.onOptionsItemSelected(item);
			}
		}
	
}
