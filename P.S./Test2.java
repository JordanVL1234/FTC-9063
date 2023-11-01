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
    public DcMotor pickupMotor
