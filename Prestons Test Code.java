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

private DcMotor FrontR;
private DcMotor FrontL;
private DcMotor BackR;
private DcMotor BackL;

 /**
 * This Function is executed when this Op Mode is selected from the Driver Station
 */
 
 @Override
 public void runOpMode() {
  FrontR = hardwareMap.get(DcMotor.class, "FrontR");
  FrontL = hardwareMap.get(DcMotor.class, "FrontR");
  BackR = hardwareMap.get(DcMotor.class, "BackR");
  BackL = hardwareMap.get(DcMotor.class, "BackL");
  colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
  colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");
  telementry.addData("Light Detected", colorsensor_LightSensor.getLightDetected());
  telementry.addData("Red", colorsensor());
  telementry.addData("Blue", colorsensor());
  telementry.addData("Green", colorsensor());
  telementry.update();
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
   BackLL.setPower(0.0);
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
}
