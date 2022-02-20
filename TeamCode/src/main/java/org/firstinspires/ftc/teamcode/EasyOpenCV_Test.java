package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

//This test does not include the live view because I have no idea how to do that
public class EasyOpenCV_Test {

    WebcamName = hardwareMap.get(WebcamName.class, "Webcam")
    OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(WebcamName);
    camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
    {
        @Override
        public void onOpened()
        {
            // Usually this is where you'll want to start streaming from the camera (see section 4)
            camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
        }
        @Override
        public void onError(int errorCode)
        {
            /*
             * This will be called if the camera could not be opened
             */
        }
    });

    }






