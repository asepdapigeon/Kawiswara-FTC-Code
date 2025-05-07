package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MechanumTeleop (Blocks to Java)")
public class MechanumTeleop extends LinearOpMode {

  private DcMotor leftRear;
  private DcMotor leftFront;
  private DcMotor rightFront;
  private DcMotor rightRear;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    
    leftRear = hardwareMap.get(DcMotor.class, "leftRear");
    leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    rightFront = hardwareMap.get(DcMotor.class, "rightFront");
    rightRear = hardwareMap.get(DcMotor.class, "rightRear");

    leftRear.setDirection(DcMotor.Direction.REVERSE);
    leftFront.setDirection(DcMotor.Direction.REVERSE);
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        float x = gamepad1.left_stick_x;
        float y = gamepad1.left_stick_y;
        float turn = gamepad1.right_stick_x;
        
        double theta = Math.atan2(y, x);
        double power = Math.hypot(x, y);
        
        double sin = Math.sin(theta - Math.PI/4);
        double cos = Math.cos(theta - Math.PI/4);
        double max = Math.max(Math.abs(sin), Math.abs(cos));
        
        leftFront.setPower(power * cos/max + turn);
        rightFront.setPower(power * sin/max - turn);
        leftRear.setPower(power * sin/max + turn);
        rightRear.setPower(power * cos/max - turn);
        
        if ((power + Math.abs(turn)) > 1) {
            leftFront.setPower(leftFront.getPower() / power + turn);
            rightFront.setPower(rightFront.getPower() / power + turn);
            leftRear.setPower(leftRear.getPower() / power + turn);
            rightRear.setPower(rightRear.getPower() / power + turn);
        }
        
        telemetry.addData("power:", JavaUtil.formatNumber(power, 3));
        telemetry.addData("degrees:", JavaUtil.formatNumber(Math.toDegrees(theta), 3));
        telemetry.update();
      }
    }
  }
}
