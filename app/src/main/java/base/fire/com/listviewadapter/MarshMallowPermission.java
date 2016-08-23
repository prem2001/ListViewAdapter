package base.fire.com.listviewadapter;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Marsh mallow permission request class
 */
public final class MarshMallowPermission {
    private static final int INTERNET_PERMISSION_REQUEST_CODE = 4;
    private static final int RECEIVE_SMS_PERMISSION_REQUEST_CODE = 5;
    private static final int ACCESS_NETWORK_STATE_PERMISSION_REQUEST_CODE = 6;
    private static final int WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 7;

    /**
     * Activity context
     */
    Activity activity;

    /**
     * Public constructor
     * @param activity for context
     */
    public MarshMallowPermission(Activity activity) {
        this.activity = activity;
    }

    /**
     * @return true if the permission is granted, false otherwise
     */
    public boolean checkPermissionForInternet(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * @return true if the permission is granted, false otherwise
     */
    public boolean checkPermissionForReceiveSms(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.RECEIVE_SMS);

        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Request permission for Internet
     */
    public void requestPermissionForInternet(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.INTERNET)){
            Toast.makeText(activity, "Internet Storage permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.INTERNET},INTERNET_PERMISSION_REQUEST_CODE);
        }
    }

    /**
     * Request permission for ReceiveSms access
     */
    public void requestPermissionForReceiveSms(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECEIVE_SMS)){
            Toast.makeText(activity, "ReceiveSms permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECEIVE_SMS}, RECEIVE_SMS_PERMISSION_REQUEST_CODE);
        }
    }

    /**
     * Request permission for NetworkAccess
     */
    public void requestPermissionForAccessNetwork(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_NETWORK_STATE)){
            Toast.makeText(activity, "AccessNetwork permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, ACCESS_NETWORK_STATE_PERMISSION_REQUEST_CODE);
        }
    }

    /**
     *
     * @return true if the permission is granted, false otherwise
     */
    public boolean checkPermissionForAccessNetwork(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_NETWORK_STATE);

        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     *
     * @return true if the permission is granted, false otherwise
     */
    public boolean checkPermissionForExternalStorage(){
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Request permission for ExternalStorage
     */
    public void requestPermissionForExternalStorage(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(activity, "ExternalStorage permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        }
    }

//    USE of this in Activity
//MarshMallowPermission marshMallowPermission = new MarshMallowPermission(this);
//    if (!marshMallowPermission.checkPermissionForInternet()) {
//        marshMallowPermission.requestPermissionForInternet();
//    }

}
