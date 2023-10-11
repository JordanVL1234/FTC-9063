// Name Package
package org.firstinspires.ftc.teamcode;

// Import Hardwear Files
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

// Define Name Using TeleOp
@TeleOp(name = "OpColor 10-11-23")

// Start of Code
public class OpColor_101123 extends LinearOpMode {
    // Define Hardwear
    DcMotor BackL, BackR, FrontL, FrontR;
    LightSensor colorsensor_LightSensor;
    ColorSensor colorsensor;

    // Initiation
    @Override
    public void runOpMode() {
        public static double OgMotorSpeed = 0.2;
        public static boolean SeenColor = false;
        BackL = hardwareMap.get(DcMotor.class, "BackL");
        BackR = hardwareMap.get(DcMotor.class, "BackR");
        FrontL = hardwareMap.get(DcMotor.class, "FrontL");
        FrontR = hardwareMap.get(DcMotor.class, "FrontR");
        colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
        colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");

        // Making Functions
        private void MoveUp(OgMotorSpeed) {
            BackL.setPower(OgMotorSpeed * -1);
            BackR.setPower(OgMotorSpeed);
            FrontL.setPower(OgMotorSpeed * -1);
            FrontR.setPower(OgMotorSpeed);
        }
        private void MoveDown(OgMotorSpeed) {
            BackL.setPower(OgMotorSpeed);
            BackR.setPower(OgMotorSpeed * -1);
            FrontL.setPower(OgMotorSpeed);
            FrontR.setPower(OgMotorSpeed * -1);
        }
        private void MoveLeft(OgMotorSpeed) {
            BackL.setPower(OgMotorSpeed);
            BackR.setPower(OgMotorSpeed * -1);
            FrontL.setPower(OgMotorSpeed * -1);
            FrontR.setPower(OgMotorSpeed);
        }
        private void MoveDown(OgMotorSpeed) {
            BackL.setPower(OgMotorSpeed * -1);
            BackR.setPower(OgMotorSpeed);
            FrontL.setPower(OgMotorSpeed);
            FrontR.setPower(OgMotorSpeed * -1);
        }
        private void MoveStop() {
            MoveDown();
            BackL.setPower(0);
            BackR.setPower(0);
            FrontL.setPower(0);
            FrontR.setPower(0);
        }
        private void CheckColor(SeenColor) {
            if (colorsensor.red() > (colorsensor.blue()+colorsensor.green())/1.5 && SeenColor == 0) {
                MoveStop();
                SeenColor = 1;
        }

        // Waiting For User Input
        waitForStart();
        if (opModeIsActive()) {

        }
    }
 }