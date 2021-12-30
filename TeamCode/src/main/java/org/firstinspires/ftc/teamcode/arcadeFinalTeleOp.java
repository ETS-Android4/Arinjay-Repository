package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "arcadeFinalTeleOp", group = "LinearOpMode")
public class FinalOpCodeFREIGHTFRENZY extends LinearOpMode {
  public static PIDCoefficients liftPID = new PIDCoefficients(0.0D, 0.0D, 0.0D);
  
  boolean liftActive = false;
  
  boolean speedModDown = false;
  
  ElapsedTime liftBreakout = new ElapsedTime();
  
  public DcMotor backLeftMotor = null;
  
  public DcMotor frontLeftMotor = null;
  
  public DcMotor backRightMotor = null;
  
  public DcMotor frontRightMotor = null;
  
  boolean hahahahahahahahah = false;
  
  public DcMotor intakeMotor = null;
  
  public DcMotorEx liftMotor = null;
  
  public CRServo carouselServo = null;
  
  public DigitalChannel liftTouch = null;
  
  public Servo boxServo = null;
  
  double speedModifier = 0.8D;
  
  static int[] direction = new int[] { 1, -1 };
  
  static double[] speed = new double[] { 1.0D, 0.25D };
  
  public void LiftRaise(double inches) {
    double winchSize = 2.0D;
    double ticksPerRotation = 529.2D;
    double ticks = 1.0D / winchSize * Math.PI / ticksPerRotation * inches;
    this.liftMotor.setPower(1.0D);
    this.liftMotor.setTargetPosition((int)ticks);
    this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    this.liftBreakout.reset();
    this.liftActive = true;
  }
  
  public void LiftRaiseTicks(double inches) {
    double winchSize = 2.0D;
    double ticksPerRotation = 529.2D;
    double ticks = inches;
    this.liftMotor.setPower(1.0D);
    this.liftMotor.setTargetPosition((int)ticks);
    this.liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    this.liftBreakout.reset();
    this.liftActive = true;
  }
  
