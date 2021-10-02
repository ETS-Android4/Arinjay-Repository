//regular tankdrivetrain
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name = "ArinjayAuton", group = "LinearOpMode")

public class ArinjayAuton extends LinearOpMode {
    //declare motors
    public DcMotor backLeft = null;
    public DcMotor frontLeft = null;
    public DcMotor backRight = null;
    public DcMotor frontRight = null;
    public double turn = 0;
    public double horizontal = 0;
    public double vertical = 0;
    static final double wheelDiameter = 3;
    static final double ticksPerRevolution = 537.6;
    double circumference = Math.PI * wheelDiameter;
    public int direction[] = {0,1,2,3};
    //test


    public void setAllPower(double speed){
        frontLeft.setPower(speed);
        backLeft.setPower(speed);
        frontRight.setPower(speed);
        backRight.setPower(speed);
    }

    public void forward(int ticks) {//0
        frontLeft.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
    }
    public void backward(int ticks) {//1
        ticks*=-1;
        frontLeft.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
    }
    public void right(int ticks) {//2
        frontLeft.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks * -1);
        frontRight.setTargetPosition(ticks * -1);
        backRight.setTargetPosition(ticks);
    }
    public void left(int ticks) {//3
        frontLeft.setTargetPosition(ticks * -1);
        backLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks * -1);
    }




    public double move(int dir, double dist) { //dir{for,back,right,left}
        int ticks = (int)(dist*ticksPerRevolution/circumference);
        if(dir == direction[0]) {
            forward(ticks);
        }
        else if(dir == direction[1]) {
            backward(ticks);
        }
        else if(dir == direction[2]) {
            right(ticks);
        }
        else if(dir == direction[3]) {
            left(ticks);
        }
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (true) {
            if(frontLeft.isBusy()==false&&frontRight.isBusy()==false&&backLeft.isBusy()==false&&backRight.isBusy()==false){
                //isbusy is self explanatory boolean function
                setAllPower(0);
                return dist;
            }
        }
    }


    public void runOpMode() {
        //initialize motors
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        waitForStart();

        //set motors to controller input

    }
}
