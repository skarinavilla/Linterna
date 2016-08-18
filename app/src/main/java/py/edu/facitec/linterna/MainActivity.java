package py.edu.facitec.linterna;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {
    Camera camera = null;
    Parameters parameters;
    Button ControlLinterna;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControlLinterna = (Button)findViewById(R.id.controlLinterna);
    }
    public void onClickLED(View arg0) {
        try{
            if(camera == null){
                camera = Camera.open();
                parameters = camera.getParameters();
                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                ControlLinterna.setText("OFF");
            }else{
                parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.release();
                camera = null;
                ControlLinterna.setText("ON");
            }
        }catch(Exception e){
        }
    }
    public void finish(){
        if (camera != null){
            parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.release();
            camera = null;
        }
        super.finish();
    }
}