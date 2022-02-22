package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotArm {

    public DcMotorEx Arm;
    public DcMotorEx ArmJoint;
    public CRServo Claw;

    static private double GEAR_3_RATIO = 2.89;
    static private double GEAR_4_RATIO = 3.61;
    static private double GEAR_5_RATIO = 5.23;

    static double COUNT_PER_DEGREE_ARM = 28 * GEAR_3_RATIO * GEAR_4_RATIO * GEAR_5_RATIO * (125.0 / 30.0) * (90.0 / 45.0) / 360;
    static double COUNT_PER_DEGREE_ARMJOINT = 28 * GEAR_3_RATIO * GEAR_4_RATIO * GEAR_5_RATIO / 360;

    // Local OpMode members
    HardwareMap hwMap = null;


    // Constructor - leave this blank for now
    public RobotArm() {

    }

        public void ClawGrab(){
        Claw.setPower(.25);
        }

        public void ArmSetPos(double angle, double speed, String status){
            Arm.setTargetPosition( (int) (angle *COUNT_PER_DEGREE_ARM) );
            Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm.setVelocity(speed * COUNT_PER_DEGREE_ARM);
        }

        public void ArmJointSetPos(double angle, double speed, String status){
            ArmJoint.setTargetPosition( (int) (angle * COUNT_PER_DEGREE_ARMJOINT) );
            ArmJoint.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            ArmJoint.setVelocity(speed * COUNT_PER_DEGREE_ARMJOINT);

        }


    public void ArmGetPosition(){}

    public void ArmJointGetPosition(){}

    public void ArmResetEncoder(){}

    public void ArmJointResetEncoder(){}

    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;


        ArmJoint = hwMap.get(DcMotorEx.class, "arm joint");
        Arm = hwMap.get(DcMotorEx.class, "Arm");
        Claw = hwMap.get(CRServo.class, "claw");

        // Reverse one of the drive motors.
        ArmJoint.setDirection(DcMotorEx.Direction.REVERSE);

        Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ArmJoint.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}