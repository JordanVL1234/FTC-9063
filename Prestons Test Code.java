package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.State;
import java.util.Set;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "PrestonTestCode")
public class PrestonTestCode extends LinearOpMode {
  
 enum DriveState  {
   Stop,
   Forward, // All wheels same value
   Backward,
   CW, // Turning in place
   CCW,
   Left, // Strafing
   Right
}

enum TestForColor {
        Red,
        Blue,
        Green,
}

private DcMotor FrontR;
private DcMotor FrontL;
private DcMotor BackR;
private DcMotor BackL;
private ServoMotor ServoUp;

 /**
 * This Function is executed when this Op Mode is selected from the Driver Station
 */
 
 public void runOpMode() {
  FrontR = hardwareMap.get(DcMotor.class, "FrontR");
  FrontL = hardwareMap.get(DcMotor.class, "FrontR");
  BackR = hardwareMap.get(DcMotor.class, "BackR");
  BackL = hardwareMap.get(DcMotor.class, "BackL");
  colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
  colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");
 
   // Put initialization process here
  waitforstart();
  /* These are some specifications for the turns, and only to be used in turning functions-
  Might update though**
  */
  int Full180 = 4200;
  int Turn90 = Full180/2;
  int Turn45 = Turn90/2;
  
  while (opModeIsActive()) {
   // Put run process here.
   // Time is in milliseconds
   
   StrafeRight(2000);
   Move_Forward(1000);
    if (Blue() == true) {
      // Pick up item and whatever
    } 
    else {
     StrafeLeft(1000);
     Move_Forward(1000);
    }
   if (Blue() == true) {
     // Pick up item and whatever
   } else {
   TurnLeftInPlace(1000);
   Move_Forward(1000); }
      // Pick up item since we are in the final spot
    }
 }


  while (opModeIsActive()) {

    // Put loop process here
    Telementry.update();
    telemetry.addData("Light Detected", colorsensor_LightSensor.getLightDetected());
    telemetry.addData("Red", colorsensor.red());
    telemetry.addData("Blue", colorsensor.blue());
    telemetry.addData("Green", colorsensor.green());
    telemetry.update();
  
 /**
  * Describe this Function...
  */
private void Move_Forward(int Seconds) {
  FrontL.setPower(-0.2);
  FrontR.setPower(0.2);
  BackL.setPower(-0.2);
  BackR.setPower(0.2);
  sleep(Seconds);
  FrontL.setPower(0.0);
  FrontR.setPower(0.0);
  BackL.setPower(0.0);
  BackR.setPower(0.0);
}
   
private void Move_Backward(int Seconds) {
    FrontL.setPower(0.2);
    FrontR.setPower(-0.2);
    BackL.setPower(0.2);
    BackR.setPower(-0.2);
    sleep(Seconds);
    FrontL.setPower(0.0);
    FrontR.setPower(0.0);
    BackL.setPower(0.0);
    BackR.setPower(0.0);
    
   }
   
   
   private void TurnLeftInPlace(int Seconds) {
    FrontL.setPower(0.2);
    FrontR.setPower(0.2);
    BackL.setPower(0.2);
    BackR.setPower(0.2);
    sleep(Seconds);
    FrontL.setPower(0.0);
    FrontR.setPower(0.0);
    BackL.setPower(0.0);
    BackR.setPower(0.0);
    
   }
   
  private void TurnRightInPlace(int Seconds) {
    FrontL.setPower(-0.2);
    FrontR.setPower(-0.2);
    BackL.setPower(-0.2);
    BackR.setPower(-0.2);
    sleep(Seconds);
    FrontL.setPower(0.0);
    FrontR.setPower(0.0);
    BackL.setPower(0.0);
    BackR.setPower(0.0);
    
   }
   
private void StrafeRight(int Seconds) {
   FrontL.setPower(-0.2);
   FrontR.setPower(-0.2);
   BackL.setPower(0.2);
   BackR.setPower(0.2);
   sleep(Seconds);
   FrontL.setPower(0.0);
   FrontR.setPower(0.0);
   BackL.setPower(0.0);
   BackR.setPower(0.0);
  
  }
  
  
  private void StrafeLeft(int Seconds) {
   FrontL.setPower(0.2);
   FrontR.setPower(0.2);
   BackL.setPower(-0.2);
   BackR.setPower(-0.2);
   sleep(Seconds);
   FrontL.setPower(0.0);
   FrontR.setPower(0.0);
   BackL.setPower(0.0);
   BackR.setPower(0.0);
  }

private boolean TestColor(TestForColor State) {

  case Red:
if (colorsensor.red() > colorsensor.blue() && (colorsensor.red() > colorsensor.green())) {

  return true;
  break;

  case Blue:
  if (colorsensor.blue() > colorsensor.red() && (colorsensor.blue() > colorsensor.green())) {

    return true;
    break;

    case Green::
      if (colorsensor.green() > colorsensor.red() && (colorsensor.green() > colorsensor.blue())) {

      return true;
      break;
    }
  }
}
}
    



  }
}
