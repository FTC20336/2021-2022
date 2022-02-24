package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotBase;

@Autonomous(name="Autonomous with RobotClass", group="Auto Blue")

public class Autonomous_with_RobotClass extends LinearOpMode {

    //Create New Robot based on RobotBase
    RobotBase Beep = new RobotBase();


    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {

        //Initialize Robot Class
        Beep.init(hardwareMap);
        Beep.BeepArm.init(hardwareMap);

        waitForStart();


        if (opModeIsActive()) {

            // Grab Initial block
            Beep.BeepArm.ClawGrab();
            sleep(1200);

            Beep.BeepArm.ArmSetPos(40,60,"");

//     /*
//      while (opModeIsActive() && Arm.isBusy() ){
//        telemetry.addData("Arm Be Move", Arm.getVelocity());
//        telemetry.update();
//      }
//    */
            Beep.BeepArm.ArmJointSetPos(50,45,"");

//     // If we want to wait until the armjoint is done.. uncomment this
//      while (opModeIsActive() && ArmJoint.isBusy() ){
//        telemetry.addData("Arm Joint Be Move", ArmJoint.getVelocity());
//        telemetry.update();
//      }
//      */
//
            Beep.move(10.5,15,"Move Foward");
            //Position 1
            Beep.strafe(28, 90, 15,"");
            Beep.move(11.5,20,"robot go forward");

            //Drop the block on the top level
            Beep.BeepArm.ClawOpen();
            sleep(200);
            Beep.BeepArm.ClawStop();


            // Move armjoint up a little to clear anything in the way
            Beep.BeepArm.ArmJointSetPos(60,45,"");

            // Move back to Warehouse from Dropping the Duck
            Beep.move(-6, 20, "roboreverse");
            Beep.rotate(90, 45, "TARGET LOCKED"); //sleep(2000);
            Beep.move(60,999,"Robot go WAREHOUSE");

            // To Roll a Duck.. Uncomment this

            Beep.move(-4, 20, "roboreverse");
            Beep.rotate(180, 45, "TARGET LOCKED");
            //Start from Po1
            Beep.strafe (65,-90,20,"");
            Beep.strafe (2,-90,10,"");
            Beep.move(10, 5, "roboreverse");
            Beep.DuckWheelBlue();
            sleep(2500);
            Beep.DuckWheelStop();



            // To part in the small parking.. Uncomment this and comment next block
            Beep.move(-18,20,"Robot go BRRRRRRRRR");
            Beep.BeepArm.ArmSetPos(70,60,"");

            // Go to Warehouse
            Beep.strafe (20,90,15,"");
            Beep.rotate(-105, 45, "TARGET LOCKED"); //sleep(2000);
            Beep.move(100,100,"Robot go BRRRRRRRRR");


            // Set Arm and ArmJoint Position to Known position so TeleOp Mode can use Encoders correctly
            Beep.BeepArm.ArmJointSetPos(0,60,"");
            sleep(500);
            Beep.BeepArm.ArmSetPos(0,60,"");
        }
    }
}

