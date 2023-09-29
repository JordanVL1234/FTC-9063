   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    BackL = hardwareMap.get(DcMotor.class, "BackL");
    BackR = hardwareMap.get(DcMotor.class, "BackR");
    FrontL = hardwareMap.get(DcMotor.class, "FrontL");
    FrontR = hardwareMap.get(DcMotor.class, "FrontR");
    colorsensor_LightSensor = hardwareMap.get(LightSensor.class, "colorsensor");
    colorsensor = hardwareMap.get(ColorSensor.class, "colorsensor");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      BackL.setPower(-0.2);
      BackR.setPower(0.2);
      FrontL.setPower(-0.2);
      FrontR.setPower(0.2);
      while (opModeIsActive()) {
        // Put loop blocks here.
        telemetry.addData("Light Detected", colorsensor_LightSensor.getLightDetected());
        telemetry.addData("Red", colorsensor.red());
        telemetry.addData("Blue", colorsensor.blue());
        telemetry.addData("Green", colorsensor.green());
        telemetry.update();
        if (colorsensor.red() > 150) {
          BackL.setPower(0);
          BackR.setPower(0);
          FrontL.setPower(0);
          FrontR.setPower(0);
        }
      }
    }
  }
}