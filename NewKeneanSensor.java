package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.State;
import java.util.Arrays;
import java.util.Collections;
@TeleOp

public class NewKeneanSensor extends LinearOpMode {
    // Define your class members here
    private DcMotor FrontR;
    private DcMotor BackR;
    private DcMotor FrontL;
    private DcMotor BackL;
    private LightSensor colorsensor_LightSensor;
    private ColorSensor colorsensor;
    
    enum TestForColor {
        Red,
        Green, 
        Blue
    }
    // This function is executed when this Op Mode is selected from the Driver Station.
    @Override
    public void runOpMode() {
        double OgMotorSpeed = 0.2;
        double DyMotorSpeed;
        boolean SeenColor = false;
        BackL = hardwareMap.get(DcMotor.class, "BackL");
        BackR = hardwareMap.get(DcMotor.class, "BackR");
        FrontL = hardwareMap.get(DcMotor.class, "FrontL");
        FrontR = hardwareMap.get(DcMotor.class, "FrontR");
        colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
        colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");
        double[] rgb = {colorsensor.red(),colorsensor.green(),colorsensor.blue()};
        
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
                telemetry.addData("Color Found", colorsensor.green());
                // telemetry.addData("Color Seen (of RGB)", Collections.max(Arrays.asList(rgb)));
                telemetry.update();
                
                if (TestColorRed() == true) {
                    BackL.setPower(OgMotorSpeed);
                    BackR.setPower(OgMotorSpeed * -1);
                    FrontL.setPower(OgMotorSpeed);
                    FrontR.setPower(OgMotorSpeed * -1);
                    BackL.setPower(0);
                    BackR.setPower(0);
                    FrontL.setPower(0);
                    FrontR.setPower(0);
                    SeenColor = true;
                }
            }
        }
    }

    private boolean TestColor(TestForColor State) {
        double OgMotorSpeed = 0.2;
        switch (State) {
            case Red:
                if (colorsensor.red() > colorsensor.blue() && (colorsensor.red() > colorsensor.green()))  {
                    
                    return true;
                }
   
            break;
            
            case Blue:
                if (colorsensor.red() < colorsensor.blue() && (colorsensor.green() < colorsensor.blue()))  {
                    
                    return true;
                }
   
            break;
            
            case Green:
                if (colorsensor.green() > colorsensor.blue() && (colorsensor.green() > colorsensor.red()))  {
                    
                    return true;
                }
   
            break;
        }
    }

    private boolean TestColorRed(){
        
    
        return TestColor(TestForColor.Red);
    }
} 
