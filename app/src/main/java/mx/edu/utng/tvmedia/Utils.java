package mx.edu.utng.tvmedia;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    private Utils() {}
    public static String loadJSONFromResource(Context context, int resource ) {
        if( resource <= 0 || context == null )
            return null;
        String json = null;
        InputStream is = context.getResources().openRawResource( resource );
        try {
            if( is != null ) {
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                json = new String(buffer, "UTF-8");
            }
        } catch( IOException e ) {
            return null;
        } finally {
            try {
                if( is != null )
                    is.close();
            } catch( IOException e ) {
                Log.i("Error on read",""+e.getStackTrace());
            }

        }
        return json;
    }
}