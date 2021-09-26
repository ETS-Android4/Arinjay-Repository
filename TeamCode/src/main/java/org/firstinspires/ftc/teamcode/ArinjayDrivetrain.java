//regular tankdrivetrain
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "ArinjayDrivetrain", group = "LinearOpMode")

public class ArinjayDrivetrain extends LinearOpMode {
    //declare motors
    DcMotor leftMotor;
    DcMotor rightMotor;
//test
    public void runOpMode() {
        //initialize motors
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        waitForStart();

        //set motors to controller input
        while(opModeIsActive()) {
            leftMotor.setPower(gamepad1.left_stick_y);
            rightMotor.setPower(-1*gamepad1.right_stick_y);
        }
    }
}
