package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;


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
    public CRServo carouselServo = null;
    //tick to inch for slide
    public double ticks = Math.PI * 0.75 / 288; //pi * D / #ticks per revolution
    public boolean box = false;

//test
    public void runOpMode() {

        //initialize motors
        backLeft = hardwareMap.get(DcMotor.class, "backLeftMotor");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backRight = hardwareMap.get(DcMotor.class, "backRightMotor");
        frontRight = hardwareMap.get(DcMotor.class, "frontRightMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        boxServo = hardwareMap.get(Servo.class, "boxServo");
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        carouselServo = hardwareMap.get(CRServo.class, "carouselServo");


        waitForStart();
        while(opModeIsActive()) {
            double d = .75;
            double horizontal = gamepad1.left_stick_x;
            double vertical = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            backLeft.setPower(vertical + turn - horizontal);
            frontLeft.setPower(vertical + turn + horizontal);
            backRight.setPower(-vertical + turn - horizontal);
            frontRight.setPower(vertical - turn - horizontal);

            if (gamepad1.right_trigger > 0) {
                intakeMotor.setPower(-1);
            } else if (gamepad1.right_bumper) {
                intakeMotor.setPower(1);
            } else {
                intakeMotor.setPower(0);
            }
            if (gamepad1.x) { //top
                slide(14);
            }
            if (gamepad1.y) { //mid
                slide(8);
            }
            if (gamepad1.b) { //bottom and turning box
                turnServo();
            }
            if (gamepad1.a) { //top
                ravel();
            }


        }
    }

    public void slide(double dist) {

        liftMotor.setPower(0.3);
        if(dist>3) {
            liftMotor.setTargetPosition((int)(dist*ticks-3));
            liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while(liftMotor.isBusy()) {}
        }
        liftMotor.setTargetPosition((int)(dist*ticks));
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(liftMotor.isBusy()) {}
        liftMotor.setPower(0);
    }
    public void ravel() {
        liftMotor.setPower(-1);
        liftMotor.setTargetPosition(1);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(liftMotor.isBusy()) {}
        liftMotor.setPower(-0.3);
        liftMotor.setTargetPosition(0);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(liftMotor.isBusy()) {}
        liftMotor.setPower(0);

    }
    public void turnServo() {
        if(!box) {
            boxServo.setDirection(Servo.Direction.FORWARD);
            boxServo.setPosition(0.8);
            box = true;
        }
        else {
            boxServo.setDirection(Servo.Direction.REVERSE);
            boxServo.setPosition(0);
            box = false;
        }
    }
}
//😎😎😎 i understand all the code 😎😎😎