package org.aerogear.mobile.security.checks;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;


/**
 * Security check that detects if developer mode is enabled in the device.
 */
public class DeveloperModeDisabledCheck extends AbstractSecurityCheck {

    /**
     * Check if developer mode has been enabled in the device. Developer mode can allow an attacker
     * to spoof GPS and other forms of data entry.
     *
     * @param context {@link Context} to be used by the check
     * @return <code>true</code> if the developer options have not been enabled on the device
     */
    @Override
    protected boolean execute(@NonNull Context context) {
        int devOptions = Settings.Secure.getInt(context.getContentResolver(),
                        Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        return devOptions == 0;
    }

    @Override
    public String getName() {
        return "Developer Mode Check";
    }
}
