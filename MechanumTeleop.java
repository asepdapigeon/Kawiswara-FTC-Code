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

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        float speed = gamepad1.left_stick_y;
        float turn = gamepad1.right_stick_x;
        boolean a = gamepad1.a;
        boolean b = gamepad1.b;
        boolean x = gamepad1.x;
        boolean y = gamepad1.y;
        
        leftRear.setPower(speed + turn);
        leftFront.setPower(speed + turn);
        rightRear.setPower(speed - turn);
        rightFront.setPower(speed - turn);
      }
    }
  }
}
