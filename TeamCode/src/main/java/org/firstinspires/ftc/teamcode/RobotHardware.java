/*
FTC Dashboard: http://192.168.43.1:8080/dash
Onbot Java: 192.168.43.1:8080
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotHardware { // the hardware map
    // drivetrain motors
    public DcMotor frontLeft = null;  // four drivetrain motors
    public DcMotor frontRight = null;
    public DcMotor backLeft = null;
    public DcMotor backRight = null;

    /*
    public DcMotor intakeMotor = null;
    public DcMotor transferMotor = null;
    public DcMotor wheelMotor = null;
     */

    HardwareMap hwMap = null;

    public RobotHardware () { // empty constructor

    }

    public void init (HardwareMap ahwMap) {
        hwMap = ahwMap;

        // front left motor
        frontLeft = hwMap.get(DcMotor.class, "leftFrontMotor");  // initialize the motor
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);  // set as forward
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  // do not use encoders for this
        frontLeft.setPower(0.0);  // initialize to no power

        // front right motor
        frontRight = hwMap.get(DcMotor.class, "rightFrontMotor");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setPower(0.0);

        // back left motor
        backLeft = hwMap.get(DcMotor.class, "leftBackMotor");
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setPower(0.0);

        // back right motor
        backRight = hwMap.get(DcMotor.class, "rightBackMotor");
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setPower(0.0);

        /*
        // intake motor
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setPower(0.0);
        // transfer motor
        transferMotor = hwMap.get(DcMotor.class, "transferMotor");
        transferMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        transferMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        transferMotor.setPower(0.0);
        // wheel motor
        wheelMotor = hwMap.get(DcMotor.class, "wheelMotor");
        wheelMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        wheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wheelMotor.setPower(0.0);
         */
    }

}