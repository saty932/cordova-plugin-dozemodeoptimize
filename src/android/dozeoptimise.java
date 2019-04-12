package cordova.plugin.dozeoptimise;


import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import javax.xml.transform.OutputKeys;

/**
 * This class echoes a string called from JavaScript.
 */
public class dozeoptimise extends CordovaPlugin {

	private OutputKeys Build;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		if(action.equals("isBatteryOptimizationAvalible")){
			this.isBatteryOptimizationAvalible(callbackContext);
			return true;
		}
		else if(action.equals("updateBatteryStatus")){
			this.updateBatteryStatus(callbackContext);
			return true;
		}
		return false;
	}

	private void isBatteryOptimizationAvalible(CallbackContext callbackContext){
		Context context = cordova.getActivity().getApplicationContext();
		String packageName = context.getPackageName();
		try{
			boolean isBatteryOptimizationAvalible=false;
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
				String message ="";

				PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
				if (pm.isIgnoringBatteryOptimizations(packageName)) {
					message ="true";
				}
				else
				{
					message ="false";
				}
				callbackContext.success(message);

			}
		}
		catch (Exception e){
			callbackContext.error("isBatteryOptimizationAvalible Failed");
		}

	}

	private void updateBatteryStatus(CallbackContext callbackContext){
		Context context = cordova.getActivity().getApplicationContext();
		String packageName = context.getPackageName();
		try {
			if (android.os.Build.VERSION.SDK_INT >android.os.Build.VERSION_CODES.M) {
				Intent intent = new Intent();
				PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
				if (pm.isIgnoringBatteryOptimizations(packageName)){
					intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
				}

				callbackContext.success("requested");

			}
			else
			{
				callbackContext.error("BATTERY_OPTIMIZATIONS Not available.");

			}
		} catch (Exception e) {
			callbackContext.error("RequestOptimizationsMenu: failed N/A");

		}
	}

}