  public void runOpMode() {
    this.backLeftMotor = (DcMotor)this.hardwareMap.get(DcMotor.class, "backLeftMotor");
    this.frontLeftMotor = (DcMotor)this.hardwareMap.get(DcMotor.class, "frontLeftMotor");
    this.backRightMotor = (DcMotor)this.hardwareMap.get(DcMotor.class, "backRightMotor");
    this.frontRightMotor = (DcMotor)this.hardwareMap.get(DcMotor.class, "frontRightMotor");
    this.intakeMotor = (DcMotor)this.hardwareMap.get(DcMotor.class, "intakeMotor");
    this.liftMotor = (DcMotorEx)this.hardwareMap.get(DcMotorEx.class, "liftMotor");
    this.carouselServo = (CRServo)this.hardwareMap.get(CRServo.class, "carouselServo");
    this.boxServo = (Servo)this.hardwareMap.get(Servo.class, "boxServo");
    this.liftTouch = (DigitalChannel)this.hardwareMap.get(DigitalChannel.class, "liftTouch");
    this.backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    this.frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    this.liftTouch.setMode(DigitalChannel.Mode.INPUT);
    waitForStart();
    this.liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    int directionPointer = 0;
    int speedPointer = 0;
    while (opModeIsActive()) {
      double y = this.gamepad1.left_stick_y;
      double x = this.gamepad1.left_stick_x * 1.1D;
      double rx = this.gamepad1.right_stick_x;
      double denom = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0D);
      this.telemetry.addData("touchSensor", Boolean.valueOf(this.liftTouch.getState()));
      this.telemetry.addData("liftbroken: ", Integer.valueOf(this.liftMotor.getCurrentPosition()));
      this.telemetry.update();
      if (this.gamepad1.y)
        this.speedModifier = Math.copySign(0.8D, this.speedModifier); 
      if (this.gamepad1.x)
        this.speedModifier = Math.copySign(0.5D, this.speedModifier); 
      if (this.gamepad1.a)
        this.speedModifier = Math.copySign(0.25D, this.speedModifier); 
      if (this.speedModDown) {
        if (!this.gamepad1.b)
          this.speedModDown = false; 
      } else if (this.gamepad1.b) {
        this.speedModifier *= -1.0D;
        this.speedModDown = true;
      } 
      if (this.gamepad1.dpad_down) {
        this.frontLeftMotor.setPower(0.75D * this.speedModifier);
        this.backLeftMotor.setPower(0.75D * this.speedModifier);
        this.frontRightMotor.setPower(0.75D * this.speedModifier);
        this.backRightMotor.setPower(0.75D * this.speedModifier);
      } else if (this.gamepad1.dpad_up) {
        this.frontLeftMotor.setPower(-0.75D * this.speedModifier);
        this.backLeftMotor.setPower(-0.75D * this.speedModifier);
        this.frontRightMotor.setPower(-0.75D * this.speedModifier);
        this.backRightMotor.setPower(-0.75D * this.speedModifier);
      } else if (this.gamepad1.dpad_right) {
        this.frontLeftMotor.setPower(-0.75D * this.speedModifier);
        this.backLeftMotor.setPower(0.75D * this.speedModifier);
        this.frontRightMotor.setPower(0.75D * this.speedModifier);
        this.backRightMotor.setPower(-0.75D * this.speedModifier);
      } else if (this.gamepad1.dpad_left) {
        this.frontLeftMotor.setPower(0.75D * this.speedModifier);
        this.backLeftMotor.setPower(-0.75D * this.speedModifier);
        this.frontRightMotor.setPower(-0.75D * this.speedModifier);
        this.backRightMotor.setPower(0.75D * this.speedModifier);
      } else {
        this.frontLeftMotor.setPower((y * this.speedModifier - x * this.speedModifier - rx * Math.abs(this.speedModifier)) / denom);
        this.backLeftMotor.setPower((y * this.speedModifier + x * this.speedModifier - rx * Math.abs(this.speedModifier)) / denom);
        this.frontRightMotor.setPower((y * this.speedModifier + x * this.speedModifier + rx * Math.abs(this.speedModifier)) / denom);
        this.backRightMotor.setPower((y * this.speedModifier - x * this.speedModifier + rx * Math.abs(this.speedModifier)) / denom);
      } 
      this.intakeMotor.setPower(this.gamepad2.right_stick_y);
      if (this.liftActive == true) {
        if (!this.liftMotor.isBusy() || this.liftBreakout.seconds() > 15.0D) {
          this.liftActive = false;
          this.liftMotor.setPower(0.0D);
        } 
      } else if (this.gamepad2.right_trigger > 0.0F) {
        this.liftMotor.setPower(1.0D);
      } else if (this.gamepad2.right_bumper) {
        this.liftMotor.setPower(-1.0D);
      } else if (this.gamepad2.dpad_up) {
        LiftRaiseTicks(1050.0D);
        this.boxServo.setPosition(0.8D);
      } else if (this.gamepad2.dpad_left) {
        LiftRaise(5.0D);
        this.boxServo.setPosition(0.8D);
      } else if (this.gamepad2.dpad_down) {
        LiftRaise(0.5D);
        this.boxServo.setPosition(0.8D);
      } else if (this.gamepad2.dpad_right) {
        this.boxServo.setPosition(0.9D);
        LiftRaise(0.0D);
      } else {
        this.liftMotor.setPower(0.0D);
      } 
      if (this.gamepad2.a) {
        this.carouselServo.setPower(1.0D);
      } else if (this.gamepad2.b) {
        this.carouselServo.setPower(-1.0D);
      } else {
        this.carouselServo.setPower(0.0D);
      } 
      if (this.gamepad2.x)
        this.boxServo.setPosition(0.53D); 
      if (this.gamepad2.y)
        this.boxServo.setPosition(0.9D); 
    } 
  }
}
