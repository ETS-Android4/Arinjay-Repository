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
//.75 6 288
        // 288 (360/360)
        //(6/(d*Math.pi))*288
        //set motors to controller input
        while(opModeIsActive()) {
            double d = .75;
            double horizontal = gamepad1.left_stick_x;
            double vertical = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            backLeft.setPower(vertical + turn - horizontal);
            frontLeft.setPower(vertical + turn + horizontal);
            backRight.setPower(-vertical + turn - horizontal);
            frontRight.setPower(vertical - turn - horizontal);

            /*
            if(gamepad1.dpad_down){
                if(liftMotor.getCurrentPosition()>0){
                    liftMotor.setPower(-1);
                }
            }
            else if(gamepad1.dpad_left){
                if(((7.5/(d*Math.PI))*288)>liftMotor.getCurrentPosition()){
                    liftMotor.setPower(1);
                }
                else if((((6.5/(d*Math.PI))*288)<liftMotor.getCurrentPosition())){
                    liftMotor.setPower(-1);
                }
            }
            else if(gamepad1.dpad_up) {
            if(((14/(d*Math.PI))*288)>liftMotor.getCurrentPosition()){
                liftMotor.setPower(1);
                }
            }
            if (gamepad1.right_trigger > 0) {
                intakeMotor.setPower(1);
            }
            else if(gamepad1.right_bumper){
                intakeMotor.setPower(-1);
            }
            else{
                intakeMotor.setPower(0);
            }

            if (gamepad1.left_bumper) {
                liftMotor.setPower(1);
            }
            else if(gamepad1.left_trigger>0){
                liftMotor.setPower(-1);
            }

            if (gamepad1.y) {
                boxServo.setPosition(0.625);
            }
            else if(gamepad1.x){
                boxServo.setPosition(0);
            }

            if (gamepad1.a) {
                carouselServo.setPower(1);
            }
            else if(gamepad1.b){
                carouselServo.setPower(-1);
            }
            */

        }
    }
}
//😎😎😎 i understand all the code 😎😎😎