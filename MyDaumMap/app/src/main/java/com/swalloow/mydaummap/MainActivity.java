package com.swalloow.mydaummap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    static final String API_KEY = "db3b73bbf771536aa9e317af7ec7770a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using TedPermission library
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this, "권한 허가", Toast.LENGTH_SHORT).show();

                // MapView 객체생성 및 API Key 설정
                MapView mapView = new MapView(MainActivity.this);
                mapView.setDaumMapApiKey(API_KEY);

                RelativeLayout mapViewContainer = (RelativeLayout) findViewById(R.id.map_view);
                mapViewContainer.addView(mapView);

                // 중심점 변경
                mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);

                // 마커 생성 및 설정
                MapPOIItem marker = new MapPOIItem();
                marker.setItemName("Default Marker");
                marker.setTag(0);
                marker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633));
                marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                mapView.addPOIItem(marker);
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };

        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("지도 서비스를 사용하기 위해서는 위치 접근 권한이 필요해요")
                .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }

}