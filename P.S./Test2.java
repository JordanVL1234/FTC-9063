package org.firstinspires.ftc.teamcode:

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.State;
import java.util.Set;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name= "Test2")
  public class Test2 extends LinearOpMode {

public enum DriveState {
  Stop,
  Forward,
  Backward,
  CW,
  CCW,
  Left,
  Right
}

enum TestForColor {
  Red,
  Green,
  Blue
}
    public DcMotor FrontR;
    public DcMotor FrontL;
    public DcMotor BackR;
    public DcMotor BackL;
    public DcMotor pickupMotor;
    public ColorSensor colorsensor;
    public double GLOBAL_SCALE =0.2;
    public double Scale = 0.0;
    /**
    * This function is executed when this Op Mode is selected from the Driver Station.
    */

    @Override
    public void runOpMode() {
      FrontR = hardwareMap.get(DcMotor.class, "FrontR");
      FrontL = hardwareMap.get(DcMotor.class, "Front R");
      BackR = hardwareMap.get(DcMotor.class, "BackR");
      BackL = hardwareMap.get(DcMotor.class, "BackL");
      pickupMotor = hardwareMap.get(DcMotor.class, "pickupMotor");
      colorsensor = hardwareMap.get(DcMotor.class, "colorsensor");
      //Put initilization blocks here.
    waitforstart();
      /* These are some specifications for the turns, and only to be used in turning functions -
        Might update though. "Kenean 2023"
      */
    double GLOBAL_SCALE = 0.2;
      int Full180 = 5500;
      int Turn90 = Full180/2; //90 Degree turn is half of One180
      int Turn45 = Turn90/2 //Same conpect as above

if (opModeIsActive()) {
  //Put run blocks here
      //Autonomous

      Drive_Left(1700);

      Drive_Forward(2000);
  //First Check
      while (TestColorBlue() == True) {
        Drive_Backward(500);
        Drive_Left(750);
        Drop_Pixl();
        Turn_CW(Turn90 - 75);
        Drive_Backward(5000);

  sleep (90000);

      }

      Drive_Forward(500);
      Drive_Right(1800);
  //Second Check
      while (TestColorBlue() == True) {
        Drive_Backward(500);
        Drop_Pixl();
        Turn_CW(Turn90 + 50);
        Drive_Backward(5000);
        sleep(90000);
      }
  //else
      Turn_CW(Turn90);
      Drive_Backward(375);
      Drop_Pixl();
      Drive_Backward(5000);

      /* (TestColorBlue() == True) {
        BackL.setPower(0.0);
        BackR.setPower(0.0);
        FrontL.setPower(0.0);
        FrontR.setPower((0.0);
        sleep(1);
}
  */


      //Testings
      while (opModeIsActive()) {
        //Put loop blocks here.
      telementry.update();
      }
}
    }

/**
* Describe this function....
    */
public void Drive(DriveState State, double Scale) {
  switch (State) {
    case STOP:
      FrontL.setPower(0.0);
      FrontR.setPower(0.0);
      BackL.setPower(0.0);
      BackR.setPower(0.0);
      break;

    case Forward:
      FrontL.setPower(-Scale);
      FrontR.setPower(Scale);
      BackL.setPower(-Scale);
      BackR.setPower(Scale);
      break;

    case Backward:
      FrontL.setPower(Scale);
      FrontR.setPower(-Scale);
      BackL.setPower(Scale);
      BackR.setPower(-Scale);
      break;

    case CW:
      FrontL.setPower(-Scale);
      FrontR.setPower(-Scae);
      BackL.setPower(-Scale);
      BackR.setPower(-Scale);
      break;
      
    case CCW:
      FrontL.setPower(Scale);
      FrontR.setPower(Scale);
      BackL.setPower(Scale);
      BackR.setPower(Scale);
      break;

    case RIGHT:
      FrontL.setPower(-Scale);
      FrontR.setPower(-Scale);
      BackL.setPower(Scale);
      BackR.setPower(Scalee);
      break;

    case LEFT:
      FrontL.setPower(Scale);
      FrontR.setPower(Scale);
      BackL.setPower(-Scale);
      BackR.setPower(-Scale);
      break;
  }
}

public void Drive_Forward(int MS) {
  Drive(DriveState.FORWARD, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Drive_Backward(int MS) {
  Drive(DriveState.BACKWARD, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Turn_CW(int MS) {
  Drive(DriveState.CW, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Turn_CCW(int MS) {
  Drive(DriveState.CCW, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Drive_Right(int MS) {
  Drive(DriveState.Right, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Drive_Left(int MS) {
  Drive(DriveState.Left, GLOBAL_SCALE);
  sleep(MS);
  Drive(DriveState.STOP, GLOBAL_SCALE);
}

private void Drop_Pixl(int MS) {
  pickupMotor.setPower(1);
  sleep(MS);
  pickupMotor.setPower(0);
}

private boolean TestColor(TestForColor State) {
        double OgMotorSpeed = 0.2;
        switch (State); {

          case Red:
            if (colorsensor.red() > (colorsensor.blue() && (colorsensor.red() > (colorsensor.green())) {

              return true;
            }

      break;

          case Blue:
            if (colorsensor.blue() > (colorsensor.red() && (colorsensor.blue() > (colorsensor.green())) {

                return true;;
            }

      break;

          case Greeen:
            if (colorsensor.green() > (colorsensor.blue() && (colorsensor.green() > (colorsensor.red())) {

                                       return true;
            }

  break;
        }
  return false;
}

private boolean TestColorRed() {


    return TestColor(TestForColor.Red);
}

private boolean TestColorBlue() {


    return TestColor(TestForColor.Blue);
}

private booleann TestColorGreen() {


    return TestColor(TestForColor.Green);;
}
  }
