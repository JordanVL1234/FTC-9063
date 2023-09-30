package org.firstinspires.ftc.teamcode; // Replace with your package name

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "ColorTest2023 (Blocks to Java)")
public class ColorTest2023BTJ extends LinearOpMode {
    // Define your class members here
    DcMotor BackL, BackR, FrontL, FrontR;
    LightSensor colorsensor_LightSensor;
    ColorSensor colorsensor;

    // This function is executed when this Op Mode is selected from the Driver Station.
    @Override
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

        waitForStart();
        if (opModeIsActive()) {
            BackL.setPower(OgMotorSpeed * -1);
            BackR.setPower(OgMotorSpeed);
            FrontL.setPower(OgMotorSpeed * -1);
            FrontR.setPower(OgMotorSpeed);
            while (opModeIsActive()) {
                telemetry.addData("Light Detected", colorsensor_LightSensor.getLightDetected());
                telemetry.addData("Red", colorsensor.red());
                telemetry.addData("Blue", colorsensor.blue());
                telemetry.addData("Green", colorsensor.green());
                telemetry.update();
                
                if (colorsensor.red() > (colorsensor.blue()+colorsensor.green())/1.5 && SeenColor == 0) {
                    BackL.setPower(OgMotorSpeed);
                    BackR.setPower(OgMotorSpeed * -1);
                    FrontL.setPower(OgMotorSpeed);
                    FrontR.setPower(OgMotorSpeed * -1);
                    BackL.setPower(0);
                    BackR.setPower(0);
                    FrontL.setPower(0);
                    FrontR.setPower(0);
                    SeenColor = 1;
                }
            }
        }
    }
}
