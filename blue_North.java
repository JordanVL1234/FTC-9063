package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.util.Set;

@TeleOp(name = "blue_North")
public class blue_North extends LinearOpMode {
    // Define your class members here
    DcMotor BackL, BackR, FrontL, FrontR;
    LightSensor colorsensor_LightSensor;
    ColorSensor colorsensor;
    
    public void runOpMode() {
        double OgMotorSpeed = 0.2;
        double DyMotorSpeed;
        int SeenColor = 0;
        BackL = hardwareMap.get(DcMotor.class, "BackL");
        BackR = hardwareMap.get(DcMotor.class, "BackR");
        FrontL = hardwareMap.get(DcMotor.class, "FrontL");
        FrontR = hardwareMap.get(DcMotor.class, "FrontR");
        colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
        colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        
        private void Move_Forward(int Seconds) {
            FrontL.setPower(-0.2);
            FrontR.setPower(0.2);
            BackL.setPower(-0.2);
            BackR.setPower(0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0); }
        private void Move_Backwards(int Seconds) {
            FrontL.setPower(0.2);
            FrontR.setPower(-0.2);
            BackL.setPower(0.2);
            BackR.setPower(-0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0); }
        private void TurnLeftInPlace(int Seconds) {
            FrontL.setPower(0.2);
            FrontR.setPower(0.2);
            BackL.setPower(0.2);
            BackR.setPower(0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0); }
        private void TurnRightInPlace(int Seconds) {
            FrontL.setPower(-0.2);
            FrontR.setPower(-0.2);
            BackL.setPower(-0.2);
            BackR.setPower(-0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0); }
        private void StrafeRight(int Seconds) {
            FrontL.setPower(-0.2);
            FrontR.setPower(-0.2);
            BackL.setPower(0.2);
            BackR.setPower(0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0); }
        private void StrafeLeft(int Seconds) {
            FrontL.setPower(0.2);
            FrontR.setPower(0.2);
            BackL.setPower(-0.2);
            BackR.setPower(-0.2);
            sleep(Seconds);
            FrontL.setPower(0);
            FrontR.setPower(0);
            BackL.setPower(0);
            BackR.setPower(0);

            waitForStart();
            if (opModeIsActive()) {
                Move_Forward(int Seconds) 
                while (opModeIsActive()) { // In a work of progress
                telemetry.addData("Light Detected", colorsensor_LightSensor.getLightDetected());
                telemetry.addData("Red", colorsensor.red());
                telemetry.addData("Blue", colorsensor.blue());
                telemetry.addData("Green", colorsensor.green());
                telemetry.update(); {
                    
                    if (colorsensor.blue() > (colorsensor.red()+colorsensor.green())/1.5 && SeenColor == 0) {
                        // (Drop pixel);
                        Move_Backwards(int 5000);
                        TurnLeftInPlace(int 5000);
                        Move_Forward(int 5000);
                        System.exit(1)
                    } else {
                        StrafeLeft(int 5000);
                    } if (colorsensor.blue() > (colorsensor.red()+colorsensor.green())/1.5 && SeenColor == 0) {
                        // (Drop pixel);
                        Move_Backwards(int 5000);
                        TurnLeftInPlace(int 5000);
                        Move_Forward(int 5000);
                        System.exit(1)
                    } else {
                        StrafeLeft(int 5000);
                        // (Drop pixel);
                        Move_Backwards(int 5000);
                        TurnLeftInPlace(int 5000);
                        Move_Forward(int 5000);
                        System.exit(1)
                            }
                }
                }
            }
        }
}

