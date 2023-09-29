package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Set;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "DriveCode (Blocks to Java)")
public class KeneansBlockToJava extends LinearOpMode {

  private DcMotor FrontR;
  private DcMotor BackR;
  private DcMotor FrontL;
  private DcMotor BackL;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double vertical;
    double horizontal;
    double pivot;
    int rescaleDrive;

    FrontR = hardwareMap.get(DcMotor.class, "FrontR");
    BackR = hardwareMap.get(DcMotor.class, "BackR");
    FrontL = hardwareMap.get(DcMotor.class, "FrontL");
    BackL = hardwareMap.get(DcMotor.class, "BackL");
    double MotorSpeed;
    MotorSpeed = .5;
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        vertical = -(gamepad1.right_stick_x * MotorSpeed);
        horizontal = -(gamepad1.left_stick_x * MotorSpeed);
        pivot = gamepad1.left_stick_y * MotorSpeed;
        // Put loop blocks here.
        rescaleDrive = 2;
        FrontR.setPower(-pivot + vertical + horizontal);
        BackR.setPower(-pivot + (vertical - horizontal));
        FrontL.setPower(pivot + vertical + horizontal);
        BackL.setPower(pivot + (vertical - horizontal));
        telemetry.update();
        if (gamepad1.x) {
          MotorSpeed = 0.25;
        }
        
        else {
          MotorSpeed = 0.5;
        }
        
      }
    }
  }
}
