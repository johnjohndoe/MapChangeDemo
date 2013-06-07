package com.example.mapchangedemo;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.Toast;

import com.bricolsoftconsulting.mapchange.MyMapView;
import com.bricolsoftconsulting.mapchange.MyOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {

	private MyMapView mMapView;
	private MyOverlay mMapOverlay;
	Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mMapView = (MyMapView) findViewById(R.id.theMap);
		
		// Add overlay
		mMapOverlay = new MyOverlay(null, mMapView);
		mMapView.getOverlays().add(mMapOverlay);

		// Add zoom controls
		mMapView.setBuiltInZoomControls(true);

		// Add listeners
		mMapView.setOnChangeListener(new MapViewChangeListener());
		mMapOverlay.setOnTapListener(new MapViewTapListener());		
	}

	private class MapViewChangeListener implements MyMapView.OnChangeListener
	{

		@Override
		public void onChange(MapView view, GeoPoint newCenter, GeoPoint oldCenter, int newZoom, int oldZoom)
		{
			// Check values
			if ((!newCenter.equals(oldCenter)) && (newZoom != oldZoom))
			{
				Toast.makeText(MainActivity.this, "Map Zoom + Pan", Toast.LENGTH_SHORT).show();
			}
			else if (!newCenter.equals(oldCenter))
			{
				Toast.makeText(MainActivity.this, "Map Pan", Toast.LENGTH_SHORT).show();
			}
			else if (newZoom != oldZoom)
			{
				Toast.makeText(MainActivity.this, "Map Zoom", Toast.LENGTH_SHORT).show();
			}
		}
	}

	private class MapViewTapListener implements MyOverlay.OnTapListener
	{
		@Override
		public void onTap(GeoPoint p, MapView mapView)
		{
			// Display message
			Toast.makeText(MainActivity.this, "Map Tap", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onDoubleTap(GeoPoint p, MapView mapView)
		{
			// Reposition map
			Point screenPoint = new Point();
			mMapView.getProjection().toPixels(p, screenPoint);
			mMapView.getController().zoomInFixing(screenPoint.x, screenPoint.y);

			// Display message
			Toast.makeText(MainActivity.this, "Map Double Tap", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
