package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotArm {

    public DcMotorEx Arm;
    public DcMotorEx ArmJoint;
    public CRServo Claw;


    static private double PI = 3.141592;
    static private double CIRCUMFERENCE = 76 / 25.4 * PI;
    static private double GEAR_3_RATIO = 2.89;
    static private double GEAR_4_RATIO = 3.61;
    static private double GEAR_5_RATIO = 5.23;
    static private double COUNTS_PER_IN_DRIVE = 28 * GEAR_3_RATIO * GEAR_4_RATIO * GEAR_3_RATIO / CIRCUMFERENCE;

    static double COUNT_PER_DEGREE_ARM = 28 * GEAR_3_RATIO * GEAR_4_RATIO * GEAR_5_RATIO * (125.0 / 30.0) * (90.0 / 45.0) / 360;
    static double COUNT_PER_DEGREE_ARMJOINT = 28 * GEAR_3_RATIO * GEAR_4_RATIO * GEAR_5_RATIO / 360;

    // Local OpMode members
    HardwareMap hwMap = null;


    // Constructor - leave this blank for now
    public RobotArm() {

    }

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