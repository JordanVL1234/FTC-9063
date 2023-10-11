package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.State;
import java.util.Set;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



@TeleOp(name = "DonovanAuto (Blocks to Java)")
public class DonovanAuto extends LinearOpMode {
  
enum DriveState {
  STOP,
  FORWARD, // Simple; All wheels are the same value
  BACKWARD,
  CW, // Turning in place (ClockWise)
  CCW, // Turning in place (CounterClockWise)
  LEFT, // Strafing
  RIGHT
}
    
private DcMotor FrontR;
private DcMotor BackR;
private DcMotor FrontL;
private DcMotor BackL;

private double GLOBAL_SCALE = 0.2;
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */

  @Override
  public void runOpMode() {
    FrontR = hardwareMap.get(DcMotor.class, "FrontR");
    BackR = hardwareMap.get(DcMotor.class, "BackR");
    FrontL = hardwareMap.get(DcMotor.class, "FrontL");
    BackL = hardwareMap.get(DcMotor.class, "BackL");
    // Put initialization blocks here.
    waitForStart();
    /* These are some specifications for the turns, and only to be used in turning fuctions-
    Might update tho 
    */
    int Full180 = 4200; 
    int Turn90 = Full180/2; //90 degree turn is half of one180
    int Turn45 = Turn90/2; //Same concept as above
    
    if (opModeIsActive()) {
      // Put run blocks here.
      Drive_Forward(1000);
      Drive_Backward(1000);
      Turn_CW(1000);
      Turn_CCW(1000);
      Drive_Left(1000);
      Drive_Right(1000);
      
      // Testings
      while (opModeIsActive()) {
        // Put loop blocks here.
        telemetry.update();
        
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Drive(DriveState State, double Scale) {
    switch (State) {
      case STOP:
        FrontL.setPower(0);
        FrontR.setPower(0);
        BackL.setPower(0);
        BackR.setPower(0);
        break;
        
      case FORWARD:
        FrontL.setPower(-Scale);
        FrontR.setPower(Scale);
        BackL.setPower(-Scale);
        BackR.setPower(Scale);
        break;
        
      case BACKWARD:
        FrontL.setPower(Scale);
        FrontR.setPower(-Scale);
        BackL.setPower(Scale);
        BackR.setPower(-Scale);
        break;
        
      case CW:
        FrontL.setPower(-Scale);
        FrontR.setPower(-Scale);
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
        BackR.setPower(Scale);
      break;
      
      case LEFT:
        FrontL.setPower(Scale);
        FrontR.setPower(Scale);
        BackL.setPower(-Scale);
        BackR.setPower(-Scale);
      break;
    }
  }
  
  private void Drive_Forward(int MS) {
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
    Drive(DriveState.RIGHT, GLOBAL_SCALE);
    sleep(MS);
    Drive(DriveState.STOP, GLOBAL_SCALE);
  }
  
  private void Drive_Left(int MS) {
    Drive(DriveState.LEFT, GLOBAL_SCALE);
    sleep(MS);
    Drive(DriveState.STOP, GLOBAL_SCALE);
  }
  
}
