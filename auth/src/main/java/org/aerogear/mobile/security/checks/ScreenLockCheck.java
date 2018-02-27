package org.aerogear.mobile.security.checks;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;

import org.aerogear.mobile.security.SecurityCheck;
import org.aerogear.mobile.security.SecurityCheckResult;
import org.aerogear.mobile.security.impl.SecurityCheckResultImpl;

import static org.aerogear.mobile.core.utils.SanityCheck.nonNull;


/**
 * A check for whether the device the application is running on has a screen lock.
 */
public class ScreenLockCheck implements SecurityCheck {
    /**
     * Check whether the device has a screen lock enabled (PIN, Password, etc).
     *
     * @param context Context to be used by the check.
     * @return <code>true</code> if the device has a screen lock enabled.
     * @throws IllegalArgumentException if {@param context} is null
     */
    @Override
    public SecurityCheckResult test(@NonNull final Context context){
        final KeyguardManager keyguardManager = (KeyguardManager) nonNull(context, "context").getSystemService(Context.KEYGUARD_SERVICE);
        // KeyguardManager#isDeviceSecure() was added in Android M.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return new SecurityCheckResultImpl(this, keyguardManager.isDeviceSecure());
        }
        return new SecurityCheckResultImpl(this, keyguardManager.isKeyguardSecure());
    }
}
