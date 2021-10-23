//regular tankdrivetrain
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "ArinjayDrivetrain", group = "LinearOpMode")

public class ArinjayDrivetrain extends LinearOpMode {
    //declare motors
    public DcMotor backLeft = null;
    public DcMotor frontLeft = null;
    public DcMotor backRight = null;
    public DcMotor frontRight = null;
    public DcMotor intakeMotor = null;
    public Servo boxServo = null;
    public DcMotor liftMotor = null;
    public Servo carouselServo = null;

//test
    public void runOpMode() {
        //initialize motors
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        boxServo = hardwareMap.get(Servo.class, "boxServo");
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        carouselServo = hardwareMap.get(Servo.class, "carouselServo");


        waitForStart();

        //set motors to controller input
        while(opModeIsActive()) {
            double horizontal = gamepad1.left_stick_x;
            double vertical = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            backLeft.setPower(vertical + turn - horizontal);
            frontLeft.setPower(vertical + turn + horizontal);
            backRight.setPower(vertical - turn + horizontal);
            frontRight.setPower(vertical - turn - horizontal);

            if (gamepad1.right_trigger > 0) {
                intakeMotor.setPower(1);
            }

            if (gamepad1.left_bumper) {
                liftMotor.setPower(1);
            }

            if (gamepad1.left_trigger > 0) {
                boxServo.setPosition(0.8);
            }

            if (gamepad1.right_bumper) {
                carouselServo.setPosition(0.7);
            }

            intakeMotor.setPower(0);
            liftMotor.setPower(0);
            boxServo.setPosition(0);
            carouselServo.setPosition(0);
        }
    }
}
//😎😎😎 i understand all the code 😎😎😎