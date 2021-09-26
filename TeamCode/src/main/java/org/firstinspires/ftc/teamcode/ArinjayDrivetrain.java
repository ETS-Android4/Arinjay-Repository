package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "ArinjayDrivetrain", group = "LinearOpMode")

public class ArinjayDrivetrain extends LinearOpMode {
    //declare motors
    public DcMotor backLeft = null;
    public DcMotor frontLeft = null;
    public DcMotor backRight = null;
    public DcMotor frontRight = null;
    public double turn = 0;
    public double horizontal = 0;
    public double vertical = 0;
//test
    public void runOpMode() {
        //initialize motors
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        waitForStart();

        //set motors to controller input
        while(opModeIsActive()) {
            horizontal = gamepad1.left_stick_x;
            vertical = gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;
            backLeft.setPower(vertical + turn - horizontal);
            frontLeft.setPower(vertical + turn + horizontal);
            backRight.setPower(vertical - turn + horizontal);
            frontRight.setPower(vertical - turn - horizontal);
        }
    }
}
